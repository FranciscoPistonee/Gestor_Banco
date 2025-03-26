package entidad;

public class Movimiento {
	//atributos
	private String fecha;
	private String detalle;
	private String importe;
	private TipoMovimiento tipoMovimiento;
	private String cbu;
	
	//constructores
	

	public Movimiento() {
		super();
	}

	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Movimiento(String fecha, String detalle, String importe, TipoMovimiento tipoMovimiento, String cbu) {
		super();
		this.fecha = fecha;
		this.detalle = detalle;
		this.importe = importe;
		this.tipoMovimiento = tipoMovimiento;
		this.cbu = cbu;
	}

	//getters and setters
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	
}
