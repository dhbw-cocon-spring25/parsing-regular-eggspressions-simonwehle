grammar Grammar;

regex: concat union;

union
    : '|' concat union
    | /* eps */
    ;

concat: kleene suffix;

suffix
    : kleene suffix
    | /* eps */
    ;

kleene
    : base '*'
    | base
    ;

base
    : LITERAL
    | '(' regex ')'
    ;

LITERAL: [a-zA-Z_][a-zA-Z0-9_]*;
