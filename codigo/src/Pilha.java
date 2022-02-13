import java.util.ArrayList;

public class Pilha {
    Noh top = null;
    //Método que empilha os valores.
    public void Empilha(String dado){
        Noh novo = new Noh();
        novo.setDado(dado);
        novo.setAnt(top);
        top = novo;
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

            String valor = top.getDado();
            top = top.getAnt();
            return valor;

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

