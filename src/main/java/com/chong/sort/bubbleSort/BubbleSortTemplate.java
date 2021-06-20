package com.chong.sort.bubbleSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Description:
 * 1、每次比较相邻两个元素，第一个比第二个大就交换
 * 2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 3、针对所有的元素重复以上的步骤，除了最后一个。
 * 4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 *
 * 平均时间复杂度：O(N^2)
 * 最优时间复杂度：O(N^2)
 * 最差时间复杂度：O(N^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 * @Author: chong
 * @Data: 2021/5/25 3:32 下午
 */
public class BubbleSortTemplate {
    public void bubbleSort(int[] nums){
        bubbleSort(nums, nums.length);
    }

    public void bubbleSort(int[] nums, int n){
//        到最后一次遍历，只剩最后两个元素需要比较，因此i只需要遍历n-1次即可
        for (int i = 0; i < n - 1; i++){
//            内循环最大只需要遍历到n-1，因为要拿nums[j]和nums[j+1]来比较，
//            而且每经过一次外循环，就少遍历一个末尾的元素，于是j<n-i-1
            for (int j = 0; j < n - i - 1; j++){
                if (nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    @Test
    public void test(){
        int[] nums = {5, 9, 1, -4, 5, 3, 7, 6, 1, 32, 23, 42, 57, 2, -49, 4, 67};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
