package com.company;

import java.util.*;

public class Main {

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

    static String[] carrier = {"Аэрофлот", "S7 Airlines", "Россия", "Aero Caribbean", "Air Canada", "Air Greenland", "Air Wisconsin"};
    static String[] flightClasses = {"Business", "Economy", "First"};

    public static void main(String[] args) {

        List<Baggage> baggageList = createBaggageList();

        // Упорядочить список от самого легкого к самому тяжелому багажу
        baggageList.stream().sorted().forEach(System.out::println);
        System.out.println("========================================");

        // Cортировка должна быть выполнена от самого длинного названия к самому короткому
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (! ((o1 instanceof Baggage) && (o2 instanceof Baggage))) {
                    throw new UnsupportedOperationException("Попытка сравнения объектов разного типа!");
                } else return Integer.compare(nameLength((Baggage) o2), nameLength((Baggage) o1));
            }
        };

        baggageList.sort(comparator);
        baggageList.forEach(System.out::println);
    }

    public static List<Baggage> createBaggageList() {

        List<Baggage> baggage = new ArrayList<>();
        int amountOfBaggage = 6 + (int)(Math.random()*5);

        for (int i = 0; i < amountOfBaggage; i++) {
            baggage.add(createBaggage());
        }
        return baggage;
    }

    public static Baggage createBaggage() {
        return new Baggage(carrier[(int) (Math.random()*carrier.length)], flightClasses[(int)(Math.random()*flightClasses.length)]);
    }

    public static int nameLength(Baggage baggage) {
        return (((Baggage) baggage).getCarrierName()).length() + (((Baggage) baggage).getFlightClassName()).length();
    }
}
