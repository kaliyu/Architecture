package facades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageFacade {
    private static final List<String> messages = new ArrayList<>();

    public static void addMessage(String msg) {
        if (msg != null && !msg.trim().isEmpty()) {
            messages.add(msg);
        }
    }

    public static List<String> getAllMessages() {
        return new ArrayList<>(messages); // retourne une copie
    }

    public static String getRandomMessage() {
        if (messages.isEmpty()) return null;
        Collections.shuffle(messages);
        return messages.get(0);
    }

    public static void clearAllMessages() {
        messages.clear();
    }

    public static boolean isEmpty() {
        return messages.isEmpty();
    }

    public static int count() {
        return messages.size();
    }
}
