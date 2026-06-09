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

    

    public Node buscar(String isbn) {
    	return buscarRec(raiz, isbn);
    }

    private Node buscarRec(Node atual, String isbn) {
    	if(atual == null) {
    		return null;
    	}
    	if(isbn.equals(atual.getLivro().getISBN())) {
    		return atual;
    	}
    	if(isbn.compareTo(atual.getLivro().getISBN()) < 0) {
    		return buscarRec(atual.getFilhoEsquerda(), isbn);
    	}else  {
    		return buscarRec(atual.getFilhoDireita(), isbn);
    	}
    }
    
    public void remover(String isbn){
        raiz = removerRec(raiz,isbn);
    }

    private Node removerRec(Node atual, String isbn){
        if(atual == null){
            return null;
        }
        if(atual.getLivro().getISBN().equals(isbn)){
            if(atual.getFilhoDireita() == null && atual.getFilhoEsquerda() == null){
                return null;
            }
            else if(atual.getFilhoDireita() == null){
                return atual.getFilhoEsquerda();
            }
            else if(atual.getFilhoEsquerda() == null){
                return atual.getFilhoDireita();
            }
            else{
                Node substituto = menorISBNRec(atual.getFilhoDireita());
                atual.setLivro(substituto.getLivro());
                atual.setFilhoDireita(removerRec(atual.getFilhoDireita(), substituto.getLivro().getISBN()));
                return atual;

            }
        }
            if(isbn.compareTo(atual.getLivro().getISBN()) < 0) {
                atual.setFilhoEsquerda(removerRec(atual.getFilhoEsquerda(), isbn));
            } else {
                atual.setFilhoDireita(removerRec(atual.getFilhoDireita(), isbn));
            }
            return atual;
    }
    
    public String exibirEmOrdem() {
        return exibirEmOrdemRec(raiz);
    }

    private String exibirEmOrdemRec(Node atual) {
        if (atual == null) {
            return "";
        }
        return exibirEmOrdemRec(atual.getFilhoEsquerda())
             + atual.getLivro().toString() + "\n\n"
             + exibirEmOrdemRec(atual.getFilhoDireita());
    }

    public String exibirPreOrdem() {
        return exibirPreOrdemRec(raiz);
    }

    private String exibirPreOrdemRec(Node atual) {
        if (atual == null) {
            return "";
        }
        return atual.getLivro().toString() + "\n\n"
             + exibirPreOrdemRec(atual.getFilhoEsquerda())
             + exibirPreOrdemRec(atual.getFilhoDireita());
    }

    public String exibirPosOrdem() {
        return exibirPosOrdemRec(raiz);
    }

    private String exibirPosOrdemRec(Node atual) {
        if (atual == null) {
            return "";
        }
        return exibirPosOrdemRec(atual.getFilhoEsquerda())
             + exibirPosOrdemRec(atual.getFilhoDireita())
             + atual.getLivro().toString() + "\n\n";
    }
    
    
    public Node maiorISBN() {
    	if (raiz == null) {
    		return null;
    	}
    	return maiorISBNRec(raiz);


    }

    private Node maiorISBNRec(Node atual) {
    	if (atual.getFilhoDireita() == null) {
    		return atual;
    	}
    	return maiorISBNRec(atual.getFilhoDireita());
    }
    
    

    
    public Node menorISBN() {
    	if (raiz == null) {
    		return null;
    	}
    	return menorISBNRec(raiz);

    }

    private Node menorISBNRec(Node atual) {
    	if (atual.getFilhoEsquerda() == null) {
    		return atual;
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
