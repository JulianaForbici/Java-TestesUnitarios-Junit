# Java - Testes Unitários com JUnit

Repositório com exemplos e exercícios práticos focados em testes unitários em Java usando JUnit (recomendado JUnit 5). O objetivo é exercitar boas práticas de testes, cobertura e uso de recursos como testes parametrizados, lifecycle e validação de casos de borda.

> Observação importante:
> Ao implementar os exercícios, fiquem atentos à cobertura de testes unitários e parametrizados conforme visto em aula.
> É essencial validar casos críticos, como:
> - Limites de caracteres;
> - Tamanhos mínimo e máximo permitidos para atributos e variáveis;
> - Valores extremos (por exemplo, o maior e o menor número possível para tipos como int, double, etc.);
> - Comportamentos esperados em situações de borda ou entrada inválida.
>
> Esses testes ajudam a garantir que o código seja robusto e confiável em diferentes cenários.

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

Sugestões de testes:
- ordenarCincoNumeros_DeveRetornarCrescentemente
- ordenarCincoNumeros_ComValoresIguais_DeveManterOcorrencias
- ordenarCincoNumeros_ComExtremos_DeveFuncionarSemOverflow

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

Sugestões de testes:
- converteNumeroRomano_ValoresValidos_Parametrizado
- converteNumeroRomano_ValoresInvalidos_DeveLancarExcecao

## Requisitos de qualidade dos testes
- Cobertura: almejar alta cobertura nas classes de domínio e nas regras de negócio (cobertura de branchs e condições quando aplicável).
- Usar testes parametrizados para validar múltiplos casos de entrada/saída de forma legível.
- Testes pequenos, independentes e com nomes descritivos (ex.: shouldDoXWhenY).
- Evitar lógica complexa dentro dos testes.
- Usar @BeforeEach/@AfterEach para setup/teardown quando pertinente.
- Isolar dependências externas com mocks (Mockito) caso existam dependências injetáveis.
- Validar cenários de borda e extremos (Integer.MIN/MAX, limites de tamanhos, entradas nulas quando aplicável).

## Como executar os testes
Caso o projeto use Maven:
- Para rodar todos os testes:
  mvn test
- Relatórios:
  target/surefire-reports (e target/site/jacoco se configurado)

Caso o projeto use Gradle:
- Para rodar todos os testes:
  ./gradlew test
- Relatórios:
  build/reports/tests/test

Executar apenas uma classe de teste (Maven exemplo):
  mvn -Dtest=NomeDaClasseDeTeste test

Executar apenas um método (Maven exemplo):
  mvn -Dtest=NomeDaClasseDeTeste#nomeDoMetodo test

## Dependências recomendadas
- JUnit 5 (jupiter)
- Mockito (opcional, para mocks)
- JaCoCo (opcional, para cobertura)

## Convenções e estrutura
- src/main/java — implementação
- src/test/java — testes
- Nomenclatura:
  - Classe: Calculator
  - Teste: CalculatorTest (ou CalculatorTestCase)
- Use testes parametrizados (JUnit Params, @ParameterizedTest) quando for validar várias entradas/saídas.
