package br.com.ricardolg.jdbc.postgres.exemplo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {
	
	public void create(int i) {
		String insert1 = "INSERT INTO tabelateste VALUES ("+i+")";
		try {
			PostgresConnector.executeUpdate(insert1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> read(int index) {
		ArrayList<String> result = new ArrayList<String>();
		String query = "SELECT * FROM tabelateste WHERE id = "+ index;
		ResultSet rs;
		try {
			rs = PostgresConnector.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int totalColumns = rsmd.getColumnCount();
			if(rs.next()) {
				for(int i = 0; i < totalColumns; i++) {
					result.add(rs.getString(i));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public void delete(int index) {
		String query = "DELETE FROM tabelateste WHERE id =" + index;
		try {
			PostgresConnector.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(int index, String col, String data) {
		String query = 
				"UPDATE tabelateste SET "+col+"="+data+" WHERE id =" + index;
		try {
			PostgresConnector.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<ArrayList<String>> readAll(){
		ArrayList<ArrayList<String>> results = 
				new ArrayList<ArrayList<String>>();
		String query = "SELECT * FROM tabelateste";
		ResultSet rs;
		try {
			rs = PostgresConnector.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int totalColumns = rsmd.getColumnCount();
			while(rs.next()) {
				ArrayList<String> row = new ArrayList<String>();
				for(int i = 0; i < totalColumns; i++) {
					row.add(rs.getString(i));
				}
				results.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
	
}
