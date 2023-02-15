package com.sistema.inventario.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.inventario.category.Category;
import com.sistema.inventario.category.CategoryRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productrepo;

	@Autowired
	private CategoryRepository categoryrepo;

	@GetMapping("/products/add")
	public String seeProductForm(Model model) {
		List<Category> categoriesList = categoryrepo.findAll();
		model.addAttribute("product", new Product());
		model.addAttribute("categoriesList", categoriesList);
		return "product_form";
	}

	@PostMapping("/products/save")
	public String addProduct(Product product, HttpServletRequest request) {
		String[] detailsIDs = request.getParameterValues("detailsIDs");
		String[] detailsNames = request.getParameterValues("detailsNames");
		String[] detailsValues = request.getParameterValues("detailsValues");

		for (int i = 0; i < detailsNames.length; i++) {
			if (detailsIDs != null && detailsIDs.length > 0) {
				product.setDetails(Integer.valueOf(detailsIDs[i]), detailsNames[i], detailsValues[i]);
			} else {
				product.addDetails(detailsNames[i], detailsValues[i]);
			}
			;
		}

		productrepo.save(product);
		return "redirect:/products";

	}

	@GetMapping("/products")
	public String productsList(Model model) {
		List<Product> productsList = productrepo.findAll();
		model.addAttribute("productsList", productsList);
		return "products";
	}

	@GetMapping("/products/edit/{id}")
	public String seeFormEditProduct(@PathVariable("id") Integer id, Model model) {
		Product product = productrepo.findById(id).get();
		model.addAttribute("product", product);

		List<Category> categoriesList = categoryrepo.findAll();
		model.addAttribute("categoriesList", categoriesList);
		return "product_form";

	}

	@GetMapping("/products/delete/{id}")
	public String deletProduct(@PathVariable("id") Integer id, Model model) {
		productrepo.deleteById(id);
		return "redirect:/products";

	}

}
