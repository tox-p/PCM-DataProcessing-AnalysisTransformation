%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                  Facts                 %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Data definitions
data(data_requestdata, 'RequestData').
data(data_flightoffers, 'FlightOffers').
data(data_flightoffer, 'FlightOffer').
data(data_ccdetails, 'CreditCardDetails').
data(data_offerid, 'OfferId').
data(data_confirmation_ta, 'Confirmation (TA -> Airline)').
data(data_confirmation_airline, 'Confirmation (Airline -> TP)').
data(data_flightOffers_filtered, 'FlightOffers (Filtered)').

% Flow starts
flowStart(flowstart_user, 'User').
flowStart(flowstart_creditcardcenterstore, 'Credit Card Center Store').
flowStart(flowstart_travelagency, 'Travel Agency').
flowStart(flowstart_airlinestore, 'Airline Store').
flowStart(flowstart_Airline, 'Airline').

% Flow nodes
flowNode(flownode_user_sendrequestdata, 'send request data (User)').
flowNode(flownode_user_receive_flightoffers, 'receive flight offers (User)').
flowNode(flownode_user_select_flightoffer, 'select flight offer (User)').
flowNode(flownode_user_receive_ccd, 'receive ccd (User)').
flowNode(flownode_user_send_ccd, 'send ccd (User)').
flowNode(flownode_user_receive_ccd_declassified, 'receive declassified ccd (User)').
flowNode(flownode_user_send_booking, 'send booking request (User)').
flowNode(flownode_user_receive_confirmation, 'receive confirmation (User)').
flowNode(flownode_TP_receiveRequestData, 'receive request data (TP)').
flowNode(flownode_TP_sendRequestData, 'send request data (TP)').
flowNode(flownode_TP_receive_FlightOffers, 'receive flight offers (TP)').
flowNode(flownode_TP_send_FlightOffers, 'send flight offers (TP)').
flowNode(flownode_ccc_send_ccd, 'send credit card data (CCC)').
flowNode(flownode_ccc_receive_ccd, 'receive ccd (CCC)').
flowNode(flownode_ccc_declassify_ccd, 'declassify ccd (CCC)').
flowNode(flownode_ccc_send_ccdDeclassified, 'send declassified ccd (CCC)').
flowNode(flownode_tp_receive_booking, 'receive booking request (TP)').
flowNode(flownode_tp_send_booking, 'send booking request (TP)').
flowNode(flownode_tp_receive_confirmation, 'receive confirmation (TP)').
flowNode(flownode_tp_send_confirmation, 'send confirmation (TP)').
flowNode(flownode_ta_receiverequestdata, 'receive request data (TA)').
flowNode(flownode_ta_sendRequestData, 'send request data (TA)').
flowNode(flownode_ta_receive_flightoffers, 'receive flight offers (TA)').
flowNode(flownode_ta_send_FlightOffers, 'send flight offers (TA)').
flowNode(flownode_ta_receive_offerid, 'receive offer id (TA)').
flowNode(flownode_ta_send_confirmation, 'send confirmation (TA)').
flowNode(flownode_airline_receiveRequestData, 'receive request data (Airline)').
flowNode(flownode_airline_loadData, 'load flight offers (Airline)').
flowNode(flownode_airline_filter_flightoffers, 'filter flight offers (Airline)').
flowNode(flownode_airline_send_flightoffers, 'send flight offers (Airline)').
flowNode(flownode_airline_receive_bookingrequest, 'receive booking request (Airline)').
flowNode(flownode_airline_project_offerid, 'project offer id (Airline)').
flowNode(flownode_airline_send_offerid, 'send offer id (Airline)').
flowNode(flownode_airline_receive_confirmation, 'receive confirmation (Airline)').
flowNode(flownode_airline_send_confirmation, 'send confirmation (Airline)').

