import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String[] array = {"a", "qwe", "ewq","wqe","qwee","a","a", "af", "ad", "da", "iamlordvoldemort", "tommarvoloriddle", "qq", "qq", "pr", "rp", "a"};
        compareIgnoreOrder(array);
    }


    public static String compareIgnoreOrder(String[] strings){
        List<String> stringCharsAsInts = Arrays.stream(strings).map(e -> {
            char[] chars = e.toCharArray();
            Arrays.sort(chars);
            StringBuilder str = new StringBuilder();
            for(char ch : chars){
                str.append(ch);
            }
            return str.toString();
        }).toList();

        Map<String, Long> pairMatches = stringCharsAsInts.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<String> stringCharsAsIntsCopy = new ArrayList<>(stringCharsAsInts);
        StringBuilder result = new StringBuilder();

        for(String val : pairMatches.keySet()){
            if(pairMatches.get(val) > 1){
                result.append(strings[stringCharsAsInts.indexOf(val)]).append(" = ");
                for(int i=0; i<pairMatches.get(val); i++){
                    int curentIndex =  stringCharsAsIntsCopy.indexOf(val);
                    result.append(curentIndex).append(i==pairMatches.get(val)-1 ? ". " : ", ");
                    stringCharsAsIntsCopy.set(curentIndex, null);
                }
            }
        }
        System.out.println(result);
        return result.toString();
}
    }
