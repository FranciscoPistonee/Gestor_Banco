package entidad;

public class Cuenta {
	
	//Atributos:
	String DniClienteAsignado;
	String tipoCuenta;
	String FechaCreacion;
	String numCuenta;
	String CBU;
	String saldo;
	
	//constructores
	public Cuenta() {

	}

	public Cuenta(String tipoCuenta, String fechaCreacion, String numCuenta, String cBU, String saldo) {
		this.tipoCuenta = tipoCuenta;
		this.FechaCreacion = fechaCreacion;
		this.numCuenta = numCuenta;
		this.CBU = cBU;
		this.saldo = saldo;
	}

	//getters y setters
	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getFechaCreacion() {
		return FechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		FechaCreacion = fechaCreacion;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getCBU() {
		return CBU;
	}

	public void setCBU(String cBU) {
		CBU = cBU;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getDniClienteAsignado() {
		return DniClienteAsignado;
	}

	public void setDniClienteAsignado(String dniClienteAsignado) {
		DniClienteAsignado = dniClienteAsignado;
	}
	
}
