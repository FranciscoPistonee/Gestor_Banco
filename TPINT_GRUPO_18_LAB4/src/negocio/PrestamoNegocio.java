package negocio;

import java.util.List;
import entidad.Prestamo;

public interface PrestamoNegocio {
	public List<Prestamo> leerTodos();
	public Prestamo get(int id);
	public boolean agregar(Prestamo prestamo);
	public boolean agregarCuotas (Prestamo prestamo);
	public boolean coincideCbu (String cbu, String usuario);
	public boolean Autorizar (String autorizacion, int id);
	public String buscarDni (String cuenta);
}
