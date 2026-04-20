package linkedList;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
    private List<String> history;
    private int current;
    private int last;

    public BrowserHistory(String homepage){
        history = new ArrayList<>();
        history.add(homepage);
        current = 0;
        last = 0;
    }

    public void visit(String url){
        current++;
        if (current < history.size()) history.set(current,url);
        else history.add(url);
        last = current;
    }

    public  String back(int steps){
        current = Math.max(0,current - steps);
        return history.get(current);
    }

    public String forward(int steps){
        current = Math.min(last,current + steps);
        return history.get(current);
    }


    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");

        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");

        System.out.println(browserHistory.back(1));     // facebook.com
        System.out.println(browserHistory.back(1));     // google.com
        System.out.println(browserHistory.forward(1));  // facebook.com

        browserHistory.visit("linkedin.com");

        System.out.println(browserHistory.forward(2));  // linkedin.com
        System.out.println(browserHistory.back(2));     // google.com
        System.out.println(browserHistory.back(7));
    }

}
