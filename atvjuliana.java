import java.io.*;
import java.util.Scanner;

public class DiarioDoDia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao seu Diário!");
        
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Registrar nova entrada");
            System.out.println("2. Visualizar entradas anteriores");
            System.out.println("3. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner

            if (opcao == 1) {
                System.out.println("\nDigite sua entrada para o diário de hoje: ");
                String entrada = scanner.nextLine();

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("diario.txt", true))) {
                    writer.write("Data: " + java.time.LocalDate.now() + " - " + java.time.LocalTime.now() + "\n");
                    writer.write(entrada + "\n\n");
                    System.out.println("Sua entrada foi salva no diário!");
                } catch (IOException e) {
                    System.out.println("Erro ao salvar a entrada.");
                }

                System.out.println("\nEntrada salva no diário:");
                System.out.println("Data e Hora: " + java.time.LocalDate.now() + " - " + java.time.LocalTime.now());
                System.out.println(entrada);

            } else if (opcao == 2) {
                try (BufferedReader reader = new BufferedReader(new FileReader("diario.txt"))) {
                    String linha;
                    System.out.println("\nEntradas anteriores no diário:");

                    while ((linha = reader.readLine()) != null) {
                        System.out.println(linha);
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao ler o diário.");
                }

            } else if (opcao == 3) {
                System.out.println("Saindo do diário. Até mais!");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
