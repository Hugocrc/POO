import java.util.Arrays;
import java.util.Scanner;

public class Array{
    Scanner scan = new Scanner(System.in);

    // (a) -> Cria e preenche um array e determina o minimo de um array 
    public int minimo(int size){
        int[] array = new int[size]; // Criar o array de inteiros
        int i;

        // Preencher o array
        for(i=0; i<size; i++){
            System.out.print("Insere um número: ");
            int numero = scan.nextInt();
            array[i] = numero;
        }

        int min = array[0];
        for(i=0; i<size; i++){
            if(array[i] < min){
                min = array[i];
            }
        }

        return min;
    }

    // (b) -> Determina o array entre dois indices
    public void arrayEntreInd(int size){
        int[] array = new int[size];

        // Preencher o array
        for(int i=0; i<size; i++){
            System.out.print("Insira um número: ");
            int numero = scan.nextInt();
            array[i] = numero;
        }

        System.out.println("Índice 1: ");
        int ind1 = scan.nextInt();
        System.out.println("Índice 2: ");
        int ind2 = scan.nextInt();

        // Caso os indices estejam fora do limite
        if(ind1 < 0 || ind2 >= size){
            System.out.print("Indices inválidos.");
        }

        int[] entreInd = new int[ind2 - ind1];
        for(int i=0; i<ind2-ind1; i+=1){
            entreInd[i] = array[i + ind1];
            System.out.print(entreInd[i]);
        }
    }

    // (c) ->  Determina o array com os elementos em comum entre dois arrays
    public void comuns(int size, int[] comuns){
        int[] array1 = new int[size];
        int[] array2 = new int[size];
        int j = 0;

        // Preencher array1
        for(int i=0; i<size; i++){
            System.out.print("Insira um número: ");
            int numero = scan.nextInt();
            array1[i] = numero;
        }

        // Preencher array2
        for(int i=0; i<size; i++){
            System.out.print("Insira um número: ");
            int numero = scan.nextInt();
            array2[i] = numero;
        }

        for(int i=0; i<size; i++){
            if(Arrays.binarySearch(array2, array1[i]) >= 0){
                comuns[j] = array1[i];
            }
            j++;
        }
    }


    // OUTRO EXERCICIO

    // (a) -> Ordena um array por ordem crescente
    public void ordenaCrescente (int size){
        int[] array = new int[size];

        // Preencher o array
        for(int i=0; i<size; i++){
            System.out.print("Insira um número: ");
            int numero = scan.nextInt();
            array[i] = numero;
        }

        // Array.sort(array); OU 
        int menor;
        for(int i=0; i<size; i++){
            menor = i;
            for(int j=i; j<size; j++){
                if(array[j] < array[menor]){
                    menor = j;
                }
                swap(array,i, menor);
            }
        }
    }

    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    // (b) -> Implementa a procura binária de um elemento num array 
    public int procuraBinaria(int size){
        int[] array = new int[size];

        // Preencher o array
        for(int i=0; i<size; i++){
            System.out.print("Insira um número: ");
            int numero = scan.nextInt();
            array[i] = numero;
        }

        System.out.print("Insira o número de procura: ");
        int x = scan.nextInt();

        return Arrays.binarySearch(array, x);
    }
}