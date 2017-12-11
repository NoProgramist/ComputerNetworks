package ua.edu.lnu.cns_webserver.controllers;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ua.edu.lnu.cns_webserver.model.Graph;
import ua.edu.lnu.cns_webserver.model.GraphWrapper;
import ua.edu.lnu.cns_webserver.model.Link;
import ua.edu.lnu.cns_webserver.model.Node;

@Controller
public class IndexController {

	@Autowired
	private ObjectMapper mapper;

	@GetMapping("/")
	public String index(Model model) {
		Node n1 = new Node(0, false);
		Node n2 = new Node(1, false);
		Node n3 = new Node(2, false);
		Link l1 = new Link(n1.getId(), n2.getId(), true, true, 1);
		Link l2 = new Link(n2.getId(), n3.getId(), false, true, 1);

		model.addAttribute("graph", new Graph(Arrays.asList(n1, n2, n3), Arrays.asList(l1, l2)));
		return "index";
	}

	@GetMapping("/action")
	public String action(Model model) {
		return index(model);
	}

	@PostMapping(path = "/action")
	public String action(Model model, @ModelAttribute GraphWrapper wrappedGraph) throws JsonParseException, JsonMappingException, IOException {
		model.addAttribute("graph", wrappedGraph.toGraph(mapper));
		return "index";
	}

}
