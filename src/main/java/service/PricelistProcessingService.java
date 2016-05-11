package service;

import mapper.FileUploadMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service("pricelistProcessor")
public class PricelistProcessingService {

    private static Logger LOG = LoggerFactory.getLogger(PricelistProcessingService.class);

    @Value("${config.inboxPath}")
    private String inboxPath;

    @Autowired
    private FileUploadMapper uploadMapper;

    @Scheduled(cron = "${cron.settings}")
    public void processInboxFiles() {
        LOG.info("Start of scheduled pricelists processing at '{}'", inboxPath);
        try {
            Files.walk(Paths.get(inboxPath)).forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    processInboxFile(filePath);
                }
            });
        } catch (IOException e) {
            LOG.error("Error while processing pricelists", e);
        }
        LOG.info("End of scheduled pricelists processing");
    }

    private void processInboxFile(Path filePath) {
        LOG.info("Start processing of {} file", filePath.getFileName().toString());
        uploadMapper.startFileUpload(filePath.getFileName().toString(), new Date());
    }
}
