public class Livro {
    private int ISBN;
    private String titulo;
    private String autor;
    private String area;
    private int quantidade;

    public Livro(int ISBN, String titulo, String autor, String area, int quantidade) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.area = area;
        this.quantidade = quantidade;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ISBN: " + ISBN + "\nTítulo: " + titulo + "\nAutor: " + autor + "\nÁrea: " + area + "\nQuantidade: " + quantidade;
    }
}
