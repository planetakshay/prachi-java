package practice2023.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/web-crawler/description/
 */
public class WebCrawler {
    private Set<String> visited;
    private String hostName;
    private HtmlParser parser;
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        visited = new HashSet<>();
        parser = htmlParser;
        hostName = getHostName(startUrl);
        dfs(startUrl);
        return new ArrayList<>(visited);
    }
    private void dfs(String url) {
        visited.add(url);
        for(String next : parser.getUrls(url)) {
            if(getHostName(next).equals(hostName)
                    && !visited.contains(next)) {
                dfs(next);
            }
        }
    }
    private String getHostName(String url) {
        return url.split("/")[2];
    }
}

interface HtmlParser {
    public List<String> getUrls(String url);
}