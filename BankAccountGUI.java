import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.text.DecimalFormat;

public class BankAccountGUI extends JFrame implements WindowListener{

	private JPanel contentPane;
	private JLabel lblBalance;
	private BankAccountWindowTwo two;
	private BankAccountWindowThree three;
	private BankAccount chequings;
	private BankAccount savings;
	private BankAccount currentAccount;
	private DecimalFormat df = new DecimalFormat("0.00");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankAccountGUI frame = new BankAccountGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BankAccountGUI() {
		setTitle("BankAccountGUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		chequings = new BankAccount("chequings",0);
		savings = new BankAccount("savings",0);
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAccount.setBounds(33, 33, 119, 28);
		contentPane.add(lblAccount);
		
		JLabel lblCurrentBalance = new JLabel("Current Balance:");
		lblCurrentBalance.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrentBalance.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCurrentBalance.setBounds(32, 130, 160, 28);
		contentPane.add(lblCurrentBalance);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if ((lblBalance.getText().equals(""))) {
				}
				else {
					openWindowTwo();
				}
			}
		});
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnWithdraw.setBounds(43, 210, 109, 28);
		contentPane.add(btnWithdraw);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if ((lblBalance.getText().equals(""))) {
				}
				else {
					openWindowThree();
				}
			}
		});
		btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeposit.setBounds(291, 210, 109, 28);
		contentPane.add(btnDeposit);
		
		lblBalance = new JLabel("");
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBalance.setBounds(183, 130, 179, 28);
		contentPane.add(lblBalance);
		
		String[] accountStrings = {"Please Select an Account...", "Chequings", "Savings"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox cmbAccounts = new JComboBox(accountStrings);
		cmbAccounts.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbAccounts.setSelectedIndex(0);
		cmbAccounts.setBounds(173, 33, 197, 28);
		contentPane.add(cmbAccounts);
		cmbAccounts.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("rawtypes")
				JComboBox cb = (JComboBox)e.getSource();
		        String accountName = (String)cb.getSelectedItem();
		        if (accountName.equals("Chequings")) {
		        	currentAccount = chequings;
		        	double display = currentAccount.getBalance();
		    		if (display<0) {
		    			lblBalance.setForeground(Color.RED);
		    			lblBalance.setText("$"+df.format(display));
		    		}
		    		else {
		    			lblBalance.setForeground(Color.BLACK);
		    			lblBalance.setText("$"+df.format(display));
		    		}
		        }
		        else if(accountName.equals("Savings")) {
		        	currentAccount = savings;
		        	double display = currentAccount.getBalance();
		    		if (display<0) {
		    			lblBalance.setForeground(Color.RED);
		    			lblBalance.setText("$"+df.format(display));
		    		}
		    		else {
		    			lblBalance.setForeground(Color.BLACK);
		    			lblBalance.setText("$"+df.format(display));
		    		}
		        }
		        else {
		        	lblBalance.setText("");
		        }
			}
		});
	}
	
	public void openWindowTwo() {
		two = new BankAccountWindowTwo(currentAccount);
		two.addWindowListener(this);
		two.setVisible(true);
		
	}
	public void openWindowThree() {
		three = new BankAccountWindowThree(currentAccount);
		three.addWindowListener(this);
		three.setVisible(true);
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		double display = currentAccount.getBalance();
		if (display<0) {
			lblBalance.setForeground(Color.RED);
			lblBalance.setText("$"+df.format(display));
		}
		else {
			lblBalance.setForeground(Color.BLACK);
			lblBalance.setText("$"+df.format(display));
		}
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// Method that runs when the window closed event gets sent
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
