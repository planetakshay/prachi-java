package practice2023.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CurrencyConverter {
    Map<String, Map<String, Double>> exchangeRates;
    boolean found = false;

    public static void main(String[] args) {
        List<ExchangeRate> rates = new LinkedList<>();
        ExchangeRate rate = new ExchangeRate("EUR", "USD", 1.2);
        rates.add(rate);
        rate = new ExchangeRate("USD", "GBP", 0.75);
        rates.add(rate);
        rate = new ExchangeRate("GBP", "AUD", 1.7);
        rates.add(rate);
        rate = new ExchangeRate("AUD", "JPY", 90);
        rates.add(rate);
        rate = new ExchangeRate("GBP", "JPY", 150);
        rates.add(rate);
        rate = new ExchangeRate("JPY", "INR", 0.6);
        rates.add(rate);
        rate = new ExchangeRate("USD", "EUR", 1.0 / 1.2);
        rates.add(rate);
        rate = new ExchangeRate("AUD", "GBP", 1.0 / 1.7);
        rates.add(rate);
        rate = new ExchangeRate("JPY", "AUD", 1.0 / 90);
        rates.add(rate);
        rate = new ExchangeRate("JPY", "GBP", 1.0 / 150);
        rates.add(rate);
        rate = new ExchangeRate("INR", "JPY", 1.0 / 0.6);
        rates.add(rate);

        CurrencyConverter converter = new CurrencyConverter();
        converter.init(rates);
        System.out.println("Rate: " + converter.convert("USD", "INR", 50));
    }
    public void init(List<ExchangeRate> rates) {
        exchangeRates = new HashMap<>();
        for (ExchangeRate rate : rates) {
            String src = rate.src;
            String dest = rate.dest;
            Map<String, Double> mapping = exchangeRates.getOrDefault(src, new HashMap<>());
            mapping.put(dest, rate.rate);
            exchangeRates.put(src, mapping);
        }
    }

    public double convert(String src, String dest, double amount) {
        if (src.equals(dest)) {
            return amount;
        }
        List<String> visited = new LinkedList<>();
        visited.add(src);
        double d1 = getRate(visited, src, dest, 1);
        if (found) {
            return d1 * amount;
        }
        return 0.0;
    }

    private double getRate(List<String> visited, String src, String dest, double rate) {
        if (found) {
            return rate;
        }
        if (exchangeRates.get(src).get(dest) != null) {
            found = true;
            return exchangeRates.get(src).get(dest);
        }
        double orgRate = rate;
        for (String currency : exchangeRates.get(src).keySet()) {
            if (visited.contains(currency)) {
                continue;
            }
            visited.add(currency);
            rate = getRate(visited, src, dest, rate * exchangeRates.get(src).get(currency));
            if (found) {
                return rate;
            }
            visited.remove(currency);
            rate = orgRate;
        }
        return rate;
    }

    public double convertDijkstra(String src, String dest, double amount) {
        return 0.0;
    }
}

class ExchangeRate {
    String src;
    String dest;
    double rate;
    public ExchangeRate(String src, String dest, double rate) {
        this.src = src;
        this.dest = dest;
        this.rate = rate;
    }
}