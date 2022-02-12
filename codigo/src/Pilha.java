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
    //Método de desempilhar
    public String Desempilha() throws EmptyStackException{
        if(top == null){
            throw new EmptyStackException("A pilha está vazia");
        }
        else{
            String valor = top.getDado();
            top = top.getAnt();
            return valor;
        }
    }
    //Método para exibir pilha
    public ArrayList<String> Exibir() throws EmptyStackException{
        if(top == null){
            throw new EmptyStackException("A pilha está vazia");
        }
        else{
            ArrayList<String> exibir = new ArrayList<String>();
            Noh aux = top;
            while(aux != null){
                exibir.add(aux.getDado());
                aux = aux.getAnt();
            }
            return exibir;
        }
    }
}

