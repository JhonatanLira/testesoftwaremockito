package com.dio.mockito.exemplos;

import me.dio.mockito.exemplos.Conta;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContaTeste {

    @Spy
    private Conta conta = new Conta(1000);

    @Test
    void validarOrdemDeChamada(){
            conta.pagarBoleto(300);

        InOrder inOrder = Mockito.inOrder(conta);
        inOrder.verify(conta).pagarBoleto(300);
        inOrder.verify(conta).validarSaldo(300);
        inOrder.verify(conta).debitaValor(300);
        inOrder.verify(conta).enviarCreditoParaEmissor(300);
    }

    @Test
    void validarQuantidadeDeChamadas(){

        conta.validarSaldo(500);
        conta.validarSaldo(500);
        conta.validarSaldo(600);

        Mockito.verify(conta, Mockito.times(3)).validarSaldo(ArgumentMatchers.anyInt());
    }

    @Test
    void retornarTrueParaQualquerValorNaValidacaoDealdo(){
        Mockito.doNothing().when(conta).validarSaldo(ArgumentMatchers.anyInt());
        conta.validarSaldo(3500);
    }
}
