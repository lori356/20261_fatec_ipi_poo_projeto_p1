import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception {
        var gerador = new Random();
        var p1 = new Personagem();
        p1.nome = "Renato Rapper";

        ArrayList<Musica> colecao = new ArrayList<>();
        colecao.add(new Musica("Geração Coca-Cola"));
        colecao.add(new Musica("Master Of Puppets"));
        colecao.add(new Musica("Debí Tirar Más Fotos"));
        colecao.add(new Musica("One Beer"));
        colecao.add(new Musica("Angel Of Death"));
        colecao.add(new Musica("Virtual Insanity"));
        colecao.add(new Musica("INVISIBLE"));
        colecao.add(new Musica("Cheia De Manias"));
        colecao.add(new Musica("War Pigs"));
        colecao.add(new Musica("Vira-Vira"));

        while(!p1.morte()){  
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
            p1.aprenderMusica(colecao);
            p1.inventario();
            System.out.println("Músicas Conhecidas: "+p1.repertorio);
            System.out.println(p1);
            Thread.sleep(5000);
            System.out.println("******************************************************");
            
            
        }
        
        System.out.println("******************************************************");
        System.out.println(p1.nome + " está morto.");
        p1.inventario();
    }   
}