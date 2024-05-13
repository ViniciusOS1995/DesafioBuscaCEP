import cepConexao.RequisicaoCep;
import modelos.EnderecoOBJ;
import modelos.GeradorJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RequisicaoCep requisicaoCep = new RequisicaoCep();
        Scanner leitura = new Scanner(System.in);
        String cep = "";
        List<EnderecoOBJ> enderecoOBJList = new ArrayList<>();
        GeradorJson geradorJson = new GeradorJson();
        while (!cep.equalsIgnoreCase("sair")){
            System.out.println("Digite CEP para ser pesquisado(se desejar parar o programa digite sair): ");
            cep = leitura.nextLine();
            if (cep.equalsIgnoreCase("sair")){
                System.out.println("Finalizando Programa.");
                geradorJson.gerarJson(enderecoOBJList);
                break;
            }
            try {
                EnderecoOBJ enderecoOBJ = new EnderecoOBJ(requisicaoCep.buscaCEP(cep));
                enderecoOBJList.add(enderecoOBJ);
                System.out.println(enderecoOBJ+"\n");

            } catch (IOException|InterruptedException e) {
                System.out.println("Não foi possivel realizar a Conexão.");
                throw new RuntimeException(e);
            }
        }
    }
}
