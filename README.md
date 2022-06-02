# Projeto da Disciplina de Paradigmas de Linguagem de Programação do PPGCC do Cin UFPE

[git@github.com:nandooliveira/Projeto-PLP-rbcs-bfao-.git](git@github.com:nandooliveira/Projeto-PLP-rbcs-bfao-.git)

## Equipe

- Rafael Borba - rbcs@cin.ufpe.br
- Benedito Fernando - bfao@cin.ufpe.br

## Projeto

Esse projeto tem como objetivo incluir o tratamento de exceções na Linguagem Imperativa 1. Serão tratadas exceções em 3 casos:

1. Exceções lançadas automaticamente pela linguagem
    - Nessa versão, a única possibilidade da linguagem lançar um exceção automaticamente será em erros de divisão por zero.
2. Exceções lançadas pelo programador que está utilizando a linguagem
    - Para isso o programador usará o comando `throw` passado uma mensagem de erro:
        - Ex.: `throw("throw str")`
3. Exceções lançadas pelo Java diretamente
    - Ex.: `java.lang.OutOfMemoryError`

Os erros passados para o comando `throw` podem ser de 3 tipos diferentes: string, integer ou boolean, que são os tipos atualmente suportados pela linguagem imperativa 1.

## Apresentação

[[https://docs.google.com/presentation/d/1LTO1BQLRRKQlETjdm6zV86M6Jq4s3TpqKM9xo5H4v2E/edit#slide=id.p](https://docs.google.com/presentation/d/1tHAcwRArJtgYlsCDZocfr3qsbFYZ0f9rjxHTZbwrSR4/edit?usp=sharing)]([https://docs.google.com/presentation/d/1LTO1BQLRRKQlETjdm6zV86M6Jq4s3TpqKM9xo5H4v2E/edit#slide=id.p](https://docs.google.com/presentation/d/1tHAcwRArJtgYlsCDZocfr3qsbFYZ0f9rjxHTZbwrSR4/edit?usp=sharing))

## Contexto

A maioria das linguagens possui mecanismos para manipulação de erros em tempo de execução, conhecidos como exceções. Essa funcionalidade deve permitir o lançamento automático de exceções naturais (e.g. divisão por zero, out of bounds de arrays), bem como um operador para lançar uma exceção genérica, de acordo com a lógica do programa (throw). A exceção é avaliada
como uma string, contendo uma simples mensagem de erro. Também deve existir um operador para definir o escopo em que uma exceção pode ser lançada (try), seguido de uma rotina de tratamento (catch).

## Gramática

[Gramática no JAVACC](https://github.com/nandooliveira/Projeto-PLP-rbcs-bfao/blob/main/workspace/src/li1/plp/imperative1/parser/Imperative1.jj#L17)

### BNF
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

## Estrutura de Arquivos / Diretórios

|Arquivo / Diretório           | Descrição                                          |
|------------------------------|----------------------------------------------------|
| `/applet.jar`                | O applet do professor pra testar as linguagens     |
| `/javacc.jar`                | A versão do javacc que tem na página da disciplina |
| `/workspace`                 | Projeto Java (Usamos o Eclipse)                    |
| `/workspace/programa.txt`    | Um programa escrito em Li1 para testar             |

## Configurações para execução:

1. Importar o projeto no Eclipse;
2. Clique com o botão direto no projeto;
3. Selecione `Run as -> Run Configurations`;
4. Selecione `Java Application` na lista do lado esquerdo;
5. Selecione a aba `Arguments` no lado direito;
6. Inclua o caminho para o arquivo `programa.txt` no input `Program Arguments`;
    - > Padrão: C:\paradigmas\plp-rbcs-bfao\workspace\programa.txt
7. Clique em `Apply`;
8. Agora clique em `Run as -> Java Application`
