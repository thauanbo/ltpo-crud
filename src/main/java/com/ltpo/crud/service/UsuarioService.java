package com.ltpo.crud.service;

import com.ltpo.crud.dao.UsuarioDAO;
import com.ltpo.crud.model.Usuario;

import java.util.List;

public class UsuarioService {
    private final UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrarUsuario(String nome, String email) {
        usuarioDAO.criarUsuario(new Usuario(0, nome, email));
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void listarUsuarios() {
        List<Usuario> usuarios = usuarioDAO.listarUsuarios();
        System.out.println("\nLista de Usuários:");
        usuarios.forEach(u -> System.out.println("ID: " + u.getId() + " | Nome: " + u.getNome() + " | Email: " + u.getEmail()));
    }

    public void atualizarUsuario(int id, String nome, String email) {
        usuarioDAO.atualizarUsuario(new Usuario(id, nome, email));
        System.out.println("Usuário atualizado com sucesso!");
    }

    public void deletarUsuario(int id) {
        usuarioDAO.deletarUsuario(id);
        System.out.println("Usuário deletado com sucesso!");
    }
}
