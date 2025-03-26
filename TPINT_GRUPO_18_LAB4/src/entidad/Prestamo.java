package entidad;

public class Prestamo {
	
	//atributos
	int idPrestamo;
	String DniClienteAsignado;
	String cbu;
	String fecha;
	String importeConIntereses;
	String importePedido;
	String cuotas;
	String montoXMes;
	String estado;
	
	//constructores
	public Prestamo() {
		super();
	}

	public Prestamo(int idPrestamo, String dniClienteAsignado, String cbu, String fecha, String importeConIntereses,
			String importePedido, String cuotas, String montoXMes, String estado) {
		super();
		this.idPrestamo = idPrestamo;
		DniClienteAsignado = dniClienteAsignado;
		this.cbu = cbu;
		this.fecha = fecha;
		this.importeConIntereses = importeConIntereses;
		this.importePedido = importePedido;
		this.cuotas = cuotas;
		this.montoXMes = montoXMes;
		this.estado = estado;
	}

	//getters y setters
	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	
	public String getDniClienteAsignado() {
		return DniClienteAsignado;
	}

	public void setDniClienteAsignado(String dniClienteAsignado) {
		DniClienteAsignado = dniClienteAsignado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getImporteConIntereses() {
		return importeConIntereses;
	}

	public void setImporteConIntereses(String importeConIntereses) {
		this.importeConIntereses = importeConIntereses;
	}

	public String getImportePedido() {
		return importePedido;
	}

	public void setImportePedido(String importePedido) {
		this.importePedido = importePedido;
	}

	public String getCuotas() {
		return cuotas;
	}

	public void setCuotas(String cuotas) {
		this.cuotas = cuotas;
	}

	public String getMontoXMes() {
		return montoXMes;
	}

	public void setMontoXMes(String montoXMes) {
		this.montoXMes = montoXMes;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}
	
	
}
