package com.company;

public class Main {

    public static void main(String[] args) {
	    // Паттерн (стратегия) меняет значения в зависимости от выбранной стратегии

        // начальная цена
        double startPrice = 100;
        // выбранная стратегия в контексте
        ContextStrategy contextPrice = new ContextStrategy(new HalfPrice());
        // создание новой цены, везде
        double price = contextPrice.getPrice(startPrice);

        // теперь можно ею пользоваться
        System.out.println(price);
    }
}

// создаём виды стратегий
interface Strategy{
    double getPrice(double price);
}

class FullPrice implements Strategy{
    @Override
    public double getPrice(double price) {
        return price;
    }
}

class HalfPrice implements Strategy{
    @Override
    public double getPrice(double price) {
        return price * 0.5;
    }
}

// вызываем нужные методы в зависимости от выбранной стратегии
class ContextStrategy{
    Strategy strategy;

    public ContextStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public double getPrice(double price) {
        return strategy.getPrice(price);
    }
}