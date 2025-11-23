package br.com.fiap.services;

import br.com.fiap.api.Endereco;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class ViaCepService {

    public Endereco getEndereco(String cep) throws IOException {
        Endereco endereco = null;

        // Monta a URL do ViaCep
        HttpGet request = new HttpGet("https://viacep.com.br/ws/" + cep + "/json/");

        // Cria o cliente HTTP
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build();
             CloseableHttpResponse response = httpClient.execute(request)) {

            // Pega a resposta
            HttpEntity entity = response.getEntity();

            // Converte o JSON que veio do site para o nosso objeto Java
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                Gson gson = new Gson();
                endereco = gson.fromJson(result, Endereco.class);
            }
        }
        return endereco;
    }
}
