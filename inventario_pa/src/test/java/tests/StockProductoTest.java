
package tests;

import com.tecno_comfenalco.models.Movimiento;
import com.tecno_comfenalco.models.Producto;
import com.tecno_comfenalco.models.Usuario;
import com.tecno_comfenalco.models.Movimiento.TipoMovimiento;
import com.tecno_comfenalco.services.HistorialMovimientos;
import com.tecno_comfenalco.services.StockProducto;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;


public class StockProductoTest {

	private StockProducto stockProducto;
	private Producto testProduct;
	private HistorialMovimientos historialMovimientos;
	private Usuario testUsuario;

	private Movimiento testMovimientoEntrada;
	private Movimiento testMovimientoSalida;


	@Before
	public void setUp() {
		stockProducto = new StockProducto();
		historialMovimientos = HistorialMovimientos.getInstance();
		testProduct = new Producto("1", "Test Product", 0);

		testMovimientoEntrada =
				new Movimiento(testProduct, 10, new Date(), TipoMovimiento.ENTRADA, testUsuario, "Test");

		testMovimientoSalida =
				new Movimiento(testProduct, 10, new Date(), TipoMovimiento.SALIDA, testUsuario, "Test");
	}

	@Test
	public void testStockCalculationWithEntries() {
		historialMovimientos.añadirMovimiento(testMovimientoEntrada);
		historialMovimientos.añadirMovimiento(testMovimientoEntrada);

		int stock = stockProducto.getStock(testProduct);
		assertEquals(20, stock);
	}

	@Test
	public void testStockCalculationWithExits() {
		historialMovimientos.añadirMovimiento(testMovimientoSalida);
		historialMovimientos.añadirMovimiento(testMovimientoSalida);

		int stock = stockProducto.getStock(testProduct);
		assertEquals(-20, stock);
	}

	@Test
	public void testStockCalculationWithEntriesAndExits() {
		historialMovimientos.añadirMovimiento(testMovimientoEntrada);
		historialMovimientos.añadirMovimiento(testMovimientoSalida);
		historialMovimientos.añadirMovimiento(testMovimientoEntrada);
		historialMovimientos.añadirMovimiento(testMovimientoSalida);

		int stock = stockProducto.getStock(testProduct);
		assertEquals(0, stock);
	}

	@Test
	public void testStockCalculationWithNoMovements() {
		int stock = stockProducto.getStock(testProduct);
		assertEquals(0, stock);
	}

	@Test
	public void testProductNotFound() {
		Producto anotherProduct = new Producto("2", "Another Product", 0);
		historialMovimientos.añadirMovimiento(new Movimiento(anotherProduct, 10, new Date(),
				TipoMovimiento.ENTRADA, testUsuario, "Test"));
		int stock = stockProducto.getStock(testProduct);
		assertEquals(0, stock);
	}
}
