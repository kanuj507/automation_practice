package org.example.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigManager {

    private ConfigManager() {  }

    public static Configuration configuration() {
        return ConfigCache.getOrCreate(Configuration.class);
    }
}
