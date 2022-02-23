
// java program to demonstrate
// use of semaphores Locks
import java.util.Random;
import java.util.concurrent.*;


class MyThread extends Thread
{
    public Pilha pilha;
    public Semaphore sem;
    String threadName;
    public MyThread( Pilha pilha)
    {
//        super(threadName);
        this.pilha = pilha;
        this.sem = pilha.semaphore;
//        this.threadName = threadName;
    }

    @Override
    public void run() {
        Random gerador = new Random();
       // pilha.threadName = threadName;
        int juiz, numero, count = 0;
        while(count < 50) { // laço para executar varias vezes
            //gera numero aleatorio de 0 até 99
            juiz = gerador.nextInt(100);
            // se o numero gerado (variavel juiz) for par um numero é colocado na pilha
            // se o numero for impar um numero é tirado da pilha

        System.out.println("Iniciando... " + Thread.currentThread().getId());

            // verifica se a pilha esta vazia
            // se estiver vazia muda variavel para par
            if (pilha.verifica() == 0) {
                System.out.println("pilha vazia!!!");
                juiz = 2;
            }

            if (juiz % 2 == 0)//numero gerado é par
            {
                numero = gerador.nextInt(100);
                // chama a funcao de empilhar da pilha
                pilha.Empilha(String.valueOf(numero));

            } else    //numero gerado é impar
            {
                String dado;
                // desempilha
                pilha.Desempilha();
            }
            count ++;// contador do while
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

