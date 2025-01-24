package com.tau.jany;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GroupedDaily(
        boolean adjusted,
        Integer queryCount,
        List<Result> results,
        Integer resultCount,
        String status
) {

    public record Result(
            @JsonProperty("T") String ticker,
            @JsonProperty("c") double close,
            @JsonProperty("h") double high,
            @JsonProperty("l") double low,
            @JsonProperty("n") int numberOfTrades,
            @JsonProperty("o") double open,
            @JsonProperty("t") long timestamp,
            @JsonProperty("v") double volume,
            @JsonProperty("vw") double vwap
    ) {}
}
