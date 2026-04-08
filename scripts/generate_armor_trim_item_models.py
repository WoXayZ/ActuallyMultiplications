"""
Génère les modèles d'items armure avec overrides trim_type (vanilla + matériaux du mod),
triés par trim_type croissant (requis pour les prédicats).
"""
from __future__ import annotations

import json
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
MODEL_DIR = ROOT / "src/main/resources/assets/actuallymultiplications/models/item"
TRIM_DATA = ROOT / "src/main/resources/data/actuallymultiplications/trim_material"

MATERIALS = [
    "diamatine",
    "emeradic",
    "enori",
    "palis",
    "restonia",
    "void",
    "black_quartz",
]
SLOTS = ["helmet", "chestplate", "leggings", "boots"]

# (suffixe fichier modèle enfant, trim_type, nom texture layer1 sous minecraft:trims/items/{slot}_...)
VANILLA_TRIMS: list[tuple[str, float, str]] = [
    ("quartz", 0.1, "trim_quartz"),
    ("iron", 0.2, "trim_iron"),
    ("netherite", 0.3, "trim_netherite"),
    ("redstone", 0.4, "trim_redstone"),
    ("copper", 0.5, "trim_copper"),
    ("gold", 0.6, "trim_gold"),
    ("emerald", 0.7, "trim_emerald"),
    ("diamond_darker", 0.8, "trim_diamond_darker"),
    ("lapis", 0.9, "trim_lapis"),
    ("amethyst", 1.0, "trim_amethyst"),
]


def layer1_mc(slot: str, trim_suffix: str) -> str:
    return f"minecraft:trims/items/{slot}_{trim_suffix}"


def layer1_mod(slot: str, mat: str) -> str:
    # Même convention que le vanilla : sprites générés par l’atlas blocks.json
    # (paletted_permutations sur trims/items/{slot}_trim).
    return f"minecraft:trims/items/{slot}_trim_{mat}"


def load_mod_trim_indices() -> list[tuple[str, float]]:
    out = []
    for p in sorted(TRIM_DATA.glob("*.json")):
        with open(p, encoding="utf-8") as f:
            data = json.load(f)
        out.append((p.stem, float(data["item_model_index"])))
    return sorted(out, key=lambda x: x[1])


def main() -> None:
    MODEL_DIR.mkdir(parents=True, exist_ok=True)
    mod_trims = load_mod_trim_indices()

    # Entrées (trim_type, kind, ...) triées
    for mat in MATERIALS:
        for slot in SLOTS:
            base = f"{mat}_{slot}"
            layer0 = f"actuallymultiplications:item/{base}"

            entries: list[tuple[float, str, str, bool]] = []
            for name, ttype, tex in VANILLA_TRIMS:
                child_id = f"{base}_{name}_trim"
                entries.append((ttype, child_id, layer1_mc(slot, tex), True))
            for trim_id, ttype in mod_trims:
                child_id = f"{base}_{trim_id}_trim"
                entries.append((ttype, child_id, layer1_mod(slot, trim_id), False))
            entries.sort(key=lambda x: x[0])

            overrides: list[dict] = []
            for ttype, child_id, layer1, _ in entries:
                overrides.append(
                    {
                        "model": f"actuallymultiplications:item/{child_id}",
                        "predicate": {"trim_type": ttype},
                    }
                )
                child = {
                    "parent": "minecraft:item/generated",
                    "textures": {"layer0": layer0, "layer1": layer1},
                }
                (MODEL_DIR / f"{child_id}.json").write_text(
                    json.dumps(child, indent=2) + "\n", encoding="utf-8"
                )

            main_model = {
                "parent": "minecraft:item/generated",
                "overrides": overrides,
                "textures": {"layer0": layer0},
            }
            (MODEL_DIR / f"{base}.json").write_text(
                json.dumps(main_model, indent=2) + "\n", encoding="utf-8"
            )

    n_mod = len(mod_trims)
    print(
        "OK — modèles:",
        len(MATERIALS) * len(SLOTS),
        "| enfants:",
        len(MATERIALS) * len(SLOTS) * (len(VANILLA_TRIMS) + n_mod),
    )


if __name__ == "__main__":
    main()
