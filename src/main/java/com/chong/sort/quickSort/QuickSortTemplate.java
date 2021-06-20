package com.chong.sort.quickSort;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Description:
 * 平均时间复杂度：O(NlgN)
 * 最优时间复杂度：O(NlgN)
 * 最差时间复杂度：O(N^2)
 * 空间复杂度：O(lgN)
 * 稳定性：不稳定
 * @Author: chong
 * @Data: 2021/5/25 2:53 下午
 */
public class QuickSortTemplate {
    public void quickSort(int[] nums){
//        high从length-1开始，否则nums[high]超出范围
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int low, int high){
        if (low >= high)
            return;
//        记录左右初始指针
        int left = low;
        int right = high;
//        记录锚点，选择数组第一位
        int pivot = nums[left];
//        保证左右指针相遇即停止
        while (left < right){
//            由于这里要不断移动指针，也要进行判断
            while (left < right){
//                先从数组右侧查找，按照快排思想，比锚点大的都应该在锚点右侧，因此判断右侧开始大于等于锚点的直接跳过
                if (nums[right] >= pivot){
                    right--;
                }else {
//                    如果比锚点小，说明应该在锚点左侧，直接把当前right值赋给left处，
//                    由于首次开始时left上的值已经保存在pivot中，不用担心覆盖导致丢失
                    nums[left] = nums[right];
                    break;
                }
            }

            while (left < right){
//                右侧经过一次变换后，开始从左侧找有没有比锚点大的值，有就赋给right所在的位置
                if (nums[left] <= pivot){
                    left++;
                }else {
                    nums[right] = nums[left];
                    break;
                }
            }
        }
//        左右指针相遇的时候跳出循环，此时left和right重合的位置就应该是锚点pivot所在的位置
        int pivotIndex = left;
        nums[left] = pivot;

//        把数组依据锚点分成左右两个子数组，进入quickSort做递归，直到左右子数组元素为1或0跳出
//        左子数组
        quickSort(nums, low, pivotIndex - 1);
//        右子数组
        quickSort(nums, pivotIndex + 1, high);
    }

    @Test
    public void test(){
        int[] nums = {5, 9, 1, -4, 5, 3, 7, 6, 1, 32, 23, 42, 57, 2, -49, 4, 67};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
