package leetcode.数组;

/**
 * @author lin
 * @creat 2023--01--11:23
 */
public class $_27_移除元素 {
    /**
     * 暴力解法
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        //记录下数组的长度
        int size=nums.length;
        for (int i=0;i<size;i++){
            if (nums[i]==val){//此时所指向的元素值跟val相等，则需要将其删除
                for (int j=i+1;j<size;j++){//因为要删除，所以需要向元素从后向前覆盖
                    nums[j-1]=nums[j];//让后面的元素覆盖掉前一个元素，就将前一个元素删除了
                }
                //因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                i--;
                //此时数组的大小要-1
                size--;
            }
        }
        return size;
    }

    /**
     * 使用双指针（快慢指针）
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        //fast是用来遍历旧数组，并记录下要输入新数组的元素值
        int fast=0;
        //slow是新数组的下标值
        int slow=0;
        int size=nums.length;
        for(fast=0;fast<size;fast++){
            if (nums[fast]!=val){//如果此时遍历的元素不等于val，则将这个值加入新数组
                nums[slow]=nums[fast];//将不等于val的值加入
                slow++;
            }
        }
        return slow;
    }
}
