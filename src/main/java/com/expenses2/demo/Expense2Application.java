package com.expenses2.demo;

import com.itextpdf.text.DocumentException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.asnworks.apis.springemailexample.utils.EmailUtil;

import java.io.*;

@SpringBootApplication
//@EnableScheduling
//@Configuration
//@ComponentScan({"com.expenses2.demo.controller", "com.expenses2.demo.repository"})
//public class Expense2Application implements CommandLineRunner {
public class Expense2Application extends SpringBootServletInitializer {
//    @Autowired
//    private JavaMailSender javaMailSender;

    //    @Autowired
//    private EmailSender emailSender;
//        @Override
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        SpringApplication.run(Expense2Application.class, args);
//        ExpenseController cc = new ExpenseController();
//        cc.getAllUniqueSerial();
    }
//    public void run(String... args) throws Exception {
//        emailSender.sendEmailAttachment("Utility Bill Report Template [Test]",
//                "Please find the attach utility bill report template for ur review",
//
//                "berihun.hadis@bankofabyssinia.com",
//                "berihun.hadis@bankofabyssinia.com",
//                true, new File("C:/Users/admin/Desktop/billadvice.pdf"));
//    }


//
//    @Resource
//    FilesStorageService storageService;C

//    @Override
//    public void run(String... args) throws MessagingException, IOException {
//
//        System.out.println("Sending Email...");
//
//        sendMail("berihun.hadis@bankofabyssinia.com", "monthly bill", "your monthly utility bill is attached herein");
////            sendEmailWithAttachment();
////        sendEmailWithAttachment();
//        System.out.println("Done");
//        storageService.deleteAll();
//        storageService.init();
//    }
//
//    public void sendMail(String to, String subject, String body) throws MessagingException, IOException {
//        MimeMessage message = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper;
//        helper = new MimeMessageHelper(message, true);//true indicates multipart message
//
//        helper.setFrom("StaffBenefitANDperformance@bankofabyssinia.com");// <--- THIS IS IMPORTANT
//
//        helper.setSubject(subject);
//        helper.setTo(to);
//        helper.setText(body, true);//true indicates body is html
//        javaMailSender.send(message);
////        sendEmailWithAttachment();
//
//    }

//    void sendEmailWithAttachment() throws MessagingException, IOException {
//
//        MimeMessage msg = javaMailSender.createMimeMessage();
//
//        // true = multipart message
//        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
//        helper.setTo("berihun.hadis@bankofabyssinia.com");
//
//        helper.setSubject("Testing from Spring Boot");
//
//        // default = text/plain
//        //helper.setText("Check attachment for image!");
//
//        // true = text/html
//        helper.setText("<h1>Check attachment for image!</h1>", true);
//
//        //FileSystemResource file = new FileSystemResource(new File("classpath:android.png"));
//
//        //Resource resource = new ClassPathResource("android.png");
//        //InputStream input = resource.getInputStream();
//
//        //ResourceUtils.getFile("classpath:android.png");
//
//        helper.addAttachment("55.xlsx", new ClassPathResource("android.png"));
//
//        javaMailSender.send(msg);
//
//    }

}
