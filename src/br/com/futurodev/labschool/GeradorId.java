package br.com.futurodev.labschool;

public class GeradorId {
    private static int id = 1;

    public static int gerarId() {
        return id++;
    }
}
