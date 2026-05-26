import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception {
        var p1 = new Cacador("Hans Hunter" , 10, 0, 0);
        var p2 = new Bardo("Tico Trovador" , 3, 8, 8);
        var gerador = new Random();

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

        p2.getRepertorio().add(new Musica("A Melódia de Tico Trovador"));

        while(!p1.morte() || !p2.morte()){ 
            var dueloChance = gerador.nextInt(1, 3);
            if (dueloChance == 1) {
                p1.duelar(p2);
            }else {
                p2.duelar(p1);
            }

            if (p1.morte()) {
                System.out.println(p1.nome + " está morto.");
            } else {
                p1.realizarAcaoAleatoria();
                if (p2.morte()) {
                System.out.println("*********CAMPEÃO*********");
                }
            }
            p1.inventario();
            System.out.println("Músicas Conhecidas: "+p1.getRepertorio());
            System.out.println(p1);
            System.out.println("******************************************************");

            if (p2.morte()) {
                System.out.println(p2.nome + " está morto.");
            } else { 
                p2.realizarAcaoAleatoria();
                if (p1.morte()) {
                    System.out.println("*********CAMPEÃO*********");
                }
                p2.aprenderMusica(colecao);
            }
            p2.inventario();
            System.out.println("Músicas Conhecidas: "+p2.getRepertorio());
            System.out.println(p2);
            Thread.sleep(5000);
            System.out.println("******************************************************");          
        }
        System.out.println("******************************************************");
        System.out.println(p1.nome + " e " + p2.nome + " estão mortos.");
        p1.inventario();
        p2.inventario();

        }
    }   
