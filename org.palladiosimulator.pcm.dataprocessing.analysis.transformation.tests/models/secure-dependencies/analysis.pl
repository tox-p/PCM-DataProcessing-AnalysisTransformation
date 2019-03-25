
% Secure Dependencies Analysis
:-discontiguous(operationProperty/3).
operationProperty(_, _, _) :- fail.
:-discontiguous(not_operationProperty/3).
not_operationProperty(_, _, _) :- fail.

secureDependencies(OP, V) :- T = 'EnumCharacteristicType Critical (_5KwWYP7hEeizQdLqRSCK5g)', isOperation(OP), hasProperty(OP, T), S=[OP|_], stackValid(S), operationReturnValue(OP, R), secureDependenciesViolation(OP, T, S, R, V).

secureDependenciesViolation(OP, T, S, R, V) :- valueSetMember('Enumeration CriticalEnum (_wK8iwf7hEeizQdLqRSCK5g)', V), operationProperty(OP, T, V), lnot(returnValue(S, R, T, V)).
secureDependenciesViolation(OP, T, S, R, V) :- valueSetMember('Enumeration CriticalEnum (_wK8iwf7hEeizQdLqRSCK5g)', V), lnot(operationProperty(OP, T, V)), returnValue(S, R, T, V).