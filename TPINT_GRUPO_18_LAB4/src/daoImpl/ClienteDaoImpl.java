package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.ClienteDao;
import entidad.Cliente;
import entidad.Persona;
import entidad.Prestamo;

public class ClienteDaoImpl implements ClienteDao {
	//Strings con consultas
		private static final String insert = "INSERT INTO clientes (DNI_cli, CUIL_cli, nombre_cli, apellido_cli, sexo_cli, nacionalidad_cli, fecha_nacimiento_cli, direccion_cli, localidad_cli, provincia_cli, correo_electronico_cli, telefono_cli, usuario_cli, contrasena_cli) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		private static final String delete = "UPDATE clientes SET estado_cli = 'baja' WHERE DNI_cli = ?";
		private static final String update = "UPDATE clientes SET  CUIL_cli = ?, nombre_cli = ?, apellido_cli = ?, sexo_cli = ?, nacionalidad_cli = ?, fecha_nacimiento_cli = ?, direccion_cli = ?, localidad_cli = ?, provincia_cli = ?, correo_electronico_cli = ?, telefono_cli = ?, usuario_cli = ?, contrasena_cli = ? WHERE DNI_cli = ?";
		private static final String list = "SELECT * FROM clientes WHERE estado_cli = 'alta'";
		private static final String find = "SELECT * FROM clientes WHERE DNI_cli = ? AND estado_cli = 'alta'";
		private static final String clienteFind = "SELECT * FROM clientes WHERE usuario_cli = ? AND contrasena_cli = ? AND estado_cli = 'alta'";
		private static final String userFind = "SELECT * FROM clientes WHERE usuario_cli = ? AND estado_cli = 'alta'";
		private static final String get = "SELECT * FROM clientes WHERE usuario_cli = ? AND estado_cli = 'alta'";
		private static final String dniGet = "SELECT * FROM clientes WHERE DNI_cli = ? AND estado_cli = 'alta'";

