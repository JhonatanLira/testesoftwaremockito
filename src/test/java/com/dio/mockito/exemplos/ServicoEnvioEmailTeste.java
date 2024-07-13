package com.dio.mockito.exemplos;

import me.dio.mockito.exemplos.Email;
import me.dio.mockito.exemplos.Formato;
import me.dio.mockito.exemplos.PlataformaDeEnvio;
import me.dio.mockito.exemplos.ServicoEnvioEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServicoEnvioEmailTeste {

    @Mock
    private PlataformaDeEnvio plataforma;

    @InjectMocks
    private ServicoEnvioEmail servico;

    @Captor
    ArgumentCaptor<Email> captor;

    @Test
    void validarDadosEnviadosParaAplataforma() {

        String enderecoEmail = "";
        String mensagem = "";
        boolean ehFormatoHtml = false;

        servico.enviaEmail(enderecoEmail,mensagem,ehFormatoHtml);

        Mockito.verify(plataforma).enviaEmail(captor.capture());

        Email emailCapturado = captor.getValue();

        Assertions.assertEquals(enderecoEmail, emailCapturado.getEnderecoEmail());
        Assertions.assertEquals(mensagem, emailCapturado.getMensagem());
        Assertions.assertEquals(Formato.TEXTO, emailCapturado.getFormato());
    }

}
