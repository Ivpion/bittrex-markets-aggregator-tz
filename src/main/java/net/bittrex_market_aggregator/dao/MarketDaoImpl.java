package net.bittrex_market_aggregator.dao;


import net.bittrex_market_aggregator.config.MyDataSource;
import net.bittrex_market_aggregator.model.Market;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class MarketDaoImpl implements MarketDao {

    private static final Logger LOGGER = Logger.getLogger(MarketDaoImpl.class);

    private final MyDataSource dataSource;

    @Autowired
    public MarketDaoImpl(MyDataSource source) {
        this.dataSource = source;
    }
    @Override
    public void saveAndUpdateAllMarkets(List<Market> list) throws ClassNotFoundException, SQLException {
        Statement statement = getStatement();
        long start = System.currentTimeMillis();
        LOGGER.info("Start updating all markets...");
        list.forEach(market -> {
            String query = createInsertUpdateQuery(market);
            try {
                statement.execute(query);
            } catch (SQLException e) {
                e.printStackTrace();
                LOGGER.error(e.getMessage());
            }
        });
        long millis = System.currentTimeMillis() - start;
        LOGGER.info("Insert/update all markets: - " + millis + " millis");
    }

    @Override
    public Market findMarketByName(String name) throws SQLException {
        //todo fix timestamp. created and double after separeted
        Statement statement = getStatement();
        LOGGER.info("Search market with name: " + name);
        ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM markets WHERE market_name = \'%s\'", name));
        resultSet.next();
        LOGGER.info("Find market with name");
        LOGGER.info("Start convert result set to Market....");
        Market market = new Market();
        market.setMarketName(resultSet.getString("market_name"));
        market.setHigh(resultSet.getDouble("high"));
        market.setLow(resultSet.getDouble("low"));
        market.setVolume(resultSet.getDouble("volume"));
        market.setLast(resultSet.getDouble("last"));
        market.setBaseVolume(resultSet.getDouble("base_volume"));
        market.setTimestamp(resultSet.getString("time_stamp"));
        market.setBid(resultSet.getDouble("bid"));
        market.setAsk(resultSet.getDouble("ask"));
        market.setOpenBuyOrders(resultSet.getInt("open_buy_orders"));
        market.setOpenSellOrders(resultSet.getInt("open_sell_orders"));
        market.setPrevDay(resultSet.getDouble("prev_day"));
        market.setCreated(resultSet.getString("created"));
        market.setDisplayMarketName(resultSet.getString("display_market_name"));
        LOGGER.info("Convert to Market successful");
        return market;
    }

    private Statement getStatement() throws SQLException {
        LOGGER.info("Create statement");
        return dataSource.getConnection().createStatement();
    }

    private String createInsertUpdateQuery(Market market) {
        return String.format("Insert into markets (market_name, high, low, volume, last, base_volume, time_stamp," +
                        " bid, ask, open_buy_orders, open_sell_orders, prev_day, created, display_market_name)" +
                        "values (\'%s\', %.10f, %.10f, %.10f, %.10f, %.10f, \'%s\', %.10f, %.10f, %d, %d, %.10f, \'%s\', \'%s\')" +
                        " on duplicate KEY UPDATE " +
                        "high = %2$.10f," +
                        "low = %3$.10f," +
                        "volume = %4$.10f," +
                        "last = %5$.10f," +
                        "base_volume = %6$.10f," +
                        "time_stamp = \'%7$s\'," +
                        "bid = %8$.10f," +
                        "ask = %9$.10f," +
                        "open_buy_orders = %10$d," +
                        "open_sell_orders = %11$d," +
                        "prev_day = %12$.10f," +
                        "created = \'%13$s\'," +
                        "display_market_name = \'%14$s\'",
                market.getMarketName(),
                market.getHigh(),
                market.getLow(),
                market.getVolume(),
                market.getLast(),
                market.getBaseVolume(),
                market.getTimestamp(),
                market.getBid(),
                market.getAsk(),
                market.getOpenBuyOrders(),
                market.getOpenSellOrders(),
                market.getPrevDay(),
                market.getCreated(),
                market.getDisplayMarketName());
    }
}
