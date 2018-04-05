package net.bittrex_market_aggregator.parser;

import net.bittrex_market_aggregator.model.Market;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.URL;
import java.util.*;

public class BittrexParser {

    private final ObjectMapper mapper;

    @Autowired
    public BittrexParser(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    private List<Market> readJsonFromUrl(String url) throws IOException {
        String jsonNode = mapper.readTree(new URL(url)).path("result").toString();
        System.out.println(jsonNode);
        List<Market> list1 = mapper.readValue(jsonNode, new TypeReference<List<Market>>() {
        });
        list1.forEach(System.out::println);
        return list1;
    }

    public static void main(String[] args) throws IOException {
        new BittrexParser(new ObjectMapper())
                .readJsonFromUrl("https://bittrex.com/api/v1.1/public/getmarketsummaries");
    }
}
