public class EmptyStackException extends NullPointerException{
    public EmptyStackException(){
        super();
    }
    public EmptyStackException(String msg){
        super(msg);
    }
}