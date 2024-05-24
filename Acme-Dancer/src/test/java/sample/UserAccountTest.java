
package sample;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import security.Authority;
import security.UserAccount;
import services.UserAccountService;
import utilities.AbstractTest;

@ContextConfiguration(locations = {
	"classpath:spring/junit.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserAccountTest extends AbstractTest {

	@Autowired
	private UserAccountService userService;


	@Test
	public void testSaveUser() {
		final UserAccount user = new UserAccount();
		final Authority authority = new Authority();
		final Collection<Authority> authorities = new ArrayList<Authority>();
		authority.setAuthority("ALUMNO");
		authorities.add(authority);

		user.setUsername("alumno2");
		user.setPassword("alumno2");
		user.setAuthorities(authorities);

		final UserAccount saved = this.userService.save(user);

		final Collection<UserAccount> actores = this.userService.findAll();
		Assert.isTrue(actores.contains(saved));

	}
}
