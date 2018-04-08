package net.bittrex_market_aggregator.dao;

import net.bittrex_market_aggregator.model.Market;

import java.sql.SQLException;
import java.util.List;

public interface MarketDao {
    void saveAndUpdateAllMarkets(List<Market> list) throws ClassNotFoundException, SQLException;

    Market findMarketByName(String name) throws SQLException;
}
