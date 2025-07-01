package excecao;

public class ErroVazio extends RuntimeException {
    private String message;

    public ErroVazio(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
