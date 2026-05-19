# WorldDelete Plugin - Quick Start Guide

## What This Plugin Does

The WorldDelete plugin allows server administrators to delete Minecraft worlds with a single command. It:
1. Removes the world from Multiverse's config using `/mv remove`
2. Deletes the entire world folder and all associated files
3. Requires no confirmation (instant deletion)

## Prerequisites

- Paper 1.21.1+ server
- Multiverse plugin installed
- OP permissions or `worlddelete.delete` permission node

## Installation Steps

1. **Download the Plugin**
   - The compiled plugin JAR is located at: `target/worlddelete-plugin-1.0.0.jar`

2. **Add to Server**
   ```bash
   cp target/worlddelete-plugin-1.0.0.jar /path/to/server/plugins/
   ```

3. **Restart Server**
   ```bash
   # Restart your Paper server
   ```

## Usage

### Basic Command
```
/deleteworld <worldname>
```

### Examples
```
/deleteworld world_nether
/deleteworld adventure_world
/dw skyblock_01
```

### Alias
You can also use `/dw` as a shortcut for `/deleteworld`

## Permissions

| Permission | Default | Description |
|-----------|---------|-------------|
| `worlddelete.delete` | OP | Allows player to use `/deleteworld` command |

## Features

✅ Instant world deletion (no confirmation required)
✅ Removes from Multiverse configuration
✅ Deletes all world files and directories
✅ Works with any world name
✅ Console-safe (can be run from console)
✅ Logging of all deletion actions

## Technical Details

- **Development Language**: Java 21
- **Server Type**: Paper/Spigot
- **Minecraft Version**: 1.21.1
- **Build Tool**: Maven

## Rebuilding the Plugin

If you want to modify the plugin:

```bash
# Edit the source files in src/main/java/

# Rebuild
mvn clean package

# New JAR will be in target/
```

## File Structure

```
worlddelete/
├── pom.xml                              # Maven configuration
├── README.md                            # Main documentation
├── src/
│   ├── main/
│   │   ├── java/com/worlddelete/
│   │   │   ├── WorldDeletePlugin.java   # Main plugin class
│   │   │   └── commands/
│   │   │       └── DeleteWorldCommand.java  # Command handler
│   │   └── resources/
│   │       └── plugin.yml               # Plugin configuration
```

## Support

For issues or questions, check the logs in your server's console. The plugin logs all deletion attempts and any errors encountered.

## Safety Notes

⚠️ **WARNING**: This plugin permanently deletes world folders with NO recovery option. Make backups before testing!

The deletion includes:
- World data folder
- Player data for that world (if applicable)
- All region files
- All metadata files
