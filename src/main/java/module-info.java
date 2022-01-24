module com.pooespol.proyectopoo_2p_murillo_suarez {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.pooespol.proyectopoo_2p_murillo_suarez to javafx.fxml;
    exports com.pooespol.proyectopoo_2p_murillo_suarez;
    requires java.mail;
}
