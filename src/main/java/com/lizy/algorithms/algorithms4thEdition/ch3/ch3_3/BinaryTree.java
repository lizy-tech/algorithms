package com.lizy.algorithms.algorithms4thEdition.ch3.ch3_3;

import java.util.LinkedList;
import java.util.Queue;
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

    //后序遍历的非递归实现1
    public void postOrder1(Node root) {
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

    //后序遍历的非递归实现2
    public void postOrder2(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur;
        Node p = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if ((cur.lchild == null && cur.rchild == null) ||
                    (p != null && (p == cur.lchild || p == cur.rchild))) {
                System.out.println(cur.val);
                stack.pop();
                p = cur;
            } else {
                if (cur.rchild != null) {
                    stack.push(cur.rchild);
                }
                if (cur.lchild != null) {
                    stack.push(cur.lchild);
                }
            }
        }
    }

    //层次遍历
    public void levelOrder(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            Node p = queue.pop();
            System.out.println(p.val);
            if (p.lchild != null) {
                queue.addLast(p.lchild);
            }
            if (p.rchild != null) {
                queue.addLast(p.rchild);
            }
        }
    }

    //二叉树的最大宽度
    public int maxWidth(Node root) {
        if(root == null)
            return 0;
        int result = 0;
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            result = Math.max(result, count);
            while (count>0) {
                Node cur = queue.poll();
                if (cur.lchild != null) {
                    queue.addLast(cur.lchild);
                }
                if (cur.rchild != null) {
                    queue.addLast(cur.rchild);
                }
            }
        }
        return result;
    }

    public int getMaxDepth(Node root) {
        if (root == null) {
            return 0;
        } else {
            int left = getMaxDepth(root.lchild);
            int right = getMaxDepth(root.rchild);
            return 1 + Math.max(left, right);
        }
    }

    //二叉树叶子结点数目
    public int getCountLeaf(Node root) {
        int count;
        if(root == null)
            count = 0;
        else if(root.lchild == null && root.rchild == null)
            count = 1;
        else
            count = getCountLeaf(root.rchild) + getCountLeaf(root.lchild);
        return count;
    }

    //判断树中是否存在某个结点
    public boolean hasNode(Node root, Node pNode) {
        if (root == pNode) {
            return true;
        }
        boolean flag = false;
        if (root.lchild != null) {
            flag = hasNode(root.lchild,pNode);
        }
        if (root.rchild != null) {
            flag = hasNode(root.rchild, pNode);
        }
        return flag;
    }

    //根结点到指定结点的路径
    public boolean getPath(Node root, Node pNode,LinkedList<Node> path) {
        path.push(root);
        if (root == pNode) {
            return true;
        }
        if (hasNode(root, pNode) == false) {
            return false;
        }
        boolean found = false;
        if (root.lchild != null) {
            found = getPath(root.lchild, pNode, path);
        }
        if (!found && root.rchild != null) {
            found = getPath(root.rchild, pNode, path);
        }
        if (!found) {
            path.remove(path.size() - 1);
        }
        return found;
    }
}
