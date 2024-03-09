package practice2023.design;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

public class ConsistentHashing {
    private static final String MD5 = "MD5";
    private final TreeMap<Long, String> ring;
    private final int shards;
    private final MessageDigest md;

    public ConsistentHashing(int shards) throws NoSuchAlgorithmException {
        this.ring = new TreeMap<>();
        this.shards = shards;
        this.md = MessageDigest.getInstance(MD5);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        ConsistentHashing consistentHashing = new ConsistentHashing(6);
        consistentHashing.addServer("shard1");
        consistentHashing.addServer("shard2");
        consistentHashing.addServer("shard3");
        consistentHashing.addServer("shard4");
        consistentHashing.addServer("shard5");
        String key1= "key1";
        String key67890 = "key67890";
        System.out.println(key1 + " is present on server: " + consistentHashing.getServer(key1));
        System.out.println(key67890 + " is present on server: " + consistentHashing.getServer(key67890));

        consistentHashing.removeServer("shard1");
        System.out.println("After removing shard1.");

        System.out.println(key1 + " is present on server: " + consistentHashing.getServer(key1));
        System.out.println(key67890 + " is present on server: " + consistentHashing.getServer(key67890));

        consistentHashing.addServer("shard6");
        System.out.println("After adding shard6");
        System.out.println(key1 + " is present on server: " + consistentHashing.getServer(key1));
        System.out.println(key67890 + " is present on server: " + consistentHashing.getServer(key67890));    }

    public void addServer(String server) {
        for (int i = 0; i < shards; i++) {
            long hash = generateHash(server + i);
            ring.put(hash, server);
        }
    }

    public void removeServer(String server) {
        for (int i = 0; i < shards; i++) {
            long hash = generateHash(server + i);
            ring.remove(hash);
        }
    }

    public long generateHash(String key) {
        md.reset();
        md.update(key.getBytes());
        byte[] digest = md.digest();
        long hash = ((long) (digest[3] & 0xFF) << 24) |
                ((long) (digest[3] & 0xFF) << 24) |
                ((long) (digest[3] & 0xFF) << 24) |
                ((long) (digest[3] & 0xFF) << 24);
        return hash;
    }

    public String getServer(String server) {
        if (ring.isEmpty()) {
            return null;
        }
        long hash = generateHash(server);
        if (!ring.containsKey(hash)) {
            Map.Entry<Long, String> entry = ring.ceilingEntry(hash);
            if (entry == null) {
                entry = ring.firstEntry();
            }
            return entry.getValue();
        }
        return ring.get(hash);
    }
}