package StudentApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class StudentJFrame extends JFrame {

	private JPanel contentPane;
	private List<String> cols;
    private List<Student> rows;
    private StudentDaoImpl studentDaoImpl;
    private SimpleTableModel<Student> simpleTableModel;
    private JTable jTable;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentJFrame frame = new StudentJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public StudentJFrame() {
		setFont(new Font("Dialog", Font.BOLD, 15));
		setTitle("Student Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cols=new ArrayList<>();
        cols.add("ID");
        cols.add("Name");
        cols.add("Age");
        cols.add("Address");
        cols.add("Student number");
        cols.add("Phone number");       
        studentDaoImpl=new StudentDaoImpl();
        rows=studentDaoImpl.getAllStudent();
        simpleTableModel=new SimpleTableModel<Student>(cols,rows);
    	
        JLabel jLabel = new JLabel();
        jLabel.setText("Student Management System");
        jLabel.setFont(new Font("Dialog", Font.BOLD, 18)); // NOI18N
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);        
        getContentPane().add(jLabel, BorderLayout.PAGE_START);
        JScrollPane jScrollPane = new JScrollPane();
        jTable = new JTable();

        
        jTable.setModel(simpleTableModel);
        jScrollPane.setViewportView(jTable);
        getContentPane().add(jScrollPane, BorderLayout.CENTER);
            
        JLabel jLabel2 = new JLabel();
        jLabel2.setText("Status bar");
        getContentPane().add(jLabel2, BorderLayout.PAGE_END);
        
        JMenuBar jMenuBar = new JMenuBar();
        
        JMenu file = new JMenu();
        file.setText("File");
        	JMenuItem quit = new JMenuItem();
        	quit.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			quitActionPerformed(e);
        		}
        	});
        		quit.setText("Quit window");
        		file.add(quit);
        jMenuBar.add(file);
        
        JMenu edit = new JMenu();
        	edit.setText("Edit");
        	edit.setToolTipText("");
        	JMenuItem insert = new JMenuItem();
        		insert.setText("insert");
        		insert.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        insertStudentActionPerformed(evt);
                    }
                });
        	edit.add(insert);
        
        	JMenuItem update = new JMenuItem();
        		update.setText("update");
        		update.addActionListener(new java.awt.event.ActionListener() {
        			public void actionPerformed(ActionEvent evt) {
        				updateStudentActionPerformed(evt);
        			}
        		});
        	edit.add(update);
        
        	JMenuItem refresh = new JMenuItem();
        	refresh.setText("refresh list");
        	refresh.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent evt) {
        			refreshActionPerformed(evt);
        		}
        	});
        	edit.add(refresh);
        jMenuBar.add(edit);
        
        JMenuItem delete = new JMenuItem("delete");
        delete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		delStudentActionPerformed(e);
        	}
        });
        edit.add(delete);
        
        JMenu query = new javax.swing.JMenu();
        	query.setText("Query");
        	JMenuItem queryAll = new JMenuItem();
        	queryAll.setText("quey all");
        	queryAll.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					queryAllActionPerformed(e);
				}
			});
        query.add(queryAll);
        
        	JMenu classifiedQuery = new JMenu();
        	classifiedQuery.setText("clasify query");
        		JMenuItem queryBySno = new JMenuItem();
        		queryBySno.setText("query by student number");
        	classifiedQuery.add(queryBySno);
        		JMenuItem queryByName = new JMenuItem();
        		queryByName.setText("query by name");
        	classifiedQuery.add(queryByName);       
        		JMenuItem queryByID = new JMenuItem();
        		queryByID.setText("query by id");
                queryByID.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        queryByIDActionPerformed(evt);
                    }
                });
            classifiedQuery.add(queryByID);
        query.add(classifiedQuery);
        jMenuBar.add(query);
        
        JMenu statistics = new JMenu();
        statistics.setText("Statistics");
        jMenuBar.add(statistics);
        
        JMenu help = new JMenu();
        help.setText("About");
        	JMenuItem about = new JMenuItem();
        	about.setText("About");
        	about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        help.add(about);         
        jMenuBar.add(help);         
        setJMenuBar(jMenuBar);  
        pack();
	}
	
	 private void aboutActionPerformed(ActionEvent evt) {
		 JOptionPane.showMessageDialog(this, "Student Management System 2021 edition \n\n JAVA PROGRAMMING\n\n created By Edson Nyoni\n\n Student ID: 201938330189\n\n Computer Science","About Student Management",JOptionPane.PLAIN_MESSAGE);
	 }

	 private void insertStudentActionPerformed(ActionEvent evt) {
	     new InsertStudentJFrame().setVisible(true);
	 }

	 private void refreshActionPerformed(ActionEvent evt) {
		 rows=studentDaoImpl.getAllStudent();
	     simpleTableModel.setRows(rows);
	     simpleTableModel.fireTableDataChanged();
	 }
	 
	 private void updateStudentActionPerformed(ActionEvent evt) {
		 try {
			 	rows=studentDaoImpl.getAllStudent();
			 	simpleTableModel.setRows(rows);
				Student student=rows.get(jTable.getSelectedRow());
				new UpdateStudentJFrame(student).setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Please select specific students...","Update student information",JOptionPane.ERROR_MESSAGE);
		}    	             
	 }
	 
	 private void queryByIDActionPerformed(ActionEvent evt) {
		 rows=studentDaoImpl.getAllStudent();
	     simpleTableModel.setRows(rows);
		 new QueryByIdJFrame(jTable).setVisible(true);
	 }
	 
	 private void delStudentActionPerformed(ActionEvent actionEvent) {		 
	     try {
			Student student=rows.get(jTable.getSelectedRow());
			studentDaoImpl.delStudentbyID(student.getSid());
			rows=studentDaoImpl.getAllStudent();
		    simpleTableModel.setRows(rows);
		    simpleTableModel.fireTableDataChanged();
		    JOptionPane.showMessageDialog(this, "Successfully Deleted.", "Delete student information", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Failed to delete! Please select the students...", "Delete student information", JOptionPane.ERROR_MESSAGE);
		}
	 }
	 
	 private void quitActionPerformed(ActionEvent actionEvent) {
		 this.setVisible(false);
		 this.dispose();
	 }
	 private void queryAllActionPerformed(ActionEvent actionEvent) {
		 rows=studentDaoImpl.getAllStudent();
	     simpleTableModel.setRows(rows);
	     simpleTableModel.fireTableDataChanged();
	 }
}
