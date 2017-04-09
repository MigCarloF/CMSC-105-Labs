package summaryTable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class Sweng {

	JFrame frmSampler;
	private JTextField textField;
	private int category;
	private String txt;
	private ArrayList<String> list;

	public Sweng(int category) {
		this.category = category;
		list = new ArrayList<String>();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSampler = new JFrame();
		frmSampler.setTitle("Sampler");
		frmSampler.setSize(250, 200);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frmSampler.getContentPane().setLayout(gridBagLayout);

		JLabel lblData = new JLabel("Data");
		GridBagConstraints gbc_lblData = new GridBagConstraints();
		gbc_lblData.insets = new Insets(0, 0, 5, 5);
		gbc_lblData.anchor = GridBagConstraints.NORTH;
		gbc_lblData.gridx = 1;
		gbc_lblData.gridy = 1;
		frmSampler.getContentPane().add(lblData, gbc_lblData);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		frmSampler.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals(null) || textField.getText().equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "No Input", "Dialog", JOptionPane.ERROR_MESSAGE);
				} else {
					if (category == 1) {
						try {
							Integer.parseInt(textField.getText());
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(new JFrame(), "Numbers Only", "Dialog",
									JOptionPane.ERROR_MESSAGE);
						}
						txt = textField.getText();
						list.add(txt);
						textField.setText("");
					} else {
						txt = textField.getText();
						list.add(txt);
						textField.setText("");
					}
				}
			}
		});

		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 3;
		frmSampler.getContentPane().add(btnAdd, gbc_btnAdd);

		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				if (list.isEmpty()) {
					JOptionPane.showMessageDialog(new JFrame(), "Input at least one item", "Dialog", JOptionPane.ERROR_MESSAGE);
				} else {
					Collections.sort(list);
					if (category == 1) {
						NumTable table = new NumTable(list);
						frmSampler.dispose();
						
					} else if (category == 2) {
						CatTable table = new CatTable(list);
						frmSampler.dispose();
						
					} else {
						try {
							throw new Exception("You're not supposed to be here");
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		GridBagConstraints gbc_btnDone = new GridBagConstraints();
		gbc_btnDone.insets = new Insets(0, 0, 0, 5);
		gbc_btnDone.gridx = 1;
		gbc_btnDone.gridy = 5;
		frmSampler.getContentPane().add(btnDone, gbc_btnDone);
		frmSampler.dispose();
	}
}
