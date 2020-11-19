package org.goodiemania.andromeda.domain;

public class DisplayedStatus {
    private SystemStatus systemStatus;
    private String name;

    public SystemStatus getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(final SystemStatus systemStatus) {
        this.systemStatus = systemStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
