import java.util.*;

public class CasaInteligente {
    private ArrayList<Lampada> lampadas;
    private String nomeDaCasa;


    public CasaInteligente(){
        this.lampadas = new ArrayList<>();
        this.nomeDaCasa = "";
    }

    public CasaInteligente(ArrayList<Lampada> l, String nomeDaCasa){
        this.lampadas = new ArrayList<>(l);
        this.nomeDaCasa = nomeDaCasa;
    }

    public CasaInteligente(CasaInteligente c){
        this(c.lampadas, c.nomeDaCasa);
    }

    // Metodo equals
    public boolean equals(Object o){
        if(this == o)
            return true;

        if(o == null || o.getClass() != this.getClass())
            return false;

        CasaInteligente c = (CasaInteligente) o;
        // se der falso nem entra no ciclo
        boolean same = this.nomeDaCasa.equals(c.nomeDaCasa);

        for(int i=0; i<this.lampadas.size() && same; i+=1){
            if(! (this.lampadas.get(i).equals(c.lampadas.get(i))))
                same = false;
        }

        return same;
    }

    // Metodo clone
    public CasaInteligente clone(){
        return new CasaInteligente(this);
    }

    // (b)
    // (i) -> Adiciona uma lampada
    public void addLampada(Lampada l){
        this.lampadas.add(l);
    }

    // (ii) -> Liga uma lampada no modo de consumo maximo
    public void ligaLampadaNormal(int index){
        this.lampadas.get(index).lampON();
    }

    // (iii) -> Liga um lampada no modo de consumo economico
    public void ligaLampadaEco(int index){
        this.lampadas.get(index).lampECO();
    }

    // (iv) -> Determina quantas lampadas estao ligadas no modo economico
    public int qtEmEco(){
        return (int)this.lampadas.stream()
                                 .filter(l->l.getModo().equals(Lampada.Modo.ECO))
                                 .count();
    }

    // (v) -> Remove uma lampada numa certa posicao
    public void removeLampada(int index){
        this.lampadas.remove(index);
    }

    // (vi) -> Liga todas as lampadas em modo ECO
    public void ligaTodasEco(){
        for(Lampada l: this.lampadas){
            l.setModo(Lampada.Modo.ECO);
        }
    }

    // (vi) -> Liga todas as lampadas em modo de consumo maximo
    public void ligaTodasMax(){
        for(Lampada l: this.lampadas){
            l.setModo(Lampada.Modo.ON);
        }
    }

    // (vii) -> Determina o consumo total da casa
    public double consumoTotal(){
        double consumo = 0;
        for(Lampada l: this.lampadas){
            consumo += l.getConsumoTotal();
        }
        return consumo;
    }

    // (viii) -> Determina a lampada que mais consumiu
    public Lampada maisGastadora(){
        Lampada l = null;
        double consumo = 0;
        for(Lampada la: this.lampadas){
            if(la.getConsumoTotal() > consumo){
                consumo = la.getConsumoTotal();
                l = la.clone();
            }
        }
        return l;
    }

    // (ix) ->  Devolve um conjunto com todas as lampadas que estao em modo ECO
    public Set<Lampada> podiumEconomia(){
        Set<Lampada> l = new TreeSet<>();
        ArrayList<Lampada> aux = new ArrayList<>(this.lampadas);
        aux.sort(Comparator.comparing(Lampada::getConsumoTotal));

        l.add(aux.get(0));
        l.add(aux.get(1));
        l.add(aux.get(2));
        return l;
    }

    // (x) -> Efetua um reset do contador de consumo em todas as lampadas
    public void reset(){
        for(Lampada l: this.lampadas){
            l.setConsumoPeriodo(0);
        }
    }
}