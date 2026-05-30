grammar CRUDForge;

start       : entityDecl fieldsBlock indexesBlock? apiBlock? uiBlock? EOF;

entityDecl  : ENTITY ID;
fieldsBlock : FIELDS COLON fieldDecl+;
fieldDecl   : ID type constraint*;
type        : UUID | STRING | INT | DECIMAL | BOOL | DATE | REFERENCE ID;
constraint  : PK
            | REQUIRED
            | MIN EQUAL NUMBER
            | DEFAULT EQUAL literal
            | GT NUMBER
            | LT NUMBER
            | UNIQUE
            ;
indexesBlock: INDEXES COLON idList;
apiBlock    : API apiMode WITH apiOption+;
uiBlock     : UI GENERATE WITH uiOption+;

apiMode     : FULL | BASIC;
apiOption   : PAGINATION | SEARCH;
uiOption    : FILTERS | SORTABLE;
idList      : ID (COMMA ID)*;
literal     : NUMBER | STRING_LITERAL | ID;

ENTITY      : 'entity';
FIELDS      : 'fields';
INDEXES     : 'indexes';
API         : 'api';
UI          : 'ui';
WITH        : 'with';
GENERATE    : 'generate';
FULL        : 'full';
BASIC       : 'basic';
PAGINATION  : 'pagination';
SEARCH      : 'search';
FILTERS     : 'filters';
SORTABLE    : 'sortable';
UUID        : 'uuid';
STRING      : 'string';
INT         : 'int';
DECIMAL     : 'decimal';
BOOL        : 'bool';
DATE        : 'date';
REFERENCE   : 'reference';
PK          : 'pk';
REQUIRED    : 'required';
MIN         : 'min';
DEFAULT     : 'default';
UNIQUE      : 'unique';
GT          : '>';
LT          : '<';
COLON       : ':';
COMMA       : ',';
EQUAL       : '=';
NUMBER      : [0-9]+ ('.' [0-9]+)?;
ID          : [a-zA-Z_][a-zA-Z0-9_]*;
STRING_LITERAL : '"' (~["\\] | '\\' .)* '"';
WS          : [ \t\r\n]+ -> skip;
COMMENT     : '//' ~[\r\n]* -> skip;
