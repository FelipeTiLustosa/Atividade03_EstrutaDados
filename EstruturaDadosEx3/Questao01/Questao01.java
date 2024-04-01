/*1. Faça um programa para executar as operações abaixo em uma árvore binária.
Menu
1 - Inserir número
2 - Mostrar os nós folha
3 - Mostrar os nós ancestrais de um nó
4 - Mostrar os nós descendentes de um nó
5 - Mostrar o nó pai e os nós filhos de um nó
6-Sair */

import java.util.Scanner;

public class Questao01 {
    private static class ARVORE {
        public int num;
        public ARVORE dir, esq;
    }

    private static Scanner entrada = new Scanner(System.in);
    private static ARVORE raiz = null;

    public static void main(String[] args) {
        menu();
    }

    // Funcao menu
    public static void menu() {
        int op;
        do {
            System.out.println("=======================================================================");
            System.out.println("\t Menu de Opções ");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("1 - Inserir número");
            System.out.println("2 - Mostrar os nós folha");
            System.out.println("3 - Mostrar os nós ancestrais de um nó");
            System.out.println("4 - Mostrar os nós descendentes de um nó");
            System.out.println("5 - Mostrar o nó pai e os nós filhos de um nó");
            System.out.println("6 - Sair");
            System.out.println("=======================================================================");
            System.out.print("Digite sua opção: ");
            op = entrada.nextInt();

            switch (op) {
                case 1:
                    inserirNo();
                    break;
                case 2:
                    mostrarNosFolha(raiz);
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.print("Digite o valor do nó para encontrar seus ancestrais: ");
                    int valorAncestral = entrada.nextInt();
                    System.out.println("Os nós ancestrais de " + valorAncestral + " são:");
                    mostrarAncestrais(raiz, valorAncestral);
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.print("Digite o valor do nó para encontrar seus descendentes: ");
                    int valorDescendente = entrada.nextInt();
                    System.out.println("Os nós descendentes de " + valorDescendente + " são:");
                    mostrarDescendentes(raiz, valorDescendente);
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.print("Digite o valor do nó para encontrar seu pai e seus filhos: ");
                    int valorNo = entrada.nextInt();
                    mostrarPaiEFilhos(raiz, valorNo);
                    System.out.println("-----------------------------------------------------------------------");
                    break;
                case 6:
                    System.out.println("Encerrando ...");
                    break;
                default:
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (op != 6);
    }

    // Funcao inserir no na arvore
    public static void inserirNo() {
        ARVORE novo = new ARVORE();
        System.out.print("Digite o número a ser inserido na árvore: ");
        novo.num = entrada.nextInt();
        novo.dir = null;
        novo.esq = null;
        if (raiz == null)
            raiz = novo;
        else {
            ARVORE aux = raiz;
            int achou = 0;
            while (achou == 0) {
                if (novo.num < aux.num) {
                    if (aux.esq == null) {
                        aux.esq = novo;
                        achou = 1;
                    } else
                        aux = aux.esq;
                } else if (novo.num >= aux.num) {
                    if (aux.dir == null) {
                        aux.dir = novo;
                        achou = 1;
                    } else
                        aux = aux.dir;
                }
            }
        }
        System.out.println("Número inserido com sucesso na árvore!");
    }

    // Funcao para mostrar os nós folha
    public static void mostrarNosFolha(ARVORE no) {
        if (no == null)
            return;
        if (no.esq == null && no.dir == null)
            System.out.print(no.num + " ");
        mostrarNosFolha(no.esq);
        mostrarNosFolha(no.dir);
    }

    // Funcao para mostrar os nós ancestrais de um nó
    public static boolean mostrarAncestrais(ARVORE no, int valor) {
        if (no == null)
            return false;
        if (no.num == valor)
            return true;
        if (mostrarAncestrais(no.esq, valor) || mostrarAncestrais(no.dir, valor)) {
            System.out.print(no.num + " ");
            return true;
        }
        return false;
    }

    // Funcao para mostrar os nós descendentes de um nó
    public static void mostrarDescendentes(ARVORE no, int valor) {
        ARVORE noBusca = busca(no, valor);
        if (noBusca != null) {
            System.out.print(noBusca.num + " ");
            mostrarDescendentesRecursivo(noBusca.esq);
            mostrarDescendentesRecursivo(noBusca.dir);
        } else {
            System.out.println("O valor informado não existe na árvore.");
        }
    }

    // Funcao auxiliar para buscar um nó na árvore
    public static ARVORE busca(ARVORE no, int valor) {
        if (no == null || no.num == valor)
            return no;
        ARVORE noEsq = busca(no.esq, valor);
        if (noEsq != null)
            return noEsq;
        return busca(no.dir, valor);
    }

    // Funcao recursiva para mostrar os descendentes de um nó
    public static void mostrarDescendentesRecursivo(ARVORE no) {
        if (no != null) {
            System.out.print(no.num + " ");
            mostrarDescendentesRecursivo(no.esq);
            mostrarDescendentesRecursivo(no.dir);
        }
    }

    // Funcao para mostrar o nó pai e os nós filhos de um nó
    public static void mostrarPaiEFilhos(ARVORE no, int valor) {
        ARVORE pai = null;
        ARVORE noBusca = raiz;
        while (noBusca != null && noBusca.num != valor) {
            pai = noBusca;
            if (valor < noBusca.num)
                noBusca = noBusca.esq;
            else
                noBusca = noBusca.dir;
        }
        if (noBusca != null) {
            System.out.println("Nó pai: " + (pai != null ? pai.num : "Não possui pai"));
            System.out.println("Nó(s) filho(s): " + (noBusca.esq != null ? noBusca.esq.num : "") + " " +
                    (noBusca.dir != null ? noBusca.dir.num : ""));
        } else {
            System.out.println("O valor informado não existe na árvore.");
        }
    }
}
