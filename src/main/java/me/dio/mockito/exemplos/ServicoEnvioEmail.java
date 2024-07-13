package me.dio.mockito.exemplos;

public class ServicoEnvioEmail {

    private PlataformaDeEnvio plataforma;

    public void enviaEmail(String enderecoEmail, String mensagem, Boolean formatoHtml){

        Email email = null;

        if(formatoHtml){
            email = new Email(enderecoEmail,mensagem,Formato.HTML);
        }else{
            email = new Email(enderecoEmail,mensagem,Formato.TEXTO);
        }
        plataforma.enviaEmail(email);
    }
}
