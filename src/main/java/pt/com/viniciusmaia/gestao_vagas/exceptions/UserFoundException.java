package pt.com.viniciusmaia.gestao_vagas.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException(){
        super("O usuário já existe");
    }
}
