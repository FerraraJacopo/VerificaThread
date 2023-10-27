public class Cliente extends Thread {
    private Magazzino magazzino;
    private int numeroThread;

    public Cliente(Magazzino magazzino, int numeroThread) {
        this.magazzino = magazzino;
        this.numeroThread = numeroThread;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                magazzino.ritiraMerce(numeroThread);
                Thread.sleep((int) (Math.random() * 1500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
