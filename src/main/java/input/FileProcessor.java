package input;

import domain.Upload;
import mapper.FileUploadMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.Iterator;

@Component
public class FileProcessor {

    private static Logger LOG = LoggerFactory.getLogger(FileProcessor.class);

    @Autowired
    private FileUploadMapper uploadMapper;

    public void process(Path filePath) {

        Iterator<FileRow> iterator;
        try {
            iterator = getPricelistFileIterator(filePath);
        } catch (Exception e) {
            LOG.error("Error while accessing pricelist '" + filePath.toString() + "'", e);
            return;
        }

        PriceListRowParser parser = getRowParser(filePath);
        RowProcessor processor = getRowProcessor();

        Upload upload  = new Upload();
        upload.setFileName(filePath.getFileName().toString());
        upload.setStartTime(new Date());
        int uploadId = uploadMapper.startFileUpload(upload);

        while (iterator.hasNext()) {
            FileRow row = iterator.next();
            if (row.isEmpty()) {
                continue;
            }

            UploadRow uploadRow;
            try {
                uploadRow = parser.parse(row);
            } catch (ParseRowException e) {
                LOG.error("Error while parsing price list row", e);
                continue;
            }

            if (uploadRow.isEmpty()) {
                continue;
            }

            processor.process(uploadRow);
        }

        uploadMapper.stopFileUpload(new Date(), upload.getId());
    }

    private RowProcessor getRowProcessor() {
        return new PricelistRowProcessor();
    }

    private PriceListRowParser getRowParser(Path filePath) {
        return new PriceListRowParser();
    }

    private Iterator<FileRow> getPricelistFileIterator(Path filePath) throws IOException {
        return new PoiExcelFileIterator(Files.newInputStream(filePath));
    }
}
