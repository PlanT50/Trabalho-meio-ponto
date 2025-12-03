public class HeapMinimo {
    private int[] heap;
    private int tamanho;

    public HeapMinimo(int capacidade) {
        heap = new int[capacidade];
        tamanho = 0;
    }

    private int pai(int i) {
        return (i - 1) / 2;
    }

    private int esq(int i) {
        return 2 * i + 1;
    }

    private int dir(int i) {
        return 2 * i + 2;
    }
    // Aqui ja se aplica a primeira reorganização para colocar o menor numero na raiz.
    public void inserir(int valor) {
        if (tamanho == heap.length) {
            throw new RuntimeException("Heap cheio");
        }

        heap[tamanho] = valor;
        int i = tamanho;
        tamanho++;

        while (i != 0 && heap[pai(i)] > heap[i]) {
            int temp = heap[i];
            heap[i] = heap[pai(i)];
            heap[pai(i)] = temp;
            i = pai(i);
        }
    }
    // E aqui quando se extrai os filhos devem ser reorganizados de acordo com o numero substituto.
    public int extrairMinimo() {
        if (tamanho <= 0) {
            throw new RuntimeException("Heap vazio");
        }

        int minimo = heap[0];
        heap[0] = heap[tamanho - 1];
        tamanho--;

        ajuste(0);

        return minimo;
    }

    private void ajuste(int i) {
        int menor = i;
        int esq = esq(i);
        int dir = dir(i);

        if (esq < tamanho && heap[esq] < heap[menor]) {
            menor = esq;
        }

        if (dir < tamanho && heap[dir] < heap[menor]) {
            menor = dir;
        }

        if (menor != i) {
            int temp = heap[i];
            heap[i] = heap[menor];
            heap[menor] = temp;
            ajuste(menor);
        }
    }

    public void mostrar() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
