package senac.appviacep.models;

public class Endereco {

    private String ibge;
    private String gia;
    private String cep;
    private String logradouro;
    private String bairro;
    private String complemento;
    private String localidade;
    private String uf;
    private String unidade;

    public Endereco() {
    }

    public Endereco(String ibge, String gia, String cep, String logradouro, String bairro, String complemento, String localidade, String uf, String unidade) {
        this.ibge = ibge;
        this.gia = gia;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.complemento = complemento;
        this.localidade = localidade;
        this.uf = uf;
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return "Meu Endereço: \n" +
                "ibge: " + ibge + "\n" +
                "GIA: " + gia + "\n" +
                "CEP: " + cep + "\n" +
                "Logradouro: " + logradouro + "\n" +
                "Bairro: " + bairro + "\n" +
                "Complemento: " + complemento + "\n" +
                "Localidade: " + localidade + "\n" +
                "UF: " + uf + "\n" +
                "Unidade: " + unidade;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
