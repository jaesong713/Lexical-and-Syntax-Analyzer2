## A. 
The tokens are stored in a hash map corresponding to their respective qualifiers.

        public static HashMap<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put("LETTER", 0);                 // letters
        myMap.put("DIGIT", 1);                  // any number
        myMap.put("UNKNOWN", 99);               // the unknown character
        myMap.put("INT_LIT", 10);               // integers
        myMap.put("FLOAT_LIT", 11);             // floating point numbers
        myMap.put("IDENT", 12);                 // identifiers
        myMap.put("ASSIGN_OP", 20);             // the assignment operation ( = )
        myMap.put("ADD_OP", 21);                // addition operator ( + )
        myMap.put("SUB_OP", 22);                // subtraction operator ( - )
        myMap.put("MULT_OP", 23);               // multiplication operator ( * )
        myMap.put("DIV_OP", 24);                // division operator ( / )
        myMap.put("MODU", 25);                  // modulus operator ( % ) 
        myMap.put("LEFT_PAREN", 26);            // left parentheses 
        myMap.put("RIGHT_PAREN", 27);           // right parentheses
        myMap.put("LEFT_CURLY", 28);            // left curly bracket
        myMap.put("RIGHT_CURLY", 29);           // right curly bracket
        myMap.put("SEMICO", 30);                // semicolon
        myMap.put("EQ", 31);                    // equals to operator ( == )
        myMap.put("NOT_EQ", 32);                // not equals operator ( != )
        myMap.put("LESS_EQ", 33);               // less than or equal to operator ( <= )
        myMap.put("LESSTH", 34);                // less than operator ( < )
        myMap.put("GRE_EQ", 35);                // greater than or equal to operator ( >= )
        myMap.put("GRE", 36);                   // greater than opeartor ( > )
        myMap.put("NO", 37);                    // not operator ( ! )
        myMap.put("START", 38);                 // start statement to start program ( lecture )
        myMap.put("END", 39);                   // end statemenet to terminate program ( hahaha )
        myMap.put("HA_STMT", 40);               // ha statement to start ha statement ( ha )
        myMap.put("ELSE_STMT", 41);             // else statement ( lol )
        myMap.put("DURING_STMT", 42);           // during statement ( during )
        myMap.put("INITIALIZE", 45);            // statement to start initialization ( $ ) 
        myMap.put("ADD_SUB", 46);               // statement to start addition or subraction ( $$ )
        myMap.put("MUL_DIV_MOD", 47);           // statement to start multiplication, division or modulus ( $$$ )

## B. 
## Grammar Rules for the Language
- START -> 'lecture' BLOCK
- BLOCK -> '{' STMT '}' $END        $ indicating that the block should end with the end statement
- STMT -> ASSIGNMENT| LOOPING | ADDMINUS | MULDIVMOD
- ASSIGNMENT -> '$'FACTOR IDENT';'
- LOOPING -> HA_STMT | DURING_STMT
- ADDMINUS -> '$$' IDENT { (+ | - | =) IDENT } ';'
- MULDIVMOD -> '$$$' IDENT { (* | / | %) IDENT } ';'
- IDENT -> 'id' | 'digit' | 'letter'
- FACTOR -> 'int_lit' | 'float_int'
- HA_STMT -> 'ha' '(' BOOL_EXPR ')' STMT [ 'lol' STMT ]      ha = if stmt
- DURING_STMT -> 'during' '(' BOOL_EXPR ')' STMT during = while stmt
- BOOL_EXPR -> B_EQ
- B_EQ -> [!]IDENT { ( '==' | '!=' | '<=' | '<' | '>=' | '>' ) IDENT }
- END -> 'hahaha'

## Grammar Syntax Notation:
- START: lecture BLOCK
- BLOCK: { STMT } $END
- STMT: ASSIGNMENT | LOOPING | ADDMINUS | MULDIVMOD
- ASSIGNMENT: `$` FACTOR IDENT `;`
- LOOPING: HA_STMT | DURING_STMT
- ADDMINUS -> `$$` IDENT { ( + | - | = ) IDENT }
- MULDIVMOD -> `$$$` IDENT { ( * | / | % ) IDENT }
- IDENT -> `id` | `digit` | `letter` 
- FACTOR -> `int_lit` | `float_lit`
- HA_STMT -> `ha` `(` BOOL_EXPR `)` STMT [ `lol` STMT ]     
- DURING_STMT -> `during` `(` BOOL_EXPR `)` STMT                
- BOOL_EXPR -> B_EQ    
- B_EQ -> [`!`]IDENT { ( `==` | `!=` | `<=` | `<` | `>=` | `>` ) IDENT }
- END -> hahaha

## Legend: 
```
ha = if in if statement
lol = else in else statement
during = while in while statement
ehh = or 
uhh = and
`...` = (`) to indicate character literal to detect for each rule
```
## C.
FIRST(START) -> {'lecture'}

FIRST(BLOCK) -> {'{'}

FIRST(STMT) -> {'$'} | {'HA', 'DURING'} | {'$$'} | {$$$}

FIRST(ASSIGNMENT) -> {'$'}

FIRST(LOOPING) -> {'HA'} | {'DURING'}

FIRST(ADDMINUS) -> {'$$'}

FIRST(MULDIVMOD) -> {'$$$'}

FIRST(IDENT) -> {'id'} | {'digit'} | {'letter'} 

FIRST(FACTOR) -> {'int_lit'} | {'float_lit'}

FIRST(HA_STMT) -> {'HA'}

FIRST(DURING_STMT) -> {'DURING'}

FIRST(BOOL_EXPR) -> {'!'} | {'id'} | {'digit'} | {'letter'}

FIRST(END) -> {'hahaha'}
## D.
Please refer to the nonambiguous.pptx file.

## E. 
Please refer to the lexical.java file in the java folder. The optimal scenario is for this program to read in my/your/his/her file and return the all lexemes and tokens according to the language that I have designed. It will also return errors if it does not recognize certain lexemes. To change through each file and see how it is implemented, simply change line 30 to your file of desire.

## F.
Please refer to the syntax.java filein the java folder. Although, it might not be optimal right now. It is set up to take in an array of tokens and process those tokens and then finally determine if the program follows the correct syntax. If not, it will throw an error.

## G.
I have developed new test files within the java folder. I apologize if the file names are not ideal but the type of files that they are will be listed below in the legend.

## Test File Legend  
```
pass1.txt - THIS IS AN OPTIMAL FILE
secondPass.txt - THIS IS AN OPTIMAL FILE
bad1.txt - THIS FILE WILL HAVE LEXICAL ERROR(S)
secondBad.txt - THIS FILE WILL HAVE SYNTAX ERROR(S)
```

## H. 
Please refer to partH.docx
