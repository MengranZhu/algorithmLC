package src.google;

import java.util.HashMap;
import java.util.Map;
/*
* 359. Logger Rate Limiter
*solution: use hashmap to store message and timestamp
*
*
* */
public class LoggerRateLimiter {

    /**
     * Initialize your data structure here.
     */
    private Map<String, Integer> map;

    public LoggerRateLimiter() {
        map = new HashMap();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            if (timestamp - map.get(message) >= 10) {
                map.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        } else {
            map.put(message, timestamp);
            return true;
        }
    }
}
