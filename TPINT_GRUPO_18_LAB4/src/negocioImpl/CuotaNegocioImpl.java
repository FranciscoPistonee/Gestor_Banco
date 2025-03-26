package negocioImpl;

import java.util.List;

import dao.CuotaDao;
import daoImpl.CuotaDaoImpl;
import entidad.Cuota;
import negocio.CuotaNegocio;

public class CuotaNegocioImpl implements CuotaNegocio {

	CuotaDao cDao = new CuotaDaoImpl();
	
	@Override
	public List<Cuota> leerCuotas(String dni) {
		return cDao.leerCuotas(dni);
	}

	@Override
	public boolean eliminar(int id) {
		boolean estado;
		estado = cDao.eliminar(id);
		return estado;
	}

}
