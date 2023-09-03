package Ficha1;

import java.util.Scanner;
import static java.lang.System.out;

public class Main {
    public static void main (String [] args){

        Ficha1 f = new Ficha1();
        Scanner sc = new Scanner(System.in);
        out.println("Exercicio: ");
        int ex = sc.nextInt();
        
        switch(ex){
            case 1:
                out.println("Graus Celsius: ");
                double graus = sc.nextInt();
                double fh = f.celsiusParaFarenheit(graus);
                out.println(graus + "celsius correspondem a " + fh + " graus farenheit");
                break;
            case 2: 
                out.println("Número a: ");
                int a = sc.nextInt();
                out.println("Número b: ");
                int b = sc.nextInt();
                int maximo = f.maximoNumeros(a,b);
                out.println("O mmáximo entre " + a + " e " + b + " é " + maximo);
                break;
            case 3 : 
                System.out.println("Insira o nome e saldo");
                String nome = sc.nextLine();
                float saldo = sc.nextFloat();
                String str = f.criaDescricaoConta(nome, saldo);
                System.out.println("Resposta =" + str);
                break;
            case 4: 
                System.out.print("Insira valor em Euros: ");
                double euros = sc.nextDouble();
                System.out.print("Insira a taxa de conversão: ");
                double taxa = sc.nextDouble();
                double eurosParaLibras = f.eurosParaLibras(euros, taxa);
                System.out.print(euros + " euros correspondem a " + eurosParaLibras + " em libras");
                break;
            case 5:
                System.out.print("Insira um inteiro: ");
                int num1 = sc.nextInt();
                System.out.print("Insira um inteiro: ");
                int num2 = sc.nextInt();
                float media = (num1 + num2) / 2;
                System.out.print(Math.max(num1, num2) + " " + Math.min(num1, num2) + " " + media);
                break;
            case 6: 
                System.out.print("Insira um número: ");
                int x = sc.nextInt();
                long fat = f.factorial(x);
                System.out.print("O fatorial do número " + x + " é " + fat);
                break;
        }
    }
}
