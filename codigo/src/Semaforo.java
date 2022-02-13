
// java program to demonstrate
// use of semaphores Locks
import java.util.Random;
import java.util.concurrent.*;

//A shared resource/class.
class Shared
{
    static Pilha pilha = new Pilha();
}

class MyThread extends Thread
{
    Semaphore sem;
    String threadName;
    public MyThread(Semaphore sem, String threadName)
    {
        super(threadName);
        this.sem = sem;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        Random gerador = new Random();
        int juiz, numero, count = 0;
        while(count < 5) {
            //gera numero aleatorio de 0 até 99
            juiz = gerador.nextInt(100);

            // se o numero gerado for par um numero é colocado na pilha
            // se o numero for impar um numero é tirado da pilha
            try {
                System.out.println("Iniciando... " + threadName);

                System.out.println(threadName + " esta esperando por permissao.");
                // O primeiro consegue permissao
                sem.acquire();

                System.out.println(threadName + " conseguiu permissao.");
                // verifica se a pilha esta vazia
                // se estiver vazia muda variavel para par
                if (Shared.pilha.verifica() == 0) {
                    System.out.println("pilha vazia!!!");
                    juiz = 2;

                }

                if (juiz % 2 == 0)//numero gerado é par
                {
                    numero = gerador.nextInt(100);
                    // chama a funcao de empilhar da pilha
                    Shared.pilha.Empilha(String.valueOf(numero));
                    // printa numero empilhado
                    System.out.println(threadName + " empilhou: " + numero);

                } else    //numero gerado é impar
                {
                    String dado;
                    // desempilha
                    dado = Shared.pilha.Desempilha();
                    // printa numero desempilhado
                    System.out.println(threadName + " desempilhou: " + dado);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
             //libera a permissao.
            System.out.println(threadName + " liberou permissao.");
            sem.release();
            System.out.println(Shared.pilha.Exibir());
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count ++;
        }
    }
}

