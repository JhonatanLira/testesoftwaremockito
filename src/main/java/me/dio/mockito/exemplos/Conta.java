package me.dio.mockito.exemplos;

public class Conta {

    private int saldo;

    public Conta(int saldo) {
        this.saldo = saldo;
    }

    public  void pagarBoleto(int valorAPagar){
        validarSaldo(valorAPagar);
        debitaValor(valorAPagar);
        enviarCreditoParaEmissor(valorAPagar);
    }

    public void  validarSaldo(int valorAPagar){
        if(valorAPagar > saldo){
            throw  new IllegalStateException("Saldo insuficiente");
        }
    }

    public void debitaValor(int valorAPagar) {
        this.saldo = this.saldo-valorAPagar;
    }

    public void enviarCreditoParaEmissor(int valorAPagar) {
        //enviar valor para o emissor do boleto
    }
}
