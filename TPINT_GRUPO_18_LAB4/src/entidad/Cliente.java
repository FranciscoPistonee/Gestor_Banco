package entidad;

public class Cliente {
	
	//atributos
	private Persona p;
	String correo; 			 
	String tel�fonos; 
	String usuario; 
	String contrasena;
	
	public Cliente(Persona p, String correo, String tel�fonos, String usuario, String contrasena) {
		super();
		this.p = p;
		this.correo = correo;
		this.tel�fonos = tel�fonos;
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
	public String getTel�fonos() {
		return tel�fonos;
	}
	public void setTel�fonos(String tel�fonos) {
		this.tel�fonos = tel�fonos;
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
