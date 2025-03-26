package entidad;

public class Persona {
	
	String DNI;         	     
	String CUIL; 			 
	String nombre;	  	   	 
	String apellido;	 	 
	String sexo;			 
	String nacionalidad;	 
	String fechaNacimiento;  
	String dirección; 		 
	String localidad;		 
	String provincia;
	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Persona(String dNI, String cUIL, String nombre, String apellido, String sexo, String nacionalidad,
			String fechaNacimiento, String dirección, String localidad, String provincia) {
		super();
		DNI = dNI;
		CUIL = cUIL;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.dirección = dirección;
		this.localidad = localidad;
		this.provincia = provincia;
	}
	
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getCUIL() {
		return CUIL;
	}
	public void setCUIL(String cUIL) {
		CUIL = cUIL;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDirección() {
		return dirección;
	}
	public void setDirección(String dirección) {
		this.dirección = dirección;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	} 
	
	
}
