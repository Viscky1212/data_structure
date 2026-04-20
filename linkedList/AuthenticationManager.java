package linkedList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AuthenticationManager {
    private int timeToLive;
    private Map<String,Integer> expiryMap;

    public AuthenticationManager(int timeToLive){
        this.timeToLive = timeToLive;
        this.expiryMap = new HashMap<>();
    }
    public void generate(String tokenId, int currentTime){
        expiryMap.put(tokenId,currentTime + timeToLive);
    }
    public void  renew(String tokenId, int currentTime){
        if (expiryMap.containsKey(tokenId) && expiryMap.get(tokenId) > currentTime){
            expiryMap.put(tokenId,currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime){
        Iterator<Map.Entry<String,Integer>> it = expiryMap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String,Integer> entry = it.next();
            if (entry.getValue() <= currentTime) it.remove();
        }
        return expiryMap.size();
    }

    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager(5);

        authenticationManager.renew("aaa", 1);
        authenticationManager.generate("aaa", 2);
        System.out.println(authenticationManager.countUnexpiredTokens(6));
        authenticationManager.generate("bbb", 7);
        authenticationManager.renew("aaa", 8);
        authenticationManager.renew("bbb", 10);
        System.out.println(authenticationManager.countUnexpiredTokens(15));
    }
}
