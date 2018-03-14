package br.com.adrisilva.agendatarefas.main;

import java.util.Scanner;

public class App {

    public static void exibirMenu() {

        System.out.println("Gerenciador De Tarefas: ");
        System.out.println("\t 1 - Iniciar Tarefa");
        System.out.println("\t 2 - Aumentar Importância da Tarefa");
        System.out.println("\t 3 - Aumentar Urgência da Tarefa");
        System.out.println("\t 4 - Diminuir Importância da Tarefa");
        System.out.println("\t 5 - Diminuir Urgência da Tarefa");
        System.out.println("\t 6 - Encerrar Tarefa");
        System.out.println("\t 7 - Ver Dados da Tarefa");
        System.out.println("\t 0 - Sair");
        System.out.print("Sua Escolha: ");

    }

    public static void iniciarTarefa(Scanner teclado) {
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
                data, local);

        System.out.println("- - - Tarefa Agendada - - -");
    }

    public static void verTarefasAgendadas(){
        
    }
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        exibirMenu();
        int opcEscolhidda = teclado.nextInt();

        while (opcEscolhidda != 0) {

            switch (opcEscolhidda) {

                case 1:
                    iniciarTarefa(teclado);
                    break;

                case 2:
                    System.out.println("Opção 2");
                    break;

                case 3:
                    System.out.println("Opção 3");
                    break;

                case 4:
                    System.out.println("Opção 4");
                    break;

                case 5:
                    System.out.println("Opção 5");
                    break;

                case 6:
                    System.out.println("Opção 6");
                    break;

                case 7:
                    System.out.println("Opção 7");
                    break;

                default:
                    System.err.println("OPÇÃO INVÁLIDA!!!");
                    System.out.print("Sua escolha: ");
                    opcEscolhidda = teclado.nextInt();
                    break;

            }

            exibirMenu();
            opcEscolhidda = teclado.nextInt();

        }

        System.out.println("Encerrando...");

    }

}
