package net.bittrex_market_aggregator.exception;

public class MarketNotFoundException extends Exception {
    public MarketNotFoundException() {
    }

    public MarketNotFoundException(String message) {
        super(message);
    }
}
