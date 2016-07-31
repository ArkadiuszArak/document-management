package pl.com.bottega.documentmanagement.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.com.bottega.documentmanagement.api.NPlusJedenSelectSymulator;
import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.Tag;

/**
 * Created by arkadiuszarak on 30/07/2016.
 */
public class NPlusJedenTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"application.xml"});
        NPlusJedenSelectSymulator simulator = applicationContext.getBean(NPlusJedenSelectSymulator.class);
      //  simulator.insertTestData();
       // simulator.simulate();
        Document d = simulator.getDocument();
        for (Tag t : d.tags()){
            System.out.println(t);
        }
    }
}
