package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CuentaDao;
import entidad.Cliente;
import entidad.Cuenta;

public class CuentaDaoImpl implements CuentaDao {

	//Strings con consultas
	private static final String insert = "INSERT INTO cuentas (cliente_asignado_cu, fecha_creacion_cu, tipo_cuenta_cu, numero_cuenta_cu, CBU_cu, saldo_cu) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String update = "UPDATE cuentas SET  cliente_asignado_cu = ?, fecha_creacion_cu = ?, tipo_cuenta_cu = ?, numero_cuenta_cu = ? WHERE CBU_cu = ?";
	private static final String plus3 = "SELECT COUNT(*) AS total FROM cuentas WHERE cliente_asignado_cu = ? AND estado_cu = 'alta'";
	private static final String find = "SELECT * FROM cuentas WHERE numero_cuenta = ? AND estado_cu = 'alta'";
	private static final String delete = "UPDATE cuentas SET estado_cu = 'baja' WHERE CBU_cu = ?";
	private static final String deleteDni = "UPDATE cuentas SET estado_cu = 'baja' WHERE cliente_asignado_cu = ?";
	private static final String list = "SELECT * FROM cuentas WHERE estado_cu = 'alta'";
	private static final String findSaldo = "SELECT saldo_cu FROM cuentas WHERE CBU_cu = ? AND estado_cu = 'alta'";
	private static final String updateSaldo = "UPDATE cuentas SET saldo_cu = ? WHERE CBU_cu = ?"; 
	private static final String findCbuClient = "SELECT * FROM cuentas INNER JOIN clientes ON DNI_cli = cliente_asignado_cu WHERE usuario_cli = ? AND CBU_cu = ? AND estado_cu = 'alta'";
	private static final String findCbu = "SELECT * FROM cuentas WHERE CBU_cu = ? AND estado_cu = 'alta'"; 
	
	@Override
	public boolean agregar(Cuenta cuenta) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean seAgrego = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, cuenta.getDniClienteAsignado());
			statement.setString(2, cuenta.getFechaCreacion());
			statement.setString(3, cuenta.getTipoCuenta());
			statement.setString(4, cuenta.getNumCuenta());
			statement.setString(5, cuenta.getCBU());
			statement.setString(6, cuenta.getSaldo());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				seAgrego = true;
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
		
		return seAgrego;
	}

	@Override
	public boolean eliminar(String cbu) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean seElimino = false;
		try
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, cbu);
			if(statement.executeUpdate() > 0) 
			{
				conexion.commit();
				seElimino = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return seElimino;
	}

	@Override
	public boolean modificar(String cbu, Cuenta cuenta) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean seModifico = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setString(1, cuenta.getDniClienteAsignado());
			statement.setString(2, cuenta.getFechaCreacion());
			statement.setString(3, cuenta.getTipoCuenta());
			statement.setString(4, cuenta.getNumCuenta());
			statement.setString(5, cbu);
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				seModifico = true;
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
		
		return seModifico;
		
	}

	@Override
	public boolean existe(String numeroCuenta) { 
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cuenta> leerTodos() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(list);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Cuenta cuenta = new Cuenta();
				cuenta.setDniClienteAsignado(resultSet.getString("cliente_asignado_cu"));  
				cuenta.setFechaCreacion(resultSet.getString("fecha_creacion_cu"));
				cuenta.setTipoCuenta(resultSet.getString("tipo_cuenta_cu"));
				cuenta.setNumCuenta(resultSet.getString("numero_cuenta_cu"));
				cuenta.setCBU(resultSet.getString("CBU_cu"));
				cuenta.setSaldo(resultSet.getString("saldo_cu"));
				lista.add(cuenta);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		conexion.cerrarConexion();
		return lista;
	}

	@Override
	public boolean verificarCuentas(String dniCliente) {
		System.out.println("---ENTRAMOS A CUENTA DAO IMPL---");
		System.out.println("valor del dni: " + dniCliente);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean masDeTres = false;
		int totalCuentas;
		try
		{
			statement = conexion.prepareStatement(plus3);
			statement.setString(1, dniCliente);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				conexion.commit();
				totalCuentas = resultSet.getInt("total");
				if(totalCuentas >= 3) { masDeTres = true; }
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
		System.out.println("valor de encontro cliente : " + masDeTres);
		System.out.println("valor del total de cuentas : " + masDeTres);
		return masDeTres;
	}
	
	@Override
	public float buscarSaldo(String cbu) {
		
		String CBU = cbu;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		float saldo = 0;
		try
		{
			statement = conexion.prepareStatement(findSaldo);
			statement.setString(1, CBU);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				conexion.commit();
				saldo = Float.parseFloat(resultSet.getString("saldo_cu"));
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
		System.out.println("valor del saldo encontrado : " + saldo);
		return saldo;
	}

	@Override
	public boolean actualizarSaldo(String saldo, String cbu) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean seActualizo = false;
		try
		{
			statement = conexion.prepareStatement(updateSaldo);
			statement.setString (1, saldo);
			statement.setString (2, cbu);
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				seActualizo = true;
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
		return seActualizo;
	}

	@Override
	public boolean coincideCbu(String cbu, String usuario) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean coincideCbu = false;
		try
		{
			statement = conexion.prepareStatement(findCbuClient);
			statement.setString(1, usuario);
			statement.setString(2, cbu);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				conexion.commit();
				coincideCbu = true;
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
		System.out.println("valor de coincide cbu : " + coincideCbu);
		return coincideCbu;
	}

	@Override
	public boolean existeCbu(String cbu) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean existeCbu = false;
		try
		{
			statement = conexion.prepareStatement(findCbu);
			statement.setString(1, cbu);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				conexion.commit();
				existeCbu = true;
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
		System.out.println("valor de coincide cbu : " + existeCbu);
		return existeCbu;
	}

	@Override
	public Cuenta get(String cbu) {
		System.out.println("ENTRANDO A GET BY DNI");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		Cuenta c = new Cuenta();
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(findCbu);
			statement.setString(1, cbu);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				c.setDniClienteAsignado(resultSet.getString("cliente_asignado_cu"));  
				c.setFechaCreacion(resultSet.getString("fecha_creacion_cu"));
				c.setTipoCuenta(resultSet.getString("tipo_cuenta_cu"));
				c.setNumCuenta(resultSet.getString("numero_cuenta_cu"));
				c.setCBU(resultSet.getString("CBU_cu"));
				c.setSaldo(resultSet.getString("saldo_cu"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		conexion.cerrarConexion();
		return c;
	}

	@Override
	public boolean eliminarDni(String dni) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean seElimino = false;
		try
		{
			statement = conexion.prepareStatement(deleteDni);
			statement.setString(1, dni);
			if(statement.executeUpdate() > 0) 
			{
				conexion.commit();
				seElimino = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return seElimino;
	}

}
