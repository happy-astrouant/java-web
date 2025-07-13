package com.xzy.web01.util;

import java.util.Map;

public class CurrentHolder {

    private static final ThreadLocal<Map<String, Object>> tokenClaimsHolder = new ThreadLocal<>();

    public static void setTokenClaimsHolder(Map<String, Object> log) {
        tokenClaimsHolder.set(log);
    }

    public static Map<String, Object> getTokenClaimsHolder() {
        return tokenClaimsHolder.get();
    }

    public static void removeTokenClaimsHolder() {
        tokenClaimsHolder.remove();
    }
}
