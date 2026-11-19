package br.com.ubiani.dao;

import br.com.ubiani.model.Anime;
import br.com.ubiani.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimeDAO {

    public List<Anime> listarTodos() throws SQLException {

        List<Anime> animes = new ArrayList<>();

        String sql = "SELECT idAnimes, titulo, descricao, "
                + "classificacao, ano_de_lancamento, genero_idGenero "
                + "FROM animes ORDER BY idAnimes";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {

                Anime anime = new Anime(
                        resultado.getInt("idAnimes"),
                        resultado.getString("titulo"),
                        resultado.getString("descricao"),
                        resultado.getInt("classificacao"),
                        resultado.getInt("ano_de_lancamento"),
                        resultado.getInt("genero_idGenero")
                );

                animes.add(anime);
            }
        }

        return animes;
        
        
    }
    public void cadastrar(Anime anime) throws SQLException {

    String sql = "INSERT INTO animes "
            + "(titulo, descricao, classificacao, "
            + "ano_de_lancamento, genero_idGenero) "
            + "VALUES (?, ?, ?, ?, ?)";

    try (Connection conexao = Conexao.conectar();
         PreparedStatement comando = conexao.prepareStatement(sql)) {

        comando.setString(1, anime.getTitulo());
        comando.setString(2, anime.getDescricao());
        comando.setInt(3, anime.getClassificacao());
        comando.setInt(4, anime.getAnoDeLancamento());
        comando.setInt(5, anime.getGeneroIdGenero());

        comando.executeUpdate();
    }
}
    
public List<Anime> buscarPorTitulo(String titulo) throws SQLException {

    List<Anime> animes = new ArrayList<>();

    String sql = "SELECT idAnimes, titulo, descricao, "
            + "classificacao, ano_de_lancamento, genero_idGenero "
            + "FROM animes "
            + "WHERE titulo LIKE ? "
            + "ORDER BY idAnimes";

    try (Connection conexao = Conexao.conectar();
         PreparedStatement comando = conexao.prepareStatement(sql)) {

        comando.setString(1, "%" + titulo + "%");

        try (ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {

                Anime anime = new Anime(
                        resultado.getInt("idAnimes"),
                        resultado.getString("titulo"),
                        resultado.getString("descricao"),
                        resultado.getInt("classificacao"),
                        resultado.getInt("ano_de_lancamento"),
                        resultado.getInt("genero_idGenero")
                );

                animes.add(anime);
            }
        }
    }

    return animes;
}

public void atualizar(Anime anime) throws SQLException {

    String sql = "UPDATE animes SET "
            + "titulo = ?, "
            + "descricao = ?, "
            + "classificacao = ?, "
            + "ano_de_lancamento = ?, "
            + "genero_idGenero = ? "
            + "WHERE idAnimes = ?";

    try (Connection conexao = Conexao.conectar();
         PreparedStatement comando = conexao.prepareStatement(sql)) {

        comando.setString(1, anime.getTitulo());
        comando.setString(2, anime.getDescricao());
        comando.setInt(3, anime.getClassificacao());
        comando.setInt(4, anime.getAnoDeLancamento());
        comando.setInt(5, anime.getGeneroIdGenero());
        comando.setInt(6, anime.getIdAnimes());

        comando.executeUpdate();
    }
}
        public Anime buscarPorId(int id) throws SQLException {

    String sql = "SELECT idAnimes, titulo, descricao, "
            + "classificacao, ano_de_lancamento, genero_idGenero "
            + "FROM animes WHERE idAnimes = ?";

    try (Connection conexao = Conexao.conectar();
         PreparedStatement comando = conexao.prepareStatement(sql)) {

        comando.setInt(1, id);

        try (java.sql.ResultSet resultado = comando.executeQuery()) {

            if (resultado.next()) {

                return new Anime(
                        resultado.getInt("idAnimes"),
                        resultado.getString("titulo"),
                        resultado.getString("descricao"),
                        resultado.getInt("classificacao"),
                        resultado.getInt("ano_de_lancamento"),
                        resultado.getInt("genero_idGenero")
                );
            }
        }
    }

    return null;
}
        public void excluir(int idAnime) throws SQLException {

    String sql = "DELETE FROM animes WHERE idAnimes = ?";

    try (Connection conexao = Conexao.conectar();
         PreparedStatement comando = conexao.prepareStatement(sql)) {

        comando.setInt(1, idAnime);

        comando.executeUpdate();
    }
}

}