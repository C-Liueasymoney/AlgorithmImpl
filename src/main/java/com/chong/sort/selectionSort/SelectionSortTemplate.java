package com.chong.sort.selectionSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Description:
 * 1、在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * 2、从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾
 * 3、以此类推，直到所有元素均排序完毕
 *
 * 平均时间复杂度：O(N^2)
 * 最优时间复杂度：O(N^2)
 * 最差时间复杂度：O(N^2)
 * 空间复杂度：O(1)
 * 稳定性：不稳定（在交换过程中，可能会把相等的两个数字位置颠倒）
 * @Author: chong
 * @Data: 2021/5/26 4:31 下午
 */
public class SelectionSortTemplate {
    public void selectionSort(int[] nums){
      int n = nums.length;
      int minIndex;
      int temp;
//      可以少遍历一次，因为最后一次剩下一个未选择的时候其实已经排序好了
      for (int i = 0; i < n - 1; i++){
//          初始化数组中最小的元素下标为i
          minIndex = i;
          for (int j = i + 1; j < n; j++){
//              找到数组最小值，将其下标保存到minIndex
              if (nums[j] < nums[minIndex])
                  minIndex = j;
          }
//          将未排序的子数组中最小元素与子数组中第一位元素交换
          temp = nums[i];
          nums[i] = nums[minIndex];
          nums[minIndex] = temp;
      }
    }


    @Test
    public void test(){
        int[] nums = {5, 9, 1, -4, 5, 3, 7, 6, 1, 32, 23, 42, 57, 2, -49, 4, 67};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
