package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.CuotaDao;
import entidad.Cuota;

public class CuotaDaoImpl implements CuotaDao{

	private static final String list = "select id_cuota, id_prestamo_cuo, nombre_cli, apellido_cli, dni_cliente_cuo, cbu_cliente_cuo, fecha_cuo , importe_intereses_cuo ,cuotas_cuo, monto_cuota_cuo from cuotas inner join clientes on DNI_cli = dni_cliente_cuo WHERE dni_cliente_cuo = ? AND estado_cuo = 'autorizado'";
	private static final String delete = "update cuotas set estado_cuo = 'pagada' where id_cuota = ?";
	
	public List<Cuota> leerCuotas(String dni) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Cuota> lista = new ArrayList<Cuota>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(list);
			statement.setString(1, dni);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Cuota c = new Cuota();
				c.setIdCuota(resultSet.getInt("id_cuota"));
				c.setIdPrestamo(resultSet.getInt("id_prestamo_cuo"));
				c.setNombreCliente(resultSet.getString("nombre_cli"));
				c.setApellidoCliente(resultSet.getString("apellido_cli"));
				c.setDniCliente(resultSet.getString("dni_cliente_cuo"));
				c.setCbuCliente(resultSet.getString("cbu_cliente_cuo"));
				c.setFecha(resultSet.getString("fecha_cuo"));
				c.setImporteIntereses(resultSet.getString("importe_intereses_cuo"));
				c.setCuotas(resultSet.getString("cuotas_cuo"));
				c.setMontoCuota(resultSet.getString("monto_cuota_cuo"));
				
				lista.add(c);
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
	public boolean eliminar(int id) {
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
			statement.setInt    (1, id);
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				seElimino = true;
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
		
		return seElimino;
	}

}
