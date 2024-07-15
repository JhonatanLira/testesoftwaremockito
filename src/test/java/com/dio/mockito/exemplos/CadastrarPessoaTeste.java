package com.dio.mockito.exemplos;

import me.dio.mockito.exemplos.ApiDosCorreios;
import me.dio.mockito.exemplos.CadastrarPessoa;
import me.dio.mockito.exemplos.DadosLocalizacao;
import me.dio.mockito.exemplos.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

    @Mock
    private ApiDosCorreios apiDosCorreios;
    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro(){
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("RJ","Cabo Frio", "Ezio Cardoso da Fonseca","","Jardim Esperança");
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("28920000")).thenReturn(dadosLocalizacao);
        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Jhonatan", "000000000", LocalDate.now(),"28920000");

            assertEquals("Jhonatan", pessoa.getNome());
            assertEquals("000000000", pessoa.getDocumento());
            assertEquals("", pessoa.getEndereco().getComplemento());
            assertEquals("RJ", pessoa.getEndereco().getUf());
    }

    @Test
    void lancarExceptionChamarApiCorreios(){

      //  DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("RJ","Cabo Frio", "Ezio Cardoso da Fonseca","","Jardim Esperança");
        //Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenThrow(IllegalArgumentException.class);
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(null);

        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Jhonatan", "000000000", LocalDate.now(),"28920000");

       // Assertions.assertThrows(IllegalArgumentException.class, ()->cadastrarPessoa.cadastrarPessoa("Jhonatan", "000000000", LocalDate.now(),"28920000"));

        assertNull(pessoa.getEndereco());
    }
}
