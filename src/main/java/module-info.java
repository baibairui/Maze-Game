module com.edu.xmum.cst206 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.edu.xmum.cst206 to javafx.fxml;
    exports com.edu.xmum.cst206;
    opens com.edu.xmum.cst206.Inteferce to javafx.fxml;
    exports com.edu.xmum.cst206.Interferce;
    opens com.edu.xmum.cst206.Interferce to javafx.fxml;
}