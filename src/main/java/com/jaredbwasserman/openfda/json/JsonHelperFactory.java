package com.jaredbwasserman.openfda.json;

public class JsonHelperFactory {
    private static JacksonJsonHelper jacksonJsonHelper = null;

    public static JsonHelper getJsonHelper() {
        if (null == jacksonJsonHelper) {
            jacksonJsonHelper = new JacksonJsonHelper();
        }
        return jacksonJsonHelper;
    }
}
