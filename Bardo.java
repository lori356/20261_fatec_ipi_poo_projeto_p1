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
    }
    @Override
    public void duelar(Personagem adversario){
        if (getEnergia() > 0 && adversario.getEnergia() > 0){
            if (getRepertorio().size() == 0) {
                System.out.println("O duelo foi cancelado porque " + nome +" não conhece nenhuma música.");
                return;
            }
            System.out.println("----------------------------------------------------------------");
            System.out.println(nome + " inicia o duelo musical!");
            var gerador = new Random();
            var musicaEscolhida = gerador.nextInt(getRepertorio().size());
            var dueloMusical = getRepertorio().get(musicaEscolhida);
            if (adversario.getRepertorio().contains(dueloMusical)) {
                setEnergia(getEnergia()-1); adversario.setEnergia(adversario.getEnergia()-1);
                System.out.println("A plateia se entediou com a performance.");
                System.out.println(nome +" ficou cansado.");
                System.out.println(adversario.nome +" ficou cansado.");
                System.out.println("----------------------------------------------------------------");
            }else{
                adversario.setEnergia(adversario.getEnergia()-1);
                adversario.getRepertorio().add(dueloMusical);
                System.out.println(nome + " venceu o duelo!");
                System.out.println(adversario.nome +" ficou cansado.");
                System.out.println(adversario.nome +" aprendeu " + dueloMusical + " pela batalha!");
                System.out.println("----------------------------------------------------------------");
            }
        }   
    } 
}
