class Graph(object):
    """
    A simple undirected, weighted graph
    """
    def __init__(self):
        self.nodes = set()
        self.edges = {}
        self.distances = {}
 
    def add_node(self, value):
        self.nodes.add(value)
 
    def add_edge(self, from_node, to_node, distance):
        self._add_edge(from_node, to_node, distance)
        self._add_edge(to_node, from_node, distance)
 
    def _add_edge(self, from_node, to_node, distance):
        self.edges.setdefault(from_node, [])
        self.edges[from_node].append(to_node)
        self.distances[(from_node, to_node)] = distance

def astar(graph, initial_node, goal_node, h):
    closed_set = set() # set of nodes already evaluated
    nodes = set() # set of tentative nodes to be evaluated
    nodes.add(initial_node)
 
    visited = {} # map of navigated nodes
    g_score = {initial_node: 0} # distance from start along optimal path
    h_score = {initial_node: h(initial_node, goal_node)} # heuristic estimate
    f_score = {initial_node: h_score[initial_node]} # estimated dist
 
    while nodes:
        x = None
        for node in nodes:
            if x is None:
                x = node
            elif f_score[node] < f_score[x]:
                x = node
 
        nodes.remove(x)
        if x == goal_node:
            return visited
 
        closed_set.add(x)
        for y in graph.edges[x]:
            if y in closed_set:
                continue
            tentative_g_score = g_score[x] + graph.distances[(x, y)]
 
            flag = False
            if y not in nodes or tentative_g_score < g_score[y]:
                nodes.add(y)
                flag = True
 
            if flag:
                visited[y] = x
 
                g_score[y] = tentative_g_score
                h_score[y] = h(y, goal_node)
                f_score[y] = g_score[y] + h_score[y]
 
    return False
 
def shortest_path(graph, initial_node, goal_node, h):
    paths = astar(graph, initial_node, goal_node, h)
    route = [goal_node]
 
    while goal_node != initial_node:
        route.append(paths[goal_node])
        goal_node = paths[goal_node]
 
    route.reverse()
    return route
 
 
if __name__ == '__main__':
    import math
    sldist = lambda c1, c2: math.sqrt((c2[0] - c1[0])**2 + (c2[1] - c1[1])**2)
    g = Graph()
    g.add_node((0, 0))
    g.add_node((1, 1))
    g.add_node((1, 0))
    g.add_node((0, 1))
    g.add_node((2, 2))
 
    g.add_edge((0, 0), (1, 1), 1.5)
    g.add_edge((0, 0), (0, 1), 1.2)
    g.add_edge((0, 0), (1, 0), 1)
    g.add_edge((1, 0), (2, 2), 2)
    g.add_edge((0, 1), (2, 2), 2)
    g.add_edge((1, 1), (2, 2), 1.5)
 
    assert shortest_path(g, (0, 0), (2, 2), sldist) == [(0, 0), (1, 1), (2, 2)]
 
    g.distances[((0, 0), (1, 1))] = 2
    g.distances[((1, 1), (0, 0))] = 2
 
    assert shortest_path(g, (0, 0), (2, 2), sldist) == [(0, 0), (1, 0), (2, 2)]
 
    g.distances[((0, 0), (1, 0))] = 1.3
    g.distances[((1, 0), (0, 0))] = 1.3
 
    assert shortest_path(g, (0, 0), (2, 2), sldist) == [(0, 0), (0, 1), (2, 2)]
