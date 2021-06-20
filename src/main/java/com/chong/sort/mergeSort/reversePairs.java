package com.chong.sort.mergeSort;

import com.sun.org.apache.bcel.internal.util.BCELifier;
import org.junit.jupiter.api.Test;
import sun.nio.cs.ext.EUC_JP_LINUX;

/**
 * @Description:
 * 归并应用：逆序对问题，在一个数组中，如果左边的数字比右边的数字大，则这两个数字构成一个逆序对，请打印所有逆序对,求出总数
 * @Author: chong
 * @Data: 2021/6/20 2:27 下午
 */
public class reversePairs {
    int[] aux;
    int res;
    public int reversePairs(int[] nums) {
        aux = new int[nums.length];
        res = 0;
        reversePairs(nums, 0, nums.length - 1);
        return res;
    }

    public void reversePairs(int[] nums, int low, int high){
        if (low >= high)
            return;
        int mid = low + ((high - low) >> 1);
        reversePairs(nums, low, mid);
        reversePairs(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    public void merge(int[] nums, int low, int mid, int high){
        int left = low;
        int right = mid + 1;
        for (int i = low; i <= high; i++){
            aux[i] = nums[i];
        }

        for (int i = low; i <= high; i++){
            if (left > mid)
                nums[i] = aux[right++];
            else if (right > high)
                nums[i] = aux[left++];
            else if (aux[left] > aux[right]){
                res += mid - left + 1;
                for (int k = left; k <= mid; k++)
                    System.out.println("逆序对：[" + aux[k] + ", " + aux[right] + "]");
                nums[i] = aux[right++];
            }else
                nums[i] = aux[left++];
        }
    }

    @Test
    public void test(){
        int[] nums = {7, 5, 6, 4};
        int res = reversePairs(nums);
        System.out.println(res);
    }
}
