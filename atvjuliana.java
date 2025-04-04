import java.io.*;
import java.util.Scanner;

public class DiarioDoDia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Digite sua entrada para o diário de hoje: ");
        String entrada = scanner.nextLine();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("diario.txt", true))) {
            writer.write("Data: " + java.time.LocalDate.now() + "\n");
            writer.write(entrada + "\n\n");
            System.out.println("Sua entrada foi salva no diário!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar a entrada.");
        }
       
        System.out.println("\nEntrada salva no diário:");
        System.out.println("Data: " + java.time.LocalDate.now());
        System.out.println(entrada);

        scanner.close();
    }
}
