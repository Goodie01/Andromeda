package org.goodiemania.andromeda.domain;

import java.util.List;
import org.goodiemania.andromeda.domain.config.MonitoredSystem;

public class Configuration {
    private List<MonitoredSystem> systems;

    public List<MonitoredSystem> getSystems() {
        return systems;
    }

    public void setSystems(final List<MonitoredSystem> systems) {
        this.systems = systems;
    }
}
