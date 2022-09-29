package br.com.futurodev.labschool.pessoas;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Professor extends Pessoa {

    private String formacao;
    private String areaDev;
    private String estado;
    private static List<Professor> professores = new ArrayList<>();
    private static List<Professor> frontEnd = new ArrayList<>();
    private static List<Professor> backEnd = new ArrayList<>();
    private static List<Professor> fullStack = new ArrayList<>();

    //  ---------------- CONSTRUTOR ----------------

    public Professor(String nome, String telefone, Date dataNascimento, String cpf, String formacao, String areaDev, String estado) {
        super(nome, telefone, dataNascimento, cpf);
        this.formacao = formacao;
        this.areaDev = areaDev;
        this.estado = estado;
    }

    public Professor() {

    }

    // ---------------- MÉTODOS ----------------

    public static void cadastrarProfessor() throws ParseException {

        Professor professor = new Professor();

        cadastrarPessoa(professor);

        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da opção desejada.");
        System.out.println("\nFormação acadêmica: ");
        System.out.println("\n[1] Graduação incompleta");
        System.out.println("[2] Graduação completa");
        System.out.println("[3] Mestrado");
        System.out.println("[4] Doutorado");

        String formacao = String.valueOf(input.nextInt());
        professor.setFormacao(formacao);

        System.out.println("\nExperiência de desenvolvimento: ");
        System.out.println("\n[1] Front-End");
        System.out.println("[2] Back-End");
        System.out.println("[3] Full-Stack");

        String areaDev = String.valueOf(input.nextInt());
        professor.setAreaDev(areaDev);

        System.out.println("\nEstado: ");
        System.out.println("\n[1] Ativo");
        System.out.println("[2] Inativo");

        String estado = String.valueOf(input.nextInt());
        professor.setEstado(estado);

        System.out.println("\nProfessor cadastrado com sucesso!");

        professores.add(professor);
        pessoas.add(professor);
        funcionarios.add(professor);

        if(areaDev.equals("1")) {
            frontEnd.add(professor);
        } else if (areaDev.equals("2")) {
            backEnd.add(professor);
        } else if (areaDev.equals("3")) {
            fullStack.add(professor);
        }
    }

    public static void listarProfessores() {
        System.out.println("\nLista de professores:\n");
        for (int i = 0; i < professores.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + professores.get(i));
        }
    }

    public static void listarProfsPorArea() {

        Scanner input = new Scanner(System.in);
        System.out.println("\nDigite o número da área que deseja listar: ");
        System.out.println("\n[1] Front-End");
        System.out.println("[2] Back-End");
        System.out.println("[3] Full-Stack");
        System.out.println("[0] VOLTAR");

        int area = input.nextInt();

        switch (area) {
            case 1:
                System.out.println("\nLista de professores Front-End:\n");
                for (int i = 0; i < frontEnd.size(); i++) {
                    System.out.println("[" + (i + 1) + "]" + frontEnd.get(i).toString());
                }
                break;
            case 2:
                System.out.println("\nLista de professores Back-End:\n");
                for (int i = 0; i < backEnd.size(); i++) {
                    System.out.println("[" + (i + 1) + "]" + backEnd.get(i).toString());
                }
                break;
            case 3:
                System.out.println("\nLista de professores Full-Stack:\n");
                for (int i = 0; i < fullStack.size(); i++) {
                    System.out.println("[" + (i + 1) + "]" + fullStack.get(i).toString());
                }
                break;
            case 0:
                break;
            default:
                System.out.println("\nComando inválido. Insira um dos números indicados.");
                break;
        }
    }

    public static void menuListarProfessores() {

        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número do que deseja listar:");
        System.out.println("\n[1] Todos os professores");
        System.out.println("[2] Professores por experiência de desenvolvimento");
        System.out.println("[0] VOLTAR");

        int opcaoListasProf = input.nextInt();

        switch (opcaoListasProf) {
            case 1:
                listarProfessores();
                break;
            case 2:
                listarProfsPorArea();
                break;
            case 0:
                break;
            default:
                System.out.println("\nComando inválido. Insira um dos números indicados.");
                break;
        }
    }

    // ---------------- GETTERS & SETTERS ----------------

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
    public void setAreaDev(String areaDev) {
        this.areaDev = areaDev;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static List<Professor> getProfessores() {
        return professores;
    }
}