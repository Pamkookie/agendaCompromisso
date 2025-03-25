package agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("📅 AGENDA DE COMPROMISSOS\n");

        int opcao;
        do {
            System.out.println("\n1 - ➕ Adicionar Compromisso");
            System.out.println("2 - 🔍 Verificar Próximos 7 Dias");
            System.out.println("0 - 🚪 Sair");
            System.out.print("👉 Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\n📝 Descrição: ");
                    String descricao = sc.nextLine();

                    
                    System.out.print("📅 Data (ddMMyyyy): ");
                    String dataStr = sc.nextLine().replaceAll("(\\d{2})(\\d{2})(\\d{4})", "$1/$2/$3");
                    LocalDate data = LocalDate.parse(dataStr, dateFormatter);

         
                    System.out.print("⏰ Hora (HHmm): ");
                    String horaStr = sc.nextLine().replaceAll("(\\d{2})(\\d{2})", "$1:$2");
                    LocalTime hora = LocalTime.parse(horaStr, timeFormatter);

                    LocalDateTime inicio = LocalDateTime.of(data, hora);

   
                    System.out.print("📅 Data Fim (ddMMyyyy): ");
                    String dataFimStr = sc.nextLine().replaceAll("(\\d{2})(\\d{2})(\\d{4})", "$1/$2/$3");
                    LocalDate dataFim = LocalDate.parse(dataFimStr, dateFormatter);

                    System.out.print("⏱ Hora Fim (HHmm): ");
                    String horaFimStr = sc.nextLine().replaceAll("(\\d{2})(\\d{2})", "$1:$2");
                    LocalTime horaFim = LocalTime.parse(horaFimStr, timeFormatter);

                    LocalDateTime fim = LocalDateTime.of(dataFim, horaFim);

                    if (fim.isBefore(inicio)) {
                        System.out.println("\n❌ Erro: Data final deve ser após a inicial!");
                        break;
                    }

                    Compromisso comp = new Compromisso(inicio, fim, descricao);
                    agenda.adicionarCompromisso(comp);
                    System.out.println("\n✅ Compromisso adicionado!");
                    break;

                case 2:
                    System.out.println("\n📅 Compromissos nos próximos 7 dias:");
                    System.out.println("──────────────────────────────");
                    ArrayList<Compromisso> compromissos = agenda.verificarCompromissos();
                    
                    if (compromissos.isEmpty()) {
                        System.out.println("✅ Nenhum compromisso agendado");
                    } else {
                        compromissos.forEach(System.out::println);
                    }
                    break;

                case 0:
                    System.out.println("\n👋 Até logo!");
                    break;

                default:
                    System.out.println("\n❌ Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}