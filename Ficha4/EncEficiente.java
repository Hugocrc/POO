import java.time.LocalDate;
import java.util.ArrayList;

public class EncEficiente {
    private String nome;
    private double NIF;
    private String morada;
    private double numEnc;
    private LocalDate data;
    private ArrayList<LinhaEncomenda> linhaEnc;

    public EncEficiente(){
        this.nome = "";
        this.NIF = 0;
        this.morada = "";
        this.numEnc = 0;
        this.data = LocalDate.now();
        this.linhaEnc = new ArrayList<LinhaEncomenda>();
    }

    public EncEficiente(String nome, double NIF, String morada, double numEnc, LocalDate data, ArrayList<LinhaEncomenda> enc){
        this.nome = nome;
        this.NIF = NIF;
        this.morada = morada;
        this.numEnc = numEnc;
        this.data = data;
        this.linhaEnc = new ArrayList<LinhaEncomenda>(enc);
    }

    public EncEficiente(EncEficiente e){
        this(e.nome, e.NIF, e.morada, e.numEnc, e.data, e.linhaEnc);
    }

    // Metodo equals
    public boolean equals(Object o){
        if(this == o)
            return true;

        if((o == null) || (this.getClass() != o.getClass()))
            return false;

        EncEficiente enc = (EncEficiente) o;

        return(
              this.nome.equals(enc.nome) && this.NIF == enc.NIF           &&
              this.morada.equals(enc.morada) && this.numEnc == enc.numEnc &&
              this.data.equals(enc.data) && this.linhaEnc.equals(enc.linhaEnc)
            );
    }

    // Metodo toString
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nCliente: " + this.nome);
        sb.append("\nNIF: " + this.NIF);
        sb.append("\nMorada: " + this.morada);
        sb.append("\nNúmero de encomenda: " + this.numEnc);
        sb.append("\nData da encomenda: " + this.data);
        sb.append("\nLinhas de encomenda: " + this.linhaEnc.toString());

        return sb.toString();
    }

    // Metodo clone
    public EncEficiente clone(){
        return new EncEficiente(this);
    }

    // (b)
    // (ii) -> Determina o valor total da encomenda
    public double calculaValorTotal(){
        return this.linhaEnc.stream()
                            .mapToDouble(LinhaEncomenda::calculaValorLinhaEnc)
                            .sum();
    }

    // (iii) -> Determina o valor total dos descontos
    public double calculaValorDesconto(){
        return this.linhaEnc.stream()
                            .mapToDouble(LinhaEncomenda::getDesconto)
                            .sum();
    }

    // (iv) -> Determina o nummero total de produtos a receber
    public int numeroTotalProdutos(){
        return this.linhaEnc.stream()
                            .mapToInt(LinhaEncomenda::getQuantidade)
                            .sum();
    }

    // (v) -> Determina se um produto vai ser encomendado
    public boolean existeProdutoEncomenda(String refProduto){
        return this.linhaEnc.stream()
                            .anyMatch(l -> l.getReferencia().equals(refProduto));
    } 

    // (vi) -> Adiciona uma nova linha de encomenda
    public void adicionaLinha(LinhaEncomenda linha){
        this.linhaEnc.add(linha.clone());
    }

    // (vii) -> Remove uma linha de encomenda
    public void removeProduto(String codProd){
        this.linhaEnc.removeIf(l -> l.getReferencia().equals(codProd));
    }


    // Gets
    public String getNome() {
        return this.nome;
    }

    public double getNIF() {
        return this.NIF;
    }

    public String getMorada() {
        return this.morada;
    }

    public double getNumEnc() {
        return this.numEnc;
    }

    public LocalDate getData() {
        return this.data;
    }

    public ArrayList<LinhaEncomenda> getLinhaEnc() {
        ArrayList<LinhaEncomenda> novo = new ArrayList<LinhaEncomenda>();
        for(LinhaEncomenda l: this.linhaEnc){
            novo.add(l.clone());
        }
        return novo;
    }

    // Sets
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNIF(double NIF) {
        this.NIF = NIF;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setNumEnc(double numEnc) {
        this.numEnc = numEnc;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setLinhaEnc(ArrayList<LinhaEncomenda> linhaEnc) {
        this.linhaEnc = new ArrayList<>();
        for(LinhaEncomenda l: linhaEnc){
            this.linhaEnc.add(l.clone());
        }
    }

}
