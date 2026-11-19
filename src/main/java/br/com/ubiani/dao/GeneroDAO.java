
package br.com.ubiani.dao;

import br.com.ubiani.model.Genero;
import br.com.ubiani.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {

    public List<Genero> listarTodos() throws SQLException {

        List<Genero> generos = new ArrayList<>();

        String sql = "SELECT idGenero, nome FROM genero "
                + "ORDER BY idGenero";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {

                Genero genero = new Genero(
                        resultado.getInt("idGenero"),
                        resultado.getString("nome")
                );

                generos.add(genero);
            }
        }

        return generos;
    }
}
