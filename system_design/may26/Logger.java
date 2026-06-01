package system_design.may26;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Logger {

    //Store:
    //message -> last printed timestamp

    private Map<String, Long> messageTimestamps;

    public Logger() {
        // Initialize the messageTimestamps map
        messageTimestamps = new HashMap<>();
    }

    //return true if message should be printed, false otherwise
    public  boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTimestamps.containsKey(message)) {

            //store the timestamp for the message
            messageTimestamps.put(message, (long) timestamp);
            System.out.println("Message printed: " + message +" at timestamp: " + timestamp);

            return true;
        }

        //get the last printed timestamp for the message
         long lastTimestamp = messageTimestamps.get(message);
        System.out.println("Message printed: " + message +" at timestamp: " + timestamp);


        //check if at least 10 seconds have passed since the last print
        if (timestamp - lastTimestamp >= 10) {

            //update the timestamp for the message
            messageTimestamps.put(message, (long) timestamp);
            System.out.println("Message printed: " + message +" at timestamp: " + timestamp);


            return true;
        }

        //ignore the message if it was printed less than 10 seconds ago
        return false;
    }








    public static void main(String[] args) {
            Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "Hello, World!"));;
        System.out.println(logger.shouldPrintMessage(2, "This is a test message."));
        System.out.println(logger.shouldPrintMessage(3, "Logging system is working."));


        System.out.println(logger.shouldPrintMessage(4, "Hello, World!"));;
        System.out.println(logger.shouldPrintMessage(5, "This is a test message."));
        System.out.println(logger.shouldPrintMessage(6, "Logging system is working."));
    }
}



//        public void log(int level, String message) {
//                String logMessage = String.format("[%s] %s", getLogLevel(level), message);
//                System.out.println(logMessage);
//        }
//
//        private String getLogLevel(int level) {
//                switch (level) {
//                        case 1:
//                                return "DEBUG";
//                        case 2:
//                                return "INFO";
//                        case 3:
//                                return "ERROR";
//                        default:
//                                return "UNKNOWN";
//                }
//        }