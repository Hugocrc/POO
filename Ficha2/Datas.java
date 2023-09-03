import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Datas {
    private LocalDate[] data;
    private int numInsertions;
    private int size;

    public Datas(int size){
        this.data = new LocalDate[size];
        this.numInsertions = 0;
        this.size = size;
    }

    // (a) -> Insere uma nova data
    public void insereData(LocalDate data){
        if(numInsertions < size){
            this.data[this.numInsertions++] = data;
        }
    }

    // (b) -> Determina a data mais proxima
    public LocalDate dataMaisProxima(LocalDate data){
        long minDist = ChronoUnit.DAYS.between(this.data[0], data);
        int index = 0;

        for(int i=0; i<this.numInsertions; i+= 1){
            long time = ChronoUnit.DAYS.between(this.data[i], data);
            if(time < minDist) {
                index = i;
                minDist = time;
            }
        }

        return this.data[index];
    }

    // (c) -> Devolve uma String com todas as datas
    public String toString(){
        String string = "";

        for(int i=0; i<this.numInsertions; i+=1)
            string += this.data[i] + "\n";

        return string;
    }
}
