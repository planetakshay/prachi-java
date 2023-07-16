package practice2023;

import java.util.HashMap;
import java.util.Map;

public class MaxVersion {

    private Map<String, Integer> softwareVersions;

    public static void main(String[] args) {
        String[] software = new String[] {"iOS", "Google Doc", "iOS", "Windows", "Google Doc"};
        int[] versions = new int[] {11, 3, 5, 3, 6};

        MaxVersion maxVersion = new MaxVersion();
        maxVersion.buildVersionMap(software, versions);
        System.out.println("Software version: " + maxVersion.getVersion("Google Doc"));
    }

    public void buildVersionMap(String[] software, int[] versions) {
        if(software == null || software.length == 0 || versions == null || versions.length == 0) {
            return;
        }
        softwareVersions = new HashMap<>();
        for(int i = 0; i < software.length;i++) {
            String softwr = software[i].toLowerCase();
            int version = softwareVersions.getOrDefault(softwr,-1);
            if(versions[i] > version) {
                softwareVersions.put(softwr, versions[i]);
            }
        }
    }
    public int getVersion(String software) {
        return softwareVersions.get(software.toLowerCase());
    }
}
