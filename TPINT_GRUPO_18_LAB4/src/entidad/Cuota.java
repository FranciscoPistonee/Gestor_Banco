package entidad;

public class Cuota {
	//atributos
	int idCuota;
	int idPrestamo;
	String nombreCliente;
	String apellidoCliente;
	String dniCliente;
	String cbuCliente;
	String fecha;
	String importeIntereses;
	String cuotas;
	String montoCuota;
	
	//constructores
	public Cuota() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cuota( int idCuota,int idPrestamo, String nombreCliente, String apellidoCliente, String dniCliente, String cbuCliente,
			String fecha, String importeIntereses, String cuotas, String montoCuota) {
		super();
		this.idCuota = idCuota;
		this.idPrestamo = idPrestamo;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.dniCliente = dniCliente;
		this.cbuCliente = cbuCliente;
		this.fecha = fecha;
		this.importeIntereses = importeIntereses;
		this.cuotas = cuotas;
		this.montoCuota = montoCuota;
	}
	
	//getters and setters
	public int getIdCuota() {
		return idCuota;
	}
	public void setIdCuota(int idCuota) {
		this.idCuota = idCuota;
	}
	public int getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	public String getCbuCliente() {
		return cbuCliente;
	}
	public void setCbuCliente(String cbuCliente) {
		this.cbuCliente = cbuCliente;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getImporteIntereses() {
		return importeIntereses;
	}
	public void setImporteIntereses(String importeIntereses) {
		this.importeIntereses = importeIntereses;
	}
	public String getCuotas() {
		return cuotas;
	}
	public void setCuotas(String cuotas) {
		this.cuotas = cuotas;
	}
	public String getMontoCuota() {
		return montoCuota;
	}
	public void setMontoCuota(String montoCuota) {
		this.montoCuota = montoCuota;
	}
	
	
}
