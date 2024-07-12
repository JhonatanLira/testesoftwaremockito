package com.dio.mockito.exemplos;

import me.dio.mockito.exemplos.EnviarMensagem;
import me.dio.mockito.exemplos.Mensagem;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EnviarMensagemTeste {

    @Spy
    private EnviarMensagem enviarMensagem;

    void verificarComportamentoDaClasse(){
        Mockito.verifyNoInteractions(enviarMensagem);

        Mensagem mensagem = new Mensagem("Hello world");
        enviarMensagem.adicionarMensagem(mensagem);

        Mockito.verify(enviarMensagem).adicionarMensagem(mensagem);
    }
}
