package org.fh.gae.query.index.filter;

import org.fh.gae.net.vo.BidRequest;
import org.fh.gae.query.index.unit.AdUnitInfo;
import org.fh.gae.query.index.unit.AdUnitStatus;
import org.fh.gae.query.profile.AudienceProfile;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Component
@DependsOn("filterTable")
public class UnitStatusFilter implements GaeFilter<AdUnitInfo> {

    @PostConstruct
    public void init() {
        FilterTable.register(AdUnitInfo.class, this);
    }

    @Override
    public void filter(Collection<AdUnitInfo> infos, BidRequest request, AudienceProfile profile) {
        traverse(infos, info -> info.getStatus() == AdUnitStatus.NORMAL);
    }
}