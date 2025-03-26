package dao;

public interface ReporteDao {
	public int contarCuenta();
	public int contarCliente();
	public int contarCuentaSaldo(float saldo);
	public int contarCuentaCliente(String dni);
	public float sumarSaldoCliente(String dni);
}
