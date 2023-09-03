public class Telemovel {
    private String marca;
    private String modelo;
    private int xDisplay;
    private int yDisplay;
    private int numMensagens;
    private String[] mensagens;
    private int armFotosApps;
    private int armFotos;
    private int armApps;
    private int espOcupado;
    private int numFotoGuard;
    private int numAppsInst;
    private String[] nomeAppsInst;

    public Telemovel(){
        this.setMarca("");
        this.setModelo("");
        this.setxDisplay(300);
        this.setyDisplay(1024);
        this.setNumMensagens(0);
        this.setMensagens(128);
        this.setArmFotosApps(512);
        this.setArmFotos(128);
        this.setArmApps(384);
        this.setEspOcupado(0);
        this.setNumFotosGuard(0);
        this.setNumAppsInst(0);
        this.setNomeAppsInst(384);
    }

    public Telemovel(String marca, String modelo, int xDisplay, int yDisplay, int numeroMensagens, int armFotosApps, int armFotos, int armApps){
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setxDisplay(xDisplay);
        this.setyDisplay(yDisplay);
        this.setNumMensagens(numeroMensagens);
        this.setMensagens(128);
        this.setArmFotosApps(armFotosApps);
        this.setArmFotos(armFotos);
        this.setArmApps(armApps);
        this.setEspOcupado(0);
        this.setNumFotosGuard(0);
        this.setNumAppsInst(0);
        this.setNomeAppsInst(armApps);
    }    

    public Telemovel(Telemovel t){
        this(t.getMarca(), t.getModelo(), t.getxDisplay(), t.getyDisplay(), t.getNumMensagens(), t.getArmFotosApps(), t.getArmFotos(), t.getArmApps());
    }

    // Metodo equals
    public boolean equals(Object umTelemovel){
        if(this == umTelemovel)
            return true;

        if((umTelemovel == null) || (this.getClass() != umTelemovel.getClass()))
            return false;

        Telemovel t = (Telemovel)umTelemovel;

        return (this.getMarca().equals(t.getMarca()) && this.getModelo().equals(t.getModelo())        &&
                this.getxDisplay() == t.getxDisplay() && this.getyDisplay() == t.getyDisplay()        &&
                this.getNumMensagens() == t.getNumMensagens() && this.getArmFotosApps() == t.getArmFotosApps() &&
                this.getArmFotos() == t.getArmFotos() && this.getArmApps() == t.getArmApps()     &&
                this.getEspOcupado() == t.getEspOcupado() && this.getNumFotosGuard() == t.getNumFotosGuard()               &&
                this.getNumAppsInst() == t.getNumAppsInst()
            );
    }

    // Metodo toString
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Marca: ").append(this.getMarca());
        sb.append("\nModelo: ").append(this.getModelo());
        sb.append("\nResolução: ").append(this.getxDisplay()).append("x").append(this.getyDisplay());
        sb.append("\nArmazenamento: ").append(this.getArmFotosApps());
        sb.append("\nEspaço ocupado: ").append(this.getEspOcupado());
        sb.append("\nNumero de fotos guardadas: ").append(this.getArmFotos());
        sb.append("\nNumero de apps instaladas: ").append(this.getArmApps());

        return sb.toString();
    }

    // Metodo clone
    public Telemovel clone(){
        return new Telemovel(this);
    }

    // (a) -> Determina se um certo conteudo pode ser carregado para o telemovel
    public boolean existeEspaco(int numeroBytes){
        int espaco = this.getEspOcupado();
        int arm = this.getArmFotosApps();

        return (espaco + numeroBytes <= arm);
    }

    // (b) -> Instala uma aplicacao nova
    public void instalaApp(String nome, int tamanho){
        if(existeEspaco(tamanho)){
            this.setArmFotosApps(getArmApps() + tamanho);
            this.nomeAppsInst[getNumAppsInst()] = nome;
            this.setNumAppsInst(getNumAppsInst() + 1);
            this.setEspOcupado(this.getEspOcupado() + tamanho);
        }else{
            System.out.println("Espaço Insuficiente");
        }
    }

    // (c) -> Receber e guarda uma mensagem
    public void recebeMsg(String msg){
        int num = this.getNumMensagens() + 1;
        String[] novo = this.getMensagens();
        this.setMensagens(num);
        System.arraycopy(novo, 0, this.mensagens, 0, num-1);
        this.mensagens[num-1] = msg;
        this.setNumMensagens(num);
    }

    // (d) -> Determina o tamanho médio das aplicações
    public double tamMedioApps(){
        return (getArmApps()/(double)getNumAppsInst());
    }

    // (e) -> Devolve a maior mensagem
    public String maiorMsg(){
        int indice = 0;
        int tamMaiorMens = 0;
        String[] msg = this.getMensagens();

        for(int i=0; i<this.getNumMensagens(); i++){
            if(msg[i].length() > tamMaiorMens){
                indice = i;
                tamMaiorMens = msg[i].length();
            }
        }
        return msg[indice];
    }

    // (f) -> Desinstala uma aplicacao
    public void removeApp(String nome, int tamanho){
        int num  = getNumAppsInst() -1;
        String[] novo = new String[num];
        String[] apps = this.getNomeAppsInst();
        this.setNomeAppsInst(num);

        for(int i=0, j=0; i<num+1; i++){
            if(apps[i] != null && !apps[i].equals(nome)) {
                novo[j] = apps[i];
                j += 1;
            }
        }

        this.setEspOcupado(this.getEspOcupado() - tamanho);
        this.setArmApps(this.getArmApps() - tamanho);
        this.setNumAppsInst(num);
        System.arraycopy(novo, 0, this.nomeAppsInst, 0, this.getNumAppsInst());
    }
    

    // Gets
    public String getMarca(){
        return this.marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public int getxDisplay(){
        return this.xDisplay;
    }

    public int getyDisplay(){
        return this.yDisplay;
    }

    public int getNumMensagens(){
        return this.numMensagens;
    }

    public int getArmFotosApps(){
        return this.armFotosApps;
    }

    public int getArmFotos(){
        return this.armFotos;
    }

    public int getArmApps(){
        return this.armApps;
    }

    public int getEspOcupado(){
        return this.espOcupado;
    }

    public int getNumAppsInst(){
        return this.numAppsInst;
    }

    public int getNumFotosGuard(){
        return this.numFotoGuard;
    }

    public String[] getMensagens(){
        String[] r = new String[this.numMensagens];

        if(this.numMensagens > 0){
            System.arraycopy(this.mensagens, 0, r, 0, this.numMensagens);
        }

        return r;
    }

    public String[] getNomeAppsInst(){
        String[] r = new String[this.getNumAppsInst()];

        if(this.getNumAppsInst() > 0){
            System.arraycopy(this.nomeAppsInst, 0, r, 0, this.getNumAppsInst());
        }

        return r;
    }

    // Sets
    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public void setxDisplay(int xDisplay){
        this.xDisplay = xDisplay;
    }

    public void setyDisplay(int yDisplay){
        this.yDisplay = yDisplay;
    }

    public void setNumMensagens(int numeroMensagens){
        this.numMensagens = numeroMensagens;
    }

    public void setMensagens(int numeroMensagens){
        this.mensagens = new String[numeroMensagens];
    }

    public void setArmFotosApps(int armazenamentoFotosApps){
        this.armFotosApps = armazenamentoFotosApps;
    }

    public void setArmFotos(int armazenamentoFotos){
        this.armFotos = armazenamentoFotos;
    }

    public void setArmApps(int armazenamentoApps){
        this.armApps = armazenamentoApps;
    }

    public void setEspOcupado(int espacoOcupado){
        this.espOcupado = espacoOcupado;
    }

    public void setNumFotosGuard(int numFotosGuardadas){
        this.numFotoGuard = numFotosGuardadas;
    }

    public void setNumAppsInst(int numAppsInstaladas){
        this.numAppsInst = numAppsInstaladas;
    }

    public void setNomeAppsInst(int armApps){
        this.nomeAppsInst = new String[armApps];
    }
}
