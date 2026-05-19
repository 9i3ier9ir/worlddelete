package com.worlddelete.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import com.worlddelete.WorldDeletePlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class DeleteWorldCommand implements CommandExecutor {

    private final WorldDeletePlugin plugin;

    public DeleteWorldCommand(WorldDeletePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            sender.sendMessage("§cUsage: /deleteworld <worldname>");
            return false;
        }

        String worldName = args[0];

        // Confirm world exists
        File worldDir = new File(Bukkit.getWorldContainer(), worldName);
        if (!worldDir.exists()) {
            sender.sendMessage("§cWorld '" + worldName + "' does not exist.");
            return true;
        }

        sender.sendMessage("§6Deleting world '" + worldName + "'...");

        // Run /mv remove command
        plugin.getLogger().info("Executing '/mv remove " + worldName + "'");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv remove " + worldName);

        // Small delay to allow Multiverse to process
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            try {
                // Delete the world folder and all contents
                deleteDirectoryRecursively(worldDir.toPath());
                sender.sendMessage("§aWorld '" + worldName + "' has been successfully deleted.");
                plugin.getLogger().info("World '" + worldName + "' has been deleted.");
            } catch (IOException e) {
                sender.sendMessage("§cError deleting world folder: " + e.getMessage());
                plugin.getLogger().severe("Error deleting world '" + worldName + "': " + e.getMessage());
                e.printStackTrace();
            }
        }, 20L); // 20 ticks = 1 second delay

        return true;
    }

    /**
     * Recursively deletes a directory and all its contents
     */
    private void deleteDirectoryRecursively(Path path) throws IOException {
        if (Files.exists(path)) {
            Files.walk(path)
                    .sorted(Comparator.reverseOrder())
                    .forEach(file -> {
                        try {
                            Files.delete(file);
                        } catch (IOException e) {
                            plugin.getLogger().warning("Could not delete: " + file + " - " + e.getMessage());
                        }
                    });
        }
    }
}
