package com.example.lab10;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component("dateTimeProvider")
public class HumanReadableDateTimeProvider implements CurrentDateTimeProvider {

    String timeStamp = new SimpleDateFormat("dd MMM yyyy HH:mm:ss").format(new Date());

    @Override
    public String currentDateTime() {
        return timeStamp;
    }
}
