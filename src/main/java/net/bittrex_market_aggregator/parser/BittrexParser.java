package net.bittrex_market_aggregator.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bittrex_market_aggregator.model.Market;


import java.io.*;
import java.net.URL;
import java.util.*;

public class BittrexParser {


    private final ObjectMapper mapper = new ObjectMapper();


    public BittrexParser() {
    }

    public List<Market> readJsonFromUrl(URL url) throws IOException {
        String jsonNode = mapper.readTree(url).path("result").toString();
        return mapper.readValue(jsonNode, new TypeReference<List<Market>>() {
        });
    }

}
