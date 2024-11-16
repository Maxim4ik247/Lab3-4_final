package Exceptions;

public class CarOverloadException extends RuntimeException {
    public CarOverloadException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Возникла ошибка: Машина перегружена (не хватает посадочных мест)";
    }
}
