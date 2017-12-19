var nodesProxyObj = {
	get : function(target, property, receiver) {
		if (!isNaN(property)) {
			var value = target[property];
			var nodeRowProperties = $('table#nodes-table tr#' + target[property].id).children();
			nodeRowProperties[1].innerHTML = Math.round(target[property].x);
			nodeRowProperties[2].innerHTML = Math.round(target[property].y);
		}
		return target[property];
	},
	set : function(target, property, value, receiver) {
		if (!isNaN(property)) {
			// set is being called second time to change
			// length property of target array
			if ($('table#nodes-table tr#' + value.id).length === 0) {
				// on
				// else
				// make
				// swap
				// of
				// elements
				// before
				// removing
				var html = '<tr id="' + value.id + '"><td>' + value.id + '</td><td>' + value.x + '</td><td>' + value.y + '</td></tr>';
				$('table#nodes-table > tbody').append(html);
			} else {
				target[target.indexOf(value)] = target[property];
			}
		}
		return target[property] = value;
	},
	deleteProperty : function(target, property) {
		if (!isNaN(property)) {
			$('table#nodes-table tr#' + target[property].id).remove();
		}
		return delete target[property];
	}
}

var linksProxyObj = {
	get : function(target, property, receiver) {
		if (!isNaN(property)) {
			var value = target[property];
			var nodeRowProperties = $('table#links-table tr#s' + target[property].source.id + 't' + target[property].target.id).children();
			nodeRowProperties[2].innerHTML = Math.round(target[property].left);
			nodeRowProperties[3].innerHTML = Math.round(target[property].right);
			nodeRowProperties[4].innerHTML = Math.round(target[property].weight);
		}
		return target[property];
	},
	set : function(target, property, value, receiver) {
		if (!isNaN(property)) {
			// set is being called second time to change
			// length property of target array
			if (value.weight === undefined){
				value.weight = askForLinkWeight();
			}
			if ($('table#links-table tr#s' + value.source.id + 't' + value.target.id).length === 0) {
				// on
				// else
				// make
				// swap
				// of
				// elements
				// before
				// removing
				var html = '<tr id="s' + value.source.id + 't' + value.target.id + '"><td>' + value.source.id + '</td><td>' + value.target.id + '</td><td>' + value.left
						+ '</td><td>' + value.right + '</td><td>' + value.weigth + '</td></tr>';
				$('table#links-table > tbody').append(html);
			} else {
				target[target.indexOf(value)] = target[property];
			}
		}
		return target[property] = value;
	},
	deleteProperty : function(target, property) {
		if (!isNaN(property)) {
			$('table#links-table tr#s' + target[property].source.id + 't' + target[property].target.id).remove();
		}
		return delete target[property];
	}
}

function askForLinkWeight() {
    var txt;
    var weight = prompt("Weight:", "1");
    if (weight == null || weight == "" || isNaN(weight)) {
        return 1.0;
    } else {
        return parseFloat(weight);
    }
    
}

function findNode(id, nodes) {
	return nodes.find(function(element) {
		return element.id === id;
	});
}

function applyProxies(graph) {
	var nodesProxy = new Proxy([], nodesProxyObj);
	for (var i = 0; i < graph.nodes.length; ++i) {
		nodesProxy.push(graph.nodes[i]);
	}
	var linksProxy = new Proxy([], linksProxyObj);
	for (var i = 0; i < graph.links.length; ++i) {
		linksProxy.push(graph.links[i]);
	}
	return {
		nodes : nodesProxy,
		links : linksProxy
	};
}

function convertModelGraphToUIGraph(graph) {
	return {
		nodes : graph.nodes,
		links : graph.links.map(function(link) {
			return {
				source : findNode(link.source, graph.nodes),
				target : findNode(link.target, graph.nodes),
				left : link.left,
				right : link.right,
				weight : link.weight
			};
		})
	};
}

function convertUIGraphToModelGraph(nodes, links) {
	var modelNodes = nodes.map(function(node){
		return node;
	});
	var modelLinks = links.map(function(link) {
		return {
			source : link.source.id,
			target : link.target.id,
			left : link.left,
			right : link.right,
			weight : link.weight
		}
	});
	return {
		nodes : modelNodes,
		links : modelLinks
	};
}

function clearTables() {
	$("#nodes-table").empty();
	$("#links-table").empty();
}
