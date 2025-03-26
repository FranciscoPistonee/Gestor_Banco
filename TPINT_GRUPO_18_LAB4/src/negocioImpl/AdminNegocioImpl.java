package negocioImpl;

import dao.AdminDao;
import daoImpl.AdminDaoImpl;
import entidad.Admin;
import negocio.AdminNegocio;

public class AdminNegocioImpl implements AdminNegocio {

	AdminDao aDao = new AdminDaoImpl();
	public boolean existe(String usuario, String clave) {
		System.out.println("---ENTRAMOS A ADMIN NEGOCIO IMPL---");
		boolean estado = false;
		estado = aDao.existe(usuario, clave);
		return estado;
	}

}
