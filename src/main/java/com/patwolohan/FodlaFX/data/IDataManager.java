package com.patwolohan.FodlaFX.data;

/*
*	Author:	COR edited by PW
*	Date:	2018
*	
*/

import java.sql.Connection;
import java.sql.SQLException;

public interface IDataManager {

	public Connection getConnectionObject() throws SQLException;

	public void disconnect() throws SQLException;
}
