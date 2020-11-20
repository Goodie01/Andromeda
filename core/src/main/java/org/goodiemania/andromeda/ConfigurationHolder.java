package org.goodiemania.andromeda;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import org.goodiemania.andromeda.domain.Configuration;
import org.goodiemania.andromeda.domain.config.MonitoredSystem;

@ApplicationScoped
public class ConfigurationHolder {
    private Configuration configuration;

    @PostConstruct
    public void init() {
        configuration = new Configuration();

        final List<MonitoredSystem> systems = List.of(MonitoredSystem.of("BookInformation", "https://bookinformation.seshat.cc/health"));
        configuration.setSystems(systems);
    }

    public Configuration get() {
        return configuration;
    }
}
