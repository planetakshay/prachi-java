package practice2023.design;

/**
 * Reddit phone screen.
 * Implement rate limit for api calls to getMeme up to 3 calls per second.
 * Once done for the API, extend the implementation for multiple users.
 */
public class RateLimit {
    Rate rate;
    String meme = "something";

    public RateLimit() {
        rate = new Rate();
    }

    public String getMeme(long timestamp) {
        if(shouldServe(timestamp)) {
            this.rate.count++;
            return meme;
        }
        return null;
    }

    public boolean shouldServe(long timestamp) {
        long curr = timestamp;
        if(curr - this.rate.timestamp > 1000) {
            rate.timestamp = curr;
            rate.count = 0;
            return true;
        }
        if(this.rate.count > 3) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        RateLimit rateLimit = new RateLimit();
        long curr = System.currentTimeMillis();
        assert rateLimit.getMeme(curr) != null;
        assert rateLimit.getMeme(curr) != null;
        assert rateLimit.getMeme(curr) != null;
        assert rateLimit.getMeme(curr) == null;
        curr = curr + 1;
        assert rateLimit.getMeme(curr) != null;
        assert rateLimit.getMeme(curr) != null;
        assert rateLimit.getMeme(curr) != null;
        assert rateLimit.getMeme(curr + 2) != null;
        assert rateLimit.getMeme(curr) == null;
    }
}

class Rate {
    long timestamp;
    int count;

    public Rate() {
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}