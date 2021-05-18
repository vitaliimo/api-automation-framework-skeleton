package com.api;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ProjectConfiguration extends Config {
    String baseUrl();

    @DefaultValue("us")
    String locale();

    boolean logging();
}
