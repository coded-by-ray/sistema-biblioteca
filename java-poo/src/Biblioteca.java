public class Biblioteca {
    private ItemBiblioteca[] acervo;
    private Usuario[] usuarios;
    private int qtdItens;
    private int qtdUsuarios;

    // Define o tamanho fixo dos arrays ao criar a biblioteca
    public Biblioteca(int capacidadeItens, int capacidadeUsuarios) {
        this.acervo = new ItemBiblioteca[capacidadeItens];
        this.usuarios = new Usuario[capacidadeUsuarios];
        this.qtdItens = 0;
        this.qtdUsuarios = 0;
    }

    public void cadastrarItem(ItemBiblioteca item) {
        if (qtdItens < acervo.length) {
            acervo[qtdItens] = item;
            qtdItens++;
        } else {
            System.out.println("Erro: Capacidade máxima do acervo atingida!");
        }
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (qtdUsuarios < usuarios.length) {
            usuarios[qtdUsuarios] = usuario;
            qtdUsuarios++;
        } else {
            System.out.println("Erro: Capacidade máxima de usuários atingida!");
        }
    }

    public void emprestar(Usuario usuario, ItemBiblioteca item) {
        // 1. Verifica se o item está na biblioteca
        if (!item.isDisponivel()) {
            System.out.println("NEGADO: '" + item.getTitulo() + "' já está emprestado.");
            return;
        }

        // 2. Verifica se o usuário não estourou o limite dele (3 para aluno, 5 para prof)
        if (!usuario.podePegarEmprestado()) {
            System.out.println("NEGADO: " + usuario.getNome() + " já atingiu o limite de " + usuario.getLimiteItens() + " itens.");
            return;
        }

        // 3. Se passou nas duas validações, efetiva o empréstimo
        item.emprestarItem();
        usuario.incrementarEmprestimos();
        System.out.println("SUCESSO: '" + item.getTitulo() + "' emprestado para " + usuario.getNome() + 
                           " (Prazo: " + item.getPrazoDias() + " dias).");
    }

    public void devolver(Usuario usuario, ItemBiblioteca item) {
        if (item.isDisponivel()) {
            System.out.println("AVISO: '" + item.getTitulo() + "' já estava disponível.");
            return;
        }

        item.devolverItem();
        usuario.decrementarEmprestimos();
        System.out.println("DEVOLVIDO: '" + item.getTitulo() + "' devolvido por " + usuario.getNome() + ".");
    }

    public void listarAcervo() {
        System.out.println("\n=== ACERVO DA BIBLIOTECA ===");
        // Um único laço, sem nenhum 'if' perguntando se é Livro ou Revista!
        for (int i = 0; i < qtdItens; i++) {
            System.out.println(acervo[i]);
        }
        System.out.println("============================\n");
    }
}