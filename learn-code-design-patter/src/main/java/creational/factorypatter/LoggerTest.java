package main.java.creational.factorypatter;

import java.util.Scanner;

public class LoggerTest {
    public static void main(String[] args) {
        Logger logger=LoggerFactory.build(LoggerFactory.LoggerType.DBLOGGER);
        logger.log();

    }
}
