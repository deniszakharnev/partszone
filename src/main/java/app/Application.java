package app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("mapper")
@ComponentScan("service;input;jmx")
@EnableScheduling
public class Application implements CommandLineRunner {

    private static Log LOG = LogFactory.getLog(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        LOG.info("Application has started");
    }
}
