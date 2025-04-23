import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class VectorGenerator {

    // Métodos de ordenamiento
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        return arr;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Método para generar vector aleatorio
    public static int[] generateVector(int n, int min, int max) {
        int[] vector = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            vector[i] = random.nextInt(max - min + 1) + min;
        }
        return vector;
    }

    // Modo CLI para probar los algoritmos desde la consola
    public static void runCLI() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            // System.out.println("Ingrese el vector (números separados por espacios o
            // comas):");
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                break;
            }
            String[] tokens = input.split("[,\\s]+");
            int[] vector = new int[tokens.length];
            try {
                for (int i = 0; i < tokens.length; i++) {
                    vector[i] = Integer.parseInt(tokens[i]);
                }
            } catch (NumberFormatException ex) {
                System.out.println("Error: Vector inválido. Asegúrate de ingresar números válidos.");
                continue;
            }
            String[] algorithms = { "Bubble Sort", "Shell Sort", "Insertion Sort", "Selection Sort", "Quick Sort" };
            for (int i = 0; i < algorithms.length; i++) {
                int[] sortedVector = null;
                long startTime = 0, endTime = 0, duration;
                switch (i) {
                    case 0:
                        startTime = System.nanoTime();
                        sortedVector = bubbleSort(vector.clone());
                        endTime = System.nanoTime();
                        break;
                    case 1:
                        startTime = System.nanoTime();
                        sortedVector = shellSort(vector.clone());
                        endTime = System.nanoTime();
                        break;
                    case 2:
                        startTime = System.nanoTime();
                        sortedVector = insertionSort(vector.clone());
                        endTime = System.nanoTime();
                        break;
                    case 3:
                        startTime = System.nanoTime();
                        sortedVector = selectionSort(vector.clone());
                        endTime = System.nanoTime();
                        break;
                    case 4:
                        startTime = System.nanoTime();
                        sortedVector = quickSort(vector.clone(), 0, vector.length - 1);
                        endTime = System.nanoTime();
                        break;
                }
                duration = (endTime - startTime) / 1000000; // convertir a milisegundos
                // System.out.println(algorithms[i] + " - Vector ordenado: " +
                // Arrays.toString(sortedVector));
                System.out.println(duration);
            }
        }
        scanner.close();
    }

    // Interfaz gráfica
    public static class VectorGeneratorGUI extends JFrame {
        private JTextField sizeField, minField, maxField;
        private JTextArea vectorTextArea;
        private JComboBox<String> algorithmComboBox;
        private JLabel timeLabel;

        public VectorGeneratorGUI() {
            setTitle("Generador y Ordenador de Vectores");
            setSize(600, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            // Panel para generación de vector
            JPanel generatePanel = new JPanel(new FlowLayout());
            generatePanel.add(new JLabel("Tamaño:"));
            sizeField = new JTextField(5);
            generatePanel.add(sizeField);
            generatePanel.add(new JLabel("Valor mínimo:"));
            minField = new JTextField(5);
            generatePanel.add(minField);
            generatePanel.add(new JLabel("Valor máximo:"));
            maxField = new JTextField(5);
            generatePanel.add(maxField);
            JButton generateButton = new JButton("Generar vector");
            generatePanel.add(generateButton);
            add(generatePanel, BorderLayout.NORTH);

            // Área de texto para ver y editar el vector
            vectorTextArea = new JTextArea();
            JScrollPane scrollPane = new JScrollPane(vectorTextArea);
            add(scrollPane, BorderLayout.CENTER);

            // Panel para ordenamiento
            JPanel sortPanel = new JPanel(new FlowLayout());
            algorithmComboBox = new JComboBox<>(
                    new String[] { "Bubble Sort", "Shell Sort", "Insertion Sort", "Selection Sort", "Quick Sort" });
            sortPanel.add(algorithmComboBox);
            JButton sortButton = new JButton("Ordenar vector");
            sortPanel.add(sortButton);
            timeLabel = new JLabel("Tiempo: ");
            sortPanel.add(timeLabel);
            add(sortPanel, BorderLayout.SOUTH);

            // Acción para generar el vector
            generateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    generateVectorAction();
                }
            });

            // Acción para ordenar el vector
            sortButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sortVectorAction();
                }
            });

            setVisible(true);
        }

        private void generateVectorAction() {
            try {
                int n = Integer.parseInt(sizeField.getText());
                int min = Integer.parseInt(minField.getText());
                int max = Integer.parseInt(maxField.getText());
                if (n <= 0 || min > max) {
                    JOptionPane.showMessageDialog(this, "Parámetros inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int[] vector = VectorGenerator.generateVector(n, min, max);
                // Mostrar el vector como una lista de números separados por espacios
                vectorTextArea.setText(Arrays.toString(vector).replaceAll("[\\[\\],]", ""));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingresa valores numéricos válidos.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        private void sortVectorAction() {
            String text = vectorTextArea.getText().trim();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El vector está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Parsear el vector (números separados por espacios o comas)
            String[] tokens = text.split("[,\\s]+");
            int[] vector;
            try {
                vector = new int[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    vector[i] = Integer.parseInt(tokens[i]);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El vector contiene elementos no numéricos.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            int option = algorithmComboBox.getSelectedIndex();
            int[] sortedVector = null;
            long startTime, endTime, duration;
            switch (option) {
                case 0:
                    startTime = System.nanoTime();
                    sortedVector = bubbleSort(vector.clone());
                    endTime = System.nanoTime();
                    break;
                case 1:
                    startTime = System.nanoTime();
                    sortedVector = shellSort(vector.clone());
                    endTime = System.nanoTime();
                    break;
                case 2:
                    startTime = System.nanoTime();
                    sortedVector = insertionSort(vector.clone());
                    endTime = System.nanoTime();
                    break;
                case 3:
                    startTime = System.nanoTime();
                    sortedVector = selectionSort(vector.clone());
                    endTime = System.nanoTime();
                    break;
                case 4:
                    startTime = System.nanoTime();
                    sortedVector = quickSort(vector.clone(), 0, vector.length - 1);
                    endTime = System.nanoTime();
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Algoritmo no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }
            duration = (endTime - startTime) / 1000000; // en milisegundos
            // Actualizar el área de texto con el vector ordenado
            vectorTextArea.setText(Arrays.toString(sortedVector).replaceAll("[\\[\\],]", ""));
            timeLabel.setText("Tiempo: " + duration + " ms");
        }
    }

    // Método main: si se ejecuta con argumento "cli" se usa la consola; de lo
    // contrario, la GUI
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("cli")) {
            runCLI();
        } else {
            SwingUtilities.invokeLater(() -> new VectorGeneratorGUI());
        }
    }
}
