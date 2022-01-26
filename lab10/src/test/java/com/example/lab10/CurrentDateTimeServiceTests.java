package com.example.lab10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CurrentDateTimeServiceTests {

    private CurrentDateTimeService currentDateTimeService;
    private HumanReadableDateTimeProvider humanReadableDateTimeProvider;
    private IsoDateTimeProvider isoDateTimeProvider;

    @Test
    void currentDateTimeServiceTest() {

        humanReadableDateTimeProvider = mock(HumanReadableDateTimeProvider.class);
        isoDateTimeProvider = mock(IsoDateTimeProvider.class);


        when(humanReadableDateTimeProvider.currentDateTime()).thenReturn("7 Feb 2022 12:23:34");
        when(isoDateTimeProvider.currentDateTime()).thenReturn("2022-02-07T12:23:34");

        assertEquals("2022-02-07T12:23:34", isoDateTimeProvider.currentDateTime());
        assertEquals("7 Feb 2022 12:23:34", humanReadableDateTimeProvider.currentDateTime());

    }



}
