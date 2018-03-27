package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.contributors.impl

import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.contributors.IPrologGeneratorContributor
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.DataFlowDiagram

class RoleCharacteristicContributor implements IPrologGeneratorContributor {
	
	override getRules(DataFlowDiagram diag) '''
		%% copy roles V from node container C to node N
		role(N, V) :-
		  flowNodeContainer(C, M),
		  member(N, M),
		  role(C, V).
		
		%% access right R for data D has been granted if explicitly granted before node N 
		hasAssignedAccessRightsBefore(N, D, R) :-
		  predecessor(N2, N),
		  grantAccessRights(N2, D, Z),
		  member(R, Z).

		%% access right R for data D has been granted if it is in initial rights of data and node N is a start node
		hasAssignedAccessRightsBefore(N, D, R) :-
		  flowStart(N, _),
		  accessRights(D, Z),
		  member(R, Z).
		
		%% copy access rights R for data D from previous data DI if node N performs a projection operation
		grantAccessRights(N, D, R) :-
		  projection(N, DI, D),
		  hasAssignedAccessRightsBefore(N, DI, R).
		
		%% copy access rights R for data D from previous data DI if node N performs a selection operation
		grantAccessRights(N, D, R) :-
		  selection(N, DI, D),
		  hasAssignedAccessRightsBefore(N, DI, R).
		
		%% copy access rights R for data D from previous data DI if node N performs a filter operation
		grantAccessRights(N, D, R) :-
		  filter(N, DI, _, D),
		  hasAssignedAccessRightsBefore(N, DI, R).

		%% data D has been accessed before node N by role R if node N has received data D
		accessedByRoleBefore(N, D, R) :-
		  role(X, R),
		  predecessor(X, N),
		  flow(_, _, X, D).
		
		%% data D has been accessed before node N by role R if node N has sent data D
		accessedByRoleBefore(N, D, R) :-
		  role(X, R),
		  predecessor(X, N),
		  flow(_, X, _, D).

		%% determine all assigned access rights R to data D before node N
		allAssignedRolesBefore(N, D, R) :-
		  findall(X, hasAssignedAccessRightsBefore(N, D, X), Z),
		  sort(Z, R).

		%% determine all accessing roles R to data D before node N
		allAccessingRolesBefore(N, D, R) :-
		  findall(X, accessedByRoleBefore(N, D, X), Z),
		  sort(Z, R).

		%% Please note: You have to provide a matching between roles and access rights in order to perform a comparison
	'''
	
}