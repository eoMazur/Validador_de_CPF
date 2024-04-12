package Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import services.filtragemCompleta;
import services.verificadorCPF;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o caminho do arquivo para a leitura dos dados: ");
        String caminho = sc.nextLine();


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


        filtragemCompleta fc = new filtragemCompleta(new verificadorCPF(), set);
        fc.imprimirListas();
        
       } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
       }
       finally{
        sc.close();
       }


    }
}
