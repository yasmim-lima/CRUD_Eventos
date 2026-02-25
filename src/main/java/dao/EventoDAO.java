package dao;

import java.sql.*;
import util.Conexao;

public class EventoDAO {

    public void inserirEvento(String nome, String categoria, String descricao, int idLocal, int idOrganizador) {
        String sql = "INSERT INTO evento (nome, categoria, descricao, id_local, id_organizador) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, categoria);
            stmt.setString(3, descricao);
            stmt.setInt(4, idLocal);
            stmt.setInt(5, idOrganizador);
            stmt.executeUpdate();
            System.out.println("Evento inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarEventos() {
        String sql = "SELECT * FROM evento";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id_evento") + " - " +
                        rs.getString("nome") + " | " +
                        rs.getString("categoria") + " | " +
                        rs.getString("descricao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarEvento(int id, String novaDescricao) {
        String sql = "UPDATE evento SET descricao = ? WHERE id_evento = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novaDescricao);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Evento atualizado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarEvento(int id) {
        String sql = "DELETE FROM evento WHERE id_evento = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Evento deletado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}