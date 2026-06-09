import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("=============================");
            System.out.println("     GERENCIADOR DE LIVROS   ");
            System.out.println("=============================");
            System.out.println("1. Inserir livro");
            System.out.println("2. Buscar livro por ISBN");
            System.out.println("3. Remover livro por ISBN");
            System.out.println("4. Exibir em ordem");
            System.out.println("5. Exibir em pré-ordem");
            System.out.println("6. Exibir em pós-ordem");
            System.out.println("7. Maior ISBN");
            System.out.println("8. Menor ISBN");
            System.out.println("9. Quantidade de livros");
            System.out.println("10. Altura da árvore");
            System.out.println("0. Sair");
            System.out.println("=============================");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Área: ");
                    String area = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();
                    arvore.inserir(new Livro(isbn, titulo, autor, area, quantidade));
                    System.out.println("Livro inserido com sucesso.");
                    break;

                case 2:
                    System.out.print("ISBN: ");
                    String isbnBusca = scanner.nextLine();
                    Node resultado = arvore.buscar(isbnBusca);
                    if (resultado == null) {
                        System.out.println("Livro não encontrado.");
                    } else {
                        System.out.println("Livro encontrado:");
                        System.out.println(resultado.getLivro());
                    }
                    break;

                case 3:
                    System.out.print("ISBN: ");
                    String isbnRemover = scanner.nextLine();
                    if (arvore.buscar(isbnRemover) == null) {
                        System.out.println("Livro não encontrado.");
                    } else {
                        arvore.remover(isbnRemover);
                        System.out.println("Livro removido com sucesso.");
                    }
                    break;

                case 4:
                    String emOrdem = arvore.exibirEmOrdem();
                    if (emOrdem.isEmpty()) {
                        System.out.println("Árvore vazia.");
                    } else {
                        System.out.println("--- Em Ordem ---");
                        System.out.println(emOrdem);
                    }
                    break;

                case 5:
                    String preOrdem = arvore.exibirPreOrdem();
                    if (preOrdem.isEmpty()) {
                        System.out.println("Árvore vazia.");
                    } else {
                        System.out.println("--- Pré-Ordem ---");
                        System.out.println(preOrdem);
                    }
                    break;

                case 6:
                    String posOrdem = arvore.exibirPosOrdem();
                    if (posOrdem.isEmpty()) {
                        System.out.println("Árvore vazia.");
                    } else {
                        System.out.println("--- Pós-Ordem ---");
                        System.out.println(posOrdem);
                    }
                    break;

                case 7:
                    Node maior = arvore.maiorISBN();
                    if (maior == null) {
                        System.out.println("Árvore vazia.");
                    } else {
                        System.out.println("Livro com maior ISBN:");
                        System.out.println(maior.getLivro());
                    }
                    break;

                case 8:
                    Node menor = arvore.menorISBN();
                    if (menor == null) {
                        System.out.println("Árvore vazia.");
                    } else {
                        System.out.println("Livro com menor ISBN:");
                        System.out.println(menor.getLivro());
                    }
                    break;

                case 9:
                    System.out.println("Quantidade de livros: " + arvore.qtdLivros());
                    break;

                case 10:
                    System.out.println("Altura da árvore: " + arvore.altura());
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }
}
