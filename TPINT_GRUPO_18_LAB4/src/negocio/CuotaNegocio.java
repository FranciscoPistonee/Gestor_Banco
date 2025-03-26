package negocio;

import java.util.List;
import entidad.Cuota;

public interface CuotaNegocio {
	public List<Cuota> leerCuotas(String dni);
	public boolean eliminar(int id);
}
