module com.undal.design_patterns {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.undal.design_patterns to javafx.fxml;
    opens com.undal.design_patterns.behavioral.iterator.example.bst.animation to javafx.fxml;
    exports com.undal.design_patterns;
}