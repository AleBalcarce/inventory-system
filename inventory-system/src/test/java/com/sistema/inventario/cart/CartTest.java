package com.sistema.inventario.cart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sistema.inventario.products.Product;
import com.sistema.inventario.user.User;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class CartTest {
	
	@Autowired
	private CartRepository cartRepository;

	
	@Autowired
	private TestEntityManager entityManager;
	
	
	@Test
	void testAddProductToCart() {
		Product product1 = entityManager.find(Product.class,1);
		User user = entityManager.find(User.class,1);
		Cart cart1 = new Cart(4, product1, user );
		cartRepository.save(cart1);
	}
	
	
	@Test
	void testAddProductsToCart() {
		Product product1 = entityManager.find(Product.class,1);
		Product product2 = entityManager.find(Product.class,2);
		User user = entityManager.find(User.class,2);
		Cart cart2 = new Cart(1, product1, user );
		Cart cart1 = new Cart(4, product2, user );
		cartRepository.saveAll(List.of(cart1, cart2));
	}
	
	

}
