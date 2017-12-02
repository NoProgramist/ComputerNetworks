package ua.edu.lnu.cns_webserver.controllers;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.edu.lnu.cns_webserver.model.Link;
import ua.edu.lnu.cns_webserver.model.Node;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index(Model model) {
		Node n1 = new Node(0L, false);
		Node n2 = new Node(1L, false);
		Node n3 = new Node(2L, false);
		Link l1 = new Link(n1.getId(), n2.getId(), true, true);
		Link l2 = new Link(n2.getId(), n3.getId(), false, true);
		model.addAttribute("nodes", Arrays.asList(n1, n2, n3));
		model.addAttribute("links", Arrays.asList(l1, l2));
		return "index";
	}
}
