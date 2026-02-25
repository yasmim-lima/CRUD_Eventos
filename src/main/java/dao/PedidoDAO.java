package dao;

import java.sql.*;
import util.Conexao;

public class PedidoDAO {

    public void inserirPedido(int idParticipante, double valorTotal, String status) {
        String sql = "INSERT INTO pedido (id_participante, valor_total, status) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idParticipante);
            stmt.setDouble(2, valorTotal);
            stmt.setString(3, status);
            stmt.executeUpdate();
            System.out.println("Pedido inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarPedidos() {
        String sql = "SELECT * FROM pedido";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Pedido " + rs.getInt("id_pedido") +
                        " | Participante: " + rs.getInt("id_participante") +
                        " | Valor: " + rs.getDouble("valor_total") +
                        " | Status: " + rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarPedido(int id, String novoStatus) {
        String sql = "UPDATE pedido SET status = ? WHERE id_pedido = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoStatus);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Pedido atualizado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarPedido(int id) {
        String sql = "DELETE FROM pedido WHERE id_pedido = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Pedido deletado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}