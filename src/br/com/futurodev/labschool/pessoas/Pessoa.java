package br.com.futurodev.labschool.pessoas;

import br.com.futurodev.labschool.GeradorId;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Pessoa {

    private String nome;
    private String telefone;
    private Date dataNascimento;
    private String cpf;
    private int id;
    static List<Pessoa> pessoas = new ArrayList<>();
    static List<Pessoa> funcionarios = new ArrayList<>();

    //  ---------------- CONSTRUTOR ----------------

    public Pessoa(String nome, String telefone, Date dataNascimento, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.id = GeradorId.gerarId();
    }

    public Pessoa() {
        this.id = GeradorId.gerarId();
    }

    // ---------------- MÉTODOS ----------------

    public static void cadastrarPessoa(Pessoa pessoa) throws ParseException {

        Scanner input = new Scanner(System.in);

        System.out.println("\nInsira os dados: ");

        System.out.println("\nNome: ");
        String nome = input.nextLine();
        pessoa.setNome(nome);

        System.out.println("\nTelefone: ");
        String telefone = input.nextLine();
        pessoa.setTelefone(telefone);

        System.out.println("\nData de nascimento (dd/MM/aaaa): ");
        String dataNascimento = input.nextLine();

        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date date = simpleDateFormat.parse(dataNascimento);
        pessoa.setDataNascimento(date);

        System.out.println("\nCPF: ");
        String cpf = input.nextLine();
        pessoa.setCpf(cpf);
    }

    public static void listarPessoas() {
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + pessoas.get(i).toString());
        }
    }

    public static void listarFuncionarios() {
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + funcionarios.get(i).toString());
        }
    }

    // ---------------- GETTERS & SETTERS ----------------

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return " Nome: " + nome +
                " | ID: " + this.getId() +
                " | CPF: " + cpf;
    }
}