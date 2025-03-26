package negocioImpl;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;
import daoImpl.ClienteDaoImpl;
import entidad.Cliente;
import negocio.ClienteNegocio;

public class ClienteNegocioImpl implements ClienteNegocio {

	//objeto de cuenta para llamar a dao
	ClienteDao cDao = new ClienteDaoImpl();
	Cliente c = new Cliente();
	
	@Override
	public boolean agregar(Cliente cliente) {
		
		boolean estado = false;
		estado = cDao.agregar(cliente);
		return estado;
		
	}

	@Override
	public boolean eliminar(String dni) {
		
		boolean estado = false;
		estado = cDao.eliminar(dni);
		return estado;
	}

	@Override
	public boolean modificar(String dni, Cliente datosNuevos) {
		
		boolean estado = false;
		estado = cDao.modificar(dni, datosNuevos);
		return estado;
		
	}

	@Override
	public boolean existe(String dni) {
		
		boolean estado = false;
		estado = cDao.existe(dni);
		return estado;
		
	}

	@Override
	public List<Cliente> leerTodos() {
		return cDao.leerTodos();
	}

	@Override
	public boolean existeLogin(String usuario, String contraseña) {
		System.out.println("---ENTRAMOS A CLIENTE NEGOCIO IMPL---");
		boolean estado = false;
		estado = cDao.existeLogin(usuario, contraseña);
		return estado;
	}

	@Override
	public Cliente get(String usuario) {
		c = cDao.get(usuario);
		return c;
	}

	@Override
	public boolean existeUsuario(String usuario) {
		boolean estado = false;
		estado = cDao.existeUsuario(usuario);
		return estado;
	}

	@Override
	public Cliente getByDni(String dni) {
		c = cDao.getByDni(dni);
		return c;
	}

}
