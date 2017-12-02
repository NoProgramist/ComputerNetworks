function findNode(id, nodes) {
	return nodes.find(function(element) {
		return element.id === id;
	});
}

function matchLinksWithNodes(links, nodes) {
	return links.map(function(element) {
		return {
			source : findNode(element.source, nodes),
			target : findNode(element.target, nodes),
			left : element.left,
			right : element.right
		};
	});
}

function reverseMatchLinksWithNodes(links, nodes) {
	return links.map(function(element) {
		return {
			source : element.source.id,
			target : element.target.id,
			left : element.left,
			right : element.right
		};
	});
}