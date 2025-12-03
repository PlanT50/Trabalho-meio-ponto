public class Main {
    public static void main(String[] args) {
        HeapMinimo heap = new HeapMinimo(10);

        heap.inserir(5);
        heap.inserir(2);
        heap.inserir(8);
        heap.inserir(1);
        // Aqui ja se aplica a primeira reorganização para colocar o menor numero na raiz.

        System.out.println("Heap antes de extrair:");
        heap.mostrar();

        int minimo = heap.extrairMinimo();
        // E aqui quando se extrai os filhos devem ser reorganizados de acordo com o numero substituto.
        System.out.println("Menor elemento removido: " + minimo);

        System.out.println("Heap depois de extrair:");
        heap.mostrar();
    }
}

