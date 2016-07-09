package pl.com.bottega.documentmanagement.appliaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.com.bottega.documentmanagement.api.DocumentFlowProcess;
import pl.com.bottega.documentmanagement.api.SigneupResultDto;
import pl.com.bottega.documentmanagement.api.SignupResultDto;
import pl.com.bottega.documentmanagement.api.UserManager;
import pl.com.bottega.documentmanagement.domain.DocumentNumber;
import pl.com.bottega.documentmanagement.domain.EmployeeId;

/**
 * Created by arkadiuszarak on 18/06/2016.
 */
public class CreateDocument {

    public static void main(String[] args) {
        // create a spring Container, load the spring configuration file
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"application.xml"}); //stworzenie container, wielka konfigurowalna fabryka
        // retriever bean from spring container
        UserManager userManager = applicationContext.getBean("userManager", UserManager.class);
        // call methods on the been
        userManager.signup("misiek", "123456" , new EmployeeId(50l));
      //  userManager.login("misiek", "123456");
        SignupResultDto result = userManager.login("misiek", "123456");
        System.out.println(result);

        // retriever bean from spring container
        DocumentFlowProcess documentFlowProcess = applicationContext.getBean("documentFlowProcess", DocumentFlowProcess.class);
        DocumentNumber number = documentFlowProcess.create("my first doc", "traaaaa");
        System.out.println(number);
    }
}
