class ArvoreBinaria {
    No raiz;

    ArvoreBinaria() {
        raiz = null;
    }

    void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    No inserirRecursivo(No raiz, int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }

        if (valor < raiz.valor)
            raiz.esquerda = inserirRecursivo(raiz.esquerda, valor);
        else if (valor > raiz.valor)
            raiz.direita = inserirRecursivo(raiz.direita, valor);

        return raiz;
    }

    void mostrarTudo() {
        mostrarTudoRecursivo(raiz);
        System.out.println();
    }

    void mostrarTudoRecursivo(No raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor);
            if (raiz.esquerda != null || raiz.direita != null) {
                System.out.print("(");
                mostrarTudoRecursivo(raiz.esquerda);
                if (raiz.direita != null) {
                    System.out.print(" ");
                    mostrarTudoRecursivo(raiz.direita);
                }
                System.out.print(")");
            }
        }
    }

    void mostrarSubArvoreDireita() {
        if (raiz != null && raiz.direita != null) {
            System.out.print("Subárvore da direita: ");
            mostrarTudoRecursivo(raiz.direita);
            System.out.println();
        } else {
            System.out.println("Não há subárvore da direita.");
        }
    }

    void mostrarSubArvoreEsquerda() {
        if (raiz != null && raiz.esquerda != null) {
            System.out.print("Subárvore da esquerda: ");
            mostrarTudoRecursivo(raiz.esquerda);
            System.out.println();
        } else {
            System.out.println("Não há subárvore da esquerda.");
        }
    }

    void mostrarNoPaiENosFilhos(int valor) {
        No pai = encontrarPai(raiz, valor);
        if (pai != null) {
            System.out.print("Nó pai de " + valor + ": " + pai.valor);
            if (pai.esquerda != null)
                System.out.print(", Filho da esquerda: " + pai.esquerda.valor);
            else
                System.out.print(", Sem filho da esquerda");
            if (pai.direita != null)
                System.out.print(", Filho da direita: " + pai.direita.valor);
            else
                System.out.print(", Sem filho da direita");
            System.out.println();
        } else {
            System.out.println("O valor " + valor + " não está na árvore.");
        }
    }

    No encontrarPai(No raiz, int valor) {
        if (raiz == null || raiz.valor == valor)
            return null;

        if ((raiz.esquerda != null && raiz.esquerda.valor == valor) ||
            (raiz.direita != null && raiz.direita.valor == valor))
            return raiz;

        No esq = encontrarPai(raiz.esquerda, valor);
        if (esq != null)
            return esq;

        return encontrarPai(raiz.direita, valor);
    }
}