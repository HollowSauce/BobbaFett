package KF5012;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskAssignmentApp {

	TaskAssignmentGUI theMainWindow;			// The GUI to communicate with user

	// This is just to run the program
	public static void main(String[] args) throws SQLException {
		TaskAssignmentApp taa = new TaskAssignmentApp();

	}
	
	/**
	* Constructs the App and a GUI. Makes the GUI visible and 
	* loads data from the database for display in the GUI
	*
	*/
	public TaskAssignmentApp() throws SQLException{
		theMainWindow = new TaskAssignmentGUI(this);
		theMainWindow.setVisible(true);


		// You need to connect to a database here, and send the data to the main window
		TaskAssignmentDatabase tad = new TaskAssignmentDatabase();
		ArrayList<Tasks> answer = tad.GetAllTasks();
		theMainWindow.displayTableData(answer);
	}
	

	
}


