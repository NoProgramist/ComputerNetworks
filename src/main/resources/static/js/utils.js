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
		if (!isNaN(property)) { // set is being called second time to change length property of target array
			if ($('table#nodes-table tr#' + value.id).length === 0) { // on else make swap of elements before removing
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
		if (!isNaN(property)) { // set is being called second time to change length property of target array
			if ($('table#links-table tr#s' + value.source.id + 't' + value.target.id).length === 0) { // on else make swap of elements before removing
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

function findNode(id, nodes) {
	return nodes.find(function(element) {
		return element.id === id;
	});
}

function convertModelGraphToUIGraph(graph) {
	var uiNodes = new Proxy([], nodesProxyObj);
	var uiLinks = new Proxy([], linksProxyObj);
	uiNodes.push.apply(uiNodes, graph.nodes);
	uiLinks.push.apply(uiLinks, graph.links.map(function(link) {
		return {
			source : findNode(link.source, uiNodes),
			target : findNode(link.target, uiNodes),
			left : link.left,
			right : link.right
		};
	}));

	return {
		nodes : uiNodes,
		links : uiLinks
	};
}