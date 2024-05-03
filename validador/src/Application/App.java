package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import services.FiltragemCompleta;
import services.VerificadorCPF;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o caminho do arquivo para a leitura dos dados: ");
        String caminho = sc.nextLine();

        sc.close();


       try (BufferedReader br = new BufferedReader(new FileReader(caminho))){

        Set<String> set = new HashSet<>();
        String codigoString;
        do {
   
            codigoString = br.readLine();

            if(codigoString != null){
                set.add(codigoString);
            }
            

           
        } while (codigoString != null);

        br.close();


        FiltragemCompleta fc = new FiltragemCompleta(new VerificadorCPF(), set);

        fc.rodarMetodos();
        set.clear();

        fc.imprimirListas();
        
       }
        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
       }
    }
}
