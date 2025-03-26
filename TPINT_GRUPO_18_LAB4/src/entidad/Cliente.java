package entidad;

public class Cliente {
	
	//atributos
	private Persona p;
	String correo; 			 
	String teléfonos; 
	String usuario; 
	String contrasena;
	
	public Cliente(Persona p, String correo, String teléfonos, String usuario, String contrasena) {
		super();
		this.p = p;
		this.correo = correo;
		this.teléfonos = teléfonos;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	public Cliente() {
		super();
	}
	public Persona getP() {
		return p;
	}
	public void setP(Persona p) {
		this.p = p;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTeléfonos() {
		return teléfonos;
	}
	public void setTeléfonos(String teléfonos) {
		this.teléfonos = teléfonos;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	

}
