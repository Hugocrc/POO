public class Lugar{
    private String matricula;
    private String nome;
    private int minutos;
    private boolean permanente;

    public  Lugar(){
        this.matricula = "";
        this.nome = "";
        this.minutos = 0;
        this.permanente = true;
    }

    public Lugar (String mat, String nom, int min, boolean perm){
        this.matricula = mat;
        this.nome = nom;
        this.minutos = min;
        this.permanente = perm;
    }

    public Lugar(Lugar l){
        this(l.getMatricula(), l.getNome(), l.getMinutos(), l.isPermanente());
    }

    // Metodo Equals
    public boolean equals (Object o){
        if(this == o){
            return true;
        }
        if((o == null) || (this.getClass() != o.getClass())){
            return false;
        }
        Lugar l = (Lugar) o;
        return this.matricula.equals(l.matricula) && 
               this.nome.equals(l.nome) && 
               this.minutos == l.minutos && 
               this.permanente == l.permanente;
    }

    // Metodo toString
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Matricula: ");
        sb.append(matricula);
        sb.append("\nNome: ");
        sb.append(nome);
        sb.append("\nMinutos: ");
        sb.append(minutos);
        sb.append("\nÉ permanente: ");
        sb.append(permanente);

        return sb.toString();
    }

    // Metodo clone
    public Lugar clone(){
        return new Lugar(this);
    }

    // Gets
    public String getMatricula() {
        return this.matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public int getMinutos() {
        return this.minutos;
    }

    public boolean isPermanente() {
        return this.permanente;
    }

    // Sets
    public void setMatricula(String mat) {
        this.matricula = mat;
    }

    public void setNome(String nom) {
        this.nome = nom;
    }

    public void setMinutos(int min) {
        this.minutos = min;
    }

    public void setPermanente(boolean p) {
        this.permanente = p;
    }
}
