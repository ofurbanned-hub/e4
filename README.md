# MyClient

Private Fabric client project targeting Minecraft 1.21.11.

## Build

GitHub Actions builds the project automatically on pushes to `main` and on manual workflow runs. The compiled JAR is published as a workflow artifact.

## Controls

- Right Shift: open ClickGUI
- Click a module: toggle it
- `*` modules are registered in the UI but still need their game hook/implementation.

## Current working modules

- Sprint
- Fullbright
- HUD

The project intentionally does not copy protected/obfuscated client internals. The module names from the reference clients are used as a feature checklist and are implemented independently over time.
