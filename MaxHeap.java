public class MaxHeap {
    private int[] heap;
    private int tamanho;

    public MaxHeap(int[] array) {
        this.heap = array;
        this.tamanho = array.length;
        buildMaxHeap();
    }

    private int pai(int i) {
        return (i - 1) / 2;
    }

    public int getPai(int i) {
        if (i > 0 && i < tamanho) {
            return heap[pai(i)];
        }
        throw new IllegalArgumentException("Index out of bounds or root node has no parent.");
    }

    private int esquerda(int i) {
        return 2 * i + 1;
    }

    private int direita(int i) {
        return 2 * i + 2;
    }

    // Seção 6.2 - MAX-HEAPIFY
    private void maxHeapify(int i) {
        int esq = esquerda(i);
        int dir = direita(i);
        int maior = i;

        if (esq < tamanho && heap[esq] > heap[maior]) {
            maior = esq;
        }

        if (dir < tamanho && heap[dir] > heap[maior]) {
            maior = dir;
        }

        if (maior != i) {
            trocar(i, maior);
            maxHeapify(maior); // Recursivamente arruma o resto
        }
    }

    private void trocar(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Seção 6.3 - BUILD-MAX-HEAP
    public void buildMaxHeap() {
        for (int i = (tamanho / 2) - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void exibirHeap() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Só de brinde: pegar o maior
    public int getMaximo() {
        return heap[0];
    }
}
