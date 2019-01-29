% Secure Links Helper

linkTransmitsDataOfSensitivityInternal(OP, L, LT, DS, DST) :- isOperation(OP), operationProperty(OP, LT, L), S=[OP|_], stackValid(S), operationState(OP, ST), preCallState(S, OP, ST, DST, DS).
linkTransmitsDataOfSensitivityInternal(OP, L, LT, DS, DST) :- isOperation(OP), operationProperty(OP, LT, L), S=[OP|_], stackValid(S), operationReturnValue(OP, R), returnValue(S, R, DST, DS).

linkTransmitsDataOfSensitivity(OP, L, S) :- linkTransmitsDataOfSensitivityInternal(OP, L, 'EnumCharacteristicType Link (_0r9P0P7hEeizQdLqRSCK5g)', S, 'EnumCharacteristicType Sensitivity (_5KwWYP7hEeizQdLqRSCK5g)').

% Attacker definitions
defaultAttacker(OP) :- linkTransmitsDataOfSensitivity(OP, 'EnumCharacteristicLiteral Internet (_roPzoP7hEeizQdLqRSCK5g)', 'EnumCharacteristicLiteral Secrecy (_ycUIcP7hEeizQdLqRSCK5g)').
defaultAttacker(OP) :- linkTransmitsDataOfSensitivity(OP, 'EnumCharacteristicLiteral Internet (_roPzoP7hEeizQdLqRSCK5g)', 'EnumCharacteristicLiteral Integrity (_yxegIP7hEeizQdLqRSCK5g)').
defaultAttacker(OP) :- linkTransmitsDataOfSensitivity(OP, 'EnumCharacteristicLiteral Encrypted (_sywe8P7hEeizQdLqRSCK5g)', 'EnumCharacteristicLiteral Integrity (_yxegIP7hEeizQdLqRSCK5g)').

insiderAttacker(OP) :- linkTransmitsDataOfSensitivity(OP, _, 'EnumCharacteristicLiteral Secrecy (_ycUIcP7hEeizQdLqRSCK5g)').
insiderAttacker(OP) :- linkTransmitsDataOfSensitivity(OP, _, 'EnumCharacteristicLiteral Integrity (_yxegIP7hEeizQdLqRSCK5g)').