package negocio;

import entidad.Admin;

public interface AdminNegocio {
	public boolean existe(String usuario, String clave);
}
