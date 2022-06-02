# Projeto da Disciplina de Paradigmas de Linguagem de Programação do PPGCC do Cin UFPE

[git@github.com:nandooliveira/Projeto-PLP-rbcs-bfao-.git](git@github.com:nandooliveira/Projeto-PLP-rbcs-bfao-.git)

## PROJETO

Visa a implementação de tratamento de exceção no Paradigma Imperativo (Linguagem Imperativa 1).

## EQUIPE

- Rafael Borba - rbcs@cin.ufpe.br
- Benedito Fernando - bfao@cin.ufpe.br

## Apresentação

[https://docs.google.com/presentation/d/1LTO1BQLRRKQlETjdm6zV86M6Jq4s3TpqKM9xo5H4v2E/edit#slide=id.p](https://docs.google.com/presentation/d/1LTO1BQLRRKQlETjdm6zV86M6Jq4s3TpqKM9xo5H4v2E/edit#slide=id.p)

## CONTEXTO

A maioria das linguagens possui mecanismos para manipulação de erros em tempo de execução, conhecidos como exceções. Essa funcionalidade deve permitir o lançamento automático de exceções naturais (e.g. divisão por zero, out of bounds de arrays), bem como um operador para lançar uma exceção genérica, de acordo com a lógica do programa (throw). A exceção é avaliada
como uma string, contendo uma simples mensagem de erro. Também deve existir um operador para definir o escopo em que uma exceção pode ser lançada (try), seguido de uma rotina de tratamento (catch).

# Gramática

<big><pre>
Programa ::= Comando
Comando ::= Atribuicao
&nbsp;            | ComandoDeclaracao
&nbsp;            | While
&nbsp;            | IfThenElse
&nbsp;            | IO
&nbsp;            | Comando ";" Comando
&nbsp;            | Skip
&nbsp;            [**| Throw**](https://github.com/nandooliveira/Projeto-PLP-rbcs-bfao/blob/main/workspace/src/li1/plp/imperative1/command/Throw.java#L11)
&nbsp;            [**| TryCatch**](https://github.com/nandooliveira/Projeto-PLP-rbcs-bfao/blob/main/workspace/src/li1/plp/imperative1/command/TryCatch.java#L13)
Skip ::=
Atribuicao ::= Id ":=" Expressao
Expressao ::= Valor | ExpUnaria | ExpBinaria | Id
Valor ::= ValorConcreto
ValorConcreto ::= ValorInteiro | ValorBooleano | ValorString
ExpUnaria ::= "-" Expressao | "not" Expressao | "length" Expressao
ExpBinaria ::= Expressao "+" Expressao
&nbsp;            | Expressao "-" Expressao
&nbsp;            | Expressao "and" Expressao
&nbsp;            | Expressao "or" Expressao
&nbsp;            | Expressao "==" Expressao
&nbsp;            | Expressao "++" Expressao
&nbsp;            [**| Expressao "/" Expressao**](https://github.com/nandooliveira/Projeto-PLP-rbcs-bfao/blob/main/workspace/src/li1/plp/expressions2/expression/ExpDiv.java#L14)
ComandoDeclaracao :: = "{" Declaracao ";" Comando "}"
Declaracao ::= DeclaracaoVariavel |  DeclaracaoComposta
DeclaracaoVariavel ::= "var" Id "=" Expressao
DeclaracaoComposta ::= Declaracao "," Declaracao
While ::= "while" Expressao "do" Comando
IfThenElse ::= "if" Expressao "then" Comando "else" Comando
IO ::= "write" "(" Expressao ")" | "read" "(" Id ")“
[**TryCatch ::= "try" Comando "catch" Id Comando**](https://github.com/nandooliveira/Projeto-PLP-rbcs-bfao/blob/main/workspace/src/li1/plp/imperative1/command/TryCatch.java#L13)
[**Throw := "throw" valorString**](https://github.com/nandooliveira/Projeto-PLP-rbcs-bfao/blob/main/workspace/src/li1/plp/imperative1/command/Throw.java#L11)
</pre></big>
