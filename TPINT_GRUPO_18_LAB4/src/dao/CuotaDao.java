package dao;

import java.util.List;
import entidad.Cuota;


public interface CuotaDao {
	public List<Cuota> leerCuotas(String dni);
	public boolean eliminar(int id);
	
}
