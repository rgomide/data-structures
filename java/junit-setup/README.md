# JUnit Setup

Este repositório possui um projeto Maven configurado para executar testes com a biblioteca JUnit 5.

## Sumário

- [Configurações](#configurações)
  - [1. Adicionar Dependência do JUnit no POM.xml](#1-adicionar-dependência-do-junit-no-pomxml)
  - [2. Estrutura de Diretórios do Projeto](#2-estrutura-de-diretórios-do-projeto)
  - [3. Criar uma Classe de Teste](#3-criar-uma-classe-de-teste)
  - [4. Executar os Testes](#4-executar-os-testes)
  - [5. Conceitos Básicos do JUnit](#5-conceitos-básicos-do-junit)
    - [Anotações Importantes](#anotações-importantes)
    - [Assertivas do JUnit](#assertivas-do-junit)
- [Relatório de cobertura](#relatório-de-cobertura)
- [Exercícios](#exercícios)

## Configurações

### 1. Adicionar Dependência do JUnit no POM.xml

Você deve adicionar a dependência do JUnit no arquivo pom.xml do seu projeto Maven. Isso garante que o Maven baixe e inclua a biblioteca JUnit no classpath do projeto.

```xml
<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter</artifactId>
  <version>5.10.3</version>
  <scope>test</scope>
</dependency>
```

O elemento `<scope>test</scope>` indica que essa dependência só será usada na fase de teste do build.

### 2. Estrutura de Diretórios do Projeto

Certifique-se de que o seu projeto siga a estrutura padrão do Maven:

```
project-root
|-- src
    |-- main
    |   |-- java
    |-- test
        |-- java
```

Os arquivos de teste devem ser colocados na pasta src/test/java.

### 3. Criar uma Classe de Teste

Crie uma classe de teste dentro do diretório src/test/java. Se estiver usando JUnit 5, use anotações como @Test para definir métodos de teste.

#### Exemplo de uma classe de teste com JUnit 5:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    @Test
    void testSomar() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.somar(2, 3), "2 + 3 deve ser 5");
    }

    @Test
    void testSubtrair() {
        Calculadora calc = new Calculadora();
        assertEquals(1, calc.subtrair(3, 2), "3 - 2 deve ser 1");
    }
}
```

### 4. Executar os Testes

Você pode executar os testes usando o Maven através da linha de comando:

```bash
mvn test
```

Este comando compila o projeto e executa todos os testes encontrados na pasta src/test/java.

### 5. Conceitos Básicos do JUnit

#### Anotações Importantes

- `@Test`: Indica que o método é um caso de teste.
- `@BeforeEach` e `@AfterEach`: Executados antes e depois de cada teste, respectivamente.
- `@BeforeAll` e `@AfterAll`: Executados uma vez antes e depois de todos os testes.
- `@DisplayName`: Fornecer um nome legível e descritivo aos métodos de teste e classes de teste.
- `@Nested`: Permite dividir um conjunto de testes em grupos logicamente relacionados, facilitando a leitura e manutenção dos testes. Cada classe aninhada pode ter seu próprio estado de configuração (`@BeforeEach`) e limpeza (`@AfterEach`), permitindo um controle mais granular sobre o ambiente de teste.

#### Assertivas do JUnit

As assertivas são usadas para validar o comportamento esperado do código. Aqui estão algumas das principais assertivas do JUnit:

- `assertEquals(expected, actual)`: Verifica se os valores esperados e atuais são iguais.

  ```java
  int expected = 5;
  int actual = 5;
  assertEquals(expected, actual, "Os valores esperados e atuais devem ser iguais");
  ```
- `assertTrue(condition)`: Verifica se a condição é verdadeira.

  ```java
  assertTrue(3 > 2, "A condição deve ser verdadeira");
  ```

- `assertFalse(condition)`: Verifica se a condição é falsa.

  ```java
  assertFalse(3 < 2, "A condição deve ser falsa");
  ```

- `assertNull(object)`: Verifica se o objeto é nulo.

  ```java
  String obj = null;
  assertNull(obj, "O objeto deve ser nulo");
  ```

- `assertNotNull(object)`: Verifica se o objeto não é nulo.

  ```java
  String obj = "Hello";
  assertNotNull(obj, "O objeto não deve ser nulo");
  ```

- `assertThrows(expectedType, executable)`: Verifica se o lançamento de uma exceção ocorre conforme esperado.

  ```java
  assertThrows(IllegalArgumentException.class, () -> {
      throw new IllegalArgumentException("Exceção esperada");
  }, "Uma exceção do tipo esperado deve ser lançada");
  ```

- `assertArrayEquals(expectedArray, actualArray)`: Verifica se dois arrays são iguais, elemento por elemento.

  ```java
  int[] expectedArray = {1, 2, 3};
  int[] actualArray = {1, 2, 3};
  assertArrayEquals(expectedArray, actualArray, "Os arrays devem ser iguais");
  ```

- `assertIterableEquals(expectedIterable, actualIterable)`: Verifica se duas coleções iteráveis (como listas) são iguais, elemento por elemento.

  ```java
  List<String> expectedList = Arrays.asList("A", "B", "C");
  List<String> actualList = Arrays.asList("A", "B", "C");
  assertIterableEquals(expectedList, actualList, "As listas devem ser iguais");
  ```

## Relatório de cobertura

Certifique-se que você possui o Maven CLI instalado e execute o comando:
```
mvn jacoco:prepare-agent test install jacoco:report
```

## Exercícios

### 1. Classe VetorUtil

Implemente a classe `VetorUtil` que realiza a interface [IVetorUtil](./src/main/java/br/com/junitsetup/exercicio/IVetorUtil.java). Comece eleborando os casos de teste para cada um dos métodos contidos em [IVetorUtil](./src/main/java/br/com/junitsetup/exercicio/IVetorUtil.java). 

Os testes devem cobrir os fluxos primários e de exceções de cada método.

## Referências
- [Maven - Download Apache Maven](https://maven.apache.org/download.cgi)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions)