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
    @Override
    public void duelar(Personagem adversario){
        if (getEnergia() > 0 && adversario.getEnergia() > 0){
            if (getItens().size() == 0) {
                System.out.println("O duelo foi cancelado porque " + nome +" não possui um item.");
                return;
            }
            System.out.println("----------------------------------------------------------------");
            System.out.println(nome + " inicia o duelo de inventário!");
            var gerador = new Random();
            var itemEscolhido = gerador.nextInt(getItens().size());
            var dueloItem = getItens().get(itemEscolhido);
            if (adversario.getItens().contains(dueloItem)) {
                setEnergia(getEnergia()-1); adversario.setEnergia(adversario.getEnergia()-1);
                System.out.println("A plateia já conhece esse item.");
                System.out.println(nome +" ficou cansado.");
                System.out.println(adversario.nome +" ficou cansado.");                    
                System.out.println("----------------------------------------------------------------");
            }else{
                adversario.setEnergia(adversario.getEnergia()-1);
                adversario.getItens().add(dueloItem);
                System.out.println(nome + " venceu o duelo!");
                System.out.println(adversario.nome +" ficou cansado.");
                System.out.println(adversario.nome +" obteve " + dueloItem + " do adversário como troféu!");
                getItens().remove(dueloItem);
                System.out.println("----------------------------------------------------------------");
            }
        }  
    }
}
