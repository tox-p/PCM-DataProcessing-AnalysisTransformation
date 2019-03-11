
% Secure Links Analysis
:-discontiguous(operationProperty/3).
operationProperty(_, _, _) :- fail.

secureLinks(ATT, OP, D, ACT, L, DS) :- hasLinkWithDataSensitivity(OP, L, DS, D), secureLinksViolation(ATT, ACT, L, DS).

hasLinkWithDataSensitivity(OP, L, DS, D) :- hasLinkWithDataSensitivityInternal(OP, L, 'EnumCharacteristicType Link (_0r9P0P7hEeizQdLqRSCK5g)', DS, 'EnumCharacteristicType Sensitivity (_5KwWYP7hEeizQdLqRSCK5g)', D).

hasLinkWithDataSensitivityInternal(OP, L, LT, DS, DST, D) :- isOperation(OP), operationProperty(OP, LT, L), S=[OP|_], stackValid(S), operationState(OP, ST), D = 'Call Parameter', preCallState(S, OP, ST, DST, DS).
hasLinkWithDataSensitivityInternal(OP, L, LT, DS, DST, D) :- isOperation(OP), operationProperty(OP, LT, L), S=[OP|_], stackValid(S), operationReturnValue(OP, R), D = 'Return Value', returnValue(S, R, DST, DS).

secureLinksViolation(ATT, ACT, L, DS) :- DS = 'EnumCharacteristicLiteral Secrecy (_ycUIcP7hEeizQdLqRSCK5g)', attacker(ATT, ACT, L), is_list(ACT), member('read', ACT).
secureLinksViolation(ATT, ACT, L, DS) :- DS = 'EnumCharacteristicLiteral Integrity (_yxegIP7hEeizQdLqRSCK5g)', attacker(ATT, ACT, L), is_list(ACT), member('insert', ACT).
secureLinksViolation(ATT, ACT, L, DS) :- DS = 'EnumCharacteristicLiteral High (_T3EVID2lEemy7-rRVYUUTw)', attacker(ATT, ACT, L), is_list(ACT), length(ACT, X), X > 0.

attacker('default', ['read', 'insert', 'delete'], 'EnumCharacteristicLiteral Internet (_roPzoP7hEeizQdLqRSCK5g)').
attacker('default', ['delete'], 'EnumCharacteristicLiteral Encrypted (_sywe8P7hEeizQdLqRSCK5g)').

attacker('insider', ['read', 'insert', 'delete'], 'EnumCharacteristicLiteral Internet (_roPzoP7hEeizQdLqRSCK5g)').
attacker('insider', ['read', 'insert', 'delete'], 'EnumCharacteristicLiteral Encrypted (_sywe8P7hEeizQdLqRSCK5g)').
attacker('insider', ['read', 'insert', 'delete'], 'EnumCharacteristicLiteral LAN (_sJEowP7hEeizQdLqRSCK5g)').