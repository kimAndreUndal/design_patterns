module com.undal.design_patterns {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.undal.design_patterns to javafx.fxml;
    exports com.undal.design_patterns;
}