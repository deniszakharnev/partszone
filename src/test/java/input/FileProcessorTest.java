package input;

import mapper.FileUploadMapper;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.nio.file.Path;

public class FileProcessorTest {

    @InjectMocks
    private FileProcessor processor = new FileProcessor();

    @Mock
    private FileUploadMapper uploadMapper;

    @Mock
    private Path inputFile;

    @Test
    public void testProcess() {
         processor.process(inputFile);
    }
}
