module AdventureGame {
    requires json.simple;
    requires javafx.controls;


    opens com.Group3.ZombieBytes.Driver to javafx.fxml;
    exports com.Group3.ZombieBytes.Driver;
}