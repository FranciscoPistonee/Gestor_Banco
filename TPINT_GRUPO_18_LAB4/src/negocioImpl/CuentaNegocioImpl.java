package negocioImpl;

import java.util.List;

import dao.CuentaDao;
import daoImpl.CuentaDaoImpl;
import entidad.Cuenta;
import negocio.CuentaNegocio;

public class CuentaNegocioImpl implements CuentaNegocio {
	
	//objeto de cuenta para llamar a dao
	CuentaDao cDao = new CuentaDaoImpl();
	Cuenta c = new Cuenta();

	@Override
	public boolean agregar(Cuenta cuenta) {
		
		boolean estado = false;
		estado = cDao.agregar(cuenta);
		return estado;
	}

	@Override
	public boolean eliminar(String cbuCuenta) {
		
		boolean estado = false;
		estado = cDao.eliminar(cbuCuenta);
		return estado;
		
	}

	@Override
	public boolean modificar(String cbu, Cuenta datosNuevos) {

		boolean estado = false;
		estado = cDao.modificar(cbu, datosNuevos);
		return estado;
		
	}

	@Override
	public boolean existe(String numeroCuenta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cuenta> leerTodos() {
		return cDao.leerTodos();
	}

	@Override
	public boolean verificarCuentas(String dniCliente) {
		
		boolean estado = false;
		estado = cDao.verificarCuentas(dniCliente);
		return estado;
	}
	
	@Override
	public float buscarSaldo(String cbu) {
		float saldo;
		saldo = cDao.buscarSaldo(cbu);
		return saldo;
	}

	@Override
	public boolean actualizarSaldo(String saldo, String cbu) {
		boolean estado;
		estado = cDao.actualizarSaldo(saldo, cbu);
		return estado;
	}

	@Override
	public boolean coincideCbu(String cbu, String usuario) {
		boolean estado;
		estado = cDao.coincideCbu(cbu, usuario);
		return estado;
	}

	@Override
	public boolean existeCbu(String cbu) {
		boolean estado;
		estado = cDao.existeCbu(cbu);
		return estado;
	}

	@Override
	public Cuenta get(String cbu) {
		c = cDao.get(cbu);
		return c;
	}

	@Override
	public boolean eliminarDni(String dni) {
		boolean estado = false;
		estado = cDao.eliminarDni(dni);
		return estado;
	}

}
