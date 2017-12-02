package ua.edu.lnu.cns_webserver.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GraphWrapper {

	private String nodes;

	private String links;

	public GraphWrapper() {
		super();
	}

	public GraphWrapper(String nodes, String links) {
		super();
		this.nodes = nodes;
		this.links = links;
	}

	public String getNodes() {
		return nodes;
	}

	public void setNodes(String nodes) {
		this.nodes = nodes;
	}

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public Graph toGraph(ObjectMapper mapper) throws JsonParseException, JsonMappingException, IOException {
		return new Graph(mapper.readValue(this.nodes, new TypeReference<List<Node>>() {
		}), mapper.readValue(this.links, new TypeReference<List<Link>>() {
		}));
	}
}
