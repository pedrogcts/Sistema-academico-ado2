package br.app.view;

import br.app.model.Aluno;
import br.app.model.Professor;
import br.app.controller.Boletim;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Boletim gestorDeNotas = new Boletim();

        while (true) {
            System.out.println("==================================================");
            System.out.println("|               -Sistema Acadêmico-              |");
            System.out.println("==================================================");
            System.out.println("                -Escolha uma Opção-            \n");
            System.out.println("1 - CADASTRAR ALUNO.");
            System.out.println("2 - CADASTRAR PROFESSOR.");
            System.out.println("3 - SAIR DO PROGRAMA.");
            System.out.print("DIGITE O NÚMERO DA OPÇÃO: ");

            int opcao = sc.nextInt();
            sc.nextLine();
            System.out.println("\n");

            switch (opcao) {
                case 1 ->
                    cadastrarAluno(sc, gestorDeNotas);
                case 2 ->
                    cadastrarProfessor(sc);
                case 3 -> {
                    System.out.println("SAINDO DO PROGRAMA...");
                    System.exit(0);
                }
                default ->
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }

    private static void cadastrarAluno(Scanner sc, Boletim gestorDeNotas) {
        
        DecimalFormat df = new DecimalFormat("#");

        System.out.println("==================================================");
        System.out.println("|                -Cadastro Aluno-                |");
        System.out.println("==================================================");

        System.out.print("Número de Alunos: ");
        int numeroAluno = sc.nextInt();
        sc.nextLine();
        System.out.println("-------------------------------------------------\n");

        Aluno[] listaAluno = new Aluno[numeroAluno];

        for (int i = 0; i < listaAluno.length; i++) {
            System.out.println((i + 1) + "º ALUNO: ");
            listaAluno[i] = new Aluno();

            System.out.print("Nome do Aluno: ");
            listaAluno[i].setNome(sc.nextLine());

            System.out.print("Id do Aluno: ");
            listaAluno[i].setId(Integer.parseInt(sc.nextLine()));

            System.out.print("CPF do Aluno: ");
            listaAluno[i].setCpf(sc.nextLine());

            System.out.print("RA do Aluno: ");
            listaAluno[i].setRa(Integer.parseInt(sc.nextLine()));

            System.out.print("Matrícula do Aluno: ");
            listaAluno[i].setMatriculaAluno(sc.nextLine());

            System.out.print("Avaliação 01: ");
            double nota1 = sc.nextDouble();

            System.out.print("Avaliação 02: ");
            double nota2 = sc.nextDouble();

            System.out.print("Avaliação 03: ");
            double nota3 = sc.nextDouble();
            sc.nextLine();

            Boletim boletim = new Boletim(nota1, nota2, nota3);
            listaAluno[i].setBoletim(boletim);

            double media = gestorDeNotas.calcularMedia(boletim);
            boolean aprovado = gestorDeNotas.verificarAprovacao(boletim);

            System.out.println("\nRELATÓRIO DO ALUNO " + (i + 1) + ": ");
            System.out.println("Nome: " + listaAluno[i].getNome());
            System.out.println("Média: " + media + df.format(media));
            System.out.println("Status: " + (aprovado ? "Aprovado" : "Reprovado"));
            System.out.println("==================================================\n");

            System.out.println("\nQUESTIONÁRIO PREENCHIDO PARA O " + (i + 1) + "º ALUNO");
            System.out.println("=================================================\n\n");
        }

        System.out.println("DADOS DOS ALUNOS CADASTRADOS:");
        for (Aluno aluno : listaAluno) {
            System.out.println(aluno.imprimiDados());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Id: " + aluno.getId());
            System.out.println("CPF: " + aluno.getCpf());
            System.out.println("-------------------------------------------------");
        }
    }

    private static void cadastrarProfessor(Scanner sc) {
        System.out.println("==================================================");
        System.out.println("|              -Cadastro Professor-              |");
        System.out.println("==================================================");

        System.out.print("Número de Professores: ");
        int numeroProfessor = sc.nextInt();
        sc.nextLine();
        System.out.println("-------------------------------------------------\n");

        Professor[] listaProfessor = new Professor[numeroProfessor];

        for (int i = 0; i < listaProfessor.length; i++) {
            System.out.println((i + 1) + "º PROFESSOR: ");
            listaProfessor[i] = new Professor();

            System.out.print("Nome do Professor: ");
            listaProfessor[i].setNome(sc.nextLine());

            System.out.print("Id do Professor: ");
            listaProfessor[i].setId(Integer.parseInt(sc.nextLine()));

            System.out.print("CPF do Professor: ");
            listaProfessor[i].setCpf(sc.nextLine());

            System.out.print("RP do Professor: ");
            listaProfessor[i].setRp(Integer.parseInt(sc.nextLine()));

            System.out.print("Matéria do Professor: ");
            listaProfessor[i].setMateria(sc.nextLine());

            System.out.println("\nQUESTIONÁRIO PREENCHIDO PARA O " + (i + 1) + "º PROFESSOR");
            System.out.println("=================================================\n\n");
        }

        System.out.println("DADOS DOS PROFESSORES CADASTRADOS:");
        for (Professor professor : listaProfessor) {
            System.out.println(professor.imprimiDados());
            System.out.println("Nome: " + professor.getNome());
            System.out.println("Id: " + professor.getId());
            System.out.println("CPF: " + professor.getCpf());
            System.out.println("-------------------------------------------------");
        }
    }
}
