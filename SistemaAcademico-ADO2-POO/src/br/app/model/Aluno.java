package br.app.model;

import br.app.controller.Boletim;

public class Aluno extends Pessoa {
    private int ra;
    private String matriculaAluno;
    private Boletim boletim;

    public Aluno() {}

    public Aluno(String nome, int id, String cpf, int ra, String matriculaAluno) {
        super(nome, id, cpf);
        this.ra = ra;
        this.matriculaAluno = matriculaAluno;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public Boletim getBoletim() {
        return boletim;
    }

    public void setBoletim(Boletim boletim) {
        this.boletim = boletim;
    }

    public String imprimiDados() {
        return "RA: " + ra + "\nMatrícula do Aluno: " + matriculaAluno;
    }
}
