package negocioImpl;

import java.util.List;

import dao.PrestamoDao;
import daoImpl.PrestamoDaoImpl;
import entidad.Prestamo;
import negocio.PrestamoNegocio;

public class PrestamoNegocioImpl implements PrestamoNegocio {
	
	PrestamoDao pDao = new PrestamoDaoImpl();
	
	public List<Prestamo> leerTodos() {
		return pDao.leerTodos();
	}

	public boolean agregar(Prestamo prestamo) {
		boolean estado;
		estado = pDao.agregar(prestamo);
		return estado;
	}

	public boolean coincideCbu(String cbu, String usuario) {
		boolean estado;
		estado = pDao.coincideCbu(cbu, usuario);
		return estado;
	}

	public String buscarDni(String cuenta) {
		String dniCliente;
		dniCliente = pDao.buscarDni(cuenta);
		return dniCliente;
	}

	@Override
	public boolean Autorizar(String autorizacion, int id) {
		boolean estado;
		estado = pDao.Autorizar(autorizacion, id);
		return estado;
	}

	@Override
	public Prestamo get(int id) {
		Prestamo p = new Prestamo();
		p = pDao.get(id);
		return p;
	}

	@Override
	public boolean agregarCuotas(Prestamo prestamo) {
		boolean estado;
		estado = pDao.agregarCuotas(prestamo);
		return estado;
	}

}
