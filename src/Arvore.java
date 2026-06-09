public class Arvore {
    private Node raiz;
    

    public Arvore() {
    	raiz = null;
    
    }
    
    
    public void inserir(Livro livro) {
    	raiz = inserirRec(raiz, livro);
    }

    private Node inserirRec(Node atual, Livro livro) {
    	if(atual == null) {
    		return new Node(livro);
    	}
    	if(livro.getISBN().compareTo(atual.getLivro().getISBN()) < 0) {
    		atual.setFilhoEsquerda(inserirRec(atual.getFilhoEsquerda(), livro));
    	}else if(livro.getISBN().compareTo(atual.getLivro().getISBN()) > 0) {
    		atual.setFilhoDireita(inserirRec(atual.getFilhoDireita(), livro));
    	}
    	return atual;
    }

    

    public Livro buscar(String isbn) {
    	return buscarRec(raiz, isbn);
    }

    private Livro buscarRec(Node atual, String isbn) {
    	if(atual == null) {
    		return null;
    	}
    	if(isbn.equals(atual.getLivro().getISBN())) {
    		return atual.getLivro();
    	}
    	if(isbn.compareTo(atual.getLivro().getISBN()) < 0) {
    		return buscarRec(atual.getFilhoEsquerda(), isbn);
    	}else  {
    		return buscarRec(atual.getFilhoDireita(), isbn);
    	}
    }
    
    // remover livro
    
    
    public void exibirEmOrdem() {
    	exibirEmOrdemRec(raiz);
    }
    
    private void exibirEmOrdemRec(Node atual) {
    	if(atual != null) {
    		exibirEmOrdemRec(atual.getFilhoEsquerda()); 
    		System.out.println(atual.getLivro().getISBN()); 
    		exibirEmOrdemRec(atual.getFilhoDireita());
    		
    	}
    	
    	
    }

    public void exibirPreOrdem() {
    	exibirPreOrdemRec(raiz);	
    }
    
    
    private void exibirPreOrdemRec(Node atual) {
    	if(atual != null) {
    		System.out.println(atual.getLivro().getISBN());
    		exibirPreOrdemRec(atual.getFilhoEsquerda());
    		exibirPreOrdemRec(atual.getFilhoDireita());
    		
    	}
    }
    
    

    public void exibirPosOrdem() {
    	exibirPosOrdemRec(raiz);
    }
    
    private void exibirPosOrdemRec(Node atual) {
    	if(atual != null) {
    		exibirPosOrdemRec(atual.getFilhoEsquerda());
    		exibirPosOrdemRec(atual.getFilhoDireita());
    		System.out.println(atual.getLivro().getISBN());
    		
    	}
    	
    	
    }
    
    
    public Livro maiorISBN() {
    	if (raiz == null) {
    		return null;
    	}
    	return maiorISBNRec(raiz);
    	
    	
    }
    
    private Livro maiorISBNRec(Node atual) {
    	if (atual.getFilhoDireita() == null) {
    		return atual.getLivro();
    	}
    	return maiorISBNRec(atual.getFilhoDireita());
    }
    
    

    
    public Livro menorISBN() {
    	if (raiz == null) {
    		return null;
    	}
    	return menorISBNRec(raiz); 
    	
    }
    private Livro menorISBNRec(Node atual) {
    	if (atual.getFilhoEsquerda() == null) {
    		return atual.getLivro();
    	}
    	return menorISBNRec(atual.getFilhoEsquerda());
    }

    
    public int qtdLivros() {
    	return qtdLivrosRec(raiz);
    }
    	
    private int qtdLivrosRec(Node atual) {
    	if (atual  == null) {
    		return 0;
    	}
    	
    	return 1+ qtdLivrosRec(atual.getFilhoEsquerda())+ qtdLivrosRec(atual.getFilhoDireita()); 
    }
    
    public int altura() {
    	return alturaRec(raiz);
    }
    
    private int alturaRec(Node atual) {
    	if (atual == null) {
    		return 0;
    	}
    int alturaEsquerda;
    int alturaDireita;
    
    alturaEsquerda = alturaRec(atual.getFilhoEsquerda());
    alturaDireita = alturaRec(atual.getFilhoDireita());
    
    return 1+Math.max(alturaEsquerda, alturaDireita);
    }
   
    
    
    
    
}
