package br.com.adrisilva.agendatarefa.main;

import java.util.ArrayList;
import java.util.Scanner;

public class RegrasTarefa {

    public static void exibirMenu() {

        System.out.println("#########################################");
        System.out.println("Gerenciador De Tarefas: ");
        System.out.println("\t 1 - Criar Tarefa");
        System.out.println("\t 2 - Iniciar Tarefa");
        System.out.println("\t 3 - Aumentar Importância da Tarefa");
        System.out.println("\t 4 - Diminuir Importância da Tarefa");
        System.out.println("\t 5 - Aumentar Urgência da Tarefa");
        System.out.println("\t 6 - Diminuir Urgência da Tarefa");
        System.out.println("\t 7 - Ver Tarefas Agendadas");
        System.out.println("\t 8 - Encerrar Tarefa");
        System.out.println("\t 0 - Sair");
        System.out.print("Sua Escolha: ");

    }

    public static void criarTarefa(ArrayList lista, Scanner teclado) {

        System.out.println("- - - Agendar Nova Tarefa - - -");

        System.out.print("Descrição da Tarefa: ");
        String desc = teclado.next();

        System.out.print("Duração: ");
        double duracao = teclado.nextLong();

        System.out.print("Importância (de 1 a 5): ");
        int importancia = teclado.nextInt();

        while (importancia > 5 || importancia < 1) {
            System.err.println("VALOR INVÁLIDO! DIGITE ENTRE 1 e 5!!!");
            System.out.print("Importância (de 1 a 5): ");
            importancia = teclado.nextInt();
        }

        System.out.print("Urgência (de 1 a 5): ");
        int urgencia = teclado.nextInt();

        while (urgencia > 5 || urgencia < 1) {
            System.err.println("VALOR INVÁLIDO! DIGITE ENTRE 1 e 5!!!");
            System.out.print("Urgência (de 1 a 5): ");
            urgencia = teclado.nextInt();
        }

        System.out.print("Hora de Inicio: ");
        int hr_inicio = teclado.nextInt();

        System.out.print("Valor Hora:R$ ");
        double vl_hora = teclado.nextLong();

        System.out.print("Data: ");
        String data = teclado.next();

        System.out.print("Local: ");
        String local = teclado.next();

        Tarefa t = new Tarefa(hr_inicio, vl_hora, duracao, desc,
                data, local, importancia, urgencia);

        lista.add(t);

        System.out.println("- - - Tarefa Criada - - -");
    }

    public static void iniciarTarefa(ArrayList lista, String nome_tarefa) {

        int qtd_tarefas = 0;
        for (int i = 0; i < lista.size(); i++) {

            Tarefa tr = (Tarefa) lista.get(i);
            if (tr.getDescricao().equals(nome_tarefa)) {
                tr.iniciarTarrefa();
                System.out.println("Tarefa Iniciada");
                qtd_tarefas++;
            }

        }

        if (qtd_tarefas == 0) {
            System.err.println("Essa tarefa não existe!!!");
        }
    }

    public static void verTarefasAgendadas(ArrayList lista) {

        for (int i = 0; i < lista.size(); i++) {

            System.out.println("- - - - - - Tarefa " + (i + 1) + " - - - - - -");
            Tarefa tr = (Tarefa) lista.get(i);
            System.out.println("Descrição: " + tr.getDescricao());
            String desc;

            if (tr.getStatus().equals("P")) {
                desc = "Por fazer";
            } else if (tr.getStatus().equals("F")) {
                desc = "Feito";
            } else {
                desc = "Em Andamento";
            }

            System.out.println("Status: (" + tr.getStatus() + ") -> " + desc);

            System.out.println("Importância: " + tr.getImportancia());
            System.out.println("Urgência: " + tr.getUrgencia());
            System.out.println("Data: " + tr.getData());
            System.out.println("Hora de inicío: " + tr.getHora_inicio());
            System.out.println("Duração: " + tr.getDuracao());
            System.out.println("Valor Cobrado:R$ " + tr.getValor_cobrado());
            System.out.println("- - - - - - - - - - - - - - - - - ");

        }
    }

    public static void aumentarImportanciaTarefa(ArrayList lista, String nome_tarefa) {

        int qtd_tarefas = 0;
        for (int i = 0; i < lista.size(); i++) {

            Tarefa tr = (Tarefa) lista.get(i);
            if (tr.getDescricao().equals(nome_tarefa)) {
                if (tr.getImportancia() < 5) {
                    tr.incrementarImportancia();
                    System.out.println("Importância Aumentada!");
                    qtd_tarefas++;
                } else {
                    System.err.println("A importância dessa tarefa não pode passar de 5");
                    qtd_tarefas++;
                }
            }

        }

        if (qtd_tarefas == 0) {
            System.err.println("Essa tarefa não existe!!!");
        }

    }

    public static void diminuirImportanciaTarefa(ArrayList lista, String nome_tarefa) {

        int qtd_tarefas = 0;
        for (int i = 0; i < lista.size(); i++) {

            Tarefa tr = (Tarefa) lista.get(i);
            if (tr.getDescricao().equals(nome_tarefa)) {
                if ((tr.getImportancia() - 1) > 0) {
                    tr.decrementarImportancia();
                    System.out.println("Importância diminuida!");
                    qtd_tarefas++;
                }else{
                    System.err.println("A importância dessa tarefa não pode ser menor que 1");
                    qtd_tarefas++;
                }
            }

        }

        if (qtd_tarefas == 0) {
            System.err.println("Essa tarefa não existe!!!");
        }

    }

    public static void aumentarUrgenciaTarefa(ArrayList lista, String nome_tarefa) {

        int qtd_tarefas = 0;
        for (int i = 0; i < lista.size(); i++) {

            Tarefa tr = (Tarefa) lista.get(i);
            if (tr.getDescricao().equals(nome_tarefa)) {
                if (tr.getUrgencia() < 5) {
                    tr.incrementarUrgencia();
                    System.out.println("Urgência Aumentada!");
                    qtd_tarefas++;
                } else {
                    System.err.println("A urgência dessa tarefa não pode passar de 5");
                    qtd_tarefas++;
                }
            }

        }

        if (qtd_tarefas == 0) {
            System.err.println("Essa tarefa não existe!!!");
        }

    }

    public static void diminuirUrgenciaTarefa(ArrayList lista, String nome_tarefa) {

        int qtd_tarefas = 0;
        for (int i = 0; i < lista.size(); i++) {

            Tarefa tr = (Tarefa) lista.get(i);
            if (tr.getDescricao().equals(nome_tarefa)) {
                if ((tr.getUrgencia() - 1) > 0) {
                    tr.decrementarUrgencia();
                    System.out.println("Urgência diminuida!");
                    qtd_tarefas++;
                } else {
                    System.err.println("A urgência dessa tarefa não pode ser menor que 1");
                    qtd_tarefas++;
                }
            }

        }

        if (qtd_tarefas == 0) {
            System.err.println("Essa tarefa não existe!!!");
        }

    }

    public static void encerrarTarefa(ArrayList lista, String nome_tarefa, double preco_tarefa) {
        int qtd_tarefas = 0;
        for (int i = 0; i < lista.size(); i++) {

            Tarefa tr = (Tarefa) lista.get(i);
            if (tr.getDescricao().equals(nome_tarefa)) {
                tr.encerrarTarefa(preco_tarefa);
                System.out.println("Tarefa Encerrada");
                qtd_tarefas++;
            }

        }

        if (qtd_tarefas == 0) {
            System.err.println("Essa tarefa não existe!!!");
        }
    }

}
