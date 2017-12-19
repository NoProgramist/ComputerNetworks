package ua.edu.lnu.cns_webserver.controllers;

import org.la4j.Matrix;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ua.edu.lnu.cns_webserver.converters.AdjMatToGraphConverter;
import ua.edu.lnu.cns_webserver.model.Graph;
import ua.edu.lnu.cns_webserver.model.algorithms.distance.DistanceAlgorithmParams;
import ua.edu.lnu.cns_webserver.model.algorithms.distance.DistanceAlgorithmType;
import ua.edu.lnu.cns_webserver.model.algorithms.traversal.TraversalAlgorithmParams;
import ua.edu.lnu.cns_webserver.model.algorithms.traversal.TraversalAlgorithmType;
import ua.edu.lnu.computer_networks.algorithms.carcass.distance.DistanceCarcassSearch;
import ua.edu.lnu.computer_networks.algorithms.carcass.distance.DistanceCarcassSearchResult;
import ua.edu.lnu.computer_networks.algorithms.carcass.distance.bellman_ford.BellmanFordCarcassSearchImpl;
import ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra.DijkstraCarcassSearchImpl;
import ua.edu.lnu.computer_networks.algorithms.carcass.traversal.TraversalCarcassSearch;
import ua.edu.lnu.computer_networks.algorithms.carcass.traversal.TraversalCarcassSearchResult;
import ua.edu.lnu.computer_networks.algorithms.carcass.traversal.bfs.BFSCarcassSearch;
import ua.edu.lnu.computer_networks.algorithms.carcass.traversal.dfs.DFSCarcassSearch;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraphUtils;

@RestController
public class AlgorithmController {

	@PostMapping(path = "/algorithm/traversal")
	public Graph doTraversalAlgorithm(@RequestBody TraversalAlgorithmParams params) {
		SimpleGraphUtils utils = new SimpleGraphUtils(Double.MAX_VALUE / 2);
		AdjMatToGraphConverter converter = new AdjMatToGraphConverter(utils);
		Matrix adjacencyMatrix = converter.convert(new Graph(params.getNodes(), params.getLinks()));
		TraversalCarcassSearch searcher = TraversalAlgorithmType.BFS.equals(params.getType()) ? new BFSCarcassSearch(utils) : new DFSCarcassSearch(utils);
		TraversalCarcassSearchResult result = searcher.findCarcass(params.getRoot(), adjacencyMatrix);
		Graph graph = converter.convert(utils.buildAdjacencyMatrix(result.getGraph()));
		graph.setVertexes(params.getNodes());
		return graph;
	}

	@PostMapping(path = "/algorithm/distance")
	public Graph doDijkstraAlgorithm(@RequestBody DistanceAlgorithmParams params) {
		SimpleGraphUtils utils = new SimpleGraphUtils(Double.MAX_VALUE / 2);
		AdjMatToGraphConverter converter = new AdjMatToGraphConverter(utils);
		Matrix adjacencyMatrix = converter.convert(new Graph(params.getNodes(), params.getLinks()));
		DistanceCarcassSearch searcher = DistanceAlgorithmType.DIJKSTRA.equals(params.getType()) ? new DijkstraCarcassSearchImpl(utils)
				: new BellmanFordCarcassSearchImpl(utils);
		DistanceCarcassSearchResult result = searcher.findCarcass(params.getRoot(), adjacencyMatrix);
		Graph graph = converter.convert(utils.buildAdjacencyMatrix(result.getGraph()));
		graph.setVertexes(params.getNodes());
		return graph;
	}
}
