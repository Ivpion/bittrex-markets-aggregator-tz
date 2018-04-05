package net.bittrex_market_aggregator.parser;

import net.bittrex_market_aggregator.model.Market;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.*;
import java.net.URL;
import java.util.*;

public class BittrexParser {

    private final ObjectMapper mapper = new ObjectMapper();


    public BittrexParser() {
    }

    public List<Market> readJsonFromUrl(URL url) throws IOException {
        String jsonNode = mapper.readTree(url).path("result").toString();
        System.out.println(jsonNode);
        List<Market> list1 = mapper.readValue(jsonNode, new TypeReference<List<Market>>() {
        });
        list1.forEach(System.out::println);
        return list1;
    }

}
