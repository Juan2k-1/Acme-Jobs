
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import security.UserAccount;
import security.UserAccountRepository;

@Service
@Transactional
public class UserAccountService {

	@Autowired
	private UserAccountRepository userRepository;


	public UserAccount save(final UserAccount user) {
		Assert.notNull(user);

		UserAccount userAccount;

		// Verificar si ya existe un usuario con el mismo nombre de usuario
		final UserAccount existingUser = this.userRepository.findByUsername(user.getUsername());
		Assert.isNull(existingUser, "Ya existe un usuario con el mismo nombre de usuario");

		userAccount = this.userRepository.save(user);

		return userAccount;
	}

	public Collection<UserAccount> findAll() {
		Collection<UserAccount> result;
		result = this.userRepository.findAll();
		return result;
	}

	public void flush() {
		this.userRepository.flush();
	}
}
