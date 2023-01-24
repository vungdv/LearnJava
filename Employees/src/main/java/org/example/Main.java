package org.example;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime xmas = LocalDateTime.of(2021, 12, 25, 12, 0);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(xmas, ZoneId.of("-8"));
        System.out.println(zonedDateTime.withZoneSameInstant(ZoneId.of("+0")));
    }
}
