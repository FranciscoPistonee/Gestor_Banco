package dao;

import java.util.List;
import entidad.Movimiento;

public interface MovimientoDao {
	public List<Movimiento> leerCuotas(String cbu);
	public boolean agregar(Movimiento movimiento);
}
