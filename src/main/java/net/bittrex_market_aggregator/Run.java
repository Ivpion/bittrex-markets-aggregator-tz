package net.bittrex_market_aggregator;

import net.bittrex_market_aggregator.deamon.SyncMarketUpdDeamon;
import net.bittrex_market_aggregator.service.MarketService;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Run {

    private static final Logger LOGGER = Logger.getLogger(Run.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Start server..");
        MarketService service = (MarketService) SpringApplication.run(Run.class, args).getBean("marketServiceImpl");
        SyncMarketUpdDeamon.start(service);
    }
}
