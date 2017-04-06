package summaryTable;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;

public class CatTable {

	private JFrame frame;
	private ArrayList<String> list;
	private JTable table;
	private String[] columns;
	private String[][] data;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatTable window = new CatTable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CatTable(/* ArrayList<String> list */) {
		// this.list = list;
		data = new String[][] {};
		columns = new String[] { "VALUE LABELS", "Percentage"};
		initialize();
	}

	private void initialize() {
		frame = new JFrame();

		table = new JTable(data, columns);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(false);
		table.setSize(new Dimension(450, 50));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

}
