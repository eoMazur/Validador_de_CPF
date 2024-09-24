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

        System.out.println("1 - Digitar os Cpfs\n2 - Verificar um arquivo de texto\n");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                sc.nextLine();
                Set<String> set = new HashSet<>();

                do{
                    System.out.println("Digite o CPF ou 0 ou apenas aperte Enter para sair: ");
                    String cpf = sc.nextLine();

                    if (cpf.isEmpty() || cpf.equals("0")) {
                        break;
                    }
                    set.add(cpf);


                }while (true);

                sc.close();

                FiltragemCompleta fc = new FiltragemCompleta(new VerificadorCPF(), set);

                fc.rodarMetodos();
                set.clear();

                fc.imprimirListas();
                break;

            case 2:
                System.out.print("Informe o caminho do arquivo para a leitura dos dados: ");
                String caminho = sc.nextLine();

                sc.close();


                try (BufferedReader br = new BufferedReader(new FileReader(caminho))){

                    Set<String> cpfs = new HashSet<>();
                    String codigoString;
                    do {

                        codigoString = br.readLine();

                        if(codigoString != null){
                            cpfs.add(codigoString);
                        }



                    } while (codigoString != null);

                    br.close();


                    FiltragemCompleta filtragem = new FiltragemCompleta(new VerificadorCPF(), cpfs);

                    filtragem.rodarMetodos();
                    cpfs.clear();

                    filtragem.imprimirListas();

                }
                catch (Exception e) {
                    System.out.println("\nErro: " + e.getMessage());
                }
                break;

            default:
                System.out.println("\nOpção Inválida: ");
                break;
        }


    }
}
