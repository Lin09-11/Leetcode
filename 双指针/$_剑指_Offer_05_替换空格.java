package leetcode.双指针;

/**
 * @author lin
 * @creat 2023--01--13:35
 */
public class $_剑指_Offer_05_替换空格 {
    public String replaceSpace(String s) {
        if (s==null){
            return null;
        }
        //选用StringBuilder
        StringBuffer sb=new StringBuffer();
        //使用sb复制s，如果遇到空格就替换
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==' '){//如果此时是空格
                //则直接添加
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
