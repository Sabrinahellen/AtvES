import java.io.*;
import java.util.Scanner;

public class DiarioDoDia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bem-vindo ao seu Diário!");
        System.out.println("Vamos registrar o seu dia.");

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

        scanner.close();
    }
}
