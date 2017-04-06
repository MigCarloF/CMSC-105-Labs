package summaryTable;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

public class NumTable {

	private JFrame frame;
	private ArrayList<String> list;

	public NumTable(ArrayList<String> list) {
		this.list = list;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
