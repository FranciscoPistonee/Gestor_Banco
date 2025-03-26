package dao;

import java.util.ArrayList;
import java.util.List;
import entidad.Cliente;

public interface ClienteDao {
	public Cliente get(String usuario);
	public Cliente getByDni(String dni);
	public boolean agregar(Cliente cliente);
	public boolean eliminar(String Dni);
	public boolean modificar(String dni, Cliente datosNuevos);
	public boolean existe(String dni);
	public boolean existeUsuario(String usuario);
	public boolean existeLogin(String usuario, String contraseña);
	public List<Cliente> leerTodos();
}
