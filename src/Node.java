public class Node {
    private Livro livro;
    private Node filhoDireita;
    private Node filhoEsquerda;

    public Node(Livro livro){
        this.livro=livro;
    }

    public Node(Livro livro, Node filhoDireita, Node filhoEsquerda){
        this.livro = livro;
        this.filhoEsquerda = filhoEsquerda;
        this.filhoDireita = filhoDireita;
    }

    public Node(Node filhoDireita, Node filhoEsquerda){
        this.filhoEsquerda = filhoEsquerda;
        this.filhoDireita = filhoDireita;
    }

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Node getFilhoDireita() {
		return filhoDireita;
	}

	public void setFilhoDireita(Node filhoDireita) {
		this.filhoDireita = filhoDireita;
	}

	public Node getFilhoEsquerda() {
		return filhoEsquerda;
	}

	public void setFilhoEsquerda(Node filhoEsquerda) {
		this.filhoEsquerda = filhoEsquerda;
	}
    
    
}
