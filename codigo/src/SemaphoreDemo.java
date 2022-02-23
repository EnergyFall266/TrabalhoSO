import java.util.concurrent.Semaphore;

// Driver class
public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        // cria a pilha
        Pilha pilha = new Pilha();
        // cria as threads
        MyThread thread1 = new MyThread( pilha);
        MyThread thread2 = new MyThread( pilha);
        MyThread thread3 = new MyThread( pilha);
        MyThread thread4 = new MyThread( pilha);
        // inicia as threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // espera pelas threads
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

    }
}
