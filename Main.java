import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("Ejercicios");
        application.setContentPane(new login().login);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.pack();
        application.setVisible(true);
        
    }
}
