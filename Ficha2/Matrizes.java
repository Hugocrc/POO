import static java.lang.System.out;

public class Matrizes {
    
    // (a) -> Lê uma matriz
    public void lerMatriz(int[][] matriz, int numLinhas, int numColunas){
        for(int i=0; i<numLinhas; i++){
            for(int j=0; j<numColunas; j++){
                out.print(matriz[numLinhas][numColunas] + " ");
            }
            out.print("\n");
        }
    }

    // (b) -> Soma duas matrizes
    public void somaMatrizes(int[][] matriz1, int[][] matriz2, int[][] result, int numLinhas, int numColunas){
        for(int i=0; i<numLinhas; i++){
            for(int j=0; i<numColunas; j++){
                result[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
    }

    // (c) -> Verifica se duas matrizes sao iguais
    public Boolean matrizesIguais(int[][] matriz1, int[][] matriz2, int numLinhas, int numColunas){
        for(int i=0; i<numLinhas; i++){
            for(int j=0; i<numColunas; j++){
                if(matriz1[i][j] != matriz2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    // (d) -> Determina a matriz oposta de uma matriz
    public void matrizOposta(int[][] matriz, int[][] result, int numLinhas, int numColunas){
        for(int i=0; i<numLinhas; i++){
            for(int j=0; i<numColunas; j++){
                result[i][j] = -matriz[i][j];
            }
        }
    }
}
