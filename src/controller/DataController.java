package controller;

import java.lang.reflect.*;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.EntityManager;

import views.MessageBox;


public class DataController{
	
	EntityManager em;
    List<Object> lstRecords;
    String strQuery;
    
    public DataController() {
    	
    }
	

//Need Method that interrogates the passed generic object for its field type and values
//Need Method that returns an object[][] as a representative of the record set we received
	
	/*want to pass some query string, or Entity with conditions for JPA record retrieval
	 * The returned ArrayList can then be parsed into a Object[][] array for use by Swing components
	 * like JTable models
	 */
	public ArrayList<Object> fetchRecords(EntityManager em, String strQuery){	
		return null;
	}

	public int createRecords(EntityManager em, List<Object> list) {
		return 0;
	}
	
	public int updateRecords(EntityManager em, List<Object> list) {
		return 0;
	}
	
	public int deleteRecords(EntityManager em, List<Object> list) {
		return 0;
	}
	/*Take a List of Objects of any type, determine the fields
	 * of that given Class of Object, use this to parse through the field values
	 * and store in the 2D Object Array for use by JTable or other components
	 */
	public <T> Object[][] parseRecords(ArrayList<T> objArray) throws IllegalArgumentException, IllegalAccessException{
		//ArrayList<String> strTypes = new ArrayList<String>(); 
		Object[][] objRecords;		
		ArrayList<String> strNames = new ArrayList<String>();
		
		Class<?> objectClass = objArray.get(0).getClass(); //just check 1st object - but they're all the same
		//Collect necessary columns names for field count and table labels
		for (Field field: objectClass.getDeclaredFields() ) {
				field.setAccessible(true);
				//Is this a field we need to store?
				if (field.isAnnotationPresent(Column.class)) {
					//MessageBox.infoBox("Has Column annotation", "@Column annotation");
					strNames.add(field.getName());
				}
				//Is the field actually an entity object of a different class?
				//If @OnetoMany do nothing for now but later we'll want to grab that collection of related records
				//If @ManytoOne, then grab the ID Field of the related object
		}
		objRecords = new Object[objArray.size()][strNames.size()];
		int x = 0;
		int y = 0;
		for (T o: objArray) {
			y=0; //reset field counter
			for (Field field: objectClass.getDeclaredFields() ) {
				field.setAccessible(true);
				//Is this a field we need to store?
				if (field.isAnnotationPresent(Column.class)) {
					objRecords[x][y] = field.get(o);
					y++;
				}
				
		}
			x++;	//increment record counter
		}
		return objRecords;
	}
	
	private int getFieldType(Field f) {
		
		String strType = f.getType().getName();
		int type;
		
		switch (strType) {
			case "String":
				type = 1;
				break;
			case "int":
				type = 2; 
				break;
			case "double":
				type = 3;
				break;
			case "BigDecimal":
				type = 4;
				break;
			case "boolean":
				type = 5;
				break;
			case "char":
				type = 6;
				break;
			default:
				type = 7;
		}
		return type;
	}
	
}
