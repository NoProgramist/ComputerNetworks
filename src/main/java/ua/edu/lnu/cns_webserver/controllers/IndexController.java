package ua.edu.lnu.cns_webserver.controllers;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.edu.lnu.cns_webserver.model.Graph;
import ua.edu.lnu.cns_webserver.model.Link;
import ua.edu.lnu.cns_webserver.model.Node;
import ua.edu.lnu.cns_webserver.model.algorithms.traversal.TraversalAlgorithmParams;
import ua.edu.lnu.cns_webserver.model.algorithms.traversal.TraversalAlgorithmType;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index(Model model) {
		Node n1 = new Node(0, false);
		Node n2 = new Node(1, false);
		Node n3 = new Node(2, false);
		Link l1 = new Link(n1.getId(), n2.getId(), true, true, 1);
		Link l2 = new Link(n2.getId(), n3.getId(), false, true, 1);

		model.addAttribute("graph", new Graph(Arrays.asList(n1, n2, n3), Arrays.asList(l1, l2)));

		TraversalAlgorithmParams p = new TraversalAlgorithmParams(0, TraversalAlgorithmType.BFS);
		model.addAttribute("traversalAlgorithmParameters", p);
		return "index";
	}

}
