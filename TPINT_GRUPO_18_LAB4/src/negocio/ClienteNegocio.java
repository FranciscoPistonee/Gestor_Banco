package negocio;

import java.util.ArrayList;
import java.util.List;
import entidad.Cliente;

public interface ClienteNegocio {
	public Cliente get(String usuario);
	public Cliente getByDni(String dni);
	public boolean agregar(Cliente cliente);
	public boolean eliminar(String dni);
	public boolean modificar(String dni, Cliente datosNuevos);
	public boolean existe(String dni);
	public List<Cliente> leerTodos();
	public boolean existeLogin(String usuario, String contraseña);
	public boolean existeUsuario(String usuario);
}
