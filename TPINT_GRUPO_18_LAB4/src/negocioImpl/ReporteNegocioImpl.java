package negocioImpl;

import dao.ReporteDao;
import daoImpl.ReporteDaoImpl;
import negocio.ReporteNegocio;

public class ReporteNegocioImpl implements ReporteNegocio {

	ReporteDao rDao = new ReporteDaoImpl();
	
	public int contarCuenta() {
		return rDao.contarCuenta();
	}

	public int contarCuentaSaldo(float saldo) {
		return rDao.contarCuentaSaldo(saldo);
	}

	@Override
	public int contarCuentaCliente(String dni) {
		return rDao.contarCuentaCliente(dni);
	}

	@Override
	public float sumarSaldoCliente(String dni) {
		return rDao.sumarSaldoCliente(dni);
	}

	@Override
	public int contarCliente() {
		return rDao.contarCliente();
	}

}
