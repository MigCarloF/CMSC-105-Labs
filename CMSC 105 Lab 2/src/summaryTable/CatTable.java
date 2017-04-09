package summaryTable;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;

public class CatTable {

	JFrame frame;
	private ArrayList<String> list;
	private JTable table;
	private String[] columns;
	private String[][] data;

	public CatTable(ArrayList<String> list) {
		this.list = list;
		data = new String[5][5];
		ArrayList<String> toRemove = new ArrayList<String>(); // Avoid
																// ConcurrentModificationException
		String label; // the label to count
		int row = 0; // rows and cols for 2d array managing for data
		int col = 0;
		int count = 0;
		int totalCount = list.size();

		while (list.isEmpty() == false) { // adds list to 2darray
			label = popList();
			count = 1;
			for (String current : list) {
				if (current.equals(label)) {
					count++;
					toRemove.add(current);
				}
			}
			while (list.contains(label)) {
				list.remove(label);
			}
			data[row][col] = label;
			col++;
			data[row][col] = String.valueOf((((double) (count)) / totalCount) * 100) + "%";
			row++;
			col--;

			count = 0;
		}

		columns = new String[] { "VALUE LABELS", "Percentage" };
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(450, 500);
		table = new JTable(data, columns);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(false);
		table.setSize(new Dimension(450, 50));
		table.setFillsViewportHeight(true);
		frame.setVisible(true);
		frame.setResizable(false);

		JScrollPane scrollPane = new JScrollPane(table);

		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

	}

	private String popList() {
		return list.remove(list.size() - 1);
	}
}