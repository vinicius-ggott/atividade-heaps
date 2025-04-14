public class Main {
    public static void main(String[] args) {
        int[] array = {4, 10, 3, 5, 1, 2};
        MaxHeap heap = new MaxHeap(array);

        System.out.println("Heap-máximo construído:");
        heap.exibirHeap();

        System.out.println("Maior elemento: " + heap.getMaximo());
    }
}
