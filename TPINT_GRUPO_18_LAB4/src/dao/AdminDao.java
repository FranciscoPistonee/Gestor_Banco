package dao;

import entidad.Admin;

public interface AdminDao {
	public boolean existe(String usuario, String clave);
}
