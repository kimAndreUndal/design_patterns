package com.undal.design_patterns.behavioral.iterator.example.bst;

import java.util.ArrayList;

public class TreeNode<E>{
    public E element;
    public TreeNode<E> left;
    public TreeNode<E> right;

    public TreeNode(E e){
        element = e;
    }
}
