package service;

import input.FileRow;
import input.PoiExcelFileIterator;
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
import java.util.Iterator;

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

        Iterator<FileRow> iterator = null;
        try {
            iterator = getPricelistFileIterator(filePath);
        } catch (IOException e) {
            LOG.error("Error while accessing pricelist '{}'", e);
            return;
        }

        uploadMapper.startFileUpload(filePath.getFileName().toString(), new Date());

        while (iterator.hasNext()) {
            FileRow row = iterator.next();
        }
    }

    private Iterator<FileRow> getPricelistFileIterator(Path filePath) throws IOException {
        return new PoiExcelFileIterator(Files.newInputStream(filePath));
    }


}
