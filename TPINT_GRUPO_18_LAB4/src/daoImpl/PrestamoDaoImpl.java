package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PrestamoDao;
import entidad.Prestamo;

public class PrestamoDaoImpl implements PrestamoDao {

	private static final String insert = "INSERT INTO prestamo(dni_cliente_pr, cbu_cliente_pr, fecha_pr, importe_intereses_pr, importe_pedido_pr, cuotas_pr, monto_cuota_pr, estado_pr) VALUES(?,?,?,?,?,?,?,?)";
	private static final String insertCuota = "INSERT INTO cuotas(id_prestamo_cuo, dni_cliente_cuo, cbu_cliente_cuo, fecha_cuo, importe_intereses_cuo, importe_pedido_cuo, cuotas_cuo, monto_cuota_cuo, estado_cuo) VALUES(?,?,?,?,?,?,?,?,?)";
	private static final String findCbu = "SELECT * FROM cuentas INNER JOIN clientes WHERE usuario_cli = ? AND CBU_cu = ?";
	private static final String update = "UPDATE prestamo SET estado_pr = ? where id_prestamo = ?";
	private static final String findClient = "Select DNI_cli from clientes where usuario_cli = ?";
	private static final String list = "Select * from prestamo where estado_pr = 'pendiente'";
	private static final String get = "Select * from prestamo where id_prestamo = ?";

	@Override
	public boolean agregar(Prestamo p) {
		
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
			statement.setString(1, p.getDniClienteAsignado());
			statement.setString(2, p.getCbu());
			statement.setString(3, p.getFecha());
			statement.setString(4, p.getImporteConIntereses());
			statement.setString(5, p.getImportePedido());
			statement.setString(6, p.getCuotas());
			statement.setString(7, p.getMontoXMes());
			statement.setString(8, p.getEstado());
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
	
	public boolean agregarCuotas(Prestamo p) {
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
			statement = conexion.prepareStatement(insertCuota);
			statement.setInt   (1, p.getIdPrestamo());
			statement.setString(2, p.getDniClienteAsignado());
			statement.setString(3, p.getCbu());
			statement.setString(4, p.getFecha());
			statement.setString(5, p.getImporteConIntereses());
			statement.setString(6, p.getImportePedido());
			statement.setString(7, p.getCuotas());
			statement.setString(8, p.getMontoXMes());
			statement.setString(9, p.getEstado());
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
		System.out.println("valor de agergo cuotas : " + seAgrego);
		return seAgrego;
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
			statement = conexion.prepareStatement(findCbu);
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
	public String buscarDni(String cuenta) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		String dni = "no encontró";
		try
		{
			statement = conexion.prepareStatement(findClient);
			statement.setString(1, cuenta);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				conexion.commit();
				dni = resultSet.getString("DNI_cli");
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
		System.out.println("valor del dni encontrado : " + dni);
		return dni;
	}

	@Override
	public List<Prestamo> leerTodos() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Prestamo> lista = new ArrayList<Prestamo>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(list);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Prestamo p = new Prestamo();
				p.setIdPrestamo(resultSet.getInt("id_prestamo"));
				p.setDniClienteAsignado(resultSet.getString("dni_cliente_pr"));
				p.setCbu(resultSet.getString("cbu_cliente_pr"));
				p.setImporteConIntereses(resultSet.getString("importe_intereses_pr"));
				p.setImportePedido(resultSet.getString("importe_pedido_pr"));
				p.setFecha(resultSet.getString("fecha_pr"));
				p.setCuotas(resultSet.getString("cuotas_pr"));
				p.setMontoXMes(resultSet.getString("monto_cuota_pr"));
				p.setEstado(resultSet.getString("estado_pr"));  
				
				lista.add(p);
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
	public boolean Autorizar(String autorizacion, int id) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean seAutorizacion = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setString (1, autorizacion);
			statement.setInt    (2, id);
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				seAutorizacion = true;
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
		
		return seAutorizacion;
	}

	@Override
	public Prestamo get(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		Prestamo p = new Prestamo();
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(get);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				p.setIdPrestamo(resultSet.getInt("id_prestamo"));
				p.setDniClienteAsignado(resultSet.getString("dni_cliente_pr"));
				p.setCbu(resultSet.getString("cbu_cliente_pr"));
				p.setImporteConIntereses(resultSet.getString("importe_intereses_pr"));
				p.setImportePedido(resultSet.getString("importe_pedido_pr"));
				p.setFecha(resultSet.getString("fecha_pr"));
				p.setCuotas(resultSet.getString("cuotas_pr"));
				p.setMontoXMes(resultSet.getString("monto_cuota_pr"));
				p.setEstado(resultSet.getString("estado_pr"));  
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		conexion.cerrarConexion();
		return p;
	}
}
