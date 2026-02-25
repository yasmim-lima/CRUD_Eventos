package app;

import dao.EventoDAO;
import dao.PedidoDAO;
import dao.UsuarioDAO;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        EventoDAO eventoDAO = new EventoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();

        //usuarioDAO.inserirUsuario("Daniel", "Pereira", "daniel@email.com", "1236");
        //usuarioDAO.listarUsuarios();
        //usuarioDAO.atualizarUsuario(20, "Graziele");
        //usuarioDAO.deletarUsuario(3);

        //eventoDAO.inserirEvento("Show de Jazz", "Musica", "Grande evento de jazz", 3, 5);
        //eventoDAO.listarEventos();
        //eventoDAO.atualizarEvento(14, "Grande evento de Rock");
        //eventoDAO.deletarEvento(17);

        //pedidoDAO.inserirPedido(5, 100.00, "PENDENTE");
        //pedidoDAO.listarPedidos();
        //pedidoDAO.atualizarPedido(14, "CONFIRMADO");
        pedidoDAO.deletarPedido(16);
    }
}