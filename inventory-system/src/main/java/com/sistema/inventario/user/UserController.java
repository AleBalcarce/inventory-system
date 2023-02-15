package com.sistema.inventario.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.inventario.category.Category;
import com.sistema.inventario.products.Product;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RolesRepository rolRepo;

	@GetMapping("/users")
	public String usersList(Model model) {
		List<User> usersList = userRepo.findAll();
		model.addAttribute("usersList", usersList);
		return "users";
	}

	@GetMapping("/users/add")
	public String seeUserForm(Model model) {
		List<Roles> rolesList = rolRepo.findAll();
		model.addAttribute("rolesList", rolesList);
		model.addAttribute("user", new User());
		return "user_form";
	}

	@PostMapping("/users/save")
	public String saveUser(User user) {
		userRepo.save(user);
		return "redirect:/users";
	}

	@GetMapping("/users/edit/{id}")
	public String seeFormEditUser(@PathVariable("id") Integer id, Model model) {
		User user = userRepo.findById(id).get();
		model.addAttribute("user", user);

		List<Roles> rolesList = rolRepo.findAll();
		model.addAttribute("rolesList", rolesList);
		return "user_form";

	}

	@GetMapping("/users/delete/{id}")
	public String deletUser(@PathVariable("id") Integer id, Model model) {
		userRepo.deleteById(id);
		return "redirect:/users";

	}

}
