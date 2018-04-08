package net.bittrex_market_aggregator.service;

import net.bittrex_market_aggregator.exception.MarketNotFoundException;
import net.bittrex_market_aggregator.model.Market;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

public interface MarketService {


    void updateMarkets() throws IOException, SQLException, ClassNotFoundException;

    Market getMarketInfoByName(String marketName) throws MarketNotFoundException, SQLException;

    double getLastChangesLastHourByMarketName(String marketName) throws MarketNotFoundException;

}
