package org.goodiemania.andromeda;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.goodiemania.andromeda.domain.DisplayedStatus;
import org.goodiemania.andromeda.domain.SystemStatus;
import org.omnifaces.cdi.Startup;

@Named
@Startup
@ApplicationScoped
public class IndexController {
    @Inject
    @Push
    PushContext helloChannel;

    private Map<String, DisplayedStatus> statusList;

    @PostConstruct
    public void init() {
        Lorem lorem = LoremIpsum.getInstance();
        statusList = new HashMap<>();
    }

    public List<DisplayedStatus> getStatusList() {
        return List.copyOf(statusList.values());
    }

    public void updateStatus(final String name, final SystemStatus ok) {
        DisplayedStatus displayedStatus = statusList.get(name);
        if(displayedStatus == null) {
            displayedStatus = new DisplayedStatus();
            displayedStatus.setName(name);
            statusList.put(name, displayedStatus);
        }

        displayedStatus.setSystemStatus(ok);
        helloChannel.send("update");
    }
}
