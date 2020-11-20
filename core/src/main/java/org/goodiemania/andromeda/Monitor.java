package org.goodiemania.andromeda;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import kong.unirest.Body;
import kong.unirest.Unirest;
import org.apache.commons.codec.binary.StringUtils;
import org.goodiemania.andromeda.domain.SystemStatus;

@Singleton
@Startup
public class Monitor {
    @Inject
    private ConfigurationHolder configuration;

    @Inject
    private IndexController index;

    @Schedule(minute = "*", hour = "*")
    public void check() {
        System.out.println("Checking");
        configuration.get().getSystems().forEach(monitoredSystem -> {
            final String healthCheckResult = Unirest.get(monitoredSystem.getUrlToCheck())
                    .asString()
                    .getBody();

            if(StringUtils.equals("\"OK\"", healthCheckResult)) {
                index.updateStatus(monitoredSystem.getName(), SystemStatus.OK);
            } else {
                index.updateStatus(monitoredSystem.getName(), SystemStatus.DANGER);
            }
        });
    }
}
