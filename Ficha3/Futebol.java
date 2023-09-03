public class Futebol {
    private int estado; 
    private int golosVisitado;
    private int golosVisitante;
    
    public Futebol(){
        this.estado = 0;
        this.golosVisitado = 0;
        this.golosVisitante = 0;
    }

    public Futebol(int est, int gVisitado, int gVisitante){
        this.estado = est;
        this.golosVisitado = gVisitado;
        this.golosVisitante = gVisitante;
    }

    public Futebol(Futebol jogo) {
        this.estado = jogo.getEstado();
        this.golosVisitado = jogo.getGolosEquipaVisitada();
        this.golosVisitante = jogo.getGolosEquipaVisitante();
    }

    // (a) -> Inicia o jogo
    public void startGame(){
        this.setEstado(0);
    }

    // (b) -> Termina o jogo
    public void endGame(){
        this.setEstado(2);
    }

    // (c) -> Adiciona um golo a equipa visitada
    public void goloVisitado(){
        this.setGolosEqVisitada(this.getGolosEquipaVisitada() + 1);
    }

    // (d) -> Adiciona um golo a equipa visitante
    public void goloVisitante(){
        this.setGolosEqVisitante(this.getGolosEquipaVisitante() + 1);
    }

    // (e) -> Devolve o resultado atual do jogo
    public String resultadoActual(){
        return ("Visitada - " + getGolosEquipaVisitada() + " - " + getGolosEquipaVisitada() + " - Visitante");
    }    


    // Gets
    public int getEstado(){
        return this.estado;
    }

    public int getGolosEquipaVisitada(){
        return this.golosVisitado;
    }

    public int getGolosEquipaVisitante(){
        return this.golosVisitante;
    }

    // Sets
    public void setEstado(int est){
        this.estado = est;
    }

    public void setGolosEqVisitada(int gVisitada){
        this.golosVisitado = gVisitada;
    }

    public void setGolosEqVisitante(int gVisitante){
        this.golosVisitante = gVisitante;
    }
}
