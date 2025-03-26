package negocio;

public interface ReporteNegocio {
	public int contarCliente();
	public int contarCuenta();
	public int contarCuentaSaldo(float saldo);
	public int contarCuentaCliente(String dni);
	public float sumarSaldoCliente(String dni);
}
