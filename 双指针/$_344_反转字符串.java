package leetcode.双指针;

/**
 * @author lin
 * @creat 2023--01--13:30
 */
public class $_344_反转字符串 {
    public void reverseString(char[] s) {
        int l=0;
        int r=s.length-1;
        while (l<r){//l<s.length/2
            char temp=s[l];
            s[l]=s[r];
            s[r]=temp;
            l++;
            r--;
        }
    }
}
