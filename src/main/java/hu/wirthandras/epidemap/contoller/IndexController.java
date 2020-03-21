package hu.wirthandras.epidemap.contoller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hu.wirthandras.epidemap.domain.Disease;
import hu.wirthandras.epidemap.service.DiseaseService;

@Controller
public class IndexController {

	@Autowired
	public DiseaseService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/table")
	public String table(Model model) {
		model.addAttribute("diseases", service.getAll());
		return "table";
	}
	
	@GetMapping("/create")
	public String create(@ModelAttribute("newdisease") Disease d) {
		return "create";
	}
	
	@PostMapping("/create")
	public String newEmployeeSave(@Validated @ModelAttribute("newdisease") Disease newdisease, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "create";
		}

		service.save(newdisease);
		return "redirect:table";
	}
}
