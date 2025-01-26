package pt.com.viniciusmaia.gestao_vagas.exceptions;

public class JobFoundException extends RuntimeException {
    public JobFoundException(){
        super("Já existe esta vaga");
    }
}
