# Java - Testes Unitários com JUnit

Repositório com exemplos e exercícios práticos focados em testes unitários em Java usando JUnit (recomendado JUnit 5). O objetivo é exercitar boas práticas de testes, cobertura e uso de recursos como testes parametrizados, lifecycle e validação de casos de borda.

## Conteúdo do repositório
- src/main/java — código das implementações dos exercícios.
- src/test/java — testes unitários (JUnit), incluindo testes parametrizados e casos de borda.
- README.md — este arquivo.

## Exercícios propostos

### 01 - Ordenação de 5 números inteiros
- Implementar algoritmo que recebe 5 números inteiros e retorna os 5 números ordenados (ordem crescente).
- Restrição importante: **não usar vetor, lista ou qualquer classe/utilitário que faça ordenação automaticamente**. A ideia é implementar a lógica manualmente (ex.: comparações e trocas entre variáveis).
- Validações e testes a cobrir:
  - Casos já ordenados, inversamente ordenados, ordenação parcial.
  - Repetição de valores (valores iguais).
  - Valores extremos: Integer.MIN_VALUE e Integer.MAX_VALUE.
  - Entradas inválidas (se houver contrato que impeça certos valores) — trate com exceção documentada.

### 02 - Conversor para Algarismos Romanos
- Implementar conversor que transforma um inteiro (1..3999) em sua representação em números romanos.
- Regras: siga o sistema usual de numerais romanos (I, V, X, L, C, D, M) e as regras de subtração padrão.
- Validação: se o número for menor que 1 ou maior que 3999, lançar uma exceção (por exemplo, IllegalArgumentException) com mensagem clara.
- Testes obrigatórios:
  - Casos básicos: 1 -> I, 4 -> IV, 9 -> IX, 40 -> XL, 90 -> XC, 400 -> CD, 900 -> CM, 1000 -> M.
  - Exemplos compostos (1984, 3999, etc.).
  - Valores limites: 1, 3999.
  - Valores inválidos: 0, -1, 4000 -> devem lançar exceção.
  - Testes parametrizados cobrindo uma tabela de entradas/saídas conhecidas.

## Como executar os testes
Caso o projeto use Maven:
- Para rodar todos os testes:
  mvn test

## Dependências recomendadas
- JUnit 5 (jupiter)

## Convenções e estrutura
- src/main/java — implementação
- src/test/java — testes
