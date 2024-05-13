package modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorJson {
    public void gerarJson(List<EnderecoOBJ> enderecoOBJ) {
        Gson gson = new GsonBuilder().setPrettyPrinting().
                create();
        try {
            FileWriter escrita = new FileWriter("CEPS.json");
            escrita.write(gson.toJson(enderecoOBJ));
            escrita.close();
            System.out.println("Json gerado com sucesso");
        } catch (IOException e) {
            System.out.println("Não Foi possivel gerar o Json!");
            throw new RuntimeException(e);
        }
    }
}
