package com.sistema.inventario.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepo;

	@GetMapping("/categories")
	public String categoriesList(Model model) {
		List<Category> categoriesList = categoryRepo.findAll();
		model.addAttribute("categoriesList", categoriesList);
		return "categories";
	}

	@GetMapping("/categories/add")
	public String seeCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		return "category_form";
	}

	@PostMapping("/categories/save")
	public String saveCategory(Category category) {
		categoryRepo.save(category);
		return "redirect:/categories";
	}

}
