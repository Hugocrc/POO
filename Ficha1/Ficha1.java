package Ficha1; 

public class Ficha1 {

    // 1 - Converter graus Celsius em Farenheit
    public double celsiusParaFarenheit(double graus){
        return ((1.8 * graus) + 32);
    }

    // 2 - Valor maximo enttre dois
    public int maximoNumeros(int a, int b){
        return (Math.max(a,b));
    }

    // 3 - Descriçao de Conta
    public String criaDescricaoConta(String nome, double saldo){
        return ("Nome: " + nome + " Saldo: " + saldo);
    }

    // 4 - Euros para libras
    public double eurosParaLibras(double valor, double taxaConversao){
        return (valor * taxaConversao);
    }

    // 5 - main

    // 6
    public long factorial(int num){
        if (num == 1){
            return 1;
        } else {
            return (num * factorial(num - 1));
        }
    }
}
