package practice2023.strings;

import java.net.Inet6Address;
import java.net.InetAddress;

/**
 * https://leetcode.com/problems/validate-ip-address
 */
public class ValidateIpAddress {
    public String validIPAddress(String queryIP) {
        try {
            InetAddress addr = InetAddress.getByName(queryIP);
            if (addr instanceof Inet6Address) {
                return "IPv6";
            } else if (addr instanceof InetAddress) {
                return "IPv4";
            }
            return "Neither";
        } catch (Exception e) {
            return "Neither";
        }
    }
}