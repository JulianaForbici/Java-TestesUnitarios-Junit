# Exercícios POO — Vendas (branch: master)

Este repositório (branch `master`) contém 4 exercícios relacionados a um sistema simples de vendas, implementados em Java.

Resumo dos exercícios presentes na branch `master`
1. Exercício 1 — Produto  
   - Classe `Produto` (package `ExerciciosPoo.Vendas`)  
   - Construtor que chama os setters, getters e validações de entrada (código, valor, descrição).  
2. Exercício 2 — ItemPedido  
   - Classe `ItemPedido` (package `ExerciciosPoo.Vendas`)  
   - Construtor que chama os setters; captura um snapshot do preço do `Produto` no momento da criação; calcula subtotal.  
3. Exercício 3 — Pedido  
   - Classe `Pedido` (package `ExerciciosPoo.Vendas`)  
   - Mantém lista de `ItemPedido`, soma subtotais e expõe `obterValorPedido()`; contém um `main` simples para demonstração.  
4. Exercício 4 — Testes unitários (JUnit 5)  
   - Testes para as três classes acima: `ProdutoTest`, `ItemPedidoTest`, `PedidoTest` (package `ExerciciosPoo.Vendas`)  
   - Os testes cobrem criação válida, validações (exceções) e comportamento do snapshot de preço; verificações de `toString` usam `String.format` para serem robustas a `Locale`.

Estrutura de diretórios (exemplo)
- src/main/java/ExerciciosPoo/Vendas/Produto.java  
- src/main/java/ExerciciosPoo/Vendas/ItemPedido.java  
- src/main/java/ExerciciosPoo/Vendas/Pedido.java  
- src/test/java/ExerciciosPoo/Vendas/ProdutoTest.java  
- src/test/java/ExerciciosPoo/Vendas/ItemPedidoTest.java  
- src/test/java/ExerciciosPoo/Vendas/PedidoTest.java

Requisitos e execução
- Java: recomendado JDK 11 (as classes e testes foram desenvolvidas com Java 11 em mente).  
- Para executar o `main` de demonstração: abra a classe `ExerciciosPoo.Vendas.Pedido` e execute sua função `main` no IDE.  
- Para rodar os testes (usando Maven):  
  - mvn test  
- Ou execute os testes diretamente no seu IDE (IntelliJ / Eclipse) com suporte a JUnit 5.

Observações
- As classes foram implementadas com validações simples e mensagens de exceção claras.  
- O `Pedido` preserva a soma acumulada dos subtotais em um campo `valorTotal` atualizado quando itens são adicionados; cada `ItemPedido` mantém um snapshot do preço unitário no momento da inclusão.  
- O `main` em `Pedido` é apenas para demonstração manual e não é coberto pelos testes unitários.
