package com.sistema.inventario.category;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repo;

	@Test
	public void AddCategorytest() {
		Category savedCategory = repo.save(new Category("Personal Care"));
		assertThat(savedCategory.getId()).isGreaterThan(0);
	}

}
