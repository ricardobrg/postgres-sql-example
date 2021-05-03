package br.com.ricardolg.jdbc.postgres.exemplo;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Test;

public class PostgresConectorTest {
	
	@Test
	public void testDbVersion() {
		String version = PostgresConnector.dbVersion();
		assertEquals("PostgreSQL 13.2, compiled by Visual C++ build 1914, 64-bit",version);
	}
	
	@Test
	public void testInsert() {
		String insert1 = "INSERT INTO tabelateste VALUES (1)";
		String insert2 = "INSERT INTO tabelateste VALUES (2)";
		String select= "SELECT * FROM tabelateste";
		String delete = "DELETE FROM tabelateste";
		try {
			PostgresConnector.executeUpdate(insert1);
			PostgresConnector.executeUpdate(insert2);
			ResultSet rs = PostgresConnector.executeQuery(select);
			rs.next();
			assertEquals(1, rs.getInt(1));
			PostgresConnector.executeUpdate(delete);
			ResultSet rs2 = PostgresConnector.executeQuery(select);
			assertFalse(rs2.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void cleanDB() {
		String delete = "DELETE FROM tabelateste";
		try {
			PostgresConnector.executeUpdate(delete);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	
}
