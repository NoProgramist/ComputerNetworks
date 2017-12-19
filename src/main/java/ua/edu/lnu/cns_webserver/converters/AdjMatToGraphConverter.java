package ua.edu.lnu.cns_webserver.converters;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.la4j.Matrix;
import org.springframework.core.convert.converter.Converter;

import ua.edu.lnu.cns_webserver.model.Graph;
import ua.edu.lnu.cns_webserver.model.Link;
import ua.edu.lnu.cns_webserver.model.Node;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraphUtils;

public class AdjMatToGraphConverter implements Converter<Graph, Matrix> {

	private SimpleGraphUtils graphUtils;

	public AdjMatToGraphConverter(SimpleGraphUtils graphUtils) {
		this.graphUtils = graphUtils;
	}

	@Override
	public Matrix convert(Graph graph) {
		fixIds(graph);
		return buildMatrix(graph);
	}

	public Graph convert(Matrix adjMatrix) {
		List<Node> nodes = IntStream.range(0, adjMatrix.rows()).mapToObj(id -> {
			return new Node(id, false);
		}).collect(Collectors.toList());
		LinkedList<Link> links = new LinkedList<Link>();
		for (int i = 0; i < adjMatrix.rows(); ++i) {
			for (int j = i + 1; j < adjMatrix.columns(); ++j) {
				double right = adjMatrix.get(i, j);
				double left = adjMatrix.get(j, i);
				Link link = new Link(i, j, false, false, 0);
				if (right < graphUtils.getMaxWeight()) {
					link.setRight(true);
					link.setWeight(right);
				}
				if (left < graphUtils.getMaxWeight()) {
					link.setRight(true);
					link.setWeight(left);
				}
				if (link.isLeft() || link.isRight()) {
					links.add(link);
				}
			}
		}
		return new Graph(nodes, new ArrayList<>(links));
	}

	private void fixIds(Graph graph) {
		IntStream ids = graph.getNodes().stream().mapToInt(node -> {
			return node.getId();
		});
		int[] newIndexes = new int[ids.max().orElse(0) + 1];
		int currentId = 0;
		for (Node node : graph.getNodes()) {
			newIndexes[node.getId()] = currentId;
			++currentId;
		}
		graph.getNodes().stream().sequential().forEach(node -> {
			node.setId(newIndexes[node.getId()]);
		});
		graph.getLinks().stream().sequential().forEach(link -> {
			link.setSource(newIndexes[link.getSource()]);
			link.setTarget(newIndexes[link.getTarget()]);
		});
	}

	private Matrix buildMatrix(Graph graph) {
		int n = graph.getNodes().size();
		Matrix adjMat = Matrix.constant(n, n, graphUtils.getMaxWeight());
		for (Link link : graph.getLinks()) {
			if (link.isLeft()) {
				adjMat.set(link.getTarget(), link.getSource(), link.getWeight());
			}
			if (link.isRight()) {
				adjMat.set(link.getSource(), link.getTarget(), link.getWeight());
			}
		}
		for (Node node : graph.getNodes()) {
			if (node.isReflexive()) {
				adjMat.set(node.getId(), node.getId(), 0.0);
			}
		}
		return adjMat;
	}
}
