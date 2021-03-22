package KF5012;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import KF5012.Tasks;

public class TaskAssignmentGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable taskTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskAssignmentGUI frame = new TaskAssignmentGUI(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param taskAssignmentApp 
	 */
	public TaskAssignmentGUI(TaskAssignmentApp taskAssignmentApp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		taskTable = new JTable();
		taskTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Task ID", "Task Name",
				"Task Description", "Assigned", "Complete", "Creation Date", "Completion Date" }));
		taskTable.getColumnModel().getColumn(2).setPreferredWidth(158);
		taskTable.getColumnModel().getColumn(5).setPreferredWidth(113);
		taskTable.getColumnModel().getColumn(6).setPreferredWidth(115);
		scrollPane.setViewportView(taskTable);
	}
	
	void displayTableData(ArrayList<Tasks> tableData){
		
		// Empty the existing data
		DefaultTableModel tableModel = (DefaultTableModel) taskTable.getModel();
		tableModel.setRowCount(0);
		
		// Some safety code missing here
		for(Tasks s: tableData) {
			tableModel.addRow(new Object[] {s.getTaskID(), s.getTaskName(), s.getTaskDescription(), s.getUserID(), s.getStatus(), s.getCreationDate(), s.getCompletionDate()});
		}
	}

}