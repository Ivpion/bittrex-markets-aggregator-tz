package net.bittrex_market_aggregator;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Run {

    private static final Logger LOGGER = Logger.getLogger(Run.class.getName());

    public static void main(String[] args) {
        LOGGER.info("HELLO");
        LOGGER.error("HELLO");
        LOGGER.warn("HELLO");

        SpringApplication.run(Run.class, args);
    }
}
