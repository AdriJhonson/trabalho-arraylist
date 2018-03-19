package br.com.adrisilva.agendatarefa.main;

import java.util.ArrayList;
import java.util.Scanner;

public class App extends RegrasTarefa {

    public static void main(String[] args) {
        ArrayList lista_tarefas = new ArrayList();

        Scanner teclado = new Scanner(System.in);
        String nome_tarefa;

        exibirMenu();
        int opcEscolhidda = teclado.nextInt();

        while (opcEscolhidda != 0) {
            System.out.println("#########################################");
            switch (opcEscolhidda) {

                case 1:
                    criarTarefa(lista_tarefas, teclado);
                    break;

                case 2:
                    System.out.print("Nome da tarefa que deseja iniciar: ");
                    nome_tarefa = teclado.next();
                    iniciarTarefa(lista_tarefas, nome_tarefa);

                    break;

                case 3:
                    System.out.print("Nome da tarefa que deseja aumentar a importância: ");
                    nome_tarefa = teclado.next();
                    aumentarImportanciaTarefa(lista_tarefas, nome_tarefa);

                    break;

                case 4:
                    System.out.print("Nome da tarefa que deseja diminuir a importância: ");
                    nome_tarefa = teclado.next();
                    diminuirImportanciaTarefa(lista_tarefas, nome_tarefa);

                    break;

                case 5:
                    System.out.print("Nome da tarefa que deseja aumentar a urgência: ");
                    nome_tarefa = teclado.next();
                    aumentarUrgenciaTarefa(lista_tarefas, nome_tarefa);

                    break;

                case 6:
                    System.out.print("Nome da tarefa que deseja diminuir a urgência: ");
                    nome_tarefa = teclado.next();
                    diminuirUrgenciaTarefa(lista_tarefas, nome_tarefa);

                    break;

                case 7:
                    verTarefasAgendadas(lista_tarefas);
                    break;

                case 8:
                    System.out.print("Nome da tarefa que deseja encerrar: ");
                    nome_tarefa = teclado.next();

                    System.out.print("Valor Cobrado pela tarefa:R$ ");
                    double preco_tarefa = teclado.nextDouble();

                    encerrarTarefa(lista_tarefas, nome_tarefa, preco_tarefa);
                    break;

                default:
                    System.err.println("OPÇÃO INVÁLIDA!!!");
                    break;

            }

            exibirMenu();
            opcEscolhidda = teclado.nextInt();

        }

        System.out.println("Encerrando...");

    }
}
