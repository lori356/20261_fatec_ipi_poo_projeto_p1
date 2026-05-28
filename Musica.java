
public class Musica implements Comparable <Musica> {
    
    private String titulo;
    private int id;
    
    public Musica(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
    @Override
    public int compareTo(Musica musica2) { 
    return this.titulo.compareTo(musica2.titulo);
    }
    @Override
    public String toString(){  
    return titulo;
    } 
    
}
