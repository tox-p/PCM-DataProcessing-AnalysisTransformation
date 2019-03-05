
% Secure Links Analysis
:-discontiguous(operationProperty/3).
operationProperty(_, _, _) :- fail.

secureLinks(ATT, OP, D, ACT, L, DS) :- ATT = 'default', defaultAttacker(OP, D, ACT, L, DS).
secureLinks(ATT, OP, D, ACT, L, DS) :- ATT = 'insider', insiderAttacker(OP, D, ACT, L, DS).

defaultAttacker(OP, D, ACT, L, DS) :- ACT = ['read', 'insert', 'delete'], L = 'EnumCharacteristicLiteral Internet (_roPzoP7hEeizQdLqRSCK5g)', secureLinksViolation(OP, D, ACT, L, DS).
defaultAttacker(OP, D, ACT, L, DS) :- ACT = ['delete'], L = 'EnumCharacteristicLiteral Encrypted (_sywe8P7hEeizQdLqRSCK5g)', secureLinksViolation(OP, D, ACT, L, DS).

insiderAttacker(OP, D, ACT, L, DS) :- ACT = ['read', 'insert', 'delete'], L = 'EnumCharacteristicLiteral Internet (_roPzoP7hEeizQdLqRSCK5g)', secureLinksViolation(OP, D, ACT, L, DS).
insiderAttacker(OP, D, ACT, L, DS) :- ACT = ['read', 'insert', 'delete'], L = 'EnumCharacteristicLiteral Encrypted (_sywe8P7hEeizQdLqRSCK5g)', secureLinksViolation(OP, D, ACT, L, DS).
insiderAttacker(OP, D, ACT, L, DS) :- ACT = ['read', 'insert', 'delete'], L = 'EnumCharacteristicLiteral LAN (_sJEowP7hEeizQdLqRSCK5g)', secureLinksViolation(OP, D, ACT, L, DS).

secureLinksViolation(OP, D, ACT, L, DS) :- DS = 'EnumCharacteristicLiteral Secrecy (_ycUIcP7hEeizQdLqRSCK5g)', hasLinkWithDataSensitivity(OP, L, DS, D), is_list(ACT), member('read', ACT).
secureLinksViolation(OP, D, ACT, L, DS) :- DS = 'EnumCharacteristicLiteral Integrity (_yxegIP7hEeizQdLqRSCK5g)', hasLinkWithDataSensitivity(OP, L, DS, D), is_list(ACT), member('insert', ACT).
secureLinksViolation(OP, D, ACT, L, DS) :- DS = 'EnumCharacteristicLiteral High (_T3EVID2lEemy7-rRVYUUTw)', hasLinkWithDataSensitivity(OP, L, DS, D), is_list(ACT), length(ACT, X), X > 0.

hasLinkWithDataSensitivity(OP, L, DS, D) :- hasLinkWithDataSensitivityInternal(OP, L, 'EnumCharacteristicType Link (_0r9P0P7hEeizQdLqRSCK5g)', DS, 'EnumCharacteristicType Sensitivity (_5KwWYP7hEeizQdLqRSCK5g)', D).

hasLinkWithDataSensitivityInternal(OP, L, LT, DS, DST, D) :- isOperation(OP), operationProperty(OP, LT, L), S=[OP|_], stackValid(S), operationState(OP, ST), D = 'Call Parameter', preCallState(S, OP, ST, DST, DS).
hasLinkWithDataSensitivityInternal(OP, L, LT, DS, DST, D) :- isOperation(OP), operationProperty(OP, LT, L), S=[OP|_], stackValid(S), operationReturnValue(OP, R), D = 'Return Value', returnValue(S, R, DST, DS).
