
import java.util.ArrayList;
import java.util.Random;



public class Personagem{
    public String nome;
    private int energia;
    private int fome;
    private int sono;
    private ArrayList<String> itens = new ArrayList<>();
    ArrayList<Musica> repertorio = new ArrayList<>();
Personagem() {
    System.out.println("Construindo novo personagem");
    energia = 10;
    fome = 0;
    sono = 0;
    itens = new ArrayList<>();
    repertorio = new ArrayList<>();
}
Personagem(String nome, int energia, int fome, int sono) {
    this.nome = nome;
    this.energia = energia;
    this.fome = fome;
    this.sono = sono;
    itens = new ArrayList<>();
    repertorio = new ArrayList<>();
}
Personagem(int energia, int fome, int sono) {
    System.out.println("Construindo novo personagem");
    this.energia = energia < 0 || energia > 10 ? 10 : energia;
    this.fome = fome >= 0 && fome <= 10 ? fome : 0;
    this.sono = sono >= 0 && sono <= 10 ? sono : 0;
    itens = new ArrayList<>();
    repertorio = new ArrayList<>();
}
    void cacar(){
        var gerador = new Random();
        if(energia >= 2){
        System.out.printf("%s caçando\n", nome);
        energia -= 2; // energia = energia - 2
        var itemLista = gerador.nextInt(1, 6);
        switch(itemLista) {
            case 1:
                itens.add("pena");
                break;
            case 2:
                itens.add("couro");
                break;
            case 3:
                itens.add("osso");
                break;
            case 4:
                itens.add("garra");
                break;
            case 5:
                itens.add("presa");
                break; 
        }   
    }else{
        System.out.printf("%s sem energia para caçar\n",nome);
    }
// fome +=1 fome++ ++fome
    if (fome < 10) fome = fome + 1;
// sono = sono + 1 > 10 ? sono : sono + 1;
        sono = sono == 10 ? sono : sono + 1;
    }
//método comer
    void comer(){
        if(fome >= 1){
        System.out.println(nome + " comendo");
        energia = Math.min(energia + 1, 10);
        fome--;
    }
    else{
        System.out.println(nome + " sem fome");
        }
    }
//método dormir
    void dormir(){
        if(sono >= 1){
        System.out.print(nome + " dormindo\n");
        energia = energia == 10 ? energia : energia + 1;
        sono -= 1;
        }else{
        System.out.println(nome + " sem sono");
        }
    }
    void aprenderMusica(ArrayList<Musica> disponiveis) {
        var gerador = new Random();
        var musicaLista = gerador.nextInt(disponiveis.size());
        Musica musicaProcessada = disponiveis.get(musicaLista); 
        if (repertorio.contains(musicaProcessada)) {
            System.out.println(nome + " já conhece a música " + musicaProcessada.titulo +"!");
        } else {
            System.out.println(nome + " aprendeu uma nova música: " + musicaProcessada.titulo +"!");
            repertorio.add(musicaProcessada);
        }
    }

    void inventario() {
        System.out.println("Inventário de " + nome + ": " + itens);
    } 
    boolean morte() {
        return energia <= 0;
    }
    @Override
    public String toString(){
//nome: e:5, f:4, s:8
        return String.format("%s: e:%d, f:%d, s:%d", nome, energia, fome, sono);
    }
}


