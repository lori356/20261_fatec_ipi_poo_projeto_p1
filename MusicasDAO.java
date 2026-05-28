import java.sql.*;
import java.util.*;

public class MusicasDAO {
    public static List<Musica> listar() throws Exception {
        List<Musica> colecao = new ArrayList<>();
        var sql = "SELECT * FROM tb_musicas";
        try (
                var conexao = ConnectionFactory.obterConexao();
                var ps = conexao.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            
            while (rs.next()) {
                var titulo = rs.getString("titulo");
                var m = new Musica(titulo);
                colecao.add(m);
            }
            return colecao;
        }
    }
}
