package tugas6.id.service;

import io.quarkus.scheduler.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.time.LocalDateTime;

@ApplicationScoped
public class SchedelulerService {

    @Inject
    MailService mailService;
    Logger logger = LoggerFactory.getLogger(SchedelulerService.class);

    @Scheduled(every = "1h")
    public void generateKawahEdukasi(){
        logger.info("Kawah Edukasi_{}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 12 1 * ?")
    public void generateSendEmailEveryMonth() throws IOException {
        mailService.sendExcelToEmail("kurniawan7437@gmail.com");
        logger.info("Send Email Success");
    }
}
