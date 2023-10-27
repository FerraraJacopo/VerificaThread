public class Fornitore extends Thread {
    private Magazzino magazzino;
    private int numeroThread;

    public Fornitore(Magazzino magazzino, int numeroThread) {
        this.magazzino = magazzino;
        this.numeroThread = numeroThread;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            int n = (int) ((Math.random() * 10) + 1);
            try {
                magazzino.inserisciMerce(n, numeroThread);
                Thread.sleep((int) (Math.random() * 1500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
