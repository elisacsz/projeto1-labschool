package br.com.futurodev.labschool;

import br.com.futurodev.labschool.pessoas.Aluno;
import br.com.futurodev.labschool.pessoas.Pedagogo;
import br.com.futurodev.labschool.pessoas.Professor;

import java.text.ParseException;
import java.util.Scanner;

import static br.com.futurodev.labschool.pessoas.Aluno.cadastrarAluno;
import static br.com.futurodev.labschool.pessoas.Pedagogo.cadastrarPedagogo;
import static br.com.futurodev.labschool.pessoas.Pessoa.listarFuncionarios;
import static br.com.futurodev.labschool.pessoas.Pessoa.listarPessoas;
import static br.com.futurodev.labschool.pessoas.Professor.cadastrarProfessor;

public class Menu {

    public static void menuCadastro() throws ParseException {

        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número do que deseja cadastrar:");
        System.out.println("\n[1] Aluno");
        System.out.println("[2] Professor");
        System.out.println("[3] Pedagogo");
        System.out.println("[0] VOLTAR");

        int opcaoMenuCadastro = input.nextInt();

        switch (opcaoMenuCadastro) {
            case 1:
                cadastrarAluno();
                Menu.menuCadastro();
                break;
            case 2:
                cadastrarProfessor();
                Menu.menuCadastro();
                break;
            case 3:
                cadastrarPedagogo();
                Menu.menuCadastro();
                break;
            case 0:
                break;
            default:
                System.out.println("\nComando inválido. Insira um dos números indicados.");
                break;
        }
    }

    public static void menuListas() {

        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número do que deseja listar:");
        System.out.println("\n[1] Alunos");
        System.out.println("[2] Professores");
        System.out.println("[3] Pedagogos");
        System.out.println("[4] Funcionários");
        System.out.println("[5] Todas as pessoas");
        System.out.println("[0] VOLTAR");

        int opcaoMenuListas = input.nextInt();

        switch (opcaoMenuListas) {
            case 1:
                Aluno.menuListarAlunos();
                menuListas();
                break;
            case 2:
                Professor.menuListarProfessores();
                menuListas();
                break;
            case 3:
                Pedagogo.menuListarPedagogos();
                menuListas();
                break;
            case 4:
                listarFuncionarios();
                menuListas();
                break;
            case 5:
                listarPessoas();
                menuListas();
            case 0:
                break;
            default:
                System.out.println("\nComando inválido. Insira um dos números indicados.");
                break;
        }
    }
}