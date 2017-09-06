import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类
 * Created by Narcissus on 2017/7/26.
 */
public class Util {
    public static boolean match(String regex, String str) {
        //字符串匹配
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
