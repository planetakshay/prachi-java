package practice2023.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-email-addresses/description/
 */
public class UniqueEmails {

    public static void main(String[] args) {
        String[] emails = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println("No of unique emails: " + numUniqueEmails(emails));

        emails = new String[] {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        System.out.println("No of unique emails: " + numUniqueEmails(emails));

        emails = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println("No of unique emails: " + straightForward(emails));

        emails = new String[] {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        System.out.println("No of unique emails: " + straightForward(emails));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        if (emails == null) {
            return uniqueEmails.size();
        }
        for (String email : emails) {
            String[] parts = email.split("@");
            if (parts.length == 2) {
                StringBuilder builder = new StringBuilder();
                builder.append(prepLocalName(parts[0]));
                builder.append("@");
                builder.append(parts[1]);
                uniqueEmails.add(builder.toString());
            }
        }
        return uniqueEmails.size();
    }

    public static String prepLocalName(String localName) {
        String local = localName;
        if (local.contains("+")) {
            local = local.substring(0, local.indexOf("+"));
        }
        local = local.replaceAll("\\.", "");
        return local;
    }

    public static int straightForward(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        if (emails == null) {
            return uniqueEmails.size();
        }
        for (String email : emails) {
            int plusInd = email.indexOf("+");
            int atInd = email.indexOf("@");
            String temp = "";
            if(plusInd != -1) {
                temp = email.substring(0, plusInd);
            } else {
                temp = email.substring(0, atInd);
            }
            temp = temp.replaceAll("\\.", "");

            StringBuilder builder = new StringBuilder();
            builder.append(temp);
            builder.append(email.substring(atInd));
            uniqueEmails.add(builder.toString());
        }
        return uniqueEmails.size();
    }
}
