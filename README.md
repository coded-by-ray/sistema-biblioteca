# Sistema de Biblioteca (Java POO + PostgreSQL)

Projeto desenvolvido para a formação **Desenvolvedor Full Stack Júnior**, aplicando conceitos de **Programação Orientada a Objetos em Java** e **Modelagem e Consultas em Banco de Dados Relacional (PostgreSQL)**.

---

## Objetivo do Projeto

Simular o controle de acervo e empréstimos de uma biblioteca de bairro, lidando com diferentes categorias de itens (Livros e Revistas) e perfis de usuários (Alunos e Professores), cada um com regras específicas de prazo, multa e limite de empréstimos simultâneos.

### Regras de Negócio
* **Livros:** Prazo de devolução de **14 dias** e multa de **R$ 0,50/dia** de atraso.
* **Revistas:** Prazo de devolução de **7 dias** e multa de **R$ 1,00/dia** de atraso.
* **Alunos:** Podem pegar até **3 itens** simultaneamente.
* **Professores:** Podem pegar até **5 itens** simultaneamente.

---

## Estrutura do Repositório

```text
sistema-biblioteca/
├── README.md
├── java-poo/
│   └── src/
│       ├── ItemBiblioteca.java
│       ├── Livro.java
│       ├── Revista.java
│       ├── Usuario.java
│       ├── Aluno.java
│       ├── Professor.java
│       ├── Biblioteca.java
│       └── Main.java
└── sql-postgres/
    ├── schema_e_dados.sql
    └── consultas.sql