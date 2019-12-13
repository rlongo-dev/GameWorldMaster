package model;

import java.util.*;

import javax.swing.table.AbstractTableModel;

import views.MessageBox;

public class GeneralTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> strColNames;
	private Object[][] objArray;
	
	public GeneralTableModel() {
		strColNames = new ArrayList<String>();
		strColNames.add("Foo1");
		strColNames.add("Foo2");
		Object[][] objArray = new Object [2][2];
		objArray[0][0] = 1;
		objArray[0][1] = "FooNess";
		objArray[1][0] = 2;
		objArray[1][1] = "FooNasty";
	}
	
	public GeneralTableModel(Object[][] objArray, ArrayList<String> strColNames) {
		this.objArray = objArray;
		this.strColNames = strColNames;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return strColNames.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		//return objArray.length;
		return 2;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return objArray[arg0][arg1];
	}

}
