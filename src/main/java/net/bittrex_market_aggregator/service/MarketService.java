package net.bittrex_market_aggregator.service;

import net.bittrex_market_aggregator.exception.MarketNotFoundException;
import net.bittrex_market_aggregator.model.Market;

public interface MarketService {


    void updateMarkets();

    Market getMarketInfoByName(String marketName)throws MarketNotFoundException;

    double getLastChangesLastHourByMarketName(String marketName) throws MarketNotFoundException;

}
