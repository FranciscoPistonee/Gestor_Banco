package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MovimientoDao;
import entidad.Movimiento;
import entidad.TipoMovimiento;

public class MovimientoDaoImpl implements MovimientoDao {

	private static final String insert = "INSERT INTO movimientos(fecha_mo, detalle_mo, importe_mo, tipo_mo, cbu_mo) VALUES(?,?,?,?,?)"; 
	private static final String list = "SELECT fecha_mo, detalle_mo, importe_mo, tipo_mo, cbu_mo FROM movimientos WHERE cbu_mo = ?";
	
	public boolean agregar(Movimiento m) {
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
			statement.setString(1, m.getFecha());
			statement.setString(2, m.getDetalle());
			statement.setString(3, m.getImporte());
			statement.setString(4, m.getTipoMovimiento().getDescripcion());
			statement.setString(5, m.getCbu());
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
	public List<Movimiento> leerCuotas(String cbu) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Movimiento> lista = new ArrayList<Movimiento>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(list);
			statement.setString(1, cbu);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Movimiento m = new Movimiento();
				m.setFecha(resultSet.getString("fecha_mo"));
				m.setDetalle(resultSet.getString("detalle_mo"));
				m.setImporte(resultSet.getString("importe_mo"));
				m.setTipoMovimiento(new TipoMovimiento(resultSet.getString("tipo_mo")));
				m.setCbu(resultSet.getString("cbu_mo"));
				
				lista.add(m);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		conexion.cerrarConexion();
		return lista;
	}

}
