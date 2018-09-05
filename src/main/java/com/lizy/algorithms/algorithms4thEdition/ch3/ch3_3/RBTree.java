package com.lizy.algorithms.algorithms4thEdition.ch3.ch3_3;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-9-5 10:47
 */
public class RBTree<T extends Comparable<T>> {

    private transient Entry<T> root;  //根结点

    private static final boolean RED   = false;
    private static final boolean BLACK = true;

    public class Entry<T extends Comparable<T>>{
        T value;        //关键字
        Entry<T> left;  //左孩子
        Entry<T> right; //右孩子
        Entry<T> parent; //父结点
        boolean color = BLACK;   //颜色

        Entry(T value, Entry<T> parent) {
            this.value = value;
            this.parent = parent;
        }
    }

    private void leftRotate(Entry<T> x) {
        Entry<T> y = x.right; //将x的右孩子设为y
        x.right = y.left;  //将x的左孩子 设为 y的右孩子
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;

        if (x.parent == null) {
            this.root = y;
        }else {
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }
        y.left = x;
        x.parent = y;
    }

    private void rigthRotate(Entry<T> y) {
        Entry<T> x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (x.parent == null) {
            this.root = x;
        } else {
            if (y == y.parent.right) {
                y.parent.right = x;
            } else {
                y.parent.left = x;
            }
        }
        x.right = y;
        y.parent = x;
    }

    public void insert(T value) {
        Entry<T> node = new Entry<>(value, null);
        if (node != null) {
            insert(node);
        }
    }

    public void insert(Entry<T> node) {
        Entry<T> t = root;
        if (t == null) {
            root = node;  //插入结点为根节点
        }
        int cmp;
        Entry<T> y = null;
        while (t != null) {
            y = t;
            cmp = node.value.compareTo(t.value);
            if (cmp > 0) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        node.parent = y;
        if (y != null) {
            cmp = node.value.compareTo(y.value);
            if (cmp < 0) {
                y.left = node;
            } else {
                y.right = node;
            }
        }

        node.color = RED;
        fixAfterInsertion(node);
    }

    private void fixAfterInsertion(Entry<T> z) {
        while (z != null && z != root && z.parent.color == RED) {// p[z]为红色
            if (parentOf(z) == leftOf(parentOf(parentOf(z)))) { // p[z]为p[p[z]]的左孩子
                Entry<T> y = rightOf(parentOf(parentOf(z)));
                if (y.color == RED) { // y为红色
                    parentOf(z).color = BLACK;
                    y.color = BLACK;
                    parentOf(parentOf(z)).color = RED;
                    z = parentOf(parentOf(z));
                } else { //y为黑色
                    if (z == rightOf(parentOf(z))) {
                        z = parentOf(z);
                        leftRotate(z);
                    }
                    parentOf(z).color = BLACK;
                    parentOf(parentOf(z)).color = RED;
                    rigthRotate(parentOf(parentOf(z)));
                }
            } else {
                Entry<T> y = leftOf(parentOf(parentOf(z)));
                if (y.color == RED) {
                    parentOf(z).color = BLACK;
                    y.color = BLACK;
                    parentOf(parentOf(z)).color = RED;
                    z = parentOf(parentOf(z));
                } else {
                    if (z == leftOf(parentOf(z))) {
                        z = parentOf(z);
                        rigthRotate(z);
                    }
                    parentOf(z).color =  BLACK;
                    parentOf(parentOf(z)).color = RED;
                    leftRotate(parentOf(parentOf(z)));
                }
            }
        }
        root.color = BLACK;
    }

    private Entry<T> parentOf(Entry<T> p) {
        return (p == null ? null: p.parent);
    }

    private Entry<T> leftOf(Entry<T> p) {
        return (p == null) ? null: p.left;
    }

    private Entry<T> rightOf(Entry<T> p) {
        return (p == null) ? null: p.right;
    }
}
