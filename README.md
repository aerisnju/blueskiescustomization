# Blue Skies Customization Mod (Forge)

## What is the mod used for
The [Blue Skies](https://www.curseforge.com/minecraft/mc-mods/blue-skies) is a wonderful mod that added two brand-new dimensions to the minecraft world. When players come to the
two new dimensions, they have to start from scratch since existing weapons or tools don't work well. During the process,
they could appreciate the remarkable aspects of the mod.

However, the design could not meet all players' tastes. Someone would like to use his weapons or tools crafted with lots
of efforts in the dimensions. He may feel disappointed when he realizes that his weapons or tools couldn't work well.
Additionally, some mod pack authors would like to place strong bosses or enhance existing bosses in the dimensions
to construct their stories and quest system. They may find the design prevented implementing their ideas.

In a word, if the settings of nerf all items come from outside the dimensions could be disabled,
those people would be happy. The [opotato mod](https://github.com/MCTeamPotato/Opotato) produced by TeamPotato has shed
some light on this. However, the mod contains lots of settings for other mods, moreover, it sticks to version 1.16.5.
So I think it would be helpful to extract the part for Blue Skies, and port it to later versions.

The mod provides such settings for disabling the item nerf and allowing structures to be generated in the BlueSkies dimensions.

## How to use it
The mod requires Forge. And the BlueSkies mod should be installed. The current branch supports Minecraft 1.20.1 Forge.

Just place the mod jar file into the "mods" directory and configure the settings file to enable or disable the settings.

Here is the default settings:
```toml
[BlueSkiesExtraSettings]
    # Blue Skies Extra Settings
    # Enable nerfing weapons and tools in blue skies dimensions
    enableDimensionalNerf = true
    # Allow every mod generate features in blue skies dimensions
    allowEveryModFeatureGenInBlueSkiesDims = false
```

## Credits
* [opotato mod](https://github.com/MCTeamPotato/Opotato) produced by TeamPotato
* The wonderful [Blue Skies](https://www.curseforge.com/minecraft/mc-mods/blue-skies) mod
