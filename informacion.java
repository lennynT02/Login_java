import java.awt.*;
import javax.swing.*;

import org.bson.Document;

public class informacion {
    JPanel menuPrincipal = new JPanel();
    JTextArea biografia = new JTextArea();
    Document estudiante;

    public informacion(Document estudiante) {
        this.estudiante = estudiante;
        menuPrincipal.setPreferredSize(new Dimension(800, 800));
        biografia
                .setText("Nombre:" + estudiante.getString("nombre") + "\nBiografia:" + estudiante.getString("biografia")
                        + "\nApellido:" + estudiante.getString("apellido") + "\nEdad:" + estudiante.getInteger("edad")
                        + "\nCiudad:" + estudiante.getString("ciudad") + "\nCorreo:" + estudiante.getString("correo"));
        menuPrincipal.add(biografia);
    }
}
