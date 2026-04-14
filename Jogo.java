import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception {
        var gerador = new Random();
        var p1 = new Personagem();
        p1.nome = "Mateus Mito";

        while(true){
        var acao = gerador.nextInt(1, 4);
            switch(acao){
                case 1:
                    p1.cacar();
                    break;
                case 2:
                    p1.comer();
                    break;
                case 3:
                    p1.dormir();
                    break;
            }
            System.out.println("****************************");
            System.out.println(p1);
            Thread.sleep(5000);
            p1.inventario();

        }

    }   
}