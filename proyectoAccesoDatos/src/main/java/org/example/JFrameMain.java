package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JFrameMain extends JFrame {

	private JTable table;
	private DefaultTableModel tableModel;
	private Consultas consultas;

	public JFrameMain() {
		consultas = new Consultas();  // Inicializamos el objeto Consultas

		setTitle("Consultas de Base de Datos");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Crear tabla y su modelo
		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

		// Crear panel para los botones
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		// Crear botones para cada consulta
		JButton buttonB = new JButton("Consulta B");
		JButton buttonC = new JButton("Consulta C");
		JButton buttonD = new JButton("Consulta D");
		JButton buttonE = new JButton("Consulta E");

		// Añadir botones al panel
		panel.add(buttonB);
		panel.add(buttonC);
		panel.add(buttonD);
		panel.add(buttonE);

		// Añadir panel al JFrame
		add(panel, BorderLayout.SOUTH);

		// Acción del botón B
		buttonB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTable(consultas.consultab(), "Employee ID", "Salary", "Project ID");
			}
		});

		// Acción del botón C
		buttonC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTable(consultas.consultac(), "Project ID", "Salary", "Hours Worked");
			}
		});

		// Acción del botón D
		buttonD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTable(consultas.consultd(), "Project ID", "Salary Costs", "Budget");
			}
		});

		// Acción del botón E
		buttonE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTable(consultas.consultae(), "Project ID", "Salary Costs Fraction");
			}
		});
	}

	// Método para actualizar la tabla con los resultados de la consulta
	private void updateTable(List<Object[]> results, String... columnNames) {
		// Limpiar el modelo de la tabla antes de actualizar
		tableModel.setRowCount(0);
		tableModel.setColumnCount(0);

		// Agregar nombres de las columnas a la tabla
		for (String columnName : columnNames) {
			tableModel.addColumn(columnName);
		}

		// Agregar los resultados de la consulta como filas en la tabla
		if (results != null) {
			for (Object[] row : results) {
				tableModel.addRow(row);
			}
		} else {
			// Si no hay resultados, agregamos una fila vacía
			tableModel.addRow(new Object[] { "No hay resultados" });
		}
	}

	public static void main(String[] args) {
		// Ejecutar la interfaz gráfica
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrameMain frame = new JFrameMain();
				frame.setVisible(true);
			}
		});
	}
}
