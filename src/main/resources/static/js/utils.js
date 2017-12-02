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

function convertNodes(nodes) {
	return nodes.map(function(element) {
		return {
			id : element.id,
			reflexive : element.reflexive
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

function generateRamdomGraph(n, m) {
	svg.selectAll('text.aEnd').remove();
	var list  = randomChoose(unorderedPairs(d3.range(n)), m);
	nodes = [];
	for(var i = 0; i < n; i++) {
		nodes.push({id: i, reflexive: false});
	}
	links = [];
	for(var i = 0; i < m; i++) {
		links.push({source: list[i][0], target: list[i][1], left: true, right: true, weight: '' });
	}
	rebuildGraph();
}

function rebuildGraph() {
	force = d3.layout.force()
	    .nodes(nodes)
	    .links(links)
	    .size([width, height])
	    .linkDistance(150)
	    .charge(-500)
	    .on('tick', tick).start();
	setTimeout(function() {
		restart();
	}, 500);
}
function randomChoose (s, k) { // returns a random k element subset of s
  var a = [], i = -1, j;
  while (++i < k) {
    j = Math.floor(Math.random() * s.length);
    a.push(s.splice(j, 1)[0]);
  };
  return a;
}

function unorderedPairs (s) { // returns the list of all unordered pairs from s
  var i = -1, a = [], j;
  while (++i < s.length) {
    j = i;
    while (++j < s.length) a.push([s[i],s[j]])
  };
  return a;
}
