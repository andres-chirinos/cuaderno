import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Formulario extends JFrame {
    private JTextField nroField;
    private JTextField serieField;
    private JButton executeButton;
    private JButton closeButton;

    public Formulario() {
        setTitle("Vector Generator");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        nroField = new JTextField(10);
        serieField = new JTextField(10);
        executeButton = new JButton("Ejecutar");
        closeButton = new JButton("Cerrar");

        // Set layout
        setLayout(new GridLayout(3, 2));

        // Add components to frame
        add(new JLabel("Nro:"));
        add(nroField);
        add(new JLabel("Serie:"));
        add(serieField);
        add(executeButton);
        add(closeButton);

        // Add action listeners
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int nro = Integer.parseInt(nroField.getText());
                    int[] vector = VectorGenerator.generateRandomVector(nro);
                    serieField.setText(java.util.Arrays.toString(vector));
                    //JOptionPane.showMessageDialog(null, "Vector generado: " + java.util.Arrays.toString(vector));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }
}

class VectorGenerator {
    public static int[] generateRandomVector(int size) {
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        int[] vector = new int[size];
        for (int i = 0; i < size; i++) {
            vector[i] = random.nextInt(100);
        }
        long endTime = System.currentTimeMillis();
        return vector;
    }
}