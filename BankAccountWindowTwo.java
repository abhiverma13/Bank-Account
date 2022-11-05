import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class BankAccountWindowTwo extends JFrame {

	private JPanel contentPane;
	private JTextField txtAmount;
	private JLabel lblError;

	/**
	 * Create the frame.
	 */
	public BankAccountWindowTwo(BankAccount currentAccount) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProvideAmount = new JLabel("Please provide the amount to be withdrawn:");
		lblProvideAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProvideAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblProvideAmount.setBounds(0, 10, 294, 47);
		contentPane.add(lblProvideAmount);
		
		txtAmount = new JTextField();
		txtAmount.setText("0.00");
		txtAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmount.setBounds(67, 60, 143, 25);
		contentPane.add(txtAmount);
		txtAmount.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblError.setForeground(Color.RED);
		lblError.setBounds(67, 95, 143, 13);
		contentPane.add(lblError);
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					double withdraw = Double.valueOf(txtAmount.getText());	
					currentAccount.withdraw(withdraw);
					done();
				}
				catch (Exception e1) {
					lblError.setText("Please enter a valid number");
				}
			}
		});
		btnOk.setBounds(25, 132, 85, 21);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				done();
			}
		});
		btnCancel.setBounds(178, 132, 85, 21);
		contentPane.add(btnCancel);
		
	}
	
	public void done() {
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
