package com.chong.tree.BinaryTreeTraversal;

import com.chong.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * 中序遍历
 * 口诀：左根右。中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树。
 * 注：二叉搜索树题目一般和中序遍历相关。
 * @Author: chong
 * @Data: 2021/5/25 4:51 下午
 */
public class InTraversal {
    List<Integer> result = new ArrayList<>();

    /**
     * 递归实现
     * @param root
     */
    public void inTraversalRecur(TreeNode root){
        if (root == null)
            return;
//        一直找左子节点递归到底
        if (root.leftNode != null)
            inTraversalRecur(root.leftNode);
//        没有左子节点了就添加当前节点值
        result.add(root.val);
//        右子节点放在最后递归
        if (root.rightNode != null)
            inTraversalRecur(root.rightNode);
    }

    /**
     * 迭代实现：迭代实现，首先依次将左子节点全部加入栈中，所以第一个while循环后，栈顶元素对应一个子树的最左子节点，
     * 然后将该元素出栈加入list，并判断该元素的遍历该节点的右子树。
     * @param root
     */
    public void inTraversalIter(TreeNode root){
        if (root == null)
            return;
        LinkedList<TreeNode> stack = new LinkedList<>();
        do {
//            先从当前节点开始遍历，把所有左子节点压栈
            while (root != null){
                stack.push(root);
//                进来遍历的话，到最后root应该为null
                root = root.leftNode;
            }
//            压栈后，栈顶元素就是当前未遍历过的最左子树的最左子节点
//            在栈不为空的情况下，弹出栈顶节点，加入list。
            if (!stack.isEmpty()){
//                把栈顶元素赋给root
                root = stack.pop();
                result.add(root.val);
//                root更新为栈顶元素的右子节点
                root = root.rightNode;
            }
//            root == null可能是栈顶元素无右子节点，此时stack不为空说明此时还有其他左子树没被遍历到
//            stack.isEmpty()可能是从根节点出发下面的所有左子树都被遍历到了，弹出栈，如果此时root！=null说明当前还有右子树没被遍历
        }while (!stack.isEmpty() || root != null);
    }


    @Test
    public void inTraversalRecurTest(){
        TreeNode root = new TreeNode(5);
        root.leftNode = new TreeNode(4);
        root.leftNode.leftNode = new TreeNode(6);
        root.leftNode.rightNode = new TreeNode(3);
        root.leftNode.rightNode.leftNode = new TreeNode(1);
        root.rightNode = new TreeNode(7);
        root.rightNode.leftNode = new TreeNode(8);
        root.rightNode.rightNode = new TreeNode(9);

        inTraversalRecur(root);
        System.out.println(result);
    }

    @Test
    public void inTraversalIterTest(){
        TreeNode root = new TreeNode(5);
        root.leftNode = new TreeNode(4);
        root.leftNode.leftNode = new TreeNode(6);
        root.leftNode.rightNode = new TreeNode(3);
        root.leftNode.rightNode.leftNode = new TreeNode(1);
        root.rightNode = new TreeNode(7);
        root.rightNode.leftNode = new TreeNode(8);
        root.rightNode.rightNode = new TreeNode(9);

        inTraversalIter(root);
        System.out.println(result);
    }
}
