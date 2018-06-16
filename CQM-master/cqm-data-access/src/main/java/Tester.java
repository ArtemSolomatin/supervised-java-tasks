import org.cqm.data.configuration.AppConfig;
import org.cqm.data.entity.Cafeteria;
import org.cqm.data.entity.Report;
import org.cqm.data.entity.User;
import org.cqm.data.entity.Vote;
import org.cqm.data.repositories.CafeteriaRepository;
import org.cqm.data.repositories.ReportRepository;
import org.cqm.data.repositories.UserRepository;
import org.cqm.data.repositories.VoteRepository;
import org.cqm.data.services.CafeteriaService;
import org.cqm.data.services.ReportService;
import org.cqm.data.services.UserService;
import org.cqm.data.services.VoteService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 * The following class can be used for testing some Hibernate queries and data
 */

public class Tester {

    private static final Logger logger = Logger.getLogger(Tester.class.getName());

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        logger.info("Testing configuration...");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserRepository userRepository = context.getBean(UserRepository.class);
        UserService userService = context.getBean(UserService.class);

        Cafeteria cafeteria = null;
        CafeteriaRepository cafeteriaRepository = context.getBean(CafeteriaRepository.class);
        CafeteriaService cafeteriaService = context.getBean(CafeteriaService.class);

        ReportRepository reportRepository = context.getBean(ReportRepository.class);
        ReportService reportService = context.getBean(ReportService.class);

        VoteRepository voteRepository = context.getBean(VoteRepository.class);
        VoteService voteService = context.getBean(VoteService.class);
    }
}
