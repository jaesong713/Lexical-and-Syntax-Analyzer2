## A. 
        myMap.put("LETTER", 0);
        myMap.put("DIGIT", 1);
        myMap.put("UNKNOWN", 99);
        myMap.put("INT_FLOAT", 10);
        myMap.put("FLOAT_INT", 11);
        myMap.put("IDENT", 12);
        myMap.put("ASSIGN_OP", 20);
        myMap.put("ADD_OP", 21);
        myMap.put("SUB_OP", 22);
        myMap.put("MULT_OP", 23);
        myMap.put("DIV_OP", 24);
        myMap.put("MODU", 25);
        myMap.put("LEFT_PAREN", 26);
        myMap.put("RIGHT_PAREN", 27);
        myMap.put("LEFT_CURLY", 28);
        myMap.put("RIGHT_CURLY", 29);
        myMap.put("SEMICO", 30);
        myMap.put("EQ", 31);
        myMap.put("NOT_EQ", 32);
        myMap.put("LESS_EQ", 33);
        myMap.put("LESSTH", 34);
        myMap.put("GRE_EQ", 35);
        myMap.put("GRE", 36);
        myMap.put("NO", 37);
        myMap.put("START", 38);
        myMap.put("END", 39);
        myMap.put("HA_STMT", 40);
        myMap.put("ELSE_STMT", 41);
        myMap.put("DURING_STMT", 42);
        myMap.put("AAND", 43);
        myMap.put("OOR", 44);
        myMap.put("INITIALIZE", 45);
        myMap.put("ADD_SUB", 46);
        myMap.put("MUL_DIV_MOD", 47);

## B. 
## Grammar Rules for the Language
- START -> lecture BLOCK
- BLOCK -> { STMT } $END
- STMT -> ASSIGNMENT | LOOPING | ADDMINUS | MULDIVMOD
- ASSIGNMENT -> $ FACTOR ;
- LOOPING -> HA_STMT | DURING_STMT
- ADDMINUS -> $$ FACTOR { ( + | - | = ) FACTOR }
- MULDIVMOD -> $$$ FACTOR { ( * | / | % ) FACTOR }
- FACTOR -> id | int_lit | float_int 
- END -> hahaha

- HA_STMT -> ha ( BOOL_EXPR ) STMT [ lol STMT ]     
- DURING_STMT -> during ( BOOL_EXPR ) STMT                

- BOOL_EXPR -> B_EQ      
- B_EQ -> [!]B_EXPR { ( == | != | <= | < | >= | > ) B_EXPR }
- B_EXPR -> B_TERM { ( + | - ) B_TERM }
- B_TERM -> B_FACT { ( * | / | % ) B_FACT }
- B_FACT -> id | int_lit | float_int 

## Grammar Syntax Notation:
- START: lecture BLOCK
- BLOCK: { STMT } $END
- STMT: ASSIGNMENT | LOOPING | ADDMINUS | MULDIVMOD
- ASSIGNMENT: `$` FACTOR `;`
- LOOPING: HA_STMT | DURING_STMT
- ADDMINUS -> `$$` FACTOR { ( + | - | = ) FACTOR }
- MULDIVMOD -> `$$$` FACTOR { ( * | / | % ) FACTOR }
- FACTOR -> `id` | `int_lit` | `float_int` 
- END -> hahaha

- HA_STMT -> `ha` `(` BOOL_EXPR `)` STMT [ `lol` STMT ]     
- DURING_STMT -> `during` `(` BOOL_EXPR `)` STMT                

- BOOL_EXPR -> B_EQ    
- B_EQ -> [`!`]B_EXPR { ( `==` | `!=` | `<=` | `<` | `>=` | `>` ) B_EXPR }
- B_EXPR -> B_TERM { ( `+` | `-` ) B_TERM }
- TERM -> NOT { ( `*` | `/` | `%` ) NOT }
- B_FACT -> `id` | `int_lit` | `float_int` 

## Legend: 
```
ha = if in if statement
lol = else in else statement
during = while in while statement
ehh = or 
uhh = and
`...` = (`) to indicate character literal to detect for each rule
```
