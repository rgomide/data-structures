# JUnit Setup

Projeto Maven configurado para executar tests com a biblioteca JUnit.

## Relatório de cobertura

Certifique-se que você possui o Maven CLI instalado e execute o comando:
```
mvn jacoco:prepare-agent test install jacoco:report
```

## Exercícios

### Classe VetorUtil
Implemente a classe `VetorUtil` que realize a interface [IVetorUtil](./src/main/java/br/com/junitsetup/exercicio/IVetorUtil.java). Comece eleborando os casos de teste para cada um dos métodos contidos na interface. 

## Referências
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions)