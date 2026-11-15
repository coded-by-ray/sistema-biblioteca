public abstract class Usuario {
    private String nome;
    private int quantidadeEmprestada;

    public Usuario(String nome) {
        this.nome = nome;
        this.quantidadeEmprestada = 0; // Começa com 0 itens emprestados
    }

    // Cada tipo de usuário define seu limite
    public abstract int getLimiteItens();

    // Verifica se ainda pode pegar mais itens
    public boolean podePegarEmprestado() {
        return this.quantidadeEmprestada < getLimiteItens();
    }

    public void incrementarEmprestimos() {
        this.quantidadeEmprestada++;
    }

    public void decrementarEmprestimos() {
        if (this.quantidadeEmprestada > 0) {
            this.quantidadeEmprestada--;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }
}