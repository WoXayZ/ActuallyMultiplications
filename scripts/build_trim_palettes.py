"""
Construit les textures color_palettes pour les trim Actually Multiplications.
Si tmp_textures contient des PNG dont le nom contient le palier (ex. restonia),
extrait les 7 pixels du bas à gauche (ligne du bas, x=0..6).
Sinon : couleurs de repli.
"""
from __future__ import annotations

import json
import struct
import zlib
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
TMP = ROOT / "tmp_textures"
OUT_PAL = ROOT / "src/main/resources/assets/actuallymultiplications/textures/trims/color_palettes"
OUT_TRIM = ROOT / "src/main/resources/data/actuallymultiplications/trim_material"

# Couleurs de repli (RGBA) — proches des cristaux AA
FALLBACK_STRIP: dict[str, list[tuple[int, int, int, int]]] = {
    "restonia": [(200, 55, 55, 255)] * 8,
    "palis": [(130, 70, 200, 255)] * 8,
    "diamatine": [(85, 235, 235, 255)] * 8,
    "void": [(90, 45, 130, 255)] * 8,
    "emeradic": [(55, 200, 95, 255)] * 8,
    "enori": [(225, 225, 235, 255)] * 8,
    "black_quartz": [(45, 45, 52, 255)] * 8,
}

# item_model_index : plage 0.01–0.07 pour éviter tout chevauchement avec le vanilla (0.1–1.0).
MATERIALS: list[tuple[str, str, str, float]] = [
    ("restonia", "actuallyadditions:restonia_crystal", "#C83737", 0.01),
    ("palis", "actuallyadditions:palis_crystal", "#8246C8", 0.02),
    ("diamatine", "actuallyadditions:diamatine_crystal", "#55EDED", 0.03),
    ("void", "actuallyadditions:void_crystal", "#5A2D82", 0.04),
    ("emeradic", "actuallyadditions:emeradic_crystal", "#37C85F", 0.05),
    ("enori", "actuallyadditions:enori_crystal", "#E1E1EB", 0.06),
    ("black_quartz", "actuallyadditions:black_quartz", "#2D2D34", 0.07),
]


def write_png_rgba8(path: Path, width: int, height: int, rgba_rows: list[list[tuple[int, int, int, int]]]) -> None:
    """PNG minimal RGBA8, sans dépendance PIL."""
    path.parent.mkdir(parents=True, exist_ok=True)
    raw = bytearray()
    for y in range(height):
        raw.append(0)  # filter None
        for x in range(width):
            r, g, b, a = rgba_rows[y][x]
            raw.extend((r, g, b, a))
    compressed = zlib.compress(bytes(raw), 9)

    def chunk(tag: bytes, data: bytes) -> bytes:
        return struct.pack(">I", len(data)) + tag + data + struct.pack(
            ">I", zlib.crc32(tag + data) & 0xFFFFFFFF
        )

    ihdr = struct.pack(">IIBBBBB", width, height, 8, 6, 0, 0, 0)
    png = b"\x89PNG\r\n\x1a\n" + chunk(b"IHDR", ihdr) + chunk(b"IDAT", compressed) + chunk(b"IEND", b"")
    path.write_bytes(png)


def extract_bottom_left_strip(mat_id: str) -> list[tuple[int, int, int, int]] | None:
    try:
        from PIL import Image
    except ImportError:
        return None
    if not TMP.is_dir():
        return None
    candidates = sorted(TMP.rglob("*.png")) + sorted(TMP.rglob("*.PNG"))
    chosen = None
    # Préférence : texture dont le nom contient le palier (ex. restonia_helmet.png)
    for p in candidates:
        if mat_id in p.name.lower():
            chosen = p
            break
    if chosen is None:
        return None
    im = Image.open(chosen).convert("RGBA")
    w, h = im.size
    if h < 1 or w < 7:
        return None
    y = h - 1
    strip = []
    for x in range(7):
        strip.append(im.getpixel((x, y)))
    # étendre à 8 colonnes (vanilla) en dupliquant la dernière couleur
    strip.append(strip[-1])
    return strip


def main() -> None:
    OUT_PAL.mkdir(parents=True, exist_ok=True)
    OUT_TRIM.mkdir(parents=True, exist_ok=True)

    for mat_id, ingredient, hex_color, model_index in MATERIALS:
        strip = extract_bottom_left_strip(mat_id)
        if strip is None:
            strip = FALLBACK_STRIP[mat_id]
        row = [tuple(p) for p in strip[:8]]
        while len(row) < 8:
            row.append(row[-1])
        write_png_rgba8(OUT_PAL / f"{mat_id}.png", 8, 1, [row])

        data = {
            "asset_name": mat_id,
            "description": {
                "color": hex_color,
                "translate": f"trim_material.actuallymultiplications.{mat_id}",
            },
            "ingredient": ingredient,
            "item_model_index": model_index,
        }
        (OUT_TRIM / f"{mat_id}.json").write_text(
            json.dumps(data, indent=2, ensure_ascii=False) + "\n", encoding="utf-8"
        )

    print("Palettes + trim_material OK:", len(MATERIALS))


if __name__ == "__main__":
    main()
