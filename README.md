# Projeto da Disciplina de Paradigmas de Linguagem de Programação do PPGCC do Cin UFPE

[git@github.com:nandooliveira/Projeto-PLP-rbcs-bfao-.git](git@github.com:nandooliveira/Projeto-PLP-rbcs-bfao-.git)

## PROJETO

Visa a implementação de tratamento de exceção no Paradigma Imperativo (Linguagem Imperativa 1).

## EQUIPE

- Rafael Borba - rbcs@cin.ufpe.br
- Benedito Fernando - bfao@cin.ufpe.br

## CONTEXTO

A maioria das linguagens possui mecanismos para manipulação de erros em tempo de execução, conhecidos como exceções. Essa funcionalidade deve permitir o lançamento automático de exceções naturais (e.g. divisão por zero, out of bounds de arrays), bem como um operador para lançar uma exceção genérica, de acordo com a lógica do programa (throw). A exceção é avaliada
como uma string, contendo uma simples mensagem de erro. Também deve existir um operador para definir o escopo em que uma exceção pode ser lançada (try), seguido de uma rotina de tratamento (catch).

ESBOÇO DA BNF

```bnf
Programa ::= Comando
Comando ::= Atribuicao
            | ComandoDeclaracao
            | While
            | IfThenElse
            | IO
            | Comando ";" Comando
            | Skip
            | Throw
            | Try
Skip ::=
Atribuicao ::= Id ":=" Expressao
Expressao ::= Valor | ExpUnaria | ExpBinaria | Id
Valor ::= ValorConcreto
ValorConcreto ::= ValorInteiro | ValorBooleano | ValorString
ExpUnaria ::= "-" Expressao | "not" Expressao | "length" Expressao
ExpBinaria ::= Expressao "+" Expressao
            | Expressao "-" Expressao
            | Expressao "and" Expressao
            | Expressao "or" Expressao
            | Expressao "==" Expressao
            | Expressao "++" Expressao
ComandoDeclaracao :: = "{" Declaracao ";" Comando "}"
Declaracao ::= DeclaracaoVariavel |  DeclaracaoComposta
DeclaracaoVariavel ::= "var" Id "=" Expressao
DeclaracaoComposta ::= Declaracao "," Declaracao
While ::= "while" Expressao "do" Comando
IfThenElse ::= "if" Expressao "then" Comando "else" Comando
IO ::= "write" "(" Expressao ")" | "read" "(" Id ")“
Try ::= "try" Comando "catch" Id Comando
Throw := "throw" valorString
```
