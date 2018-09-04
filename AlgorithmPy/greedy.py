#!/usr/bin/env python
# -*- coding: utf-8 -*- 

states_need=set(["mt", "wa", "or", "id", "nv", "ut","ca", "az"])

stations = {}
stations["kone"] = set(["id", "nv", "ut"])
stations["ktwo"] = set(["wa", "id", "mt"])
stations["kthree"] = set(["or", "nv", "ca"])
stations["kfour"] = set(["nv", "ut"])
stations["kfive"] = set(["ca", "az"])

final_stations=set()

while states_need:
    bestStation=None
    states_covered=set()
    for station,states_stations in stations.items():
        # print station
        # print states_stations
        covered=states_need&states_stations
        if len(covered)>len(states_covered):
            states_covered=covered
            bestStation=station
    final_stations.add(bestStation)
    states_need-=states_covered

print final_stations





# while states_need:
#     bestStation=None
#     states_covered=set()
#     for station,states_stations in states_need.items():
#         covered=states_stations&states_need
#         if len(states_covered)<len(covered):
#             states_covered=covered
#             bestStation=station
#     states_need-=states_covered
#     final_stations.add(bestStation)