package br.com.futurodev.labschool.pessoas;

import java.text.ParseException;
import java.util.*;

public class Aluno extends Pessoa {

    private String condicaoMatricula;
    private static Double notaSelecao;
    private int atendimentosPedagogicos;
    private static List<Aluno> alunos = new ArrayList<Aluno>();
    private static List<Aluno> ativos = new ArrayList<Aluno>();
    private static List<Aluno> irregulares = new ArrayList<Aluno>();
    private static List<Aluno> atendPedagogico = new ArrayList<Aluno>();
    private static List<Aluno> inativos = new ArrayList<Aluno>();

    //  ---------------- CONSTRUTOR ----------------

    public Aluno(String nome, String telefone, Date dataNascimento, String cpf, String condicaoMatricula, Double notaSelecao) {
        super(nome, telefone, dataNascimento, cpf);
        this.condicaoMatricula = condicaoMatricula;
        this.notaSelecao = notaSelecao;
        this.atendimentosPedagogicos = 0;
    }

    public Aluno() {

    }

    // ---------------- MÉTODOS ----------------

    public static void cadastrarAluno() throws ParseException {

        Aluno aluno = new Aluno();

        cadastrarPessoa(aluno);

        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da opção desejada.");
        System.out.println("\nCondição de matrícula: ");
        System.out.println("\n[1] Ativo");
        System.out.println("[2] Irregular");
        System.out.println("[3] Atendimento pedagógico");
        System.out.println("[4] Inativo");

        String condicaoMatricula = String.valueOf(input.nextInt());
        aluno.setCondicaoMatricula(condicaoMatricula);

        System.out.println("\nDigite a nota do processo seletivo do aluno (0 até 10): ");

        Double notaSelecao = input.nextDouble();
        aluno.setNotaSelecao(notaSelecao);

        if (notaSelecao < 0 || notaSelecao > 10) {
            System.out.println("\nNota inválida! Digite um valor de 0 até 10.");
        } else {
            System.out.println("\nAluno cadastrado com sucesso!");

            alunos.add(aluno);
            pessoas.add(aluno);

            if (condicaoMatricula.equals("1")) {
                ativos.add(aluno);
            } else if (condicaoMatricula.equals("2")) {
                irregulares.add(aluno);
            } else if (condicaoMatricula.equals("3")) {
                atendPedagogico.add(aluno);
            } else if (condicaoMatricula.equals("4")) {
                inativos.add(aluno);
            }
        }
    }

    public static void alterarMatricula() {

        listarAlunos();

        System.out.println("\nDigite o número do aluno que deseja alterar a condição da matrícula:");

        Scanner input = new Scanner(System.in);
        int numeroAluno = input.nextInt();
        numeroAluno = numeroAluno - 1;

        System.out.println("\nDigite o número da opção desejada.");
        System.out.println("\nNova condição de matrícula do aluno: ");
        System.out.println("\n[1] Ativo");
        System.out.println("[2] Irregular");
        System.out.println("[3] Atendimento pedagógico");
        System.out.println("[4] Inativo");
        String novaMatricula = String.valueOf(input.nextInt());

        alunos.get(numeroAluno).setCondicaoMatricula(novaMatricula);

        System.out.println("\nCondição de matrícula alterada com sucesso!");
    }

    public static void listarAlunos() {
        System.out.println("\nLista de alunos:\n");
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + alunos.get(i).toString());
        }
    }

    public static void listarAlunosPorMatricula() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número de quais alunos deseja listar: ");
        System.out.println("\n[1] Ativos");
        System.out.println("[2] Irregulares");
        System.out.println("[3] Em atendimento pedagógico");
        System.out.println("[4] Inativos");
        System.out.println("[5] Todos");

        int listarMatriculas = input.nextInt();

        switch (listarMatriculas) {
            case 1:
                System.out.println("\nLista de alunos ativos:\n");
                for (int i = 0; i < ativos.size(); i++) {
                    System.out.println("[" + (i + 1) + "]" + ativos.get(i).toString());
                }
                break;
            case 2:
                System.out.println("\nLista de alunos irregulares:\n");
                for (int i = 0; i < irregulares.size(); i++) {
                    System.out.println("[" + (i + 1) + "]" + irregulares.get(i).toString());
                }
                break;
            case 3:
                System.out.println("\nLista de alunos em atendimento pedagócio:\n");
                for (int i = 0; i < atendPedagogico.size(); i++) {
                    System.out.println("[" + (i + 1) + "]" + atendPedagogico.get(i).toString());
                }
                break;
            case 4:
                System.out.println("\nLista de alunos inativos:\n");
                for (int i = 0; i < inativos.size(); i++) {
                    System.out.println("[" + (i + 1) + "]" + inativos.get(i).toString());
                }
                break;
            case 0:
                break;
            default:
                System.out.println("\nComando inválido. Insira um dos números indicados.");
                break;
        }
    }

    public static void listarAlunosPorAtendimentos() {
        System.out.println("\nLista de alunos por maior número de atendimentos pedagógicos: \n");
        Collections.sort(alunos, (aluno1, aluno2) -> {
            return aluno2.getAtendimentosPedagogicos() < aluno1.getAtendimentosPedagogicos() ? -1 : 1;
        });
        listarAlunos();
    }

    public static void menuListarAlunos() {

        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número do que deseja listar:");
        System.out.println("\n[1] Todos os alunos");
        System.out.println("[2] Alunos por condição de matrícula");
        System.out.println("[3] Alunos por maior número de atendimentos pedagógicos");
        System.out.println("[0] VOLTAR");

        int opcaoListasAluno = input.nextInt();

        switch (opcaoListasAluno) {
            case 1:
                listarAlunos();
                break;
            case 2:
                listarAlunosPorMatricula();
                break;
            case 3:
                listarAlunosPorAtendimentos();
                break;
            case 0:
                break;
            default:
                System.out.println("\nComando inválido. Insira um dos números indicados.");
                break;
        }
    }

    public void adicionarAtendimentoPedagogico() {
        this.atendimentosPedagogicos++;
        this.setCondicaoMatricula("Atendimento pedagógico");
    }

    // ---------------- GETTERS & SETTERS ----------------

    public String getCondicaoMatricula() {
        if (condicaoMatricula.equals("1")) {
            condicaoMatricula = "Ativa";
        } else if (condicaoMatricula.equals("2")) {
            condicaoMatricula = "Irregular";
        } else if (condicaoMatricula.equals("3")) {
            condicaoMatricula = "Em atendimento pedagógico";
        } else if (condicaoMatricula.equals("4")) {
            condicaoMatricula = "Inativa";
        }
        return condicaoMatricula;
    }

    public void setCondicaoMatricula(String condicaoMatricula) {
        this.condicaoMatricula = condicaoMatricula;
    }

    public Double getNotaSelecao() {
        return notaSelecao;
    }

    public void setNotaSelecao(Double notaSelecao) {
        this.notaSelecao = notaSelecao;
    }

    public Integer getAtendimentosPedagogicos() {
        return atendimentosPedagogicos;
    }

    public static List<Aluno> getAlunos() {
        return alunos;
    }

    @Override
    public String toString() {
        return " Nome: " + this.getNome() +
                " | ID: " + this.getId() +
                " | CPF: " + this.getCpf() +
                " | Nota do Processo Seletivo: " + this.getNotaSelecao() +
                " | Matrícula: " + this.getCondicaoMatricula() +
                " | Atendimentos Pedagógicos: " + this.getAtendimentosPedagogicos();
    }
}