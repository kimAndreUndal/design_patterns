package com.undal.design_patterns.behavioral.iterator.example.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>(new Integer[]{1,4,2,5,1});
        tree.add(7);
        tree.delete(1);
        for (TreeNode<Integer> i:tree.path(5)
             ) {
            System.out.println(i.element);
        }
        System.out.println("==============");
        List<Integer>ss = List.of(new Integer[]{
                1,4,2,1,5
        });
        Object[] s = tree.toArray();
        Arrays.stream(s).forEach(System.out::println);
        System.out.println(tree.containsAll(ss));
    }


}
