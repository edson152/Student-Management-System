package StudentApp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InsertStudentJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField sname;
	private JTextField sage;
	private JTextField saddress;
	private JTextField snumber;
	private JTextField sphone;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertStudentJFrame frame = new InsertStudentJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public InsertStudentJFrame() {
		setTitle("Add Student Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 426, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		sname = new JTextField();
		sname.setBounds(195, 57, 128, 21);
		contentPane.add(sname);
		sname.setColumns(10);
		
		sage = new JTextField();
		sage.setBounds(195, 110, 128, 21);
		contentPane.add(sage);
		sage.setColumns(10);
		
		saddress = new JTextField();
		saddress.setBounds(195, 152, 128, 21);
		contentPane.add(saddress);
		saddress.setColumns(10);
		
		snumber = new JTextField();
		snumber.setBounds(195, 200, 128, 21);
		contentPane.add(snumber);
		snumber.setColumns(10);
		
		sphone = new JTextField();
		sphone.setBounds(195, 249, 128, 21);
		contentPane.add(sphone);
		sphone.setColumns(10);
		
		JLabel labelName = new JLabel("Name");
		labelName.setBounds(91, 60, 66, 15);
		contentPane.add(labelName);
		
		JLabel labelAge = new JLabel("AGE");
		labelAge.setBounds(91, 113, 66, 15);
		contentPane.add(labelAge);
		
		JLabel labelAddress = new JLabel("Address");
		labelAddress.setBounds(91, 155, 66, 15);
		contentPane.add(labelAddress);
		
		JLabel labelSnumber = new JLabel("Student Number");
		labelSnumber.setBounds(91, 203, 78, 15);
		contentPane.add(labelSnumber);
		
		JLabel labelPhone = new JLabel("Phone Number");
		labelPhone.setBounds(91, 252, 78, 15);
		contentPane.add(labelPhone);
		
		JButton buttonAdd = new JButton("Add");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudentActionPerformed(e);
			}
		});
		buttonAdd.setBounds(91, 327, 93, 23);
		contentPane.add(buttonAdd);
		
		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelActionPerformed(e);
			}
		});
		buttonCancel.setBounds(230, 327, 93, 23);
		contentPane.add(buttonCancel);
	}
	
	private void addStudentActionPerformed(ActionEvent event) {
		Student student=new Student();		
        StudentDaoImpl studentDaoImpl=new StudentDaoImpl();
        try {
        	student.setSname(sname.getText());
        	student.setSage(Integer.parseInt(sage.getText()));
        	student.setSaddress(saddress.getText());
        	student.setSnumber(snumber.getText());
        	student.setSphone(sphone.getText());
			studentDaoImpl.addStudent(student);
			JOptionPane.showMessageDialog(this, "Inserted successfully!...","Add student information",JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Insert failed!...","Add student information",JOptionPane.ERROR_MESSAGE);
		}              
	}
	private void cancelActionPerformed(ActionEvent event) {
		this.setVisible(false);
        this.dispose();
	}
}
