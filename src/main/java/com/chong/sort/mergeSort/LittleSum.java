package com.chong.sort.mergeSort;

import org.junit.jupiter.api.Test;

/**
 * @Description:
 * 归并排序思想的应用：
 * 小和问题在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
 * 例子：[1,3,4,2,5]1左边比1小的数，没有；3左边比3小的数，1；4左边比4小的数，1、3；2左边比2小的数，1；
 * 5左边比5小的数，1、3、4、2；所以小和为1+1+3+1+1+3+4+2=16
 * @Author: chong
 * @Data: 2021/6/19 8:04 下午
 */
public class LittleSum {
    int[] aux;
    int result;
    public int littleSum(int[] nums){
        aux = new int[nums.length];
        result = 0;
        littleSum(nums, 0, nums.length - 1);
        return result;
    }

    private void littleSum(int[] nums, int low, int high){
        if (low == high)
            return;
        int mid = low + ((high - low) >> 1);

        littleSum(nums, low, mid);
        littleSum(nums, mid + 1, high);

        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high){
        int left = low;
        int right = mid + 1;
        for (int i = low; i <= high; i++)
            aux[i] = nums[i];

        for (int i = low; i <= high; i++){
            if (left > mid)
                nums[i] = aux[right++];
            else if (right > high)
                nums[i] = aux[left++];
            else if (aux[left] < aux[right]){
                result += aux[left] * (high - right + 1);
                nums[i] = aux[left++];
//                这里注意当两个指针位置上的元素相等时，一定先拷贝右子数组，才能知道左子数组多少元素比右子数组小
            }else
                nums[i] = aux[right++];
        }
    }


    @Test
    public void test(){
        int[] nums = {1, 1, 5, 1, 1, 3};
        int res = littleSum(nums);
        System.out.println(res);
    }
}
