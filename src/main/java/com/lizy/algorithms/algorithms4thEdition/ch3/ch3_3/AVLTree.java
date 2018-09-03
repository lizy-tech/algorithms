package com.lizy.algorithms.algorithms4thEdition.ch3.ch3_3;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-9-3 17:07
 */
public class AVLTree<Value extends Comparable<Value>> {
    private Node<Value> root;
    private class Node<Value>{
        Node<Value> left;
        Node<Value> right;
        Value val;
        int height;//高度

        public Node(Node<Value> left,Node<Value> right,Value data){
            this.left = left;
            this.right = right;
            this.val = data;
            this.height = 0;
        }
    }

    public Node<Value> insert(Value data) {
        return root = insert(data, root);
    }

    /**
     * 递归过程插入，先插入再调整
     */
    public Node<Value> insert(Value data, Node<Value> node) {
        if (node == null) {
            return new Node<>(null, null, data);
        }
        int compareResult = data.compareTo(node.val);
        if (compareResult > 0) {//插入node的右子树中
            node.right = insert(data, node.right);
            //递归回调时判断是否平衡
            if (getHeight(node.right) - getHeight(node.left) == 2) {//需要旋转的条件
                int compareResult2 = data.compareTo(node.right.val);
                if (compareResult2 > 0) {//data插入node的右子树中了，符合RR型调整
                    node = rotateSingleLeft(node);
                } else {//data插入node的右子树的左孩子结点中，符合RL型调整
                    node = rotateRightAndLeft(node);
                }
            }
        } else if (compareResult < 0) {//插入node的左子树
            node.left = insert(data, node.left);
            if (getHeight(node.left ) - getHeight(node.right)== 2) {
                int compareResult2 = data.compareTo(node.left.val);
                if (compareResult2 < 0) {
                    node = rotateSingleRight(node);
                } else {
                    node = rotateLeftAndRight(node);
                }
            }
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return node;
    }

    //RR型调整，左旋
    private Node<Value> rotateSingleLeft(Node<Value> node) {
        Node<Value> rightNode = node.right;
        node.right = rightNode.left;
        rightNode.left = node;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        rightNode.height = Math.max(node.height, getHeight(rightNode.right)) + 1;
        return rightNode;
    }

    //LL型调整，右旋
    private Node<Value> rotateSingleRight(Node<Value> node) {
        Node<Value> leftNode = node.left;
        node.left = leftNode.right;
        leftNode.right = node;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        leftNode.height = Math.max(getHeight(leftNode.left), node.height) + 1;
        return leftNode;
    }

    //RL型调整，先右旋再左旋
    private Node<Value> rotateRightAndLeft(Node<Value> node) {
        node.right = rotateSingleRight(node.right);
        node = rotateSingleLeft(node);
        return node;
    }

    //LR型调整，先左旋再右旋
    private Node<Value> rotateLeftAndRight(Node<Value> node) {
        node.left = rotateSingleLeft(node.left);
        node = rotateSingleRight(node);
        return node;
    }

    private int getHeight(Node<Value> node) {
        return node == null ? 0 : node.height;
    }

    public Node<Value> remove(Value data) {
        return root = remove(data, root);
    }

    private Node<Value> remove(Value data, Node<Value> node) {
        if (node == null) {
            return null;
        }
        int compareResult = data.compareTo(node.val);
        if(compareResult == 0){//node为要删除的结点
            /**
             * 判断node是否有子树，若无，直接删除
             * 若有两个子树，判断node的平衡系数balance
             *      若balance为0或者1，择将node左子树的最大值和node交换，
             *      否则将node右子树的最小值和node交换
             * 交换结点之后删除node结点，判断删除之后结点的父节点是否平衡，
             * 如果不平衡进行节点旋转，旋转之后返回delete节点的父节点进行回溯
             */
            if (node.left != null && node.right != null) {
                int balance = getHeight(node.left) - getHeight(node.right);
                Node<Value> temp = node;
                if (balance == -1) {//node与node右子树中最小值交换
                    exchangeRightData(node, node.right);
                } else {//node与node左子树中最大值交换
                    exchangeLeftData(node, node.left);
                }
                temp.height = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;
                return temp;
            } else {
                return node.left != null ? node.left : node.right;
            }
        }else if (compareResult > 0) {//要删除的结点在node的右子树中
            node.right = remove(data, node.right);
            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
            if (getHeight(node.left) - getHeight(node.right) == 2) {// 进行旋转
                Node<Value> leftSon = node.left;
                // 判断是否需要进行两次右旋还是一次右旋
                // 判断条件就是比较leftSon节点的左右子节点树高
                if (leftSon.left.height > leftSon.right.height) {
                    // 右旋一次
                    node = rotateSingleRight(node);
                } else {
                    // 两次旋转，先左旋，后右旋
                    node = rotateLeftAndRight(node);
                }
            }
            return node;
        } else if (compareResult < 0) {//要删除的结点在node的左子树中
            node.left = remove(data, node.left);
            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
            if (getHeight(node.right) - getHeight(node.left) == 2) {
                Node<Value> rightSon = node.right;
                // 判断是否需要进行两次右旋还是一次右旋
                // 判断条件就是比较rightSon节点的左右子节点树高
                if (rightSon.right.height > rightSon.left.height) {
                    node = rotateSingleLeft(node);
                } else {
                    // 先右旋再左旋
                    node = rotateRightAndLeft(node);
                }
            }
            return node;
        }
        return null;
    }

    //递归寻找left子树中的最大值
    private Node<Value> exchangeLeftData(Node<Value> node, Node<Value> right) {
        if (right.right != null) {
            right.right = exchangeLeftData(node, right.right);
        } else {
            node.val = right.val;
            return right.left;
        }
        right.height = Math.max(getHeight(right.left), getHeight(right.right)) + 1;
        right.height = Math.max(getHeight(right.left), getHeight(right.right)) + 1;
        // 回溯判断left是否平衡,如果不平衡则进行左旋操作。
        int isbanlance = getHeight(right.left) - getHeight(right.right);
        if (isbanlance == 2) {// 进行旋转
            Node<Value> leftSon = node.left;
            // 判断是否需要进行两次右旋还是一次右旋
            // 判断条件就是比较leftSon节点的左右子节点树高
            if (leftSon.left.height > leftSon.right.height) {
                // 右旋一次
                return node = rotateSingleRight(node);
            } else {
                // 两次旋转，先左旋，后右旋
                return node = rotateLeftAndRight(node);
            }
        }
        return right;
    }

    private Node<Value> exchangeRightData(Node<Value> node, Node<Value> left) {
        if (left.left != null) {
            left.left = exchangeRightData(node, left.left);
        } else {
            node.val = left.val;
            // 此处已经把替换节点删除
            return left.right;
        }
        left.height = Math.max(getHeight(left.left), getHeight(left.right)) + 1;
        // 回溯判断left是否平衡,如果不平衡则进行左旋操作。
        int isbanlance = getHeight(left.left) - getHeight(left.right);
        if (isbanlance == -2) {// 进行旋转
            Node<Value> rightSon = node.right;
            // 判断是否需要进行两次右旋还是一次右旋
            // 判断条件就是比较rightSon节点的左右子节点树高
            if (rightSon.right.height > rightSon.left.height) {
                return node = rotateSingleLeft(node);
            } else {
                // 先右旋再左旋
                return node = rotateRightAndLeft(node);
            }
        }
        return left;
    }

}
