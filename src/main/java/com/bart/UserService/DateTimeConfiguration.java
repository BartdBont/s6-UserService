package com.bart.UserService;

import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Configuration
public class DateTimeConfiguration {
    public static ZonedDateTime getCurrentDateTime() {
        Instant nowUtc = Instant.now();
        ZoneId europeAmsterdam = ZoneId.of("Europe/Amsterdam");
        return ZonedDateTime.ofInstant(nowUtc, europeAmsterdam);
    }
}
