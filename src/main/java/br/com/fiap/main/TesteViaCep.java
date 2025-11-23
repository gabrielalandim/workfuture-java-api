package br.com.fiap.main;

import br.com.fiap.api.Endereco;
import br.com.fiap.services.ViaCepService;
import javax.swing.JOptionPane;
import java.io.IOException;

public class TesteViaCep {
    public static void main(String[] args) {
        // Pede o CEP para o usuário
        String cep = JOptionPane.showInputDialog("Digite um CEP para buscar (Ex: 01311000)");

        ViaCepService service = new ViaCepService();

        try {
            System.out.println("Buscando endereço...");
            Endereco endereco = service.getEndereco(cep);

            if (endereco != null && endereco.getCep() != null) {
                System.out.println("---- ENDEREÇO ENCONTRADO ----");
                System.out.println("CEP: " + endereco.getCep());
                System.out.println("Rua: " + endereco.getLogradouro());
                System.out.println("Bairro: " + endereco.getBairro());
                System.out.println("Cidade: " + endereco.getLocalidade());
                System.out.println("Estado: " + endereco.getEstado());
                JOptionPane.showMessageDialog(null, "Endereço encontrado:\n" + endereco);
            } else {
                System.out.println("CEP não encontrado ou inválido.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao buscar CEP: " + e.getMessage());
        }
    }
}