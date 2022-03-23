module AdventureGame {
    requires json.simple;
    requires javafx.controls;

    opens JSON;
    exports com.Group3.ZombieBytes.Driver;
}