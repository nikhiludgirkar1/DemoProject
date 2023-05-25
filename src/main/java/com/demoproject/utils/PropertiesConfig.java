package com.demoproject.utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:properties/${TEST_CONFIG}.properties"})
public interface PropertiesConfig extends Config {

    @Key("SLOWMO")
    @DefaultValue("200")
    int slowmo();

    @Key("MAX_ELEMENT_TIMEOUT_IN_SEC")
    int maxElementTimeoutInSec();

    @Key("MAX_PAGE_LOAD_TIMEOUT_IN_SEC")
    int maxPageLoadTimeoutInSec();

    @Key("PORTAL_URL")
    String portalUrl();

    @Key("KEEP_BROWSER_OPEN")
    boolean keepBrowserOpen();

    @Key("BROWSER_TYPE")
    String browserType();

    @Key("REQUEST_JSON_PATH")
    String requestJsonPath();

    @Key("BASE_API_URL")
    String baseApiUrl();

    @Key("HEADLESS")
    boolean headless();
}