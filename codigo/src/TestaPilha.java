import java.util.ArrayList;
import java.util.Scanner;

public class TestaPilha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pilha pilha = new Pilha();
        String dado, op;

        do{
            System.out.println("Escolha uma opção:\n1->Empilhar\n2->Desempilhar\n3->Exibir");
            op = sc.next();
            //Empilha uma string.
            if(op.equals("1")){
                System.out.println("Insira: ");
                dado = sc.next();
                pilha.Empilha(dado);
            }
            //Desempilha:
            else if(op.equals("2")){
                try{
                    System.out.println("Desempilhado valor: " + pilha.Desempilha());
                }
                catch(EmptyStackException e){
                    System.out.println(e.getMessage());
                }
            }
            //Exibe os itens da pilha.
            else if(op.equals("3")){
                ArrayList<String> exibir = new ArrayList<String>();
                try{
                    exibir = pilha.Exibir();
                }
                catch(EmptyStackException e){
                    System.out.println(e.getMessage());
                }

                for(String vl : exibir){
                    System.out.println(vl);
                }
            }
            else
                System.out.println("Opção inválida!");
        }
        while(op != "9");
    }
}