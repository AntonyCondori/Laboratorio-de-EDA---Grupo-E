package PRACTICA03.EJERCICIOS_PROPUESTOS;

public class Operador<T extends Number> {
    private T primerValor;
    private T segundoValor;

    public Operador(T primerValor, T segundoValor) {
        this.primerValor = primerValor;
        this.segundoValor = segundoValor;
    }

    public T getPrimerValor() {
        return primerValor;
    }

    public T getSegundoValor() {
        return segundoValor;
    }
}