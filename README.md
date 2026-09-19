# Sistema de Gestão de Biblioteca Municipal (Java)

Trabalho de Campo da disciplina de **Introdução a Algoritmos e Programação** do Curso de Licenciatura em Engenharia Informática da **Universidade Aberta ISCED (UnISCED)**.

---

##  Descrição do Projeto
O sistema permite automatizar a gestão de acervo, o registo de leitores e o histórico de requisições e devoluções numa Biblioteca Municipal. Opera em modo consola e manipula a base de dados simulada em memória utilizando **vetores/arrays unidimensionais** e **matrizes bidimensionais**.

---

##  Estrutura de Ficheiros
- `src/Obra.java`: Modelo representativo das obras literárias no acervo.
- `src/Leitor.java`: Modelo representativo dos utilizadores/leitores.
- `src/Requisicao.java`: Modelo para associar requisições entre leitores e obras.
- `src/GestorBiblioteca.java`: Módulo de serviço com a lógica de negócio, controlo de vetores e matrizes transacionais.
- `src/ValidadorEntrada.java`: Módulo de utilidade para validação e tratamento de exceções de entrada.
- `src/Principal.java`: Classe de execução com menu interativo na consola.

---

##  Como Compilar e Executar

1. **Clonar o Repositório:**
   ```bash
   git clone [https://github.com/TEU_UTILIZADOR/sistema-biblioteca-unisced.git](https://github.com/TEU_UTILIZADOR/sistema-biblioteca-unisced.git)
   cd sistema-biblioteca-unisced

Compilar todos os ficheiros Java:
 ```bash
javac src/*.java
```

Executar a aplicação:
```bash
java -cp src Principal
```

## Autor
Estudante: Igor Gervasio

Curso: Licenciatura em Engenharia Informática

Instituição: Universidade Aberta ISCED (UnISCED)
