
package tests;

import com.tecno_comfenalco.models.Movimiento;
import com.tecno_comfenalco.models.Producto;
import com.tecno_comfenalco.models.Usuario;
import com.tecno_comfenalco.models.Movimiento.TipoMovimiento;
import com.tecno_comfenalco.models.Usuario.Role;
import com.tecno_comfenalco.services.HistorialMovimientos;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;

public class HistorialMovimientosTest {

	private HistorialMovimientos historialMovimientos;
	private Producto anotherProduct;
	private Usuario testUsuario;

	@Before
	public void setUp() {
		anotherProduct = new Producto("1", "Test Product", 0);
		testUsuario = new Usuario("admin", "admin", Role.ADMINISTRADOR);

		historialMovimientos = HistorialMovimientos.getInstance();
		historialMovimientos.getMovimientos().clear(); // Clear any existing movements
	}

	@Test
	public void testSingletonInstance() {
		HistorialMovimientos instance1 = HistorialMovimientos.getInstance();
		HistorialMovimientos instance2 = HistorialMovimientos.getInstance();
		assertSame(instance1, instance2);
	}

	@Test
	public void testAddSingleMovement() {
		Movimiento movimiento =
				new Movimiento(anotherProduct, 10, new Date(), TipoMovimiento.ENTRADA, testUsuario, "Test");

		assertEquals(1, historialMovimientos.getMovimientos().size());
		assertEquals(movimiento, historialMovimientos.getMovimientos().get(0));
	}

	@Test
	public void testAddMultipleMovements() {
		Movimiento movimiento1 =
				new Movimiento(anotherProduct, 10, new Date(), TipoMovimiento.ENTRADA, testUsuario, "Test");
		Movimiento movimiento2 =
				new Movimiento(anotherProduct, 5, new Date(), TipoMovimiento.ENTRADA, testUsuario, "Test");

		historialMovimientos.añadirMovimiento(movimiento1);
		historialMovimientos.añadirMovimiento(movimiento2);
		assertEquals(2, historialMovimientos.getMovimientos().size());
		assertEquals(movimiento1, historialMovimientos.getMovimientos().get(0));
		assertEquals(movimiento2, historialMovimientos.getMovimientos().get(1));
	}

	@Test
	public void testGetMovimientos() {
		Movimiento movimiento =
				new Movimiento(anotherProduct, 10, new Date(), TipoMovimiento.ENTRADA, testUsuario, "Test");
		historialMovimientos.añadirMovimiento(movimiento);
		assertEquals(1, historialMovimientos.getMovimientos().size());
		assertEquals(movimiento, historialMovimientos.getMovimientos().get(0));
	}
}
