package org.example.config;

import org.aeonbits.owner.Config;

@Config.Sources({ "file:${user.dir}/src/test/resources/properties/config.properties" })
public interface Configuration extends Config {

    @Key("baseUrl")
    String baseUrl();

    @Key("env")
    String env();

    @Key("browser")
    String browser();

}
