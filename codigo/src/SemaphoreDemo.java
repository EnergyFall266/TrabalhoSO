import java.util.concurrent.Semaphore;

// Driver class
public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        // creating a Semaphore object
        // with number of permits 1
        Semaphore sem = new Semaphore(1);

        // creating two threads with name A and B
        // Note that thread A will increment the count
        // and thread B will decrement the count
        MyThread thread1 = new MyThread(sem, "A");
        MyThread thread2 = new MyThread(sem, "B");

        // começa threads A e B
        thread1.start();
        thread2.start();

        // waiting for threads A and B
        thread1.join();
        thread2.join();

    }
}
