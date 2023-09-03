import java.util.ArrayList;

public class Stack {
    private ArrayList<String> stack;

    public Stack(){
        this.stack = new ArrayList<>();
    }

    public Stack(ArrayList<String> s){
        this.stack = new ArrayList<>(s);
    }

    public Stack(Stack s){
        this(s.stack);
    }

    // Metodo equals
    public boolean equals(Object o){
        if(this == o)
            return true;
        if( (null == o) || (this.getClass() != o.getClass()))
            return false;

        Stack s = (Stack)o;
        return this.stack.equals(s.stack);
    }

    // Metodo toString
    public String toString(){
        return this.stack.toString();
    }

    // Metodo clone
    public Stack clone(){
        return new Stack(this.stack);
    }

    // (a) -> Determina o topo da stack
    public String top(){
        return this.stack.get(this.stack.size() - 1);
    }    

    // (b) -> Insere no topo da stack
    public void push(String s){
        this.stack.add(this.stack.size()-1, s);
    }

    // (c) -> Remove o elemento do topo da stack
    public void pop(){
        this.stack.remove(this.stack.size()-1);
    }

    // (d) -> Determina se a stack esta vazia
    public boolean empty(){
        return this.stack.isEmpty();
    }

    // (e) -> Determina o comprimento da stack
    public int length(){
        return this.stack.size();
    }
}
