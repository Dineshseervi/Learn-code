package main.java.test;

import sun.util.resources.LocaleData;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class SpliUrl {
    public static void main(String[] args) {

        long val=30000L*8;
        System.out.println(val);
        // System.out.println("Date Time : "+new LocalDateTime());
    }

    private static void OffeSetDateTimeTest() {
        String uri="http://localhost:9080/login/rest/profile";
        String [] array=uri.split("/login");
        System.out.println(array[1].toString());
        OffsetDateTime offsetDateTime=OffsetDateTime.now();

        System.out.println(offsetDateTime);
        System.out.println("Zone :"+offsetDateTime.getOffset());
        System.out.println("offset :"+offsetDateTime.toLocalDateTime());

        System.out.println("----------=========-------");
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        OffsetDateTime newOffsetDateTime=OffsetDateTime.of(localDateTime, offsetDateTime.getOffset());
        System.out.println("TEST: "+newOffsetDateTime);

        System.out.println("----------=======3333 ==-------");
        Instant instant2 = Instant.ofEpochMilli(System.currentTimeMillis()-250000);
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault());
        OffsetDateTime newOffsetDateTime2=OffsetDateTime.of(localDateTime2, offsetDateTime.getOffset());
        System.out.println("TEST: "+newOffsetDateTime2);
    }
}
