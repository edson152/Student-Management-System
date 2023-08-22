package StudentApp;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class QueryByIdJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idJTextField;
	private JTable jTable;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryByIdJFrame frame = new QueryByIdJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public QueryByIdJFrame() {
		setFont(new Font("Tahoma", Font.BOLD, 15));
		setTitle("Enter ID to Query");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblId.setBounds(91, 48, 54, 15);
		contentPane.add(lblId);
		
		idJTextField = new JTextField();
		idJTextField.setBounds(155, 46, 166, 21);
		contentPane.add(idJTextField);
		idJTextField.setColumns(10);
		
		JButton buttonSearch = new JButton("Search");
		buttonSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchActionPerformed(e);
			}
		});
		buttonSearch.setBounds(169, 96, 93, 23);
		contentPane.add(buttonSearch);
	}
	
	public QueryByIdJFrame(JTable jTable) throws HeadlessException {
		super();
		this.jTable = jTable;
		setTitle("Enter ID to Query");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblId.setBounds(91, 48, 54, 15);
		contentPane.add(lblId);
		
		idJTextField = new JTextField();
		idJTextField.setBounds(155, 46, 166, 21);
		contentPane.add(idJTextField);
		idJTextField.setColumns(10);
		
		JButton buttonSearch = new JButton("Search");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchActionPerformed(e);
			}
		});
		buttonSearch.setBounds(169, 96, 93, 23);
		contentPane.add(buttonSearch);
	}


	private void SearchActionPerformed(ActionEvent event) {
		try {
			jTable.clearSelection();
			int id=Integer.parseInt(this.idJTextField.getText());
			SimpleTableModel<Student> simpleTableModel=(SimpleTableModel<Student>)jTable.getModel();
			List<Student> rows=simpleTableModel.getRows();			
			int index=-1;
			for(int i=0;i<rows.size();i++){
				if(id==rows.get(i).getSid()) index=i;
			}
			if(index==-1) {
				JOptionPane.showMessageDialog(this, " No students found！", " Check student information",JOptionPane.WARNING_MESSAGE );
			}
			else {
				jTable.changeSelection(index, 0, false, false);
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, " Query failed！", " Check student information",JOptionPane.ERROR_MESSAGE );
		}
		
	}
}