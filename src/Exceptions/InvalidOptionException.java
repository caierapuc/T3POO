package Exceptions;

public class InvalidOptionException extends Exception {
    private String message;

    public InvalidOptionException(){
        this.message = "Opção não encontrada! Contate um administrador.";
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
