module co.edu.uniquindio {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.rabbitmq.client;
    requires java.sql.rowset;

    opens co.edu.uniquindio to javafx.fxml;
    exports co.edu.uniquindio;

    opens co.edu.uniquindio.Controller;
    exports co.edu.uniquindio.Controller;

    opens co.edu.uniquindio.Model;
    exports co.edu.uniquindio.Model;



}

