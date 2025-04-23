import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Laboratorio2 extends JFrame {

    // Se elimina final para poder actualizar la matriz
    private int[][] matriz = {
        { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 }
    };

    // Áreas de texto para los paneles que dependen de la matriz
    private JTextArea diagTextArea, triSupTextArea, sumaImparesTextArea, sumaPrimeraFilaTextArea,
                       mayorElementoTextArea, matrizUnitariaTextArea, multiplosSieteTextArea;

    public Laboratorio2() {
        setTitle("Laboratorio Nro. 2 - Operaciones con Matrices y Algoritmos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        // Crear el panel con pestañas
        JTabbedPane pestañas = new JTabbedPane();

        // Panel para ingresar la matriz con instrucciones en un título
        pestañas.addTab("Insertar Matriz", crearPanelIngresarMatriz());

        // 1. Diagonal principal
        pestañas.addTab("Diagonal Principal", crearPanelDiagonal());
        // 2. Sumar triangular superior derecha
        pestañas.addTab("Triangular Superior", crearPanelTriangularSuperior());
        // 3. Sumar impares
        pestañas.addTab("Suma Impares", crearPanelSumaImpares());
        // 4. Sumar primera fila
        pestañas.addTab("Suma Primera Fila", crearPanelSumaPrimeraFila());
        // 5. Mayor elemento
        pestañas.addTab("Mayor Elemento", crearPanelMayorElemento());
        // 6. Matriz Unitaria
        pestañas.addTab("Matriz Unitaria", crearPanelMatrizUnitaria());
        // 7. Múltiplos de 7
        pestañas.addTab("Múltiplos de 7", crearPanelMultiplosSiete());
        // 8. Algoritmo de Euclides
        pestañas.addTab("Euclides", crearPanelEuclides());
        // 9. Multiplicación Rusa
        pestañas.addTab("Multiplicación Rusa", crearPanelMultiplicacionRusa());

        // Agregar ChangeListener para actualizar resultados según la matriz actual
        pestañas.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                String titulo = pestañas.getTitleAt(pestañas.getSelectedIndex());
                switch(titulo) {
                    case "Diagonal Principal":
                        actualizarDiagonal();
                        break;
                    case "Triangular Superior":
                        actualizarTriangularSuperior();
                        break;
                    case "Suma Impares":
                        actualizarSumaImpares();
                        break;
                    case "Suma Primera Fila":
                        actualizarSumaPrimeraFila();
                        break;
                    case "Mayor Elemento":
                        actualizarMayorElemento();
                        break;
                    case "Matriz Unitaria":
                        actualizarMatrizUnitaria();
                        break;
                    case "Múltiplos de 7":
                        actualizarMultiplosSiete();
                        break;
                    default:
                        break;
                }
            }
        });

        add(pestañas);
    }

    // Panel para ingresar la matriz (instrucciones en un título)
    private JPanel crearPanelIngresarMatriz() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel lblTitulo = new JLabel("Ingrese la matriz: Cada fila en una línea, números separados por espacios.");
        JTextArea txtMatriz = new JTextArea(10, 30);
        // Dejar el área de texto vacía para insertar la matriz
        txtMatriz.setText("1 2 3 4 \n5 6 7 8 \n9 10 11 12 \n13 14 15 16");
        JButton btnCargar = new JButton("Cargar Matriz");
        JLabel lblResultado = new JLabel(" ");
        
        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtMatriz.getText();
                try {
                    int[][] nuevaMatriz = parsearMatriz(input);
                    // Se verifica que la matriz sea cuadrada y no vacía
                    if (nuevaMatriz.length == 0 || nuevaMatriz.length != nuevaMatriz[0].length) {
                        lblResultado.setText("La matriz debe ser cuadrada y no vacía.");
                        return;
                    }
                    matriz = nuevaMatriz;
                    lblResultado.setText("Matriz cargada exitosamente.");
                } catch (Exception ex) {
                    lblResultado.setText("Error al parsear la matriz: " + ex.getMessage());
                }
            }
        });
        
        JPanel inputs = new JPanel(new BorderLayout());
        inputs.add(new JScrollPane(txtMatriz), BorderLayout.CENTER);
        inputs.add(btnCargar, BorderLayout.SOUTH);
        panel.add(lblTitulo, BorderLayout.NORTH);
        panel.add(inputs, BorderLayout.CENTER);
        panel.add(lblResultado, BorderLayout.SOUTH);
        return panel;
    }

    // Método que parsea la cadena de texto ingresada y retorna una matriz de enteros
    private int[][] parsearMatriz(String input) throws Exception {
        String[] lineas = input.split("\\n");
        java.util.List<String> filasList = new java.util.ArrayList<>();
        for (String linea : lineas) {
            if (!linea.trim().isEmpty()) {
                filasList.add(linea.trim());
            }
        }
        int filas = filasList.size();
        if (filas == 0) {
            throw new Exception("No se ingresaron filas.");
        }
        String[] elementosPrimeraFila = filasList.get(0).split("\\s+");
        int columnas = elementosPrimeraFila.length;
        int[][] matrizTemp = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            String[] elementos = filasList.get(i).split("\\s+");
            if (elementos.length != columnas) {
                throw new Exception("Todas las filas deben tener el mismo número de elementos.");
            }
            for (int j = 0; j < columnas; j++) {
                matrizTemp[i][j] = Integer.parseInt(elementos[j]);
            }
        }
        return matrizTemp;
    }

    // Panel 1: Diagonal principal (se usa un área de texto de instancia)
    private JPanel crearPanelDiagonal() {
        JPanel panel = new JPanel(new BorderLayout());
        diagTextArea = new JTextArea();
        diagTextArea.setEditable(false);
        panel.add(new JScrollPane(diagTextArea), BorderLayout.CENTER);
        actualizarDiagonal(); // Cálculo inicial
        return panel;
    }

    private void actualizarDiagonal() {
        StringBuilder salida = new StringBuilder("Diagonal Principal:\n");
        for (int i = 0; i < matriz.length; i++) {
            salida.append(matriz[i][i]).append(" ");
        }
        diagTextArea.setText(salida.toString());
    }

    // Panel 2: Sumar triangular superior derecha
    private JPanel crearPanelTriangularSuperior() {
        JPanel panel = new JPanel(new BorderLayout());
        triSupTextArea = new JTextArea();
        triSupTextArea.setEditable(false);
        panel.add(new JScrollPane(triSupTextArea), BorderLayout.CENTER);
        actualizarTriangularSuperior();
        return panel;
    }

    private void actualizarTriangularSuperior() {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = i + 1; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
        }
        triSupTextArea.setText("Suma de la parte triangular superior derecha: " + suma);
    }

    // Panel 3: Sumar elementos impares
    private JPanel crearPanelSumaImpares() {
        JPanel panel = new JPanel(new BorderLayout());
        sumaImparesTextArea = new JTextArea();
        sumaImparesTextArea.setEditable(false);
        panel.add(new JScrollPane(sumaImparesTextArea), BorderLayout.CENTER);
        actualizarSumaImpares();
        return panel;
    }

    private void actualizarSumaImpares() {
        int suma = 0;
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor % 2 != 0) {
                    suma += valor;
                }
            }
        }
        sumaImparesTextArea.setText("Suma de los elementos impares: " + suma);
    }

    // Panel 4: Sumar primera fila
    private JPanel crearPanelSumaPrimeraFila() {
        JPanel panel = new JPanel(new BorderLayout());
        sumaPrimeraFilaTextArea = new JTextArea();
        sumaPrimeraFilaTextArea.setEditable(false);
        panel.add(new JScrollPane(sumaPrimeraFilaTextArea), BorderLayout.CENTER);
        actualizarSumaPrimeraFila();
        return panel;
    }

    private void actualizarSumaPrimeraFila() {
        int suma = 0;
        for (int valor : matriz[0]) {
            suma += valor;
        }
        sumaPrimeraFilaTextArea.setText("Suma de la primera fila: " + suma);
    }

    // Panel 5: Mayor elemento
    private JPanel crearPanelMayorElemento() {
        JPanel panel = new JPanel(new BorderLayout());
        mayorElementoTextArea = new JTextArea();
        mayorElementoTextArea.setEditable(false);
        panel.add(new JScrollPane(mayorElementoTextArea), BorderLayout.CENTER);
        actualizarMayorElemento();
        return panel;
    }

    private void actualizarMayorElemento() {
        int mayor = matriz[0][0];
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor > mayor) {
                    mayor = valor;
                }
            }
        }
        mayorElementoTextArea.setText("El mayor elemento de la matriz es: " + mayor);
    }

    // Panel 6: Matriz Unitaria (identidad)
    private JPanel crearPanelMatrizUnitaria() {
        JPanel panel = new JPanel(new BorderLayout());
        matrizUnitariaTextArea = new JTextArea();
        matrizUnitariaTextArea.setEditable(false);
        panel.add(new JScrollPane(matrizUnitariaTextArea), BorderLayout.CENTER);
        actualizarMatrizUnitaria();
        return panel;
    }

    private void actualizarMatrizUnitaria() {
        int n = matriz.length;
        int[][] identidad = new int[n][n];
        for (int i = 0; i < n; i++) {
            identidad[i][i] = 1;
        }
        StringBuilder salida = new StringBuilder("Matriz Unitaria:\n");
        for (int[] fila : identidad) {
            for (int valor : fila) {
                salida.append(valor).append(" ");
            }
            salida.append("\n");
        }
        matrizUnitariaTextArea.setText(salida.toString());
    }

    // Panel 7: Elementos múltiplos de 7
    private JPanel crearPanelMultiplosSiete() {
        JPanel panel = new JPanel(new BorderLayout());
        multiplosSieteTextArea = new JTextArea();
        multiplosSieteTextArea.setEditable(false);
        panel.add(new JScrollPane(multiplosSieteTextArea), BorderLayout.CENTER);
        actualizarMultiplosSiete();
        return panel;
    }

    private void actualizarMultiplosSiete() {
        StringBuilder salida = new StringBuilder("Elementos múltiplos de 7:\n");
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor % 7 == 0) {
                    salida.append(valor).append(" ");
                }
            }
        }
        multiplosSieteTextArea.setText(salida.toString());
    }

    // Panel 8: Algoritmo de Euclides (se mantiene sin refrescar, ya que depende de la entrada)
    private JPanel crearPanelEuclides() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputs = new JPanel(new FlowLayout());
        JLabel lblNum1 = new JLabel("Número 1:");
        JTextField txtNum1 = new JTextField(5);
        JLabel lblNum2 = new JLabel("Número 2:");
        JTextField txtNum2 = new JTextField(5);
        JButton btnCalcular = new JButton("Calcular MCD");

        inputs.add(lblNum1);
        inputs.add(txtNum1);
        inputs.add(lblNum2);
        inputs.add(txtNum2);
        inputs.add(btnCalcular);

        JTextArea textArea = new JTextArea(5, 30);
        textArea.setEditable(false);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(txtNum1.getText());
                    int num2 = Integer.parseInt(txtNum2.getText());
                    String proceso = calcularMCD(num1, num2);
                    textArea.setText(proceso);
                } catch (NumberFormatException ex) {
                    textArea.setText("Ingrese números válidos.");
                }
            }
        });

        panel.add(inputs, BorderLayout.NORTH);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        return panel;
    }

    private String calcularMCD(int a, int b) {
        StringBuilder proceso = new StringBuilder();
        proceso.append("Datos iniciales: a = ").append(a).append(", b = ").append(b).append("\n");
        while (b != 0) {
            int residuo = a % b;
            proceso.append("a = ").append(a).append(", b = ").append(b)
                     .append(" -> residuo = ").append(residuo).append("\n");
            a = b;
            b = residuo;
        }
        proceso.append("El MCD es: ").append(a);
        return proceso.toString();
    }

    // Panel 9: Multiplicación Rusa (se mantiene sin actualización automática)
    private JPanel crearPanelMultiplicacionRusa() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputs = new JPanel(new FlowLayout());
        JLabel lblNum1 = new JLabel("Multiplicando:");
        JTextField txtNum1 = new JTextField(5);
        JLabel lblNum2 = new JLabel("Multiplicador:");
        JTextField txtNum2 = new JTextField(5);
        JButton btnCalcular = new JButton("Calcular Producto");

        inputs.add(lblNum1);
        inputs.add(txtNum1);
        inputs.add(lblNum2);
        inputs.add(txtNum2);
        inputs.add(btnCalcular);

        JTextArea textArea = new JTextArea(5, 30);
        textArea.setEditable(false);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(txtNum1.getText());
                    int b = Integer.parseInt(txtNum2.getText());
                    String proceso = multiplicacionRusa(a, b);
                    textArea.setText(proceso);
                } catch (NumberFormatException ex) {
                    textArea.setText("Ingrese números válidos.");
                }
            }
        });

        panel.add(inputs, BorderLayout.NORTH);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        return panel;
    }

    private String multiplicacionRusa(int a, int b) {
        StringBuilder proceso = new StringBuilder();
        proceso.append("Datos iniciales: a = ").append(a).append(", b = ").append(b).append("\n");
        int resultado = 0;
        while (b > 0) {
            proceso.append("a = ").append(a).append(", b = ").append(b);
            if (b % 2 != 0) {
                resultado += a;
                proceso.append(" (b es impar, se suma a resultado -> resultado = ").append(resultado).append(")");
            }
            proceso.append("\n");
            a *= 2;
            b /= 2;
        }
        proceso.append("El producto es: ").append(resultado);
        return proceso.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Laboratorio2 frame = new Laboratorio2();
            frame.setVisible(true);
        });
    }
}
