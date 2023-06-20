package practice2023;

import java.util.*;

public class LeastPopularPerson {

    public static String findLeastPopular(List<Message> messages) {

        if (messages == null || messages.isEmpty()) {
            return null;
        }
        Map<String, Integer> messagesReceived = new HashMap<>();
        for (Message message : messages) {
            messagesReceived.put(message.getTo(), (messagesReceived.getOrDefault(message.getTo(),0)) + 1);
        }
        return messagesReceived.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).findFirst().get().getKey();
    }

    public static void main(String[] args) {
        Message message1 = new Message("to1", "from1", "message1");
        Message message2 = new Message("to2", "from2", "message2");
        Message message3 = new Message("to3", "from3", "message3");
        Message message4 = new Message("to4", "from4", "message4");
        Message message5 = new Message("to5", "from5", "message5");
        Message message6 = new Message("to1", "from11", "message1");
        Message message7 = new Message("to2", "from12", "message2");
        Message message8 = new Message("to3", "from13", "message3");
        Message message9 = new Message("to4", "from14", "message4");
        Message message10 = new Message("to2", "from21", "message2");

        System.out.println("Least Popular person: " + findLeastPopular(Arrays.asList(message1, message2, message3, message4, message5, message6, message7, message8, message9, message10)));
    }
}

class Message {
    String to;
    String message;
    String from;

    public Message(String to, String from, String message) {
        this.to = to;
        this.from = from;
        this.message = message;
    }
    public String getTo() {
        return to;
    }
}
