module com.edu.xmum.cst206 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.edu.xmum.cst206 to javafx.fxml;
    exports com.edu.xmum.cst206;
}