package com.chong.sort.mergeSort;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Description:
 * 1.把长度为n的输入序列分成两个长度为n/2的子序列；
 * 2. 对这两个子序列分别采用归并排序；
 * 3. 将两个排序好的子序列合并成一个最终的排序序列。
 *
 * 平均时间复杂度：O(NlgN)
 * 最优时间复杂度：O(NlgN)
 * 最差时间复杂度：O(NlgN)
 * 空间复杂度：O(n)
 * 稳定性：稳定
 * @Author: chong
 * @Data: 2021/5/28 10:31 上午
 */
public class MergeSortTemplate {
//    创建一个辅助数组
    private int[] aux;
    public void mergeSort(int[] nums){
//        为辅助数组分配空间
        aux = new int[nums.length];
        int low = 0;
        int high = nums.length - 1;
        mergeSort(nums, low, high);
    }

    public void mergeSort(int[] nums, int low, int high){
//        如果子数组没有元素或只有一个元素了就返回
        if (low >= high)
            return;
//        找到子数组的中点
        int middle = low + ((high - low) >> 1);
//        对于左右子数组进行递归
        mergeSort(nums, low, middle);
        mergeSort(nums, middle + 1, high);
//        递归结束之后从最小的数组开始聚合（最小有两个元素）
        merge(nums, low, middle, high);
    }

    /**
     * 对子数组进行聚合，实际的排序在此发生，对于每个小数组进行小数组范围内的排序，每次保证输入的两个子数组合并且变为有序的
     * @param nums
     * @param low：左子数组的开始下标
     * @param middle：左右子数组的中点，middle下标处的元素属于左子数组
     * @param high：右子数组的结束下标
     */
    public void merge(int[] nums, int low, int middle, int high){
//        这一步是记录下左子数组和右子数组的开始下标，记为left，right
        int left = low;
        int right = middle + 1;
//        要把左右子数组所涉及的元素保存在辅助数组中
        for (int k = low; k <= high; k++){
            aux[k] = nums[k];
        }
//        由于辅助数组已经保存下来了原来的值，故可以直接在原数组nums上做改动
//        high是子数组最大元素下标，也要遍历到
        for (int h = low; h <= high; h++){
//            left>middle时说明左子数组已经添加完了，所以添加右子数组的元素right++
            if (left > middle)
                nums[h] = aux[right++];
//            right>high说明右子数组添加完了，添加左子数组元素left++
            else if (right > high)
                nums[h] = aux[left++];
//            比较左右子数组指针所指位置元素大小，左子数组（已排序）要比右子数组（已排序）小，
//            所以如果aux[left] > aux[right] 就把小的元素aux[right]添加进去（从小到大的顺序），反之相反。
//            使用辅助数组进行比较，原数组在排序过程中会改变
            else if (aux[left] > aux[right])
                nums[h] = aux[right++];
            else
                nums[h] = aux[left++];
        }
    }

    @Test
    public void test(){
        int[] nums = {5, 9, 1, -4, 5, 3, 7, 6, 1, 32, 23, 42, 57, 2, -49, 4, 67};
//        int[] nums = {5, 9, 1, -4, 5, 3, 7, 6, 1};

        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
