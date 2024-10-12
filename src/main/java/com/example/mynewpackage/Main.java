package com.example.mynewpackage;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import javax.naming.ldap.PagedResultsControl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Function<Integer,Integer> function = x -> x *x* x;
        Function<Integer,Integer> function1 = x -> x * x*x*x;
        System.out.println(function.andThen(function1).apply(2));


    }
}
