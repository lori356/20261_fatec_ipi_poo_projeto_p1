import java.util.*;

public class Cacador extends Personagem {
    public Cacador() {
    }
    public Cacador(String nome, int energia, int fome, int sono) {
        super(nome, energia, fome, sono);
    }
    public Cacador(int energia, int fome, int sono) {
        super(energia, fome, sono);
    }
    @Override
    public void realizarAcaoAleatoria() {
        var gerador = new Random();
        var acaoP1 = gerador.nextInt(1, 4);
        switch(acaoP1){
            case 1:
                cacar();
                break;
            case 2:
                comer();
                break;
            case 3:
                dormir();
                break;
        }
    }
}
