import java.time.LocalDate;
import java.util.ArrayList;

public class Youtube {
    private String nomeVideo;
    private String conteudo;
    private LocalDate dataCarregamento;
    private int resolucaoVideo;
    private int duracaoMin;
    private int duracaoSec;
    private ArrayList<String> comentarios;
    private int likes;
    private int dislikes;

    public Youtube() {
        this.nomeVideo = "";
        this.conteudo = "";
        this.dataCarregamento = LocalDate.now();
        this.resolucaoVideo = 0;
        this.duracaoMin = 0;
        this.duracaoSec = 0;
        this.comentarios = new ArrayList<>();
        this.likes = 0;
        this.dislikes = 0;
    }

    public Youtube(String name, String content, LocalDate date, int resolution, int durationMin, int durationSec, ArrayList<String> coments, int likes, int dislikes) {
        this.nomeVideo = name;
        this.conteudo = content;
        this.dataCarregamento = date;
        this.resolucaoVideo = resolution;
        this.duracaoMin = durationMin;
        this.duracaoSec = durationSec;
        this.comentarios = coments;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Youtube(Youtube video) {
        this.nomeVideo = video.getNomeVideo();
        this.conteudo = video.getConteudo();
        this.dataCarregamento = video.getData();
        this.resolucaoVideo = video.getResolucao();
        this.duracaoMin = video.getDuracaoMin();
        this.duracaoSec = video.getDuracaoSec();
        this.comentarios = video.getComentarios();
        this.likes = video.getLikes();
        this.dislikes = video.getDislikes();
    }

    // Metodo toString
    public String toString() {
        return ("Nome: " + getNomeVideo() + "\n" +
                "Conteúdo: " + getConteudo() + "\n" +
                "Data de Upload: " + getData() + "\n" +
                "Resolução: " + getResolucao() + "\n" +
                "Tempo em minutos: " + getDuracaoMin() + "\n" +
                "Tempo em segundos: " + getDuracaoSec() + "\n" +
                "Comentários: " + getComentarios() + "\n" +
                "Likes: " + getLikes() + "\n" +
                "Dislikes: " + getDislikes() + "\n");
    }

    // Metodo equals
    public boolean equals(Object obj) {
        if(obj == this)
            return true;

        if((obj == null) || (this.getClass() != obj.getClass()))
            return false;

        Youtube video = (Youtube) obj;
        return (this.nomeVideo == video.getNomeVideo() &&
                this.conteudo.equals(video.getConteudo()) &&
                this.dataCarregamento.equals(video.getData()) &&
                this.resolucaoVideo == video.getResolucao() &&
                this.duracaoMin == video.getDuracaoMin() &&
                this.duracaoSec == video.getDuracaoSec() &&
                this.comentarios == video.getComentarios() &&
                this.likes == video.getLikes() &&
                this.dislikes == video.getDislikes());
    }

    // Metodo clone
    public Youtube clone() {
        return new Youtube(this);
    }

    // (b) -> Insere um comentario
    public void insereComentario(String comentario){
        this.comentarios.add(comentario);
    }

    // (c) -> Determina ha quantos dias o video foi publicado
    public long qtsDiasDepois(){
        return LocalDate.now().getDayOfYear() - dataCarregamento.getDayOfYear();
    }

    // (d) -> Faz um like
    public void thumbsUp(){
        this.setLikes(this.getLikes() + 1);
    }

    // (e) -> Devolve o conteudo
    public String processa(){
        return this.conteudo;
    }


    // Gets
    public String getNomeVideo() {
        return this.nomeVideo;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public LocalDate getData() {
        return dataCarregamento;
    }

    public int getResolucao() {
        return this.resolucaoVideo;
    }

    public int getDuracaoMin() {
        return this.duracaoMin;
    }

    public int getDuracaoSec() {
        return this.duracaoMin;
    }

    public ArrayList<String> getComentarios() {
        return this.comentarios;
    }

    public int getLikes() {
        return this.likes;
    }

    public int getDislikes() {
        return this.dislikes;
    }

    // Sets
    public void setName(String nome) {
        this.nomeVideo = nome;
    }

    public void setContent(String content) {
        this.conteudo = content;
    }

    public void setUploadDate(LocalDate data) {
        this.dataCarregamento = data;
    }

    public void setResolution(int resolucao) {
        this.resolucaoVideo = resolucao;
    }

    public void setDurationMin(int durationMin) {
        this.duracaoMin = durationMin;
    }

    public void setDurationSec(int durationSec) {
        this.duracaoSec = durationSec;
    }

    public void setComents(ArrayList<String> coments) {
        this.comentarios = coments;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

}
