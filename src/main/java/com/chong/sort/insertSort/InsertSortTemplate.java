package com.chong.sort.insertSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Description:
 * 1、从第一个元素开始，该元素可以认为已经被排序
 * 2、取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3、如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 4、重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 5、将新元素插入到该位置后
 * 6、重复步骤2~5
 *
 * 平均时间复杂度：O(N^2)
 * 最优时间复杂度：O(N):数组已经排序好的情况
 * 最差时间复杂度：O(N^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 * @Author: chong
 * @Data: 2021/5/26 4:09 下午
 */
public class InsertSortTemplate {
    public void insertSort(int[] nums){
        int n = nums.length;
//        从数组的第二位开始遍历，第一位默认已经排序好了
        for (int i = 1; i < n; i++){
//            从已经排序好了的子数组的最后一位开始从后向前遍历
            for (int j = i; j > 0; j--){
//                判断当前位是否比前一位小，如果小就交换这两个元素
//                不会出现隔位交换的情况，因为前面的子数组已经排序好了
                if (nums[j] < nums[j - 1]){
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }

    @Test
    public void test(){
        int[] nums = {5, 9, 1, -4, 5, 3, 7, 6, 1, 32, 23, 42, 57, 2, -49, 4, 67};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
