import java.lang.Math;

public class Circulo {
    private double x;
    private double y;
    private double raio;

    public  Circulo(){
        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }

    public Circulo(double x1, double y1, double raio1){
        this.x = x1;
        this.y = y1;
        this.raio = raio1;
    }

    // Metodo equals
    public boolean equals (Object o){
        if(this == o){
            return true;
        }
        if((o == null) || (this.getClass() != o.getClass())){
            return false;
        }
        Circulo c = (Circulo) o ;
        return (this.x == c.getX() && this.y == c.getY() && this.raio == c.getRaio()); 
    }

    // Metodo toString
    public String toString(){
        return "Centro = " + this.x + "-" + this.y + "\n"
                + "Raio = " + this.raio + "\n";
    }

    // Metodo clone
    public Circulo clone(){
        return new Circulo(this.x, this.y, this.raio);
    }

    // (a) -> getter do x
    public double getX(){
        return this.x;
    }

    // (d) -> setter do x
    public void setX(double x1){
        this.x = x1;
    }

    // (b) -> getter do y
    public double getY(){
        return this.y;
    }

    // (d) -> setter do y
    public void setY(double y1){
        this.y = y1;
    }

    // (c) -> getter do raio
    public double getRaio(){
        return this.raio;
    }

    // (d) -> setter do raio
    public void setRaio(double raio1){
        this.raio = raio1;
    }

    // (e) -> Altera o posicionamento do circulo
    public void alteraCentro(double x, double y){
        this.setX(x);
        this.setY(y);
    }

    // (f) -> Calcula a area do circulo
    public double calculaArea(){
        return (Math.PI * Math.pow(raio, 2));
    }

    // (g) -> Calcula o perimetro do circulo
    public double calculaPerimetro(){
        return (2 * Math.PI * raio);
    }
}
