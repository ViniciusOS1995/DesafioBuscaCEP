package cepConexao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import modelos.EnderecoReco;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequisicaoCep {
    public EnderecoReco buscaCEP(String cep) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().
                create();
        EnderecoReco endereco = null;
        URI enderecoApi = URI.create("https://viacep.com.br/ws/"+cep+"/json/");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(enderecoApi)
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().
                send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        try {
            endereco = gson.fromJson(json, EnderecoReco.class);
        }catch (JsonSyntaxException e){
            throw new CepErradoExcecao("Não localizei o CEP, finalizando o Programa.");
        }
        return endereco;
    }
}
