import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String[] array = {"qqw", "pr", "rp", "qwq", "wqq", "w"};
        compareIgnoreOrder(array);
    }


    public static String compareIgnoreOrder(String[] strings){
        List<String> stringCharsAsList = Arrays.stream(strings).map(e -> {
            char[] chars = e.toCharArray();
            Arrays.sort(chars);
            StringBuilder str = new StringBuilder();
            for(char ch : chars){
                str.append(ch);
            }
            return str.toString();
        }).toList();

        Map<String, Long> pairMatches = stringCharsAsList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<String> stringCharsAsListCopy = new ArrayList<>(stringCharsAsList);
        StringBuilder result = new StringBuilder();

        for(String val : pairMatches.keySet()){
            if(pairMatches.get(val) > 1){
                result.append(strings[stringCharsAsList.indexOf(val)]).append(" = ");
                for(int i=0; i<pairMatches.get(val); i++){
                    int curentIndex =  stringCharsAsListCopy.indexOf(val);
                    result.append(curentIndex).append(i==pairMatches.get(val)-1 ? ". " : ", ");
                    stringCharsAsListCopy.set(curentIndex, null);
                }
            }
        }
        System.out.println(result);
        return result.toString();
}
    }
