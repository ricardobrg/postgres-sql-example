package br.com.ricardolg.jdbc.postgres.exemplo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostgresConectorTest {

	@Test
	public void testDbVersion() {
		String version = PostgresConnector.dbVersion();
		assertEquals("PostgreSQL 13.2, compiled by Visual C++ build 1914, 64-bit",version);
	}

}