% Node containers
flowNodeContainer(nc_user, [flowstart_user, flownode_user_sendrequestdata, flownode_user_receive_flightoffers, flownode_user_select_flightoffer, flownode_user_receive_ccd, flownode_user_send_ccd, flownode_user_receive_ccd_declassified, flownode_user_send_booking, flownode_user_receive_confirmation]).
flowNodeContainer(nc_mobile, [flowstart_creditcardcenterstore, flownode_TP_receiveRequestData, flownode_TP_sendRequestData, flownode_TP_receive_FlightOffers, flownode_TP_send_FlightOffers, flownode_ccc_send_ccd, flownode_ccc_receive_ccd, flownode_ccc_declassify_ccd, flownode_ccc_send_ccdDeclassified, flownode_tp_receive_booking, flownode_tp_send_booking, flownode_tp_receive_confirmation, flownode_tp_send_confirmation]).
flowNodeContainer(nc_travelagency, [flownode_ta_receiverequestdata, flownode_ta_sendRequestData, flownode_ta_receive_flightoffers, flownode_ta_send_FlightOffers, flownode_ta_receive_offerid, flowstart_travelagency, flownode_ta_send_confirmation]).
flowNodeContainer(nc_airline, [flowstart_airlinestore, flownode_airline_receiveRequestData, flownode_airline_loadData, flownode_airline_filter_flightoffers, flownode_airline_send_flightoffers, flownode_airline_receive_bookingrequest, flownode_airline_project_offerid, flownode_airline_send_offerid, flownode_airline_receive_confirmation, flowstart_Airline, flownode_airline_send_confirmation]).

% Flows
flow(flow_requestData_User_User, flowstart_user, flownode_user_sendrequestdata, [data_requestdata]).
flow(flow_requestData_User_TP, flownode_user_sendrequestdata, flownode_TP_receiveRequestData, [data_requestdata]).
flow(flow_requestData_TP_TP, flownode_TP_receiveRequestData, flownode_TP_sendRequestData, [data_requestdata]).
flow(flow_requestData_TP_TA, flownode_TP_sendRequestData, flownode_ta_receiverequestdata, [data_requestdata]).
flow(flow_requestData_TA_TA, flownode_ta_receiverequestdata, flownode_ta_sendRequestData, [data_requestdata]).
flow(flow_requestData_TA_Airline, flownode_ta_sendRequestData, flownode_airline_receiveRequestData, [data_requestdata]).
flow(flow_flightOffers_Airline_Airline, flowstart_airlinestore, flownode_airline_loadData, [data_flightoffers]).
flow(flow_flightoffers_filter_Airline_Airline, flownode_airline_loadData, flownode_airline_filter_flightoffers, [data_flightoffers]).
flow(flow_requestData_filter_Airline_Airline, flownode_airline_receiveRequestData, flownode_airline_filter_flightoffers, [data_requestdata]).
flow(flow_flightoffers_filtered_Airline_Airline, flownode_airline_filter_flightoffers, flownode_airline_send_flightoffers, [data_flightOffers_filtered]).
flow(flow_flightoffers_Airline_TA, flownode_airline_send_flightoffers, flownode_ta_receive_flightoffers, [data_flightOffers_filtered]).
flow(flow_flightoffers_TA_TA, flownode_ta_receive_flightoffers, flownode_ta_send_FlightOffers, [data_flightOffers_filtered]).
flow(flow_flightoffers_TA_TP, flownode_ta_send_FlightOffers, flownode_TP_receive_FlightOffers, [data_flightOffers_filtered]).
flow(flow_flightoffers_TP_TP, flownode_TP_receive_FlightOffers, flownode_TP_send_FlightOffers, [data_flightOffers_filtered]).
flow(flow_flightoffers_TP_User, flownode_TP_send_FlightOffers, flownode_user_receive_flightoffers, [data_flightOffers_filtered]).
flow(flow_flightoffersselected_User_User, flownode_user_receive_flightoffers, flownode_user_select_flightoffer, [data_flightOffers_filtered]).
flow(flow_ccd_CCC_CCC, flowstart_creditcardcenterstore, flownode_ccc_send_ccd, [data_ccdetails]).
flow(flow_ccd_CCC_User, flownode_ccc_send_ccd, flownode_user_receive_ccd, [data_ccdetails]).
flow(flow_ccd_User_User_intermediate, flownode_user_receive_ccd, flownode_user_send_ccd, [data_ccdetails]).
flow(flow_ccd_User_CCC, flownode_user_send_ccd, flownode_ccc_receive_ccd, [data_ccdetails]).
flow(flow_ccd_CCC_CCC_declassify, flownode_ccc_receive_ccd, flownode_ccc_declassify_ccd, [data_ccdetails]).
flow(flow_ccd_CCC_CCC_declassified, flownode_ccc_declassify_ccd, flownode_ccc_send_ccdDeclassified, [data_ccdetails]).
flow(flow_ccd_CCC_User_declassified, flownode_ccc_send_ccdDeclassified, flownode_user_receive_ccd_declassified, [data_ccdetails]).
flow(flow_ccd_User_User_bookingRequest, flownode_user_receive_ccd_declassified, flownode_user_send_booking, [data_ccdetails]).
flow(flow_flightoffer_User_User_bookingRequest, flownode_user_select_flightoffer, flownode_user_send_booking, [data_flightoffer]).
flow(flow_bookingrequest_User_TP, flownode_user_send_booking, flownode_tp_receive_booking, [data_flightoffer, data_ccdetails]).
flow(flow_bookingrequest_TP_TP, flownode_tp_receive_booking, flownode_tp_send_booking, [data_ccdetails, data_flightoffer]).
flow(flow_bookingrequest_TP_Airline, flownode_tp_send_booking, flownode_airline_receive_bookingrequest, [data_flightoffer, data_ccdetails]).
flow(flow_flightOffer_User_Airline, flownode_airline_receive_bookingrequest, flownode_airline_project_offerid, [data_flightoffer]).
flow(flow_offerid_Airline_Airline, flownode_airline_project_offerid, flownode_airline_send_offerid, [data_offerid]).
flow(flow_offerid_Airline_TA, flownode_airline_send_offerid, flownode_ta_receive_offerid, [data_offerid]).
flow(flow_confirmation_TA_TA, flowstart_travelagency, flownode_ta_send_confirmation, [data_confirmation_ta]).
flow(flow_confirmation_TA_Airline, flownode_ta_send_confirmation, flownode_airline_receive_confirmation, [data_confirmation_ta]).
flow(flow_confirmation_Airline_Airline, flowstart_Airline, flownode_airline_send_confirmation, [data_confirmation_airline]).
flow(flow_confirmation_Airline_TP, flownode_airline_send_confirmation, flownode_tp_receive_confirmation, [data_confirmation_airline]).
flow(flow_confirmation_TP_TP, flownode_tp_receive_confirmation, flownode_tp_send_confirmation, [data_confirmation_airline]).
flow(flow_confirmation_TP_User, flownode_tp_send_confirmation, flownode_user_receive_confirmation, [data_confirmation_airline]).

