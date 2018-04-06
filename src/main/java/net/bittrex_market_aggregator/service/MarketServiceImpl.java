package net.bittrex_market_aggregator.service;

import net.bittrex_market_aggregator.dao.MarketDao;
import net.bittrex_market_aggregator.exception.MarketNotFoundException;
import net.bittrex_market_aggregator.model.Market;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MarketServiceImpl implements MarketService{

    private final static Logger LOGGER = Logger.getLogger(MarketServiceImpl.class);

    private final MarketDao dao;

    @Autowired
    public MarketServiceImpl(MarketDao dao) {
        this.dao = dao;
    }


    @Override
    public void updateMarkets() {

    }

    @Override
    public Market getMarketInfoByName(String marketName)  throws MarketNotFoundException{
        return null;
    }

    @Override
    public double getLastChangesLastHourByMarketName(String marketName) throws MarketNotFoundException {
        return 0;
    }
}
