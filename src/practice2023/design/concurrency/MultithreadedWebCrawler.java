package practice2023.design.concurrency;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/web-crawler-multithreaded/description/
 *
 */
public class MultithreadedWebCrawler {
    private Set<String> visited;
    private String tld;
    private HtmlParser parser;

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        // Use newKeySet() method from ConcurrentHashMap as
        // Java doesn't have ConcurrentHashSet.
        visited = ConcurrentHashMap.newKeySet();
        visited.add(startUrl);
        tld = getHostName(startUrl);
        parser = htmlParser;
        return dfs(startUrl).collect(Collectors.toList());
    }

    private Stream<String> dfs(String url) {
        Stream<String> links = parser.getUrls(url).parallelStream().
                filter(link -> getHostName(link).equals(tld)).
                filter(link -> visited.add(link)).
                flatMap(link -> dfs(link));
        return Stream.concat(Stream.of(url), links);
    }

    private String getHostName(String url) {
        return url.split("/")[2];
    }
}