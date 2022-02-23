import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Pilha {
    Noh top = null;
    Semaphore semaphore;
    //Método que empilha os valores.
    MyThread myThread;

    public Pilha(){
        semaphore= new Semaphore(1);

    }
    public void Empilha(String dado){
        try {
            System.out.println(Thread.currentThread().getId() + " esta esperando por permissao.");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getId() + " conseguiu permissao.");
            Noh novo = new Noh();
            novo.setDado(dado);
            novo.setAnt(top);
            top = novo;
            System.out.println(Thread.currentThread().getId() + " empilhou: " + dado);
            System.out.println(Thread.currentThread().getId() + " liberou permissao.");
            System.out.println(Exibir());
            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // função para gerar numero aleatorio
    public int random(){
        int numero;
        Random gerador = new Random();
        numero = gerador.nextInt(100);
        return numero;
    }
    // verifica se a pilha esta vazia
    public int verifica(){
        int vazio;
        if(top == null){
            vazio = 0;
        }else {
            vazio = 1;
        }
        return vazio;
    }
    //Método de desempilhar
    public String Desempilha(){

        try {
            System.out.println(Thread.currentThread().getId() + " esta esperando por permissao.");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getId() + " conseguiu permissao.");
            String valor = top.getDado();
            top = top.getAnt();
            System.out.println(Thread.currentThread().getId() + " desempilhou: " + valor);
            System.out.println(Thread.currentThread().getId() + " liberou permissao.");
            System.out.println(Exibir());
            semaphore.release();

            return valor;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    //Método para exibir pilha
    public ArrayList<String> Exibir(){

            ArrayList<String> exibir = new ArrayList<String>();
            Noh aux = top;
            while(aux != null){
                exibir.add(aux.getDado());
                aux = aux.getAnt();
            }
            return exibir;

    }

}



