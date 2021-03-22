package KF5012;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskAssignmentDatabase {
	
	//CONNECTION TO THE DATABASE
	private DBConnection database;

	public TaskAssignmentDatabase(){
	database = new DBConnection();		// In constructor! Bad!
	database.Connect("C:\\Users\\bauch\\Desktop\\Year 2\\Software_engineering\\AssesmentTASKS.db");
	}
	
	//DATABASE FUNCTIONS

	//DISPLAY ALL
	public ArrayList<Tasks> GetAllTasks() throws SQLException{
		String sqlString = new String("SELECT taskID, taskName, taskDescription, userID, status, creationDate, completionDate FROM Tasks;");
		
		ResultSet taskList = database.RunSQLQuery(sqlString);
		ArrayList<Tasks> tasks = new ArrayList<Tasks>();
		
		System.out.println("TESTING");
		System.out.println(tasks);
		System.out.println(taskList);
		
		while(taskList.next()) {
			//DO THE REST FOR THE OTHER ITEMS IN THE DATABASE
			Tasks newTask = new Tasks();
			newTask.setTaskID(taskList.getInt(1));
			newTask.setTaskName(taskList.getString(2));
			newTask.setTaskDescription(taskList.getString(3));
			newTask.setUserID(taskList.getInt(4));
			newTask.setStatus(taskList.getString(5));
			newTask.setCreationDate(taskList.getString(6));
			newTask.setCompletionDate(taskList.getString(7));
			tasks.add(newTask);
		}
		
		return tasks;
		
	}

}
