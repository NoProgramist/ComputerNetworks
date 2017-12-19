function submitTraversal() {
	var modelGraph = convertUIGraphToModelGraph(nodes, links)
	$.ajax({
		url : "/algorithm/traversal",
		type : "POST",
		data : JSON.stringify({
			root : $("#traversal-root").val(),
			type : $("#traversal-algorithm").val(),
			nodes : modelGraph.nodes,
			links : modelGraph.links
		}),
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		processData : false
	}).done(function(modelGraph) {
		for (var i = 0; i < nodes.length; ++i) {
			delete nodes[i];
		}
		nodes.length = 0;
		for (var i = 0; i < links.length; ++i) {
			delete links[i];
		}
		links.length = 0;
		restart();
		var newGraph = convertModelGraphToUIGraph(modelGraph);
		for (var i = 0; i < newGraph.nodes.length; ++i) {
			nodes.push(newGraph.nodes[i]);
		}
		for (var i = 0; i < newGraph.links.length; ++i) {
			links.push(newGraph.links[i]);
		}
		restart();
	});
}

function submitDistance() {
	var modelGraph = convertUIGraphToModelGraph(nodes, links)
	$.ajax({
		url : "/algorithm/distance",
		type : "POST",
		data : JSON.stringify({
			root : $("#distance-root").val(),
			type : $("#distance-algorithm").val(),
			nodes : modelGraph.nodes,
			links : modelGraph.links
		}),
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		processData : false
	}).done(function(modelGraph) {
		for (var i = 0; i < nodes.length; ++i) {
			delete nodes[i];
		}
		nodes.length = 0;
		for (var i = 0; i < links.length; ++i) {
			delete links[i];
		}
		links.length = 0;
		restart();
		var newGraph = convertModelGraphToUIGraph(modelGraph);
		for (var i = 0; i < newGraph.nodes.length; ++i) {
			nodes.push(newGraph.nodes[i]);
		}
		for (var i = 0; i < newGraph.links.length; ++i) {
			links.push(newGraph.links[i]);
		}
		restart();
	});
}