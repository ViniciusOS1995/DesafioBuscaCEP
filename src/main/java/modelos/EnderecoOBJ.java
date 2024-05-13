package modelos;

public class EnderecoOBJ {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String complemento;

    public  EnderecoOBJ (EnderecoReco enderecoReco){
        this.cep = enderecoReco.cep();
        this.logradouro = enderecoReco.logradouro();
        this.bairro = enderecoReco.bairro();
        this.localidade = enderecoReco.localidade();
        this.uf = enderecoReco.uf();
        this.complemento = enderecoReco.complemento();
    }

    @Override
    public String toString() {
        return "Endereço: " + "cep= " + cep + ", logradouro= " + logradouro + ", bairro= " + bairro + ", localidade= " + localidade +  ", uf= " + uf+
                ", complemento= " + complemento ;
    }
}
