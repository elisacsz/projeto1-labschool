package br.com.futurodev.labschool;

import br.com.futurodev.labschool.pessoas.Aluno;
import br.com.futurodev.labschool.pessoas.Pedagogo;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("| PORTAL LABSCHOOL |");
        System.out.println("--------------------");

        int menu;

        do {
            System.out.println("\nDigite o n�mero do que deseja acessar:");
            System.out.println("\n[1] Cadastro de Pessoas");
            System.out.println("[2] Listas de Pessoas");
            System.out.println("[3] Atendimento Pedag�gico");
            System.out.println("[4] Altera��o de matr�cula");
            System.out.println("[0] SAIR");

            menu = input.nextInt();

            switch (menu) {
                case 1:
                    Menu.menuCadastro();
                    break;
                case 2:
                    Menu.menuListas();
                    break;
                case 3:
                    Pedagogo.atendimentoPedagogico();
                    break;
                case 4:
                    Aluno.alterarMatricula();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nComando inv�lido. Insira um dos n�meros indicados.");
                    break;
            }
        } while (menu != 0);
    }
}
