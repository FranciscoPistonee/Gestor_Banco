package negocio;

import java.util.List;
import entidad.Movimiento;

public interface MovimientoNegocio {
	public List<Movimiento> leerCuotas(String cbu);
	public boolean agregar(Movimiento movimiento);
}
