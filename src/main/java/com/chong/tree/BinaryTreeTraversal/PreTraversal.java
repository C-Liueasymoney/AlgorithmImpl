package com.chong.tree.BinaryTreeTraversal;

import com.chong.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * 前序遍历
 * 口诀：根左右。前序遍历首先访问根结点然后遍历左子树，最后遍历右子树。在遍历左、右子树时，仍然先访问根节点，然后遍历左子树，最后遍历右子树。
 * 若二叉树为空则结束返回，否则：
 * （1）访问根结点。
 * （2）前序遍历左子树。
 * （3）前序遍历右子树 。
 * 需要注意的是：遍历左右子树时仍然采用前序遍历方法。
 * 注意：已知后序遍历和中序遍历，就能确定前序遍历。
 * @Author: chong
 * @Data: 2021/5/25 3:59 下午
 */
public class PreTraversal {
    List<Integer> result = new ArrayList<>();

    /**
     * 递归实现
     * @param root
     */
    public void preTraversalRecur(TreeNode root){
        if (root == null)
            return;
        result.add(root.val);
        preTraversalRecur(root.leftNode);
        preTraversalRecur(root.rightNode);
    }

    /**
     * 迭代实现：维护一个栈，入栈顺序按照"根右左"进行入栈，因此首先将根出栈，
     * 按照"右左"的顺序放入根的两个子节点入栈，然后出栈左子节点，最后出栈右子节点。
     * @param root
     */
    public void preTraversalIter(TreeNode root){
        if (root == null)
            return;
//        使用LinkedList的push、pop等方法实现栈
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tempNode = stack.pop();
            result.add(tempNode.val);
//            注意右子节点先入栈，左子节点后入栈，保证始终是左子节点先弹出栈（左子节点存在的情况下）
            if (tempNode.rightNode != null)
                stack.push(tempNode.rightNode);
            if (tempNode.leftNode != null)
                stack.push(tempNode.leftNode);
        }
    }


    @Test
    public void preTraversalRecurTest(){
        TreeNode root = new TreeNode(5);
        root.leftNode = new TreeNode(4);
        root.leftNode.leftNode = new TreeNode(6);
        root.leftNode.rightNode = new TreeNode(3);
        root.leftNode.rightNode.leftNode = new TreeNode(1);
        root.rightNode = new TreeNode(7);
        root.rightNode.leftNode = new TreeNode(8);
        root.rightNode.rightNode = new TreeNode(9);

        preTraversalRecur(root);
        System.out.println(result);
    }


    @Test
    public void preTraversalIterTest(){
        TreeNode root = new TreeNode(5);
        root.leftNode = new TreeNode(4);
        root.leftNode.leftNode = new TreeNode(6);
        root.leftNode.rightNode = new TreeNode(3);
        root.leftNode.rightNode.leftNode = new TreeNode(1);
        root.rightNode = new TreeNode(7);
        root.rightNode.leftNode = new TreeNode(8);
        root.rightNode.rightNode = new TreeNode(9);

        preTraversalIter(root);
        System.out.println(result);
    }
}
