public class Noh {
    private String dado;
    private Noh ant; //ant de anterior
    //Define o nó anterior
    public void setAnt(Noh ant) {
        this.ant = ant;
    }
    //Retorna o nó anterior.
    public Noh getAnt() {
        return ant;
    }
    //Define valor do nó
    public void setDado(String dado) {
        this.dado = dado;
    }
    //Retorna valor do nó
    public String getDado() {
        return dado;
    }
}

