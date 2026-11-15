package systemDesign.easy;

import java.util.ArrayList;
import java.util.List;

// 1. Abstract Alert class
abstract class Alert {

    private final String target;

    public Alert(String target) {
        this.target = target;
    }

    // Each channel identifies itself
    public abstract String channel();

    // Each channel implements its own message rendering
    public abstract String render(String message);

    protected String getTarget() {
        return target;
    }
}

// 2. EmailAlert class
class EmailAlert extends Alert {

    public EmailAlert(String to) {
        super(to);
    }

    @Override
    public String channel() {
        return "email";
    }

    @Override
    public String render(String message) {
        return "EMAIL to " + getTarget() + ": " + message;
    }
}

// 3. SmsAlert class
class SmsAlert extends Alert {

    private static final int MAX_LENGTH = 20;

    public SmsAlert(String phone) {
        super(phone);
    }

    @Override
    public String channel() {
        return "sms";
    }

    @Override
    public String render(String message) {

        String shortenedMessage = message;

        if (message.length() > MAX_LENGTH) {
            shortenedMessage = message.substring(0, MAX_LENGTH);
        }

        return "SMS to " + getTarget() + ": " + shortenedMessage;
    }
}

// 4. PushAlert class
class PushAlert extends Alert {

    public PushAlert(String device) {
        super(device);
    }

    @Override
    public String channel() {
        return "push";
    }

    @Override
    public String render(String message) {
        return "PUSH to " + getTarget() + ": "
                + message.toUpperCase(java.util.Locale.ROOT);
    }
}

class WhatsAppAlert extends Alert {

    public WhatsAppAlert(String phone) {
        super(phone);
    }

    @Override
    public String channel() {
        return "whatsapp";
    }

    @Override
    public String render(String message) {
        return "WHATSAPP to " + getTarget() + ": " + message;
    }
}

// 5. Provided NotificationCenter class
class NotificationCenter {

    private final List<Alert> channels = new ArrayList<>();

    public NotificationCenter() {
    }

    private Alert channelAt(int index) {
        if (index < 0 || index >= channels.size()) {
            return null;
        }

        return channels.get(index);
    }

    public int addEmail(String to) {
        channels.add(new EmailAlert(to));
        return channels.size() - 1;
    }

    public int addSms(String phone) {
        channels.add(new SmsAlert(phone));
        return channels.size() - 1;
    }

    public int addPush(String device) {
        channels.add(new PushAlert(device));
        return channels.size() - 1;
    }

    public int count() {
        return channels.size();
    }

    public String channelOf(int index) {
        Alert channel = channelAt(index);
        return channel == null ? "UNKNOWN" : channel.channel();
    }

    public String send(int index, String message) {
        Alert channel = channelAt(index);
        return channel == null ? "UNKNOWN" : channel.render(message);
    }

    public String[] sendAll(String message) {
        String[] results = new String[channels.size()];

        for (int i = 0; i < channels.size(); i++) {
            results[i] = channels.get(i).render(message);
        }

        return results;
    }



    public static void main(String[] args) {

        NotificationCenter center = new NotificationCenter();

        // Add notification channels
        int emailIndex = center.addEmail("user@example.com");
        int smsIndex = center.addSms("9876543210");
        int pushIndex = center.addPush("DEVICE_101");

        String message = "Your order has been successfully delivered";

        // Total channels
        System.out.println("Total Channels: " + center.count());

        System.out.println();

        // Email notification
        System.out.println("Email Channel: " + center.channelOf(emailIndex));
        System.out.println(center.send(emailIndex, message));

        System.out.println();

        // SMS notification
        System.out.println("SMS Channel: " + center.channelOf(smsIndex));
        System.out.println(center.send(smsIndex, message));

        System.out.println();

        // Push notification
        System.out.println("Push Channel: " + center.channelOf(pushIndex));
        System.out.println(center.send(pushIndex, message));

        System.out.println();

        // Send to all channels
        System.out.println("Send All:");

        String[] results = center.sendAll(message);

        for (String result : results) {
            System.out.println(result);
        }

        System.out.println();

        // Invalid index testing
        System.out.println("Invalid Channel: " + center.channelOf(10));
        System.out.println("Invalid Send: " + center.send(10, message));

        System.out.println("WhatsApp Channel: " + center.channelOf(3));
        System.out.println("WhatsApp Send: " + center.send(3, message));

    }
}
