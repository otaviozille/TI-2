package src;

import java.util.Scanner;

import dao.ProdutoDAO;
import model.Produto;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProdutoDAO dao = new ProdutoDAO();

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Listar");
            System.out.println("2 - Inserir");
            System.out.println("3 - Excluir");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    dao.listar();
                    break;

                case 2:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    Produto novoProduto = new Produto(nome, preco);
                    dao.inserir(novoProduto);
                    break;

                case 3:
                    System.out.print("Digite o ID do produto para excluir: ");
                    int idExcluir = scanner.nextInt();
                    scanner.nextLine();

                    dao.excluir(idExcluir);
                    break;

                case 4:
                    System.out.print("Digite o ID do produto para atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Digite o novo preço: ");
                    double novoPreco = scanner.nextDouble();
                    scanner.nextLine();

                    Produto produtoAtualizado = new Produto(idAtualizar, novoNome, novoPreco);
                    dao.atualizar(produtoAtualizado);
                    break;

                case 5:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 5);

        scanner.close();
    }
}