package com.undal.design_patterns.behavioral.iterator.example.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class BST<E extends Comparable<E>> implements Tree<E> {
    protected TreeNode<E> root;
    protected int size;

    public BST() {
    }

    BST(E[] objects) {
        this.addAll(Arrays.asList(objects));
    }

    @Override
    public int size() {
        return size;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    @Override
    public Iterator<E> iterator() {
        return new InorderIterator();
    }

    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean insert(E e) {
        if (root == null) root = createNewNode(e);
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false;
            }
            if (e.compareTo(parent.element) < 0) {
                parent.left = createNewNode(e);
            } else
                parent.right = createNewNode(e);
        }
        size++;
        return true;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.println(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.element + " ");
    }

    @Override
    public boolean isEmpty() {
        return Tree.super.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return Tree.super.contains(o);
    }

    @Override
    public Object[] toArray() {
        return Tree.super.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return Tree.super.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return Tree.super.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return Tree.super.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return Tree.super.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return Tree.super.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return Tree.super.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return Tree.super.retainAll(c);
    }

    @Override
    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                break;
        }
        if (current == null)
            return false;

        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else {
                    parent.right = current.right;
                }
            }
        }
        else{
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }
            current.element = rightMost.element;
            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                parentOfRightMost.left = rightMost.left;
        }
        size--;
        return true;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void clear(){
        root = null;
        size = 0;
    }

    private TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    public ArrayList<TreeNode<E>> path(E e) {
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        TreeNode<E> current = root;

        while (current != null) {
            list.add(current);
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else
                break;
        }
        return list;
    }

    private class InorderIterator implements Iterator<E>{
        private ArrayList<E> list = new ArrayList<>();

        private int current = 0;

        public InorderIterator(){
            inorder();
        }

        private void inorder(){
            inorder(root);
        }

        private void inorder(TreeNode<E> root){
            if(root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        @Override
        public boolean hasNext() {
            return current < list.size();
        }

        @Override
        public E next() {
            return list.get(current++);
        }

        @Override
        public void remove() {
            if(current == 0)
                throw new IllegalStateException();
            delete(list.get(--current));
            list.clear();
            inorder();
        }
    }

}
