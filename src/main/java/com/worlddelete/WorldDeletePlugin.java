package com.worlddelete;

import org.bukkit.plugin.java.JavaPlugin;
import com.worlddelete.commands.DeleteWorldCommand;

public class WorldDeletePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("WorldDelete plugin enabled!");
        getCommand("deleteworld").setExecutor(new DeleteWorldCommand(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("WorldDelete plugin disabled!");
    }
}
