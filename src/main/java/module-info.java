module com.tvinh.test1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires json.path;
    requires rest.assured;
    requires json.simple;
    requires org.testng;
    requires org.apache.commons.lang3;

    opens com.tvinh.test1 to javafx.fxml;
    exports com.tvinh.test1;
}