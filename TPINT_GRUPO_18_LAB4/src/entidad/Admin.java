package entidad;

public class Admin {
	
	String usuario;
	String contrase�a;
	
	public Admin() {
		
	}
	
	public Admin(String usuario, String contrase�a) {
		super();
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	
}
