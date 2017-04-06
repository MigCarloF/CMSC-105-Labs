package summaryTable;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Categ {

	JFrame frmSelectCategory;
	private int category = -1;
	Boolean actionPerformed = false;
	/**
	 * Create the application.
	 */
	public Categ() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSelectCategory = new JFrame();
		frmSelectCategory.setTitle("Select Type");
		frmSelectCategory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSelectCategory.setResizable(false);
		frmSelectCategory.setAlwaysOnTop(true);
		frmSelectCategory.setBounds(100, 100, 350, 150);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmSelectCategory.getContentPane().setLayout(gridBagLayout);
		
		JButton btnNumerical = new JButton("Numerical");
		btnNumerical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category = 1;
				Sweng sweng = new Sweng(category);
				sweng.frmSampler.setVisible(true);
				sweng.frmSampler.setResizable(false);
				frmSelectCategory.dispose();
			}
		});
		GridBagConstraints gbc_btnNumerical = new GridBagConstraints();
		gbc_btnNumerical.insets = new Insets(0, 0, 5, 0);
		gbc_btnNumerical.gridx = 4;
		gbc_btnNumerical.gridy = 1;
		frmSelectCategory.getContentPane().add(btnNumerical, gbc_btnNumerical);
		
		JButton btnCategorical = new JButton("Categorical");
		btnCategorical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category = 2;
				Sweng sweng = new Sweng(category);
				sweng.frmSampler.setVisible(true);
				sweng.frmSampler.setResizable(false);
				frmSelectCategory.dispose();
			}
		});
		GridBagConstraints gbc_btnCategorical = new GridBagConstraints();
		gbc_btnCategorical.gridx = 4;
		gbc_btnCategorical.gridy = 2;
		frmSelectCategory.getContentPane().add(btnCategorical, gbc_btnCategorical);
	}

}
