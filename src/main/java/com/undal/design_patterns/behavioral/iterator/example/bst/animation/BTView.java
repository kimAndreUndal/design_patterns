package com.undal.design_patterns.behavioral.iterator.example.bst.animation;

import com.undal.design_patterns.behavioral.iterator.example.bst.BST;
import com.undal.design_patterns.behavioral.iterator.example.bst.TreeNode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class BTView extends Pane {
    private BST<Integer> tree = new BST<>();
    private double radius = 15;
    private double vGap = 50;

    BTView(BST<Integer> tree){
        this.tree = tree;
        setStatus("Tree is empty");
    }

    public void setStatus(String msg){
        getChildren().add(new Text(20,20, msg));
    }

    public void displayTree(){
        this.getChildren().clear();
        if(tree.getRoot() != null){
            displayTree(tree.getRoot(), getWidth()/2, vGap, getWidth() / 4);
        }
    }

    private void displayTree(TreeNode<Integer> root, double x, double y, double hGap){
        if(root.left != null){
            getChildren().add(new Line(x - hGap, y+vGap, x, y));
            displayTree(root.left, x - hGap, y+vGap, hGap / 2);
        }
        if(root.right != null){
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            displayTree(root.right, x + hGap, y + vGap, hGap/2);
        }

        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHEAT);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle, new Text(x - 4, y + 4, root.element + " "));
    }
}
