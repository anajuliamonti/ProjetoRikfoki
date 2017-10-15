package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;
	private boolean connectedToDatabase;
	
	public ResultSetTableModel(ResultSet resultSet, boolean connectedToDatabase) {
		this.connectedToDatabase = connectedToDatabase;
		this.resultSet = resultSet;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int column) throws IllegalStateException{
		if(!connectedToDatabase)
			throw new IllegalStateException("Desconectado do Banco de Dados");
		try{
			String className = metaData.getColumnClassName(column+1);
			return Class.forName(className);
		}catch(Exception e){
			e.printStackTrace();
		}
		return Object.class;
	}
	
	
	@Override
	public int getColumnCount() throws IllegalStateException{
		// TODO Auto-generated method stub
		if(!connectedToDatabase)
			throw new IllegalStateException("Desconectado do Banco de Dados");
		try{
			return metaData.getColumnCount();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public String getColumnName(int column) throws IllegalStateException{
		if(!connectedToDatabase)
			throw new IllegalStateException("Desconectado do Banco de Dados");
		try{
			return metaData.getColumnName(column+1);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return "";
	}

	
	@Override
	public int getRowCount() throws IllegalStateException{
		// TODO Auto-generated method stub
		if(!connectedToDatabase)
			throw new IllegalStateException("Desconectado do Banco de Dados");
		return numberOfRows;
	}

	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) throws IllegalStateException{
		// TODO Auto-generated method stub
		if(!connectedToDatabase)
			throw new IllegalStateException("Desconectado do Banco de Dados");
		try{
			resultSet.absolute(rowIndex + 1);
			return resultSet.getObject(columnIndex + 1);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return "";
	}
	
	public void setQuery(PreparedStatement ps) throws SQLException, IllegalStateException{
		if(!connectedToDatabase)
			throw new IllegalStateException("Desconectado do Banco de Dados");
		resultSet = ps.executeQuery();
		metaData = resultSet.getMetaData();
		resultSet.last();
		numberOfRows = resultSet.getRow();
		fireTableStructureChanged();
	}
	
}
