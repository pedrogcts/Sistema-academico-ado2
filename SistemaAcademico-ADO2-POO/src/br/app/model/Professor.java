package br.app.model;

public class Professor extends Pessoa {
    private int rp;
    private String materia;

    public Professor() {
    
    }

    public Professor(String nome, int id, String cpf, int rp, String materia) {
        super(nome, id, cpf);
        this.rp = rp;
        this.materia = materia;
    }

    public int getRp() {
        return rp;
    }

    public void setRp(int rp) {
        this.rp = rp;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String imprimiDados() {
        return "RP: " + rp + "\nMatéria: " + materia;
    }
}
