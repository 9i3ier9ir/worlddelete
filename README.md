# WorldDelete

A Paper 1.21.11 plugin that allows you to delete worlds with a single command.

## Features

- Delete worlds with `/deleteworld <worldname>` command
- Automatically removes the world from Multiverse's config via `/mv remove`
- Deletes the world folder and all associated files
- No confirmation required - instantaneous deletion
- Requires `worlddelete.delete` permission (OP by default)

## Building

1. Ensure you have Maven installed
2. Run: `mvn clean package`
3. The plugin JAR will be created in the `target/` directory

## Installation

1. Build the plugin (see above)
2. Copy the JAR file from `target/` to your server's `plugins/` directory
3. Make sure your server has the Multiverse plugin installed (for `/mv remove` command)
4. Restart your server

## Usage

```
/deleteworld <worldname>
```

Example:
```
/deleteworld world_nether
```

This will:
1. Execute `/mv remove world_nether` to remove it from Multiverse config
2. Delete the world folder and all associated files
3. Confirm deletion to the player

## Permissions

- `worlddelete.delete` - Allows player to use the `/deleteworld` command (Default: OP)
- `worlddelete.delete.other` - (Reserved for future use)

## Notes

- The command requires OP permissions by default
- There is a 1-second delay between removing from Multiverse and deleting files to ensure proper cleanup
- All files associated with the world are permanently deleted with no recovery option