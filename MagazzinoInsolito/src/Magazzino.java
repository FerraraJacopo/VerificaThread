import java.util.ArrayList;

public class Magazzino {
    private ArrayList<Integer>buffer;
    private int maxMerci;

    public Magazzino(int maxMerci){
        this.buffer = new ArrayList();
        this.maxMerci = maxMerci;
    }

    public synchronized void inserisciMerce(int n, int numeroThread) throws InterruptedException {
        while (buffer.size() >= maxMerci/2){
            wait();
        }
        buffer.add(n);
        System.out.println("Fornitore " + numeroThread + " ha inserito " + n + " nel magazzino");
        notifyAll();
    }

    public synchronized void ritiraMerce(int numeroThread) throws InterruptedException {
        while(buffer.isEmpty()){
            wait();
        }
        int n = buffer.remove(buffer.size()-1);
        System.out.println("Consumatore " + numeroThread + " ha ritirato " + n + " dal magazzino");
        notifyAll();
    }
}
