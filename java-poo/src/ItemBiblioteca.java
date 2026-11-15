public abstract class ItemBiblioteca {
    private String codigo;
    private String titulo;
    private boolean disponivel;

    public ItemBiblioteca(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public abstract int getPrazoDias();
    public abstract double getMultaPorDia();

    public void emprestarItem() {
        this.disponivel = false;
    }

    public void devolverItem() {
        this.disponivel = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    @Override 
    public String toString() {
        String status = disponivel ? "Disponivel" : "Emprestado";
        return "[" + codigo + "] " + titulo + " | Status: " + status + " | Prazo: " + getPrazoDias() + " dias | Multa/dia: R$ " + getMultaPorDia();
    }
}