package net.bittrex_market_aggregator;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Run {

    private static final Logger LOGGER = Logger.getLogger(Run.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Start server..");
        SpringApplication.run(Run.class, args);
    }
}
