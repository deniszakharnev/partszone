package jmx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;
import service.PricelistProcessingService;

@ManagedResource(objectName = "Ground Control:type=JMX,name=Resource")
@Component
public class GroundControl {

    private static Logger LOG = LoggerFactory.getLogger(GroundControl.class);

    @Autowired
    private PricelistProcessingService pricelistProcessingService;

    @ManagedOperation
    public void processPricelists() {
        try {
            pricelistProcessingService.processInboxFiles();
        } catch (Exception e) {
            LOG.error("Pricelists processing failured", e);
        }
    }
}
