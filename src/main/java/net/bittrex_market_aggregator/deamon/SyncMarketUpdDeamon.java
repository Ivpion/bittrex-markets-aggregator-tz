package net.bittrex_market_aggregator.deamon;

import net.bittrex_market_aggregator.service.MarketService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

public class SyncMarketUpdDeamon {

    private static final Logger LOGGER = Logger.getLogger(SyncMarketUpdDeamon.class);

    public static void start(MarketService service){
        LOGGER.info("Start demon...");
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                LOGGER.error(e.getMessage());
            }
            while (true){
                try {
                    service.updateMarkets();
                } catch (IOException | SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                    LOGGER.error(e.getMessage());
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    LOGGER.error(e.getMessage());
                }
            }
        });
        CompletableFuture.runAsync(thread);
    }
}
