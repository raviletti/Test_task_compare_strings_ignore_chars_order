import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class Test {
    @DataProvider
    public Object [][] data(){
        return new Object[][]{
                {"qwe", "ewq","wqe","qwee","a", "qwe = 0, 1, 2. "},
                {"af", "ad", "da", "iamlordvoldemort", "tommarvoloriddle", "iamlordvoldemort = 3, 4. ad = 1, 2. "},
                {"2", "54", "45", "121", "2", "2 = 0, 4. 54 = 1, 2. "}
        };
    }


    @org.testng.annotations.Test(dataProvider = "data")
    public void test(String str1, String str2, String str3, String str4, String str5, String result){
        Assert.assertEquals(result, Solution.compareIgnoreOrder(new String[]{str1, str2, str3, str4, str5}));
    }
}
