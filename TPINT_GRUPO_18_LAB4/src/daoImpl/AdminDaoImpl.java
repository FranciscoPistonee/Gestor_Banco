package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.AdminDao;
import entidad.Admin;

public class AdminDaoImpl implements AdminDao{

	private static final String adminFind = "SELECT * FROM administrador WHERE usuario_ad = ? AND contraseña_ad = ?";
	
	public boolean existe(String usuario, String clave) {
		System.out.println("---ENTRAMOS A DAO IMPL---");
		System.out.println("valor de usuario: " + usuario);
		System.out.println("valor de clave: " + clave);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean encontroAdmin = false;
		try
		{
			statement = conexion.prepareStatement(adminFind);
			statement.setString(1, usuario);
			statement.setString(2, clave);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				conexion.commit();
				encontroAdmin = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("valor de encontro : " + encontroAdmin);
		return encontroAdmin;
	}

}
