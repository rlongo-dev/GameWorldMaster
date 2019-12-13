package controller;


import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Area;
import views.MainFrame;

public class MainControl {
	static MainFrame frame;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GameWorldMaster");
    EntityManager em = emf.createEntityManager();
    
    /*
	public static void main(String[] args) {

		

		frame = new MainFrame();
		frame.setVisible(true);

		ArrayList<Area> arrArea = new ArrayList<Area>();
		ArrayList<String> arrString = new ArrayList<String>();
		arrString.add("ID");
		arrString.add("NAME");
		Object[][] objArray = null;
		arrArea.add(new Area(1,"Area51"));
		arrArea.add(new Area(2,"Metro Area"));
		
		DataController DC = new DataController();
		try {
			objArray = DC.parseRecords(arrArea);
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame.setTableModel(objArray,arrString);
	}
	*/

}
