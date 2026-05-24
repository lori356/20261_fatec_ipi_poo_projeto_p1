import java.util.*;

public class Bardo extends Personagem{
    public Bardo() {
    }
    public Bardo(String nome, int energia, int fome, int sono) {
        super(nome, energia, fome, sono);
    }
    public Bardo(int energia, int fome, int sono) {
        super(energia, fome, sono);
    }
    @Override
    public void realizarAcaoAleatoria() {
        var gerador = new Random();
        var acaoP2 = gerador.nextInt(1, 6);
        switch(acaoP2){
            case 1:
                cacar();
                break;
            case 2:
                comer(); 
                break;
            case 3, 4, 5:
                dormir();
                break;
        }
        //aprenderMusica(colecao);
    } 
}
