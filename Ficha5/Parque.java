import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Parque {
    private String nomeParque;
    private Map<String, Lugar> lugares;

    public Parque(){
        this.nomeParque = "";
        this.lugares = new HashMap<String, Lugar>();
    }

    public Parque(String nomeP, Map<String, Lugar> lug){
        this.nomeParque = nomeP;
        this.lugares = lug;
    }

    public Parque(Parque p){
        this(p.getNomeParque(), p.getLugares());
    }

    // Metodo equals
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if((o==null) || (this.getClass() != o.getClass())){
            return false;
        }
        Parque p = (Parque) o;
        return (this.nomeParque.equals(p.nomeParque) && this.lugares.equals(p.lugares));
    } 

    // Metodo toString
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do parque: ");
        sb.append(nomeParque);
        if(this.lugares.isEmpty()){
            sb.append("Parque vazio");
        } else {
            sb.append("\nLugares: ");
            this.lugares.values().forEach(l-> {
                sb.append(l.toString());
                sb.append("\n");
            });
        }
        return sb.toString();
    }

    // Metodo clone
    public Parque clone(){
        return new Parque(this);
    }

    // (a) -> Devolve todas as matriculas do lugares ocupados
    public Set<String> lugaresOcup(){
        return this.lugares.keySet();
    }

    // (b) -> Regista uma nova ocupacao de lugar
    public void registaLugar(String mat, String nome, int min, boolean perm){
        this.lugares.put(mat, new Lugar(mat, nome, min, perm));
    }

    // (c) -> Remove o lugar de uma matricula
    public void removeLugar(String mat){
        this.lugares.remove(mat);
    }

    // (d) -> Altera o tempo disponivel de um lugar
    public void alteraTemp(String mat, int min){
        Lugar l = this.lugares.get(mat);
        if(l != null){
            l.setMinutos(min);
            this.lugares.replace(mat, l);
        }
    }

    // (e) -> Devolve a quantidade total de minutos - Iterador Interno
    public int totalMin(){
        return this.lugares.values().stream().mapToInt(Lugar::getMinutos).sum();
    }

    // (e) -> Devolve a quantidade total de minutos - Iterador Externo
    public int totalMinutos(){
        int totalMin = 0;
        for(Lugar l: this.lugares.values()){
            totalMin += l.getMinutos();
        }
        return totalMin; 
    }

    // (f) -> Verifica se existe lugar atribuido a matricula
    public boolean existLugar(String mat){
        return this.lugares.containsKey(mat);
    }

    // (g) -> Cria uma lista das matriculas com mais do que um certo tempo - Iterador Interno
    public List<String> listMatriculas(int x){
        return this.lugares.values().stream().filter(l -> l.isPermanente() && l.getMinutos()>x).map(Lugar::getMatricula).collect(Collectors.toList());
    }

    // (g) -> Cria uma lista das matriculas com mais do que um certo tempo - Iterador Externo
    public List<String> listMat(int x){
        List<String> lista = new ArrayList<String>();
        for(Lugar l: lugares.values()){
            if(l.getMinutos() > x && l.isPermanente()){
                lista.add(l.getMatricula()); 
            }
        }
        return lista;
    }

    // (h) -> Devolve uma copia dos lugares
    public Map<String, Lugar> copiaLugares(){
        return new HashMap<>(lugares);
    }

    // (i) -> Devolve a informacao de um lugar
    public Lugar infoMatricula (String mat){
        return this.lugares.get(mat).clone();
    }


    //Gets
    public String getNomeParque() {
        return this.nomeParque;
    }
    public Map<String, Lugar> getLugares() {
        return this.lugares.values().stream().collect(Collectors.toMap(Lugar::getMatricula, Lugar::clone));
    }

    // Sets
    public void setNomeParque(String nome) {
        this.nomeParque = nome;
    }
    public void setLugares(Map<String, Lugar> mapa) {
        this.lugares = mapa.values().stream().collect(Collectors.toMap(Lugar::getMatricula, Lugar::clone));
    }
}
