public class Turma {
    private int[][] notasTurma;
    private int numAlunos;
    private int ucs;

    public Turma(int numA, int ucs){
        notasTurma = new int[numAlunos][ucs];
        this.numAlunos = numA;
        this.ucs = ucs;
    }

    public void setNota (int aluno, int uc, int novaNota){
        this.notasTurma[aluno][uc] = novaNota;
    }

    public int getNota(int aluno, int uc){
        return this.notasTurma[aluno][uc];
    }

    // (a) -> Atualizar a pauta
    public void atualizaPauta(int aluno, int uc, int nota){
        setNota(aluno, uc, nota);
    }

    // (b) -> Calcula a soma das notas de uma uc
    public int somaNotasUC(int uc){
        int soma = 0;
        for(int i=0; i<this.ucs; i++){
            soma += getNota(i, uc);
        }
        return soma;
    }

    // (c) -> Calcula a media das notas de um aluno
    public double mediaNotasAluno(int aluno){
        double media = 0.0, soma = 0.0;
        for(int i=0; i<this.ucs; i++){
            soma += this.notasTurma[aluno][i];
        }
        media = soma/this.ucs;

        return media;
    }

    // (d) -> Calcula a media de uma uc
    public double mediaUC(int uc){
        double soma = 0.0, media = 0.0;
        for(int i=0; i<this.ucs; i++){
            soma += getNota(i, uc);
        }
        media = soma/this.numAlunos;

        return media;
    }

    // (e) -> Calcula a nota mais alta de todas
    public int notaMaisAlta(){
        int maisAlta = notasTurma[0][0];

        for(int i=0; i<this.ucs; i++){
            for(int j=0; j<this.ucs; j++){
                if(notasTurma[i][j] > maisAlta){
                    maisAlta = notasTurma[i][j];
                }
            }
        }

        return maisAlta;
    }

    // (f) -> Calcula a nota mais baixa de todas
    public int notaMaisBaixa(){
        int maisBaixa = notasTurma[0][0];

        for(int i=0; i<this.ucs; i++){
            for(int j=0; j<this.ucs; j++){
                if(notasTurma[i][j] < maisBaixa){
                    maisBaixa = notasTurma[i][j];
                }
            }
        }

        return maisBaixa;
    }

    // (g) -> Devolve um array com as notas acima de um valor
    public int[] acimaDe (int valor){
        int[] res = new int[this.numAlunos*this.ucs];
        int i=0;

        for(int[] aluno: this.notasTurma){
            for(int nota: aluno){
                if(nota > valor){
                    res[i++] = nota;
                }
            }
        }

        int[] result = new int[i];
        System.arraycopy(res, 0, result, 0, i);
        return result;
    }

    // (h) -> Calcula uma String com as notas todas
    public String todasNotas(){
        String notas = "Notas dos Alunos: \n";

        int i,j;
        for(i=0; i<this.numAlunos; i++){
            notas = notas.concat("Aluno " + i + ":\n");
            for(j=0; j<this.ucs; j++){
                notas = notas.concat("UC " + j + ": " + this.notasTurma[i][j] + "\n");
            }
        }

        return notas;
    }

    // (i) -> Determina o indice da uc com a media mais elevada
    public int ucMaisAlta(){
        double media, maxMedia = mediaUC(0);
        int max = 0;

        for(int i=0; i<this.ucs; i++){
            media = this.mediaUC(i);
            if(media > maxMedia){
                maxMedia = media;
                max = i;
            }
        }

        return max;
    }
}
