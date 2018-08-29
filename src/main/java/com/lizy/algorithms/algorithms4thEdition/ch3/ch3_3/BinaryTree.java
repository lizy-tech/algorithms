package com.lizy.algorithms.algorithms4thEdition.ch3.ch3_3;

import java.util.Stack;

/**
 * @author: lizhiyong_tech@foxmail.com
 * @date: 2018-08-29 21:15.
 */
public class BinaryTree<Value extends Comparable<Value>> {
    class Node{
        private Value val;
        private Node lchild;
        private Node rchild;
    }

    /**
     * 创建二叉排序树
     * 二叉排序树：左结点值全部小于根结点值，右结点值全部大于根结点值
     * @return 根节点
     */
    public Node createTree(Value[] vals, int n) {
        int flag;//判断插入结点是其父结点左孩子还是右孩子，0-左孩子，1-右孩子
        Node root,p,q;
        root = new Node();
        root.val = vals[0];
        for (int i = 1; i < n; i++) {
            p = root;
            while (true) {
                if (vals[i].compareTo(p.val) < 0) {
                    if (p.lchild != null) {
                        p = p.lchild;
                        flag = 0;
                    } else {
                        flag = 0;
                        break;
                    }
                } else {
                    if (p.rchild != null) {
                        p = p.rchild;
                        flag = 1;
                    } else {
                        flag = 1;
                        break;
                    }
                }
            }
            q = new Node();
            q.val = vals[i];
            if (flag == 0) {
                p.lchild = q;
            } else {
                p.rchild = q;
            }
        }
        return root;
    }

    //先序遍历的递归实现
    public void preOrderRecursion(Node root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderRecursion(root.lchild);
            preOrderRecursion(root.rchild);
        }
    }

    //先序遍历的非递归实现
    public void preOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.empty()) {
            Node p = stack.pop();
            System.out.println(p.val);
            if (p.rchild != null) {
                stack.push(p.rchild);
            }
            if (p.lchild != null) {
                stack.push(p.lchild);
            }
        }
    }

    //中序遍历的递归实现
    public void inOrderRecursion(Node root) {
        if (root != null) {
            preOrderRecursion(root.lchild);
            System.out.println(root.val);
            preOrderRecursion(root.rchild);
        }
    }

    //中序遍历的非递归实现
    public void inOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.lchild;
            }
            if (!stack.isEmpty()) {
                p = stack.peek();
                System.out.println(p.val);
                stack.pop();
                p = p.rchild;
            }
        }
    }

    //后序遍历的递归实现
    public void postOrderRecursion(Node root) {
        if (root != null) {
            preOrderRecursion(root.lchild);
            preOrderRecursion(root.rchild);
            System.out.println(root.val);
        }
    }

    //后序遍历的非递归实现
    public void postOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node p = root;
        Node tmp = null;
        if (root != null) {
            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.push(p);
                    p = p.lchild;
                }
                if (!stack.isEmpty()) {
                    p = stack.peek();
                    if (p.rchild == tmp) {
                        System.out.println(p);
                        stack.pop();
                        tmp = p;
                        p = null;
                    } else {
                        p = p.rchild;
                    }
                }
            }
        }
    }
}
