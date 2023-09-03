import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Fitness {
    private List<Utilizador> utilizadores;

    public Fitness(){
        this.utilizadores = new ArrayList<>();
    }

    // (a) -> Verifica a esxistencia de um utilizador
    public boolean existeUtilizador(String email){
        for(Utilizador u: this.utilizadores){
            if(u.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    // (b) -> Devolve a quantidade de utlizadores
    public int quantos(){
        return this.utilizadores.size();
    }

    // (c) -> Devolve o numero total de atividades desportivas efetuadas por um utilizador
    public int quantos(String atividade, String email){
        int ativ = 0;
        for(Utilizador u: this.utilizadores){
            if(u.getEmail().equals(email)){
                for(Atividade a: u.getAtividades().values()){
                    if(a.getDescricao().equals(atividade)){
                        ativ++;
                    }
                }
            }
        }
        return ativ;
    }

    // (d) -> Devolve a informacao de um utilizador
    public Utilizador getUtilizador(String email){
        for(Utilizador u: this.utilizadores){
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }

    // (e) -> Adiciona uma atividade ao registo do utilizador
    public void adiciona(String email, Atividade act){
        for(Utilizador u: this.utilizadores){
            if(u.getEmail().equals(email)){
                u.getAtividades().put(email, act);
            }
        }
    }

    // (f) -> Devolve uma lista com todas as atividades existentes
    public List<Atividade> getAllAtividades(){
        List<Atividade> atividades = new ArrayList<Atividade>();
        for(Utilizador u: this.utilizadores){
            for(Atividade a: u.getAtividades().values()){
                atividades.add(a);
            }
        }
        return atividades;
    }

    // (g) -> Adiciona a informacao de um conjunto de atividades de um utilizador
    public void adiciona(String email, Set<Atividade> activs){
        for(Utilizador u: this.utilizadores){
            if(u.getEmail().equals(email)){
                for(Atividade a: activs){
                    u.getAtividades().put(email, a);
                }
            }
        }
    }

    // (h) -> Indica o numero total de minutos de um Utilizador nas atividades
    public int tempoTotalUtilizador(String email){
        int tempo = 0;
        for(Utilizador u: this.utilizadores){
            if(u.getEmail().equals(email)){
                for(Atividade a: u.getAtividades().values()){
                    tempo += a.getDuracao();
                }
            }
        }
        return tempo;
    }

    // (i) -> Devolve a atividade com maior dispendio de calorias
    public Atividade actividadeMaisExigente(){
        Atividade ativ = null;
        double maisCal = 0;
        double cal;
        
        for(Utilizador u: this.utilizadores){
            for(Atividade a: u.getAtividades().values()){
                cal = 0;
                if(a instanceof Corrida){
                    cal += ((Corrida) a).calorias(u);
                } else if (a instanceof Canoagem){
                    cal += ((Canoagem) a).calorias(u);
                } else if (a instanceof Abdominal){
                    cal += ((Abdominal) a).calorias(u);
                }

                if(cal > maisCal){
                    maisCal = cal;
                    ativ = a;
                }
            }
        }
        return ativ; 
    }

    // (j) -> Obter o Utilizador com mais dispendio de calorias
    public Utilizador utilizadorMaisActivo(){
        Utilizador uti = null;
        double maisCalorias = 0;
        double cal;

        for(Utilizador u: utilizadores){
            cal = 0;
            for(Atividade a: u.getAtividades().values()){
                if(a instanceof Corrida){
                    cal += ((Corrida) a).calorias(u);
                } else if (a instanceof Canoagem){
                    cal += ((Canoagem) a).calorias(u);
                } else if (a instanceof Abdominal){
                    cal += ((Abdominal) a).calorias(u);
                }
            }
            if(cal > maisCalorias){
                maisCalorias = cal;
                uti = u;
            }
        }
        return uti;
    }

    // (k) -> Atualiza a informacao relativa ao seu desporto favorito do Utilizador
    public void actualizaDesportoFav(){
        for(Utilizador u: utilizadores){
            u.setDesportoFavorito(null);
        }
    }


    // Gets
    public List<Utilizador> getUtilizadores() {
        return utilizadores;
    }

    // Sets
    public void setUtilizadores(List<Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }
}
