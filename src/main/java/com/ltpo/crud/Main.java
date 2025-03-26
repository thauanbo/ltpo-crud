package com.ltpo.crud;

import com.ltpo.crud.service.UsuarioService;
import com.ltpo.crud.ui.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        UsuarioService usuarioService = new UsuarioService();
        int opcao;

        do {
            opcao = menu.exibirMenu();
            switch (opcao) {
                case 1:
                    usuarioService.cadastrarUsuario(
                            menu.lerString("Nome: "),
                            menu.lerString("Email: ")
                    );
                    break;
                case 2:
                    usuarioService.listarUsuarios();
                    break;
                case 3:
                    int idAtualizar = Integer.parseInt(menu.lerString("ID do usuário a atualizar: "));
                    menu.lerString(""); // Limpa o buffer após a leitura do id
                    usuarioService.atualizarUsuario(
                            idAtualizar,
                            menu.lerString("Novo nome: "),
                            menu.lerString("Novo email: ") // O email agora é lido corretamente
                    );
                    break;
                case 4:
                    int idDeletar = Integer.parseInt(menu.lerString("ID do usuário a deletar: "));
                    menu.lerString(""); // Limpa o buffer após a leitura do id
                    usuarioService.deletarUsuario(idDeletar);
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        menu.fecharScanner();
    }
}
