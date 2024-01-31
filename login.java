import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.bson.Document;

import javax.swing.*;

public class login extends base {
    JButton register = new JButton("Register");
    JTextArea user = new JTextArea();
    JPasswordField password = new JPasswordField();
    JPanel login = new JPanel();
    JLabel usuario = new JLabel("USUARIO");
    JLabel contraseña = new JLabel("CONTRASEÑA");

    public login() {
        password.setPreferredSize(new Dimension(200, 50));
        user.setPreferredSize(new Dimension(200, 50));
        login.setPreferredSize(new Dimension(800, 800));
        login.add(usuario);
        login.add(user);
        login.add(contraseña);
        login.add(password);
        login.add(register);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((password.getPassword()).length == 0) {
                    JOptionPane.showMessageDialog(null, "No se ha ingresado una contraseña");
                } else if (user.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "No se ha ingresado un usuario");
                } else {
                    base estudiante = new base();
                    Document verificar = estudiante.verificar(user.getText(), new String(password.getPassword()));
                    if (verificar == null) {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    } else {
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(login);
                        frame.dispose();

                        // Abrir una nueva ventana
                        JFrame informacion = new JFrame();
                        informacion.setContentPane(new informacion(verificar).menuPrincipal);
                        informacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        informacion.pack();
                        informacion.setVisible(true);
                    }
                }
            }
        });
    }
}