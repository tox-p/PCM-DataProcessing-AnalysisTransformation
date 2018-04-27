%% copy roles V from node container C to node N
hasRole(N, V) :-
  flowNodeContainer(C, M),
  member(N, M),
  role(C, X),
  member(V, X).

%% access right R for data D has been granted for N if has already been granted before N
hasAssignedAccessRights(N, D, R) :-
  predecessor(N2, N),
  hasAssignedAccessRights(N2, D, R).

%% access right R for data D has been granted if explicitly granted in node N
hasAssignedAccessRights(N, D, R) :-
  opGrantAccessRights(N, D, Z),
  member(R, Z).

%% access right R for data D has been granted if it is in initial rights of data and node N is a start node
hasAssignedAccessRights(N, D, R) :-
  flowStart(N, _),
  flow(_, N, _, DT),
  member(D, DT),
  accessRights(D, Z),
  member(R, Z).

%% copy access rights R for data D from previous data DI if node N performs a projection operation
hasAssignedAccessRights(N, D, R) :-
  opProjection(N, DI, D),
  hasAssignedAccessRights(N, DI, R).

%% copy access rights R for data D from previous data DI if node N performs a selection operation
hasAssignedAccessRights(N, D, R) :-
  opSelection(N, DI, D),
  hasAssignedAccessRights(N, DI, R).

%% copy access rights R for data D from previous data DI if node N performs a filter operation
hasAssignedAccessRights(N, D, R) :-
  opFilter(N, DI, _, D),
  hasAssignedAccessRights(N, DI, R).

%% data D has been accessed transitively in node N by role R if it has been accessed transitively by role R in a node before
accessedByRoleTransitive(N, D, R) :-
  predecessor(N2, N),
  accessedByRoleTransitive(N2, D, R).

%% data D has been accessed transitively in node N by role R if it has been accessed directly in node N
accessedByRoleTransitive(N, D, R) :-
  accessedByRole(N, D, R).

%% data D is accessed by role R in node N if N received the data
accessedByRole(N, D, R) :-
  hasRole(N, R),
  flow(_, _, N, Y),
  member(D, Y).

%% data D is accessed by role R in node N if node N is sending the data
accessedByRole(N, D, R) :-
  hasRole(N, R),
  flow(_, N, _, Y),
  member(D, Y).

%% determine all assigned access rights R to data D before node N
allAssignedRolesBefore(N, D, R) :-
  findall(X, hasAssignedAccessRights(N, D, X), Z),
  sort(Z, R).

%% determine all accessing roles R to data D in node N
allAccessingRoles(N, D, R) :-
  findall(X, accessedByRole(N, D, X), Z),
  sort(Z, R).

%% determine node N that accesses data D with role R without proper access rights
illegalAccess(N, D, R) :-
  accessedByRole(N, D, R),
  \+hasAssignedAccessRights(N, D, R).