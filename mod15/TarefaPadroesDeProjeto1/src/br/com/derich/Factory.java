package br.com.derich;

public abstract class Factory {

    public Car create(String nota) {
        Car car = retornarCar(nota);
        car = prepararCarro(car);
        return car;
    }
    private Car prepararCarro(Car car) {
        car.limpar();
        car.combustivel();
        return car;
    }
    abstract Car retornarCar(String nota);
}
