package model;

public class TableData {
	private String[]dbTables ;

	
	public TableData() {
		dbTables = new String[]{"world","region","state","site","district","area","plot","location","creature","creature_type",
				"attribute","statistic","inventory","storyline","condition","item"};
	}

	public String[] getDbTables() {
		return dbTables;
	}

	public void setDbTables(String[] dbTables) {
		this.dbTables = dbTables;
	}

}
