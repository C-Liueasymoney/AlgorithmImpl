package com.chong.sort.heapSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/21 2:51 下午
 */
public class HeapSortTemplate2 {
    public void heapSort(int[] nums){
//        初始状态下还未构成堆，heapSize=0，那么就初始化堆，此过程相当于将数组中元素不断进行heapInsert
        for (int i = 0; i < nums.length; i++){  // O(N)
            heapInsert(nums, i);    // O(logN)
        }
        int heapSize = nums.length;
        swap(nums, 0, --heapSize);  // 先执行--heapSize否则越界
        while (heapSize > 0){       // O(N)
//            一直将根节点作为要交换的节点进行堆化
            heapify(nums, 0, heapSize);   // O(logN)
            swap(nums, 0, --heapSize);      // O(1)
        }
    }

    public void heapInsert(int[] nums, int index){
        // (index - 1) / 2代表index的父节点，只要当前节点比它的父节点大，就继续插入
        while (nums[index] > nums[(index - 1) / 2]){
            // 如果index已经到达0位置，那么（0 - 1）/2依旧是0位置,和自身比较就会不满足条件跳出循环
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;        // 向前调整子节点为其父节点
        }
    }

    /**
     * 当某数处于index位置时，调整位置完成堆构造
     * @param nums
     * @param index
     * @param heapSize
     */
    public void heapify(int[] nums, int index, int heapSize){
        int left = index * 2 + 1;    // 左子节点的下标
        while (left < heapSize){    // 左子节点不越界,如左子节点越界则右子节点必越界
            // 比较两个子节点谁的值更大（存在右子节点的情况下），保存对应下标
            int largest = left + 1 < heapSize && nums[left] < nums[left + 1] ? left + 1 : left;
            // 比较两个子节点中大者和当前父节点谁更大，赋给下标
            largest = nums[largest] > nums[index] ? largest : index;
            if (largest == index)   // 没有子节点比父节点大，跳出
                break;
            swap(nums, index, largest);
            // 把当前节点位置往下调整
            index = largest;
            left = index * 2 + 1;
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    @Test
    public void test(){
        int[] nums = {5, 9, 1, -4, 5, 3, 7, 6, 1, 32, 23, 42, 57, 2, -49, 4, 67};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
