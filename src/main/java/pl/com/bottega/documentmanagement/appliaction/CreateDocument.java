package pl.com.bottega.documentmanagement.appliaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.com.bottega.documentmanagement.api.DocumentFlowProcess;
import pl.com.bottega.documentmanagement.api.UserManager;
import pl.com.bottega.documentmanagement.domain.EmployeeId;

/**
 * Created by arkadiuszarak on 18/06/2016.
 */
public class CreateDocument {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"application.xml"}); //stworzenie container, wielka konfigurowalna fabryka
        UserManager userManager = applicationContext.getBean("userManager", UserManager.class);
        userManager.signup("misiek", "123456" , new EmployeeId(666l));
        userManager.login("misiek", "123456");

        DocumentFlowProcess documentFlowProcess = applicationContext.getBean("documentFlowProcess", DocumentFlowProcess.class);
        documentFlowProcess.create("my first doc", "traaaaa");
    }
}
