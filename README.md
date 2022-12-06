## B. 
## Grammar Rules for the Language
- START -> lecture BLOCK
- BLOCK -> { STMT } $END
- STMT -> ASSIGNMENT | LOOPING | ADDMINUS | MULDIVMOD
- ASSIGNMENT -> $ FACTOR ;
- LOOPING -> HA_STMT | DURING_STMT
- ADDMINUS -> $$ FACTOR { ( + | - | = ) FACTOR }
- MULDIVMOD -> $$$ FACTOR { ( * | / | % ) FACTOR }
- FACTOR -> id | int_lit | float_int | ( EXPR )
- END -> hahaha

- HA_STMT -> ha ( BOOL_EXPR ) STMT [ lol STMT ]     
- DURING_STMT -> during ( BOOL_EXPR ) STMT                

- BOOL_EXPR -> B_EQ      
- B_EQ -> [!]B_EXPR { ( == | != | <= | < | >= | > ) B_EXPR }
- B_EXPR -> B_TERM { ( + | - ) B_TERM }
- B_TERM -> B_FACT { ( * | / | % ) B_FACT }
- B_FACT -> id | int_lit | float_int | ( EXPR )

## Grammar Syntax Notation:
- START: lecture BLOCK
- BLOCK: { STMT } $END
- STMT: ASSIGNMENT | LOOPING | ADDMINUS | MULDIVMOD
- ASSIGNMENT: `$` FACTOR `;`
- LOOPING: HA_STMT | DURING_STMT
- ADDMINUS -> `$$` FACTOR { ( + | - | = ) FACTOR }
- MULDIVMOD -> `$$$` FACTOR { ( * | / | % ) FACTOR }
- FACTOR -> `id` | `int_lit` | `float_int` | `(` EXPR `)`
- END -> hahaha

- HA_STMT -> `ha` `(` BOOL_EXPR `)` STMT [ `lol` STMT ]     
- DURING_STMT -> `during` `(` BOOL_EXPR `)` STMT                

- BOOL_EXPR -> B_EQ    
- B_EQ -> [`!`]B_EXPR { ( `==` | `!=` | `<=` | `<` | `>=` | `>` ) B_EXPR }
- B_EXPR -> B_TERM { ( `+` | `-` ) B_TERM }
- TERM -> NOT { ( `*` | `/` | `%` ) NOT }
- B_FACT -> `id` | `int_lit` | `float_int` | `(` EXPR `)`

## Legend: 
```
ha = if in if statement
lol = else in else statement
during = while in while statement
ehh = or 
uhh = and
`...` = (`) to indicate character literal to detect for each rule
```
