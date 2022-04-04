import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) throws Exception {
        fila filaa = new fila(5);
        fila filaaa = new fila(5);
        filaa.add(55);
        filaa.add(5);
        filaa.add(42);
        filaa.remove();
        filaa.add(398);
        filaa.add(3);
        System.out.print("Array 1: ");
        filaa.println();
        for(int i = 0; i < filaaa.getTamMax()*0.5; i++){
            filaaa.add(ThreadLocalRandom.current().nextInt(0, 30 + 1));
        }
        System.out.print("Array 2: ");
        filaaa.println();
        fila filaaaaa = filaa.merge(filaaa);
        System.out.print("Array 3 (array 1 + 2 e NAO ordenado): ");
        filaaaaa.println();
        filaaaaa.ordenar();
        System.out.print("Array 3 (array 1 + 2 e ordenado): ");
        filaaaaa.println();


    }
}