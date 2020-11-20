package org.goodiemania.andromeda.domain.config;

public class MonitoredSystem {
    private String name;
    private String urlToCheck;

    public static MonitoredSystem of(final String name, final String urlToCheck) {
        final MonitoredSystem system = new MonitoredSystem();
        system.name = name;
        system.urlToCheck = urlToCheck;

        return system;
    }

    public String getName() {
        return name;
    }

    public String getUrlToCheck() {
        return urlToCheck;
    }
}
