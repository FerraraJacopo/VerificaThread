public class Main {
    public static void main(String[] args) {
        Magazzino magazzino = new Magazzino(10);
        for (int i = 0; i < 5; i++) {
            new Fornitore(magazzino, i).start();
            new Cliente(magazzino, i).start();
        }
    }
}