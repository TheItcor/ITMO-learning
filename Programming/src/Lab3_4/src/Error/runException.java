package Error;

public class runException extends RuntimeException{

    public runException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "[Ошибка]" + super.getMessage();
    }
}
