package com.chong.tree.BinaryTreeTraversal;

import com.chong.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * 口诀：左右根。后序遍历首先遍历左子树，然后遍历右子树，最后访问根结点，在遍历左、右子树时，仍然先遍历左子树，然后遍历右子树，最后遍历根结点。即：
 * 若二叉树为空则结束返回，
 * 否则：
 * （1）后序遍历左子树
 * （2）后序遍历右子树
 * （3）访问根结点
 * 注意：已知前序遍历和中序遍历，就能确定后序遍历。
 * @Author: chong
 * @Data: 2021/5/25 5:27 下午
 */
public class PostTraversal {
    List<Integer> result = new ArrayList<>();

    /**
     * 递归方法
     * @param root
     */
    public void postTraversalRecur(TreeNode root){
        if (root == null)
            return;
        postTraversalRecur(root.leftNode);
        postTraversalRecur(root.rightNode);
        result.add(root.val);
    }

    /**
     * 迭代方法:使用栈实现，出栈得到节点顺序为根右左，每次向list最开头插入元素
     * 相当于前序遍历的反向操作，在栈中最先弹出的应该是遍历结果中最后一个，依次类推
     * 画图看一下流程就可以看出，这个迭代的过程是根右左，是前序遍历反过来
     * @param root
     */
    public void postTraversalIter(TreeNode root){
        if (root == null)
            return;
        LinkedList<TreeNode> stack = new LinkedList<>();
//        将根节点压栈
        stack.push(root);
        while (!stack.isEmpty()){
//            弹出栈顶元素
            TreeNode tempNode = stack.pop();
//            先入栈的后出栈
            if (tempNode.leftNode != null)
                stack.push(tempNode.leftNode);
            if (tempNode.rightNode != null)
                stack.push(tempNode.rightNode);
            result.add(0, tempNode.val);
        }
    }


    @Test
    public void postTraversalRecurTest(){
        TreeNode root = new TreeNode(5);
        root.leftNode = new TreeNode(4);
        root.leftNode.leftNode = new TreeNode(6);
        root.leftNode.rightNode = new TreeNode(3);
        root.leftNode.rightNode.leftNode = new TreeNode(1);
        root.rightNode = new TreeNode(7);
        root.rightNode.leftNode = new TreeNode(8);
        root.rightNode.rightNode = new TreeNode(9);

        postTraversalRecur(root);
        System.out.println(result);
    }

    @Test
    public void postTraversalIterTest(){
        TreeNode root = new TreeNode(5);
        root.leftNode = new TreeNode(4);
        root.leftNode.leftNode = new TreeNode(6);
        root.leftNode.rightNode = new TreeNode(3);
        root.leftNode.rightNode.leftNode = new TreeNode(1);
        root.rightNode = new TreeNode(7);
        root.rightNode.leftNode = new TreeNode(8);
        root.rightNode.rightNode = new TreeNode(9);

        postTraversalIter(root);
        System.out.println(result);
    }
}
