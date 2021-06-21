package com.chong.sort.heapSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Description:
 * 1、将初始待排序关键字序列(R1, R2 … .Rn)构建成大顶堆，此堆为初始的无序区；
 * 2、将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 * 3、由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，
 * 得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 *
 * 注意：大顶堆转化为数组储存的话遵循以下逻辑：arr[i] >= arr[2i + 1] && arr[i] >= arr[2i + 2]
 * 二叉树转化为数组储存，则左子节点对应root节点下标乘2加1，右子节点对应root节点下标乘2加2
 * https://blog.csdn.net/qq_36186690/article/details/82505569
 *
 * 平均时间复杂度：O(NlgN)
 * 最优时间复杂度：O(NlgN)
 * 最差时间复杂度：O(NlgN)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 * @Author: chong
 * @Data: 2021/5/26 4:46 下午
 */
public class HeapSortTemplate {

    /**
     * 构造大顶堆的函数，把输入的nums数组转换为一个大顶堆
     * @param nums：未排序的堆
     * @param root：一开始要检查的根节点
     * @param length：数组的长度，即要进行转换堆的范围
     */
    public void heapify(int[] nums, int root, int length){
//        先定义出当前root根节点的左子节点
        int son = root * 2 + 1;
//        要有一个循环，因为如果交换了父子节点，那么可能会导致交换后子节点不满足大顶堆的要求
//        左子节点在范围内，代表root节点具有左子节点，由于堆是二叉树，则如果没有左子节点必定没有右子节点
        while (son <= length){
//            判断root有没有右子节点，并且左右子节点哪个更大，哪个更大把son设定为哪个的下标
            if (son + 1 <= length && nums[son] < nums[son + 1]){
                son++;
            }
//            如果父节点大于子节点，已经满足大顶堆，直接跳出函数返回
            if (nums[son] < nums[root]){
                return;
            }else {
//                交换父子节点
                int temp = nums[root];
                nums[root] = nums[son];
                nums[son] = temp;
//                把下一轮检查的父节点下标设为上一轮交换中的子节点下标（交换中数组中元素交换了，下标没变）
                root = son;
//                重新把son设定为新root的左子节点
                son = root * 2 + 1;
            }
        }
    }

    public void heapSort(int nums[]){
        int length = nums.length;
//        把nums初始化为一个大顶堆，从最后一个父节点开始调整，其中length / 2 - 1代表最后一个子树的根节点的下标,可以从二叉树转数组逆推回来
        for (int i = length / 2 - 1 ; i >= 0; i--){
            heapify(nums, i, length - 1);
        }
//        对堆顶元素和未排序子数组的最后一个元素进行交换
        for (int i = length - 1; i > 0; i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
//            重新从顶级根节点将未排序数组重建堆
            heapify(nums, 0, i - 1);
        }
    }

    @Test
    public void test(){
        int[] nums = {5, 9, 1, -4, 5, 3, 7, 6, 1, 32, 23, 42, 57, 2, -49, 4, 67};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
