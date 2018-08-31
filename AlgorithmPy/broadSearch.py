#!/usr/bin/env python
# -*- coding: utf-8 -*- 
from collections import deque
# graph={}
# graph["start"]={}
# graph["start"]["A"]=6
# graph["start"]["B"]=2

# graph["a"] = {}
# graph["a"]["fin"] = 1

# graph["b"] = {}
# graph["b"]["a"] = 3
# graph["b"]["fin"] = 5

# graph["fin"] = {} 


# infinity = float("inf")
# costs = {}
# costs["a"] = 6
# costs["b"] = 2
# costs["fin"] = infinity 

# parents = {}
# parents["a"] = "start"
# parents["b"] = "start"
# parents["fin"] = None 

# processed = [] 

# # print graph.keys()

# def find_lowest(costs):
#     lowest_cost=float("inf")
#     lowest_cost_node=None
#     for node in costs:
#         if costs[node]<lowest_cost and node not in processed:
#             lowest_cost=costs[node]
#             lowest_cost_node=node
#     return lowest_cost_node

# node = find_lowest(costs)
# while node != None:
#     cost=costs[node]
#     neighbors=graph[node]
#     for n in neighbors.keys():
#         new_cost=cost+neighbors[n]
#         if costs[n]>new_cost:
#             costs[n]=new_cost
#             parents[n]=node
#     processed.append(node)
#     node = find_lowest(costs)
# print parents

graph={}
graph["you"]=["a","b","c"]
graph["a"]=["d","e","f"]
graph["b"]=["g","h"]
graph["c"]=[]
graph["d"]=[]
graph["e"]=[]
graph["f"]=[]
graph["g"]=[]
graph["h"]=[]

def find_the_one(name):
    if name=="e":
        return True
    return False

def broad_search(name):
    queue=deque()
    queue+=graph[name]
    searched=[]
    while queue:
        leftNode=queue.popleft()
        if leftNode not in searched:
            if find_the_one(leftNode):
                print "result is "+leftNode
                return True
            else: 
                queue+=graph[leftNode]
                searched.append(leftNode)
    return False
broad_search("you")
# queue=deque()
# queue.append(1)
# queue.append(2)
# queue.append(3)
# queue+="4"
# print queue.pop()

# queue=deque()
# queue+=graph("you")
# while queue:
#     left_node=queue.popleft()
#     if find_the_one(left_node):
#         pritn "找到！"
#         return True
#     else:
#         searched.append(left_node)
#         queue+=graph[left_node]
# return False