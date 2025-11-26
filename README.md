# Java - Testes Unitários (JUnit)

Repositório para guardar os exercícios do curso de Testes Unitários em Java (JUnit). Aqui você encontrará exemplos, exercícios resolvidos e casos de testes que acompanham o aprendizado prático do curso.

## Objetivo
Organizar e versionar os exercícios do curso de forma clara, para consulta posterior e para servir como material de apoio prático ao estudo de testes unitários com JUnit.

## Estrutura sugerida do repositório
- src/main/java/… - código fonte (quando houver exercícios com implementação)
- src/test/java/… - classes de teste JUnit
- README.md - documentação do repositório (este arquivo)
- docs/ - anotações, cheatsheets, prints e materiais auxiliares (opcional)
- exercises/ - pastas por aula/exercício com enunciado e solução (opcional)

Exemplo:
- exercises/aula-01-nome-da-aula/
  - README.md (enunciado)
  - src/main/java/...
  - src/test/java/...

## Pré-requisitos
- Java JDK 11+ (ou versão usada no curso)
- Maven ou Gradle (dependendo do setup do exercício)
- IDE (IntelliJ, Eclipse, VS Code) recomendada para rodar e depurar testes

## Como executar os testes
Se o projeto usa Maven:
- Instalar dependências e rodar todos os testes:
  mvn test

Se o projeto usa Gradle:
- Com wrapper:
  ./gradlew test
- Ou com Gradle instalado:
  gradle test

Também é possível rodar testes direto pela IDE (run → Test) ou utilizando o JUnit Platform Console, se configurado.

## Boas práticas ao adicionar exercícios
- Crie uma pasta por exercício/aula com um README explicando:
  - enunciado curto
  - requisitos
  - instruções de execução
- Separe código de produção (src/main/java) de testes (src/test/java)
- Dê nomes descritivos às classes de teste, por exemplo: NomeDaClasseTest
- Escreva testes pequenos, independentes e legíveis
- Documente suposições e limites nos comentários do exercício

## Convenções de commits e branches
- Branch principal: main
- Feature/Exercício: use branches com nomes como `exercicio/aula-03-nome`
- Mensagens de commit: sejam curtas e descritivas, ex: "feat: adicionar exercícios da aula 03 - cálculos"

## Como contribuir
1. Fork o repositório
2. Crie uma branch para sua alteração: `git checkout -b exercicio/aula-04-meu-exercicio`
3. Adicione o exercício e testes
4. Abra um Pull Request descrevendo:
   - que aula/exercício adicionou
   - como rodar os testes
   - observações importantes

## Exemplos úteis
- Exemplo de nome de teste: CalculatorTest.java
- Exemplo de método de teste:
  - @Test
    void soma_deve_retornar_valor_correto() { ... }

## Contato
Maintainer: Juliana Forbici (JulianaForbici)
