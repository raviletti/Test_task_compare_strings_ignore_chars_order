import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String[] array = {"a", "qwe", "ewq","wqe","qwee","a","a", "af", "ad", "da", "iamlordvoldemort", "tommarvoloriddle"};
        compareIgnoreOrder(array);
    }


    public static String compareIgnoreOrder(String[] strings){
        List<Integer> stringCharsAsInts = Arrays.stream(strings).map(e -> {
            int charsCounter = 0;
            for (int k = 0; k < e.length(); k++) {
                charsCounter += e.charAt(k);
            }
            return charsCounter;
        }).toList();

        Map<Integer, Long> pairMatches = stringCharsAsInts.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Integer> stringCharsAsIntsCopy = new ArrayList<>(stringCharsAsInts);
        StringBuilder result = new StringBuilder();

        for(Integer val : pairMatches.keySet()){
            if(pairMatches.get(val) > 1){
                result.append(strings[stringCharsAsInts.indexOf(val)]).append(" = ");
                for(int i=0; i<pairMatches.get(val); i++){
                    int curentIndex =  stringCharsAsIntsCopy.indexOf(val);
                    result.append(curentIndex).append(i==pairMatches.get(val)-1 ? ". " : ", ");
                    stringCharsAsIntsCopy.set(curentIndex, 0);
                }
            }
        }
        System.out.println(result);
        return result.toString();
}
    }
