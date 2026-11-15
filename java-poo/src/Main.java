public class Main {
    public static void main(String[] args) {
        // Criando biblioteca com espaço para 10 itens e 5 usuários
        Biblioteca biblioteca = new Biblioteca(10, 5);

        // 1. Cadastrando itens
        ItemBiblioteca livro1 = new Livro("L01", "Clean Code");
        ItemBiblioteca livro2 = new Livro("L02", "Java Efetivo");
        ItemBiblioteca revista1 = new Revista("R01", "Superinteressante");
        ItemBiblioteca revista2 = new Revista("R02", "National Geographic");

        biblioteca.cadastrarItem(livro1);
        biblioteca.cadastrarItem(livro2);
        biblioteca.cadastrarItem(revista1);
        biblioteca.cadastrarItem(revista2);

        // 2. Cadastrando usuários
        Usuario aluno = new Aluno("Rayssa");
        Usuario professor = new Professor("Prof. Marcos");

        biblioteca.cadastrarUsuario(aluno);
        biblioteca.cadastrarUsuario(professor);

        // Lista inicial (todos disponíveis)
        biblioteca.listarAcervo();

        // 3. Empréstimos bem-sucedidos (Aluno pode até 3)
        biblioteca.emprestar(aluno, livro1);   // 1º item
        biblioteca.emprestar(aluno, livro2);   // 2º item
        biblioteca.emprestar(aluno, revista1); // 3º item

        // 4. Empréstimo recusado por limite atingido (tentando o 4º item)
        biblioteca.emprestar(aluno, revista2);

        // Conferindo como ficou o acervo
        biblioteca.listarAcervo();

        // 5. Testando devolução e novo empréstimo
        biblioteca.devolver(aluno, livro1);
        biblioteca.emprestar(professor, livro1);

        biblioteca.listarAcervo();
    }
}