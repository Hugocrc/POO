import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Exercicio: ");
        int ex = sc.nextInt();
        System.out.print("Alinea: ");
        String al = sc.next();

        switch(ex){
            case 1:
                Circulo c = new Circulo(0,0,1);
                switch (al){
                    case "a": 
                        double x = c.getX();
                        System.out.println("Valor em x: " + x);
                        break;
                    case "b":
                        double y = c.getY();
                        System.out.println("Valor em y: " + y);
                        break;
                    case "c":
                        double raio = c.getRaio();
                        System.out.println("Valor do raio: " + raio);
                        break;
                    case "d":
                        c.setX(2);
                        c.setY(2);
                        c.setRaio(16);
                        System.out.println("X: " + c.getX());
                        System.out.println("Y: " + c.getY());
                        System.out.println("Raio: " + c.getRaio());
                        break;
                    case "e":
                        c.alteraCentro(3, 3);
                        System.out.println("X: " + c.getX());
                        System.out.println("Y: " + c.getY());
                        break;
                    case "f":
                        double area = c.calculaArea();
                        System.out.print("Area do circulo: " + area);
                        break;
                    case "g":
                        double p = c.calculaPerimetro();
                        System.out.print("Perímetro do circulo: " + p);
                        break;
                }
                break;
            
            case 2:
                Telemovel tl = new Telemovel("Samsung", "A52", 300, 600, 40, 10000, 4000, 6000);
                tl.instalaApp("Whatsapp", 1000);
                tl.instalaApp("Instagram", 1000);
                tl.instalaApp("Blackboard", 1000);

                switch(al){
                    case "a":
                        boolean espaco = tl.existeEspaco(3000);
                        System.out.println("Existe espaço: " + espaco);
                        break;
                    case "b":
                        String[] apps = tl.getNomeAppsInst();
                        System.out.println("----- Apps instaladas ----");
                        for(int i=0; i< tl.getNumAppsInst(); i+=1){
                            System.out.println(apps[i]);
                        }
                        break;
                    case "c":
                        tl.recebeMsg("I'm not great at the advice.");
                        tl.recebeMsg("Can I interest you in a sarcastic comment?");
                        tl.recebeMsg("Some cheese?");
                        String[] mensagens = tl.getMensagens();
                        System.out.println("-------------- Mensagens --------------");
                        for(int i =0; i<tl.getNumMensagens(); i+=1){
                            System.out.println(mensagens[i]);
                        }
                        break;
                }
                break;
            
            case 3:
                Youtube video1 = new Youtube();
                switch (al){
                    case "b":
                        video1.insereComentario("Loved it!");
                        video1.insereComentario("Agreed with every single one!");
                        video1.insereComentario("DAMN IT! I WANT TO STUDY COMPUTER SCIENCE NOW!");

                        System.out.println("---------------- Comentários video 1 ----------------");
                        ArrayList<String> comentarios = video1.getComentarios();
                        for(int i = 0; i<comentarios.size(); i+=1)
                            System.out.println("Comentário " + (i+1) +": " + comentarios.indexOf(i));

                        break;
                    case "c":
                        System.out.println("Passaram " + video1.qtsDiasDepois() + " dias");
                        break;
                    case "d":
                        for(int i = 0; i< 100; i+=1)
                            video1.thumbsUp();
                        System.out.println("Likes: " + video1.getLikes());
                        break;
                    default:
                        System.out.println("Alínea inexistente");
                        break;
                }
                break;
              
            case 4:
                Futebol f = new Futebol();
                switch(al){
                    case "a":
                        f.startGame();
                        break;
                    case "b": 
                        f.endGame();
                        break;
                    case "c":
                        f.goloVisitado();
                        break;
                    case "d":
                        f.goloVisitante();
                        break;
                    case "e": 
                        f.resultadoActual();
                        break;
                }
                break;
        }
    }
}
