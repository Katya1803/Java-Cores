package a.example;

import collections.CollectionsExample;
import concurrency.ConcurrencyExample;
import generics.GenericsExample;
import lambda.LambdaExample;
import oops.OOPExample;
import regex.RegexExample;

public enum ExampleOption {
    CONCURRENCY(1, "Concurrency", new ConcurrencyExample()),
    COLLECTIONS(2, "Collections", new CollectionsExample()),
    GENERICS(3, "Generics", new GenericsExample()),
    LAMBDA(4, "Lambda", new LambdaExample()),
    OOP(5, "OOP", new OOPExample()),
    REGEX(6, "Regex", new RegexExample()),
    EXIT(7, "Thoát", null);

    private final int optionNumber;
    private final String description;
    private final Example example;

    ExampleOption(int optionNumber, String description, Example example) {
        this.optionNumber = optionNumber;
        this.description = description;
        this.example = example;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public String getDescription() {
        return description;
    }

    public Example getExample() {
        return example;
    }

    public static ExampleOption fromOptionNumber(int optionNumber) {
        for (ExampleOption option : values()) {
            if (option.optionNumber == optionNumber) {
                return option;
            }
        }
        return null;
    }
}
