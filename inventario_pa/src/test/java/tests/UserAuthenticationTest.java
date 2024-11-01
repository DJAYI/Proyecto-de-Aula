
package tests;

import com.tecno_comfenalco.auth.UserAuthentication;
import com.tecno_comfenalco.models.Usuario;
import com.tecno_comfenalco.models.Usuario.Role;
import com.tecno_comfenalco.utils.listas.ListaUsuarios;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class UserAuthenticationTest {

	private UserAuthentication userAuth;
	private Usuario testUser;


	@Before
	public void setUp() {
		testUser = new Usuario("testUser", "testPass", Role.ADMINISTRADOR);

		userAuth = UserAuthentication.getInstance();
		ListaUsuarios.getInstance().getUsuarios().add(testUser);
	}

	@Test
	public void testLoginSuccess() {
		boolean result = userAuth.login("testUser", "testPass", Role.ADMINISTRADOR.toString());
		assertTrue(result);
		assertTrue(userAuth.isLogged);
	}

	@Test
	public void testLoginFailure() {
		boolean result = userAuth.login("wrongUser", "wrongPass", "wrongRole");
		assertFalse(result);
		assertFalse(userAuth.isLogged);
	}

	@Test
	public void testLogout() {
		userAuth.login("testUser", "testPass", "testRole");
		userAuth.logout();
		assertFalse(userAuth.isLogged);
	}
}
