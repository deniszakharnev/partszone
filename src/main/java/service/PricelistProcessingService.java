package service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PricelistProcessingService {

    private static Log LOG = LogFactory.getLog(PricelistProcessingService.class);

    @Scheduled(cron = "${cron.settings}")
    public void processInboxFiles() {
    }
}
