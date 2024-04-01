/*2. Faça um programa para executar as operações abaixo em uma árvore binária.
Menu
1 - Inserir número
2 - Mostrar todos
Ex. Dado que tenha a árvore:

Faça a seguinte representação:

6(2(1 4(3)) 8)

3 - Mostrar a subárvore da direita
4 - Mostrar a subárvore da esquerda
5 - Mostrar o nó pai e os nós filhos de um nó
6 - Sair */
import java.util.Scanner;
public class Testi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();

        int opcao;
        do {
            System.out.println("=======================================================================");
            System.out.println("1 - Inserir número");
            System.out.println("2 - Mostrar todos");
            System.out.println("3 - Mostrar a subárvore da direita");
            System.out.println("4 - Mostrar a subárvore da esquerda");
            System.out.println("5 - Mostrar o nó pai e os nós filhos de um nó");
            System.out.println("6 - Sair");
            System.out.println("=======================================================================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número a ser inserido: ");
                    int numero = scanner.nextInt();
                    arvore.inserir(numero);
                    break;
                case 2:
                    System.out.print("Árvore: ");
                    arvore.mostrarTudo();
                    break;
                case 3:
                    arvore.mostrarSubArvoreDireita();
                    break;
                case 4:
                    arvore.mostrarSubArvoreEsquerda();
                    break;
                case 5:
                    System.out.print("Digite o número para encontrar o pai e os filhos: ");
                    int valor = scanner.nextInt();
                    arvore.mostrarNoPaiENosFilhos(valor);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
        scanner.close();
    }
}