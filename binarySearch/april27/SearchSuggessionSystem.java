package binarySearch.april27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggessionSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord){
        //Step 1 : Sort product
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        String prefix = "";

        //Step 2 : process each prefix
        for (char c : searchWord.toCharArray()){
            prefix += c;

            int index = lowerBound(products,prefix);
            List<String> suggestions = new ArrayList<>();

            //collect at most 3 matching product
            for (int i = index; i < products.length && suggestions.size() < 3; i++) {
                if (products[i].startsWith(prefix)){
                    suggestions.add(products[i]);
                } else {
                    break;
                }
            }
            result.add(suggestions);
        }
        return result;
    }

    private int lowerBound(String[] products,String prefix){
        int left = 0;
        int right =  products.length;

        while (left < right){
            int mid = left + (right - left) / 2;

            if (products[mid].compareTo(prefix) < 0){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchSuggessionSystem sol = new SearchSuggessionSystem();
        String[] products1 = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord1 = "mouse";

        List<List<String>> result1 = sol.suggestedProducts(products1, searchWord1);
        System.out.println(result1);

        String[] products2 = {"havana"};
        String searchWord2 = "havana";

        List<List<String>> result2 = sol.suggestedProducts(products2, searchWord2);
        System.out.println(result2);
    }
}
