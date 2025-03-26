package com.ltpo.crud.ui;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public int exibirMenu() {
        System.out.println("\n### Sistema de Gerenciamento de Usuários ###");
        System.out.println("1. Cadastrar usuário");
        System.out.println("2. Listar usuários");
        System.out.println("3. Atualizar usuário");
        System.out.println("4. Deletar usuário");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public String lerString(String mensagem) {
        System.out.print(mensagem);
        scanner.nextLine(); // Limpar o buffer
        return scanner.nextLine();
    }

    public void fecharScanner() {
        scanner.close();
    }
}
