package dao;

import java.sql.*;
import util.Conexao; // importa a classe de conexão

public class UsuarioDAO {

    // CREATE - Inserir usuário
    public void inserirUsuario(String nome, String sobrenome, String email, String senha) {
        String sql = "INSERT INTO usuario (primeiro_nome, sobrenome, email, senha) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, sobrenome);
            stmt.setString(3, email);
            stmt.setString(4, senha);
            stmt.executeUpdate();
            System.out.println("Usuário inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ - Listar usuários
    public void listarUsuarios() {
        String sql = "SELECT * FROM usuario";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id_usuario") + " - " +
                        rs.getString("primeiro_nome") + " " +
                        rs.getString("sobrenome") + " - " +
                        rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE - Atualizar usuário
    public void atualizarUsuario(int id, String novoNome) {
        String sql = "UPDATE usuario SET primeiro_nome = ? WHERE id_usuario = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoNome);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Usuário atualizado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE - Deletar usuário
    public void deletarUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuário deletado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}