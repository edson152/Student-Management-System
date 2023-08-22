package StudentApp;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginJFrame extends JFrame {


	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField userPassword;
	private JTextField adminName;
	private JPasswordField adminPassword;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJFrame frame = new LoginJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LoginJFrame() {
		setFont(new Font("Times New Roman", Font.BOLD, 14));
		setTitle("Student Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		CardLayout cardLayout=new CardLayout();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu landingOptions = new JMenu("Select Login");
		landingOptions.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(landingOptions);
		
		JMenuItem adminOption = new JMenuItem("Admin Login");
		adminOption.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		adminOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.last(contentPane);
			}
		});
		landingOptions.add(adminOption);
		
		JMenuItem userOption = new JMenuItem("User Login");
		userOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.first(contentPane);
			}
		});
		landingOptions.add(userOption);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cardLayout);
		
		JPanel userPanel = new JPanel();
		contentPane.add(userPanel, "name_5600414879778");
		userPanel.setLayout(null);
		
		userName = new JTextField();
		userName.setBounds(148, 55, 122, 21);
		userPanel.add(userName);
		userName.setColumns(10);
		
		userPassword = new JPasswordField();
		userPassword.setBounds(148, 96, 122, 21);
		userPanel.add(userPassword);
		
		JButton userButton1 = new JButton("Login");
		userButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				userLoginActionPerformed(event);
			}
		});
		userButton1.setBounds(72, 159, 93, 23);
		userPanel.add(userButton1);
		
		JButton userButton2 = new JButton("Register");
		userButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				userRegisterActionPerformed(event);
			}
		});
		userButton2.setBounds(220, 159, 93, 23);
		userPanel.add(userButton2);
		
		JLabel lbll = new JLabel("User name");
		lbll.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbll.setBounds(41, 58, 85, 15);
		userPanel.add(lbll);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(41, 98, 68, 15);
		userPanel.add(lblPassword);
		
		JPanel adminPanel = new JPanel();
		contentPane.add(adminPanel, "name_5642638031832");
		adminPanel.setLayout(null);
		
		adminName = new JTextField();
		adminName.setBounds(190, 48, 129, 21);
		adminPanel.add(adminName);
		adminName.setColumns(10);
		
		adminPassword = new JPasswordField();
		adminPassword.setBounds(190, 91, 129, 21);
		adminPanel.add(adminPassword);
		
		JButton adminButton = new JButton("Login:");
		adminButton.setBounds(209, 154, 93, 23);
		adminPanel.add(adminButton);
		
		JLabel lblNewLabel = new JLabel("Admin Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(79, 51, 101, 15);
		adminPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(59, 94, 121, 15);
		adminPanel.add(lblNewLabel_1);
		
	}
	private void userLoginActionPerformed(ActionEvent event) {
		 String uname=userName.getText();
	        String upassword=userPassword.getText();
	        UserDaoImpl userDaoImpl=new UserDaoImpl();
	        if(userDaoImpl.certifyUser(uname, upassword))
	        {
	            JOptionPane.showMessageDialog(this, "Login Successful");
	            StudentJFrame studentJFrame=new StudentJFrame();
	            studentJFrame.setBounds(600, 400, 800, 600);
	            studentJFrame.setVisible(true);
	            this.setVisible(false);
	            this.dispose();
	        }
	        else
	        {
	            JOptionPane.showMessageDialog(this, "Failed to Login, account number or password error！","Logging in the student management system...",JOptionPane.ERROR_MESSAGE);
	        }
	}
	private void userRegisterActionPerformed(ActionEvent event) {
		String uname=userName.getText();
	     String upassword=userPassword.getText();
	     User user=new User(uname,upassword);
	     UserDaoImpl userDaoImpl=new UserDaoImpl();
	     if(userDaoImpl.addUser(user)) {
	    	 JOptionPane.showMessageDialog(this, "Registration was successful");
	     }
	     else {
	    	 JOptionPane.showMessageDialog(this, "Registration failed!","Register for the Student Management System",JOptionPane.ERROR_MESSAGE);
	     }
	}
	
}
