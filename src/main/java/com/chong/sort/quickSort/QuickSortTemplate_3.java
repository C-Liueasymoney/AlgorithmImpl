package com.chong.sort.quickSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Description:
 * 快速排序3.0
 * @Author: chong
 * @Data: 2021/6/20 3:49 下午
 */
public class QuickSortTemplate_3 {
    public void quickSort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int low, int high){
        if (low >= high)
            return;
//        随机在nums数组中选择一个数，让其和low做交换，保证选到合适的partition
        swap(nums, low + (int) (Math.random() * (high - low + 1)), low);
        int partition = partition(nums, low, high);
        quickSort(nums, low, partition);
        quickSort(nums, partition + 1, high);
    }

    public int partition(int[] nums, int low, int high){
        int left = low;
        int right = high;
        int pivot = nums[left];
        while (left < right){
            while (left < right){
                if (nums[right] >= pivot)
                    right--;
                else {
//                    如果比锚点小，说明应该在锚点左侧，直接把当前right值赋给left处，
//                    由于首次开始时left上的值已经保存在pivot中，不用担心覆盖导致丢失
                    nums[left] = nums[right];
                    break;
                }
            }
            while (left < right){
                if (nums[left] <= pivot)
                    left++;
                else {
                    nums[right] = nums[left];
                    break;
                }
            }
        }
        nums[left] = pivot;
        return left;
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    @Test
    public void test(){
//        int[] nums = {5, 9, 1, -4, 5, 3, 7, 6, 1, 32, 23, 42, 57, 2, -49, 4, 67};
//        这个例子能很好的展示3.0和之前的快排在时间上的差距
        int[] nums = new int[10000];
        for (int i = 0; i < 10000; i++){
            nums[i] = i;
        }
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