% Characteristic values

%% Role (characteristic_role)
role(nc_user, [enumliteral_role_user]).
role(nc_mobile, [enumliteral_role_user]).
role(nc_travelagency, [enumliteral_role_travelagency]).
role(nc_airline, [enumliteral_role_airline]).

%% AccessRights (characteristic_accesscontrol)
accessRights(data_requestdata, [enumliteral_role_airline, enumliteral_role_travelagency, enumliteral_role_user]).
accessRights(data_flightoffers, [enumliteral_role_airline, enumliteral_role_travelagency, enumliteral_role_user]).
accessRights(data_ccdetails, [enumliteral_role_user]).
accessRights(data_confirmation_ta, [enumliteral_role_airline, enumliteral_role_travelagency, enumliteral_role_user]).
accessRights(data_confirmation_airline, [enumliteral_role_airline, enumliteral_role_travelagency, enumliteral_role_user]).


% Node operations

%% opSelection (op_selection)
opSelection(flownode_user_select_flightoffer, data_flightoffers, data_flightoffer).

%% opGrantAccessRights (op_grantaccessrights)
opGrantAccessRights(flownode_ccc_declassify_ccd, data_ccdetails, [enumliteral_role_airline]).

%% opFilter (op_filter)
opFilter(flownode_airline_filter_flightoffers, data_flightoffers, data_requestdata, data_flightOffers_filtered).

%% opProjection (op_projection)
opProjection(flownode_airline_project_offerid, data_flightoffer, data_offerid).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%            Contributed Facts           %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.contribution.AccessControlContributor
% no facts contributed

% edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.relational.contribution.RelationalContributor
% no facts contributed


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                  Rules                 %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

predecessor(S, T) :-
  flow(_, S, T, _).

transitivePredecessor(S, T) :-
  flow(_, X, T, _),
  predecessor(S, X).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%            Contributed Rules           %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.contribution.AccessControlContributor
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

% edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.relational.contribution.RelationalContributor
% no rules contributed

