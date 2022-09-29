package br.com.futurodev.labschool.pessoas;

import java.text.ParseException;
import java.util.*;

public class Pedagogo extends Pessoa {

    private int totalAtendimentosPedagogicos;
    private static List<Pedagogo> pedagogos = new ArrayList<Pedagogo>();

    //  ---------------- CONSTRUTOR ----------------

    public Pedagogo(String nome, String telefone, Date dataNascimento, String cpf) {
        super(nome, telefone, dataNascimento, cpf);
        this.totalAtendimentosPedagogicos = 0;
    }

    public Pedagogo() {

    }


    // ---------------- MÉTODOS ----------------

    public static void cadastrarPedagogo() throws ParseException {

        Pedagogo pedagogo = new Pedagogo();

        cadastrarPessoa(pedagogo);

        Scanner input = new Scanner(System.in);

        System.out.println("\nPedagogo cadastrado com sucesso!");

        pedagogos.add(pedagogo);
        pessoas.add(pedagogo);
        funcionarios.add(pedagogo);
    }

    public void adicionarAtendimentoPedagogico() {
        this.totalAtendimentosPedagogicos++;
    }

    public static void atendimentoPedagogico() {

        System.out.println("\nDigite o número do ALUNO em atendimento pedagógico:");

        Aluno.listarAlunos();

        Scanner input = new Scanner(System.in);
        int indexAluno = input.nextInt();
        indexAluno = indexAluno - 1;
        Aluno aluno = Aluno.getAlunos().get(indexAluno);

        System.out.println("\nDigite o número do PEDAGOGO que irá atender o aluno:");

        listarPedagogos();

        int indexPedagogo = input.nextInt();
        indexPedagogo = indexPedagogo - 1;
        Pedagogo pedagogo = Pedagogo.getPedagogos().get(indexPedagogo);

        System.out.println("\nAtendimento pedagógico de " + aluno.getNome() + " com " + pedagogo.getNome() + " adicionado com sucesso!");

        aluno.adicionarAtendimentoPedagogico();
        pedagogo.adicionarAtendimentoPedagogico();
    }

    public static void listarPedagogos() {
        System.out.println("\nLista de pedagogos:\n");
        for (int i = 0; i < pedagogos.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + pedagogos.get(i));
        }
    }

    public static void listarPedagogosPorAtendimento() {
        System.out.println("\nLista de pedagogos por maior número de atendimentos pedagógicos: \n");
        Collections.sort(pedagogos, (pedagogo1, pedagogo2) -> {
            return pedagogo2.getTotalAtendimentosPedagogicos() < pedagogo1.getTotalAtendimentosPedagogicos() ? -1 : 1;
        });
        listarPedagogos();
    }

    public static void menuListarPedagogos() {

        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número do que deseja listar:");
        System.out.println("\n[1] Todos os pedagogos");
        System.out.println("[2] Pedagogos por maior número de atendimentos pedagógicos");
        System.out.println("[0] VOLTAR");

        int opcaoListasProf = input.nextInt();

        switch (opcaoListasProf) {
            case 1:
                listarPedagogos();
                break;
            case 2:
                listarPedagogosPorAtendimento();
                break;
            case 0:
                break;
            default:
                System.out.println("\nComando inválido. Insira um dos números indicados.");
                break;
        }
    }

    // ---------------- GETTERS & SETTERS ----------------

    public int getTotalAtendimentosPedagogicos() {
        return totalAtendimentosPedagogicos;
    }

    public static List<Pedagogo> getPedagogos() {
        return pedagogos;
    }

    @Override
    public String toString() {
        return " Nome: " + this.getNome() +
                " | ID: " + this.getId() +
                " | CPF: " + this.getCpf() +
                " | Atendimentos Pedagógicos: " + this.getTotalAtendimentosPedagogicos();
    }
}

