package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ReporteDao;

public class ReporteDaoImpl implements ReporteDao {
	
	private static final String count = "SELECT COUNT(*) AS total_registros FROM cuentas";
	private static final String countClient = "SELECT COUNT(*) AS total_clientes FROM clientes";
	private static final String countSaldo = "SELECT COUNT(*) AS registros_sueldos FROM cuentas WHERE saldo_cu > ?";
	private static final String countCuenta = "SELECT COUNT(*) AS total_cuentas FROM cuentas WHERE cliente_asignado_cu = ?";
	private static final String sumSaldo = "SELECT SUM(saldo_cu) AS saldo_total FROM cuentas WHERE cliente_asignado_cu = ?";

	public int contarCuenta() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int contar = 0;
		try
		{
			statement = conexion.prepareStatement(count);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				conexion.commit();
				contar = resultSet.getInt("total_registros");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("valor del contar cuentas : " + contar);
		return contar;
	}

	public int contarCuentaSaldo(float saldo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int contar = 0;
		try
		{
			statement = conexion.prepareStatement(countSaldo);
			statement.setFloat(1, saldo);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				conexion.commit();
				contar = resultSet.getInt("registros_sueldos");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("valor del contar por sueldo : " + contar);
		return contar;
	}

	@Override
	public int contarCuentaCliente(String dni) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int contar = 0;
		try
		{
			statement = conexion.prepareStatement(countCuenta);
			statement.setString(1, dni);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				conexion.commit();
				contar = resultSet.getInt("total_cuentas");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("valor del contar cuentas : " + contar);
		return contar;
	}

	@Override
	public float sumarSaldoCliente(String dni) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		float sumar = 0;
		try
		{
			statement = conexion.prepareStatement(sumSaldo);
			statement.setString(1, dni);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				conexion.commit();
				sumar = resultSet.getFloat("saldo_total");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("valor del saldo total : " + sumar);
		return sumar;
	}

	@Override
	public int contarCliente() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int contar = 0;
		try
		{
			statement = conexion.prepareStatement(countClient);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				conexion.commit();
				contar = resultSet.getInt("total_clientes");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("valor del contar clientes : " + contar);
		return contar;
	}
	
}
