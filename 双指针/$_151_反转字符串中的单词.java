package leetcode.双指针;

import javax.xml.transform.sax.SAXTransformerFactory;

/**
 * @author lin
 * @creat 2023--01--18:47
 */
public class $_151_反转字符串中的单词 {
    public String reverseWords(String s) {
        //1.去除是首尾以及中间多余的空格
        StringBuilder sb=removeSpace(s);
        //2.反转整个字符串
        reverseString(sb,0,sb.length()-1);
        //3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    /**
     * 删除多余空格
     * @param s
     * @return
     */
    private StringBuilder removeSpace(String s){
        int start=0;
        int end=s.length()-1;
        //如果链表头前是空格就start向后走
        while (s.charAt(start)==' ') start++;
        //如果链表头后是空格就end向前走
        while (s.charAt(end)==' ') end--;
        StringBuilder sb=new StringBuilder();
        while (start<=end){
            //使用变量c接收字符串的字母
            char c=s.charAt(start);
            if (c!=' '|| sb.charAt(sb.length()-1)!=' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    private void reverseString(StringBuilder sb,int start, int end){
        while (start<end){
            char temp=sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }

    private void reverseEachWord(StringBuilder sb){
        int start=0;
        int end=1;
        int n=sb.length();
        while (start<n){
            while (end<n && sb.charAt(end)!=' '){
                end++;
            }
            reverseString(sb,start,end-1);
            start=end+1;
            end=start+1;
        }
    }

}
