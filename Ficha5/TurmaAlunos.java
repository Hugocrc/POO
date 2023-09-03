import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TurmaAlunos {
    private Map<String, Aluno> alunos;
    private String nomeTurma;
    private String uc;

    public TurmaAlunos() {
        this.alunos = new HashMap<>();
        this.nomeTurma = "";
        this.uc = "";
    }

    public TurmaAlunos(Map<String, Aluno> al, String nome, String UC) {
        this.alunos = al.values().stream().collect(Collectors.toMap(Aluno::getNumero, Aluno::clone));
        this.nomeTurma = nome;
        this.uc = UC;
    }

    public TurmaAlunos(TurmaAlunos t) {
        this(t.alunos,t.nomeTurma,t.uc);
    }

    // Metodo equals
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || this.getClass() != o.getClass()) return false;

        TurmaAlunos t = (TurmaAlunos) o;
        return  this.nomeTurma.equals((t.nomeTurma)) &&
                this.uc.equals(t.uc) &&
                this.alunos.equals(t.alunos);
    }

    // Metodo toString
    public String toString() {
        StringBuilder sb = new StringBuilder("Turma: ");

        sb.append(this.nomeTurma);
        sb.append("\nUC: "); sb.append(this.uc);
        if (!this.alunos.isEmpty()) {
            sb.append("\nAlunos: \n\n");
            this.alunos.values().forEach(a->{
                sb.append(a.toString());
                sb.append("\n");
            });
        }

        return sb.toString();
    }

    // Metodo clone
    public TurmaAlunos clone() {
        return new TurmaAlunos(this);
    }

    // Metodo compareTo
    public int compareTo(Object o) {
        if (o.getClass() != this.getClass()) return 1;

        TurmaAlunos t = (TurmaAlunos) o;
        if (!this.nomeTurma.equals(t.nomeTurma)) {
            return this.nomeTurma.compareTo(t.nomeTurma);
        }
        if (!this.uc.equals(t.uc)) {
            return this.uc.compareTo(t.uc);
        }
        if (!this.alunos.equals(t.alunos)) {
            return this.alunos.size() - t.alunos.size();
        }
        return 0;
    }

    // (b) -> Adiciona um novo aluno a turma
    public void insereAluno(Aluno a){
        this.alunos.put(a.getNumero(), a.clone());
    }

    // (c) -> Devolve a instancia de Aluno associada 
    public Aluno getAluno(String codAluno){
        return this.alunos.getOrDefault(codAluno, null).clone();
    }

    // (d) -> Remove uma aluno
    public Aluno removeAluno(String codAluno){
        return this.alunos.remove(codAluno);
    }

    // (e) -> Devolve a informacao de todos os numeros de alunos
    public Set<String> todosOsCodigos(){
        Set<String> inf = new HashSet<String>();
        for(Aluno a: this.alunos.values()){
            inf.add(a.getNumero());
        }
        return inf;
    }

    // (f) -> Devolve a informacao de quantos alunos existem na turma
    public int qtsAlunos(){
        int quant = 0;
        for(Aluno a: this.alunos.values()){
            quant ++;
        }
        return quant;
        // return this.alunos.size();
    }

    // (g) -> Devolve os alunos por ordem alfabetica
    public Collection<Aluno> alunosOrdemAlfabetica(){
        return this.alunos.values().stream().sorted().collect(Collectors.toList());
    }

    // (h) -> Devolve os alunos ordenados pelo seu numero
    public Set<Aluno> alunosOrdemDescrescenteNumero(){
        return this.alunos.values().stream()
                                   .sorted(Comparator.comparingInt(Aluno::getNumero).reversed())
                                   .collect(Collectors.toCollection(LinkedHashSet::new));
    }


    // Gets
    public String getUc() {
        return this.uc;
    }

    public String getNomeTurma() {
        return this.nomeTurma;
    }

    public Map<String, Aluno> getAlunos() {
        return this.alunos.values().stream().collect(Collectors.toMap(Aluno::getNumero, Aluno::clone));
    }

    // Sets
    public void setAlunos(Map<String, Aluno> al) {
        this.alunos = al.values().stream().collect(Collectors.toMap(Aluno::getNumero, Aluno::clone));
    }

    public void setNomeTurma(String nome) {
        this.nomeTurma = nome;
    }

    public void setUc(String UC) {
        this.uc = UC;
    }
}