	@Override
	public boolean agregar(Cliente cliente) {
		
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
			statement.setString(1, cliente.getP().getDNI());
			statement.setString(2, cliente.getP().getCUIL());
			statement.setString(3, cliente.getP().getNombre());
			statement.setString(4, cliente.getP().getApellido());
			statement.setString(5, cliente.getP().getSexo());
			statement.setString(6, cliente.getP().getNacionalidad());
			statement.setString(7, cliente.getP().getFechaNacimiento());
			statement.setString(8, cliente.getP().getDirección());
			statement.setString(9, cliente.getP().getLocalidad());
			statement.setString(10, cliente.getP().getProvincia());
			statement.setString(11, cliente.getCorreo());
			statement.setString(12, cliente.getTeléfonos());
			statement.setString(13, cliente.getUsuario());
			statement.setString(14, cliente.getContrasena());
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
	public boolean eliminar(String Dni) {
		
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
			statement.setString(1, Dni);
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
	public boolean modificar(String dni, Cliente cliente) {
		
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
			statement.setString(1, cliente.getP().getCUIL());
			statement.setString(2, cliente.getP().getNombre());
			statement.setString(3, cliente.getP().getApellido());
			statement.setString(4, cliente.getP().getSexo());
			statement.setString(5, cliente.getP().getNacionalidad());
			statement.setString(6, cliente.getP().getFechaNacimiento());
			statement.setString(7, cliente.getP().getDirección());
			statement.setString(8, cliente.getP().getLocalidad());
			statement.setString(9, cliente.getP().getProvincia());
			statement.setString(10, cliente.getCorreo());
			statement.setString(11, cliente.getTeléfonos());
			statement.setString(12, cliente.getUsuario());
			statement.setString(13, cliente.getContrasena());
			statement.setString(14, dni);
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
	public boolean existe(String dni) {	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean encontroDni = false;
		try
		{
			statement = conexion.prepareStatement(find);
			statement.setString(1, dni);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				conexion.commit();
				encontroDni = true;
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
		System.out.println("valor de encontro cliente : " + encontroDni);
		return encontroDni;
	}

	@Override
	public List<Cliente> leerTodos() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(list);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Cliente cliente = new Cliente();
				Persona p = new Persona(
					resultSet.getString("DNI_cli"), 
					resultSet.getString("CUIL_cli"),
					resultSet.getString("nombre_cli"),
					resultSet.getString("apellido_cli"),
					resultSet.getString("sexo_cli"),
					resultSet.getString("nacionalidad_cli"),
					resultSet.getString("fecha_nacimiento_cli"),
					resultSet.getString("direccion_cli"),
					resultSet.getString("localidad_cli"),
					resultSet.getString("provincia_cli")
				); 
				cliente.setP(p);
				cliente.setCorreo(resultSet.getString("correo_electronico_cli"));
				cliente.setTeléfonos(resultSet.getString("telefono_cli"));
				cliente.setUsuario(resultSet.getString("usuario_cli"));
				cliente.setContrasena(resultSet.getString("contrasena_cli"));

				lista.add(cliente);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		conexion.cerrarConexion();
		return lista;
		
	}

	public boolean existeLogin(String usuario, String clave) {
		System.out.println("---ENTRAMOS A CLIENTE DAO IMPL---");
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
		boolean encontroCliente = false;
		try
		{
			statement = conexion.prepareStatement(clienteFind);
			statement.setString(1, usuario);
			statement.setString(2, clave);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				conexion.commit();
				encontroCliente = true;
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
		System.out.println("valor de encontro cliente : " + encontroCliente);
		return encontroCliente;
	}

	public Cliente get(String usuario) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		Cliente c = new Cliente();
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(get);
			statement.setString(1, usuario);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Persona p = new Persona(
					resultSet.getString("DNI_cli"), 
					resultSet.getString("CUIL_cli"),
					resultSet.getString("nombre_cli"),
					resultSet.getString("apellido_cli"),
					resultSet.getString("sexo_cli"),
					resultSet.getString("nacionalidad_cli"),
					resultSet.getString("fecha_nacimiento_cli"),
					resultSet.getString("direccion_cli"),
					resultSet.getString("localidad_cli"),
					resultSet.getString("provincia_cli")
				); 
				c.setP(p);
				c.setCorreo(resultSet.getString("correo_electronico_cli"));
				c.setTeléfonos(resultSet.getString("telefono_cli"));
				c.setUsuario(resultSet.getString("usuario_cli"));
				c.setContrasena(resultSet.getString("contrasena_cli"));
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
	public boolean existeUsuario(String usuario) {
		System.out.println("valor de usuario para encontrar usuario en modificar cliente: " + usuario);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean encontroCliente = false;
		try
		{
			statement = conexion.prepareStatement(userFind);
			statement.setString(1, usuario);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				conexion.commit();
				encontroCliente = true;
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
		System.out.println("valor de encontro cliente : " + encontroCliente);
		return encontroCliente;
	}

	@Override
	public Cliente getByDni(String dni) {
		System.out.println("ENTRANDO A GET BY DNI");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		PreparedStatement statement;
		Cliente c = new Cliente();
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(dniGet);
			statement.setString(1, dni);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Persona p = new Persona(
					resultSet.getString("DNI_cli"), 
					resultSet.getString("CUIL_cli"),
					resultSet.getString("nombre_cli"),
					resultSet.getString("apellido_cli"),
					resultSet.getString("sexo_cli"),
					resultSet.getString("nacionalidad_cli"),
					resultSet.getString("fecha_nacimiento_cli"),
					resultSet.getString("direccion_cli"),
					resultSet.getString("localidad_cli"),
					resultSet.getString("provincia_cli")
				); 
				c.setP(p);
				c.setCorreo(resultSet.getString("correo_electronico_cli"));
				c.setTeléfonos(resultSet.getString("telefono_cli"));
				c.setUsuario(resultSet.getString("usuario_cli"));
				c.setContrasena(resultSet.getString("contrasena_cli"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		conexion.cerrarConexion();
		return c;
	}
}
