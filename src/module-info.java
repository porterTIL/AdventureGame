module AdventureGame {
    requires json.simple;
    requires javafx.controls;
    opens json;
    exports com.Group3.ZombieBytes.Driver;
}