package StudentApp;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class UpdateStudentJFrame extends JFrame {


	private JPanel contentPane;
	private Student student;
	private JTextField sname;
	private JTextField sage;
	private JTextField saddress;
	private JTextField snumber;
	private JTextField sphone;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStudentJFrame frame = new UpdateStudentJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public UpdateStudentJFrame() {
		setFont(new Font("Dialog", Font.BOLD, 15));
		setTitle("Update Student Information");		
		initComponents();
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		sname = new JTextField();
		sname.setBounds(216, 66, 128, 21);
		contentPane.add(sname);
		sname.setColumns(10);
		
		sage = new JTextField();
		sage.setBounds(216, 115, 128, 21);
		contentPane.add(sage);
		sage.setColumns(10);
		
		saddress = new JTextField();
		saddress.setBounds(216, 160, 128, 21);
		contentPane.add(saddress);
		saddress.setColumns(10);
		
		snumber = new JTextField();
		snumber.setBounds(216, 211, 128, 21);
		contentPane.add(snumber);
		snumber.setColumns(10);
		
		sphone = new JTextField();
		sphone.setBounds(216, 260, 128, 21);
		contentPane.add(sphone);
		sphone.setColumns(10);
		
		JLabel labelName = new JLabel("Student Name:");
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelName.setBounds(102, 69, 91, 15);
		contentPane.add(labelName);
		
		JLabel labelAge = new JLabel("Age:");
		labelAge.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelAge.setBounds(123, 115, 70, 15);
		contentPane.add(labelAge);
		
		JLabel labelAddress = new JLabel("Address:");
		labelAddress.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelAddress.setBounds(123, 163, 70, 15);
		contentPane.add(labelAddress);
		
		JLabel labelSno = new JLabel("Student No:");
		labelSno.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelSno.setBounds(123, 217, 70, 15);
		contentPane.add(labelSno);
		
		JLabel labelPhone = new JLabel("Phone No:");
		labelPhone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelPhone.setBounds(123, 263, 70, 15);
		contentPane.add(labelPhone);
		
		JButton buttonUpdate = new JButton("Update");
		buttonUpdate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateStudentActionPerformed(e);
			}
		});
		buttonUpdate.setBounds(102, 328, 93, 23);
		contentPane.add(buttonUpdate);
		
		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelActionPerformed(e);
			}
		});
		buttonCancel.setBounds(261, 330, 93, 23);
		contentPane.add(buttonCancel);
	}
	public UpdateStudentJFrame(Student student) throws HeadlessException {
		super();
		initComponents();
		this.student = student;
		sname.setText(student.getSname());
		sage.setText(student.getSage()+"");
		saddress.setText(student.getSaddress());
		snumber.setText(student.getSnumber());
		sphone.setText(student.getSphone());
	}
	
	private void updateStudentActionPerformed(ActionEvent actionEvent) {
		 StudentDaoImpl studentDaoImpl=new StudentDaoImpl();
		try {
			student.setSname(this.sname.getText());
			student.setSage(Integer.parseInt(this.sage.getText()));
			student.setSaddress(this.saddress.getText());
			student.setSnumber(this.snumber.getText());			
			student.setSphone(this.sphone.getText());			
			studentDaoImpl.updateStudent(student);
			JOptionPane.showMessageDialog(this, "The update was successful！");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "The update failed！");
		}		
	}
	
	private void cancelActionPerformed(ActionEvent actionEvent) {
		this.setVisible(false);
		this.dispose();
	}
}
