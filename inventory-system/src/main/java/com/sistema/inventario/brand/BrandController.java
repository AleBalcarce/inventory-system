package com.sistema.inventario.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.inventario.category.Category;
import com.sistema.inventario.category.CategoryRepository;
import com.sistema.inventario.products.Product;

@Controller
public class BrandController {

	@Autowired
	private BrandRepository brandRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@GetMapping("/brands/add")
	public String seeFormAddBrand(Model model) {
		List<Category> categoriesList = categoryRepo.findAll();
		model.addAttribute("categoriesList", categoriesList);
		model.addAttribute("brand", new Brand());
		return "brand_form";

	}

	@PostMapping("/brands/save")
	public String addBrand(Brand brand) {
		brandRepo.save(brand);
		return "redirect:/";

	}

	@GetMapping("/brands")
	public String brandsList(Model model) {
		List<Brand> brandsList = brandRepo.findAll();
		model.addAttribute("brandsList", brandsList);
		return "brands";
	}

	@GetMapping("/brands/edit/{id}")
	public String seeFormEditBrand(@PathVariable("id") Integer id, Model model) {
		Brand brand = brandRepo.findById(id).get();
		List<Category> categoriesList = categoryRepo.findAll();

		model.addAttribute("categoriesList", categoriesList);
		model.addAttribute("brand", brand);
		return "brand_form";

	}

	@GetMapping("/brands/delete/{id}")
	public String deletbrand(@PathVariable("id") Integer id, Model model) {
		brandRepo.deleteById(id);
		return "redirect:/brands";

	}
}
