package com.sistema.inventario.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class UserRepositoryTest {

	@Autowired
	private UserRepository repo;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	void testAddRoles() {
		Roles rolAdmin = new Roles("Admin");
		Roles rolSupervisor = new Roles("Supervisor");
		Roles rolVisit = new Roles("Visit");

		entityManager.persist(rolAdmin);
		entityManager.persist(rolSupervisor);
		entityManager.persist(rolVisit);

	}

	@Test
	void testAddOneRoleUser() {
		Roles roleAdmin = entityManager.find(Roles.class, 1);
		User user = new User("hh@gmail.com", "12345");

		user.addRole(roleAdmin);
		repo.save(user);
	}

	@Test
	void testAddTwoRoleUser() {
		Roles roleAdmin = entityManager.find(Roles.class, 1);
		Roles rolSupervisor = entityManager.find(Roles.class, 2);
		User user = new User("pp@gmail.com", "589658");

		user.addRole(roleAdmin);
		user.addRole(rolSupervisor);
		repo.save(user);
	}

	@Test
	void testAddRoleFromResgiterUser() {

		User user = repo.findById(1).get();
		Roles roleAdmin = entityManager.find(Roles.class, 3);
		user.addRole(roleAdmin);
		repo.save(user);
	}

	@Test
	void testRemoveRoleFromResgiterUser() {

		User user = repo.findById(3).get();
		Roles role = entityManager.find(Roles.class, 2);
		user.removeRole(role);

	}
}
