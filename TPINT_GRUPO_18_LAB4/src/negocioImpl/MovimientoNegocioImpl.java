package negocioImpl;

import java.util.List;

import dao.MovimientoDao;
import daoImpl.MovimientoDaoImpl;
import entidad.Movimiento;
import negocio.MovimientoNegocio;

public class MovimientoNegocioImpl implements MovimientoNegocio {

	MovimientoDao mDao = new MovimientoDaoImpl();
	
	public boolean agregar(Movimiento movimiento) {
		boolean estado;
		estado = mDao.agregar(movimiento);
		return estado;
	}

	@Override
	public List<Movimiento> leerCuotas(String cbu) {
		return mDao.leerCuotas(cbu);
	}

}
