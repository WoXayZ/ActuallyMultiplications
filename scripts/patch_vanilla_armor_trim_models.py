"""
Ajoute les overrides trim_type (matériaux du mod) aux modèles d'armure vanilla
et génère les modèles enfants correspondants.

Sources vanilla : inventivetalent/minecraft-assets 1.21.1 (aligné sur game_version).
Relancer après modification de data/.../trim_material/*.json
"""
from __future__ import annotations

import json
import ssl
from pathlib import Path
from urllib.request import Request, urlopen

ROOT = Path(__file__).resolve().parents[1]
TRIM_DATA = ROOT / "src/main/resources/data/actuallymultiplications/trim_material"
OUT = ROOT / "src/main/resources/assets/minecraft/models/item"
BASE_URL = (
    "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/"
    "1.21.1/assets/minecraft/models/item/{}.json"
)

# Tag trimmable_armor 1.21.1 (head 7 + chest/leg/foot 6 chacun)
VANILLA_ARMOR = [
    "leather_helmet",
    "chainmail_helmet",
    "golden_helmet",
    "iron_helmet",
    "diamond_helmet",
    "netherite_helmet",
    "turtle_helmet",
    "leather_chestplate",
    "chainmail_chestplate",
    "golden_chestplate",
    "iron_chestplate",
    "diamond_chestplate",
    "netherite_chestplate",
    "leather_leggings",
    "chainmail_leggings",
    "golden_leggings",
    "iron_leggings",
    "diamond_leggings",
    "netherite_leggings",
    "leather_boots",
    "chainmail_boots",
    "golden_boots",
    "iron_boots",
    "diamond_boots",
    "netherite_boots",
]


def load_mod_trims() -> list[tuple[str, float]]:
    out: list[tuple[str, float]] = []
    for p in sorted(TRIM_DATA.glob("*.json")):
        with open(p, encoding="utf-8") as f:
            data = json.load(f)
        out.append((p.stem, float(data["item_model_index"])))
    return sorted(out, key=lambda x: x[1])


def slot_trim_prefix(item_base: str) -> str:
    if item_base.endswith("_boots"):
        return "boots_trim"
    if item_base.endswith("_leggings"):
        return "leggings_trim"
    if item_base.endswith("_chestplate"):
        return "chestplate_trim"
    return "helmet_trim"


def fetch_vanilla(name: str) -> dict:
    url = BASE_URL.format(name)
    req = Request(url, headers={"User-Agent": "ActuallyMultiplications-patch-script"})
    ctx = ssl.create_default_context()
    with urlopen(req, context=ctx, timeout=60) as r:
        return json.loads(r.read().decode("utf-8"))


def merge_overrides(
    vanilla: dict, mod_trims: list[tuple[str, float]], base_id: str
) -> list[dict]:
    raw = list(vanilla.get("overrides") or [])
    entries: list[tuple[float, dict]] = []
    for o in raw:
        tt = float(o["predicate"]["trim_type"])
        entries.append((tt, o))
    existing = {tt for tt, _ in entries}
    for mat, ttype in mod_trims:
        if ttype in existing:
            continue
        existing.add(ttype)
        entries.append(
            (
                ttype,
                {
                    "model": f"minecraft:item/{base_id}_{mat}_trim",
                    "predicate": {"trim_type": ttype},
                },
            )
        )
    entries.sort(key=lambda x: x[0])
    return [e[1] for e in entries]


def child_model(base_id: str, mat: str) -> dict:
    trim_key = slot_trim_prefix(base_id)
    trim_tex = f"minecraft:trims/items/{trim_key}_{mat}"
    if base_id.startswith("leather_"):
        return {
            "parent": "minecraft:item/generated",
            "textures": {
                "layer0": f"minecraft:item/{base_id}",
                "layer1": f"minecraft:item/{base_id}_overlay",
                "layer2": trim_tex,
            },
        }
    return {
        "parent": "minecraft:item/generated",
        "textures": {
            "layer0": f"minecraft:item/{base_id}",
            "layer1": trim_tex,
        },
    }


def main() -> None:
    mod_trims = load_mod_trims()
    OUT.mkdir(parents=True, exist_ok=True)
    n_child = 0
    for base_id in VANILLA_ARMOR:
        data = fetch_vanilla(base_id)
        data["overrides"] = merge_overrides(data, mod_trims, base_id)
        (OUT / f"{base_id}.json").write_text(
            json.dumps(data, indent=2) + "\n", encoding="utf-8"
        )
        for mat, _ in mod_trims:
            child = child_model(base_id, mat)
            (OUT / f"{base_id}_{mat}_trim.json").write_text(
                json.dumps(child, indent=2) + "\n", encoding="utf-8"
            )
            n_child += 1
    print(
        "OK — armures vanilla:",
        len(VANILLA_ARMOR),
        "| modèles enfants mod trim:",
        n_child,
    )


if __name__ == "__main__":
    main()
