package com.company;

public class Baggage implements Comparable{

    /**
     * У вас есть список описаний багажа, в виде набора данных - наименование перевозчика,
     * наименование класса перелета, предельно допустимый вес багажа.
     * 1. Ваша задача - описать класс багажа, создать на его основе список из > 5 объектов.
     * Упорядочить список от самого легкого к самому тяжелому багажу, вывести список на экран.
     * 2. Далее - переупорядочить список, теперь сортировка должна произойти в зависимости от длины строки,
     * получаемой путем сложения названия перевозчика и названия класса перелета.
     * Сортировка должна быть выполнена от самого длинного названия к самому короткому.
     * В одном из случаев использовать анонимный класс, в одном - лямбду, на ваше усмотрение.
     */

    private String carrierName;
    private String flightClassName;
    private int weightLimit;

    public Baggage(String carrierName, String flightClassName) {
        this.carrierName = carrierName;
        this.flightClassName = flightClassName;
        this.weightLimit = 10 + (int)(Math.random()*30);
    }

    public String getCarrierName() {
        return carrierName;
    }

    public String getFlightClassName() {
        return flightClassName;
    }

    public int getWeightLimit() {
        return weightLimit;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public void setFlightClassName(String flightClassName) {
        this.flightClassName = flightClassName;
    }

    public void setWeightLimit(int weightLimit) {
        this.weightLimit = weightLimit;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s%n", "Наименование перевозчика: " + carrierName, "Наименование класса перелета: " + flightClassName, "Вес багажа: " + weightLimit);
    }

    @Override
    public int compareTo(Object o) {
        if (! (o instanceof Baggage)) {
            throw new UnsupportedOperationException("Попытка сравнения объектов разного типа!");
        } else return Integer.compare(this.getWeightLimit(), ((Baggage) o).getWeightLimit());
    }
}
