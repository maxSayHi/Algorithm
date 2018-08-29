graph={}
graph["start"]={}
graph["start"]["A"]=6
graph["start"]["B"]=2

graph["a"] = {}
graph["a"]["fin"] = 1

graph["b"] = {}
graph["b"]["a"] = 3
graph["b"]["fin"] = 5

graph["fin"] = {} 


infinity = float("inf")
costs = {}
costs["a"] = 6
costs["b"] = 2
costs["fin"] = infinity 

parents = {}
parents["a"] = "start"
parents["b"] = "start"
parents["fin"] = None 

processed = [] 

# print graph.keys()

def find_lowest(costs):
    lowest_cost=float("inf")
    lowest_cost_node=None
    for node in costs:
        if costs[node]<lowest_cost and node not in processed:
            lowest_cost=costs[node]
            lowest_cost_node=node
    return lowest_cost_node

node = find_lowest(costs)
while node != None:
    cost=costs[node]
    neighbors=graph[node]
    for n in neighbors.keys():
        new_cost=cost+neighbors[n]
        if costs[n]>new_cost:
            costs[n]=new_cost
            parents[n]=node
    processed.append(node)
    node = find_lowest(costs)
print parents


    