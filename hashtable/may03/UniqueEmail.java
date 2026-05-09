package hashtable.may03;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmail {

    public int numUniqueEmails(String[] emails ){
        Set<String> unique = new HashSet<>();

        for (String email : emails){

            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];

            //remove after '+'
            int plusIndex = local.indexOf('+');
            if (plusIndex != -1){
                local = local.substring(0,plusIndex);
            }

            //Step 2 : remove '.'
            local = local.replace(".","");

            //Step 3 : combine
            unique.add(local + "@" + domain);
        }
        return unique.size();
    }

    public static void main(String[] args) {

        UniqueEmail sol = new UniqueEmail();

        String[] emails1 = {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        };

        System.out.println(sol.numUniqueEmails(emails1)); // 2

        String[] emails2 = {
                "a@leetcode.com",
                "b@leetcode.com",
                "c@leetcode.com"
        };

        System.out.println(sol.numUniqueEmails(emails2)); // 3
    }
}
