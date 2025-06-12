import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SolverGUI extends JFrame {
    public SolverGUI() {
        super("Multi-Problem Solver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Sudoku", createSudokuPanel());
        tabs.addTab("N-Reinas", createNQueensPanel());
        tabs.addTab("Labyrinth", createMazePanel());
        add(tabs);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createSudokuPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel grid = new JPanel(new GridLayout(9, 9));
        JTextField[][] fields = new JTextField[9][9];
        int[][] defaultPuzzle = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                fields[i][j] = new JTextField();
                fields[i][j].setHorizontalAlignment(JTextField.CENTER);
                if (defaultPuzzle[i][j] != 0) fields[i][j].setText(String.valueOf(defaultPuzzle[i][j]));
                grid.add(fields[i][j]);
            }
        }
        JButton solveBtn = new JButton("Resolver");
        solveBtn.addActionListener(e -> {
            int[][] board = new int[9][9];
            for (int r = 0; r < 9; r++)
                for (int c = 0; c < 9; c++)
                    board[r][c] = fields[r][c].getText().isEmpty() ? 0 : Integer.parseInt(fields[r][c].getText());
            SudokuSolver solver = new SudokuSolver(board);
            if (solver.resolver()) {
                for (int r = 0; r < 9; r++)
                    for (int c = 0; c < 9; c++)
                        fields[r][c].setText(String.valueOf(board[r][c]));
                JOptionPane.showMessageDialog(this, "¡Sudoku resuelto!");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo resolver el Sudoku.");
            }
        });
        panel.add(grid, BorderLayout.CENTER);
        panel.add(solveBtn, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createNQueensPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel top = new JPanel();
        top.add(new JLabel("Tamaño (n):"));
        JTextField sizeField = new JTextField("8", 5);
        top.add(sizeField);
        JButton solveBtn = new JButton("Resolver");
        JTextArea output = new JTextArea();
        output.setEditable(false);
        solveBtn.addActionListener(e -> {
            int n = Integer.parseInt(sizeField.getText());
            NReinas solver = new NReinas(n);
            solver.resolver();
            // Captura la salida en consola
            output.setText("Número de soluciones: " + solver.getSoluciones() + "\nPrimera solución:\n" + solver.getPrimeraSolucionString());
        });
        top.add(solveBtn);
        panel.add(top, BorderLayout.NORTH);
        panel.add(new JScrollPane(output), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createMazePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        int rows = 5, cols = 5;
        JPanel grid = new JPanel(new GridLayout(rows, cols));
        JTextField[][] cells = new JTextField[rows][cols];
        int[][] defaultLab = {
            {1,0,1,1,1},{1,0,0,0,1},{1,1,1,0,1},{0,0,1,0,1},{1,1,1,1,1}
        };
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new JTextField(defaultLab[i][j] + "");
                cells[i][j].setHorizontalAlignment(JTextField.CENTER);
                grid.add(cells[i][j]);
            }
        }
        JButton solveBtn = new JButton("Resolver");
        solveBtn.addActionListener(e -> {
            int[][] lab = new int[rows][cols];
            for (int r = 0; r < rows; r++)
                for (int c = 0; c < cols; c++)
                    lab[r][c] = Integer.parseInt(cells[r][c].getText());
            MazeSolver solver = new MazeSolver(lab);
            if (solver.resolver()) {
                int[][] path = solver.getCamino();
                for (int r = 0; r < rows; r++)
                    for (int c = 0; c < cols; c++)
                        cells[r][c].setText(path[r][c] + "");
                JOptionPane.showMessageDialog(this, "Camino encontrado.");
            } else {
                JOptionPane.showMessageDialog(this, "No hay solución.");
            }
        });
        panel.add(grid, BorderLayout.CENTER);
        panel.add(solveBtn, BorderLayout.SOUTH);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SolverGUI::new);
    }
}

// Nota: Asegúrate de tener las clases SudokuSolver, NReinas y MazeSolver en el mismo paquete o de importarlas correctamente.
