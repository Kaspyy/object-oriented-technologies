package com.example.lab10;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CurrentDateTimeService {

    public CurrentDateTimeService(CurrentDateTimeProvider currentDateTimeProvider) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        currentDateTimeProvider = applicationContext.getBean("dateTimeProvider", CurrentDateTimeProvider.class);

        System.out.println(currentDateTimeProvider.currentDateTime());
    }


    public static void main(String[] args) {
        CurrentDateTimeService currentDateTimeService = new CurrentDateTimeService(null);
    }

}
