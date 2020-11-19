package org.goodiemania.andromeda;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import java.util.ArrayList;
import java.util.List;
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

    private List<DisplayedStatus> statusList;

    @PostConstruct
    public void init() {
        Lorem lorem = LoremIpsum.getInstance();
        statusList = new ArrayList<>();

        for(int i = 0; i < 20; i++) {
            final DisplayedStatus status = new DisplayedStatus();
            status.setName(lorem.getTitle(1,3));
            status.setSystemStatus(SystemStatus.OK);
            statusList.add(status);
        }
    }

    public List<DisplayedStatus> getStatusList() {
        return statusList;
    }

    public void setStatusList(final List<DisplayedStatus> statusList) {
        this.statusList = statusList;
    }
}
