package negocio;

import java.util.List;
import entidad.Cuenta;

public interface CuentaNegocio {
	public boolean agregar(Cuenta cuenta);
	public boolean eliminar(String cbuCuenta);
	public boolean eliminarDni (String dni);
	public boolean modificar(String cbu, Cuenta datosNuevos);
	public boolean existe(String numeroCuenta);
	public boolean verificarCuentas (String dniCliente);
	public List<Cuenta> leerTodos();
	public float buscarSaldo (String cbu);
	public boolean actualizarSaldo (String saldo, String cbu);
	public boolean coincideCbu (String cbu, String usuario);
	public boolean existeCbu (String cbu);
	public Cuenta get (String cbu);
}
