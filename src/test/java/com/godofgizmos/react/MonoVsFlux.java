package com.godofgizmos.react;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonoVsFlux {

    @Test
    public void test(){
        // Mono - 1 object - Integer/String/List - object
        // Flux - Multiple Objects - 1,2,3 - List1, List2 and so on.
        /*System.out.println("Mono Just");
        Mono godOfGizmos = Mono.just("GodOfGizmos -1 ");
        godOfGizmos.subscribe(System.out::println);*/

        System.out.println("Mono Empty");
        Mono emptyMono = Mono.empty().log();
        emptyMono.subscribe(System.out::println, throwable -> {
            System.out.println(throwable);
        }, () -> {
            System.out.println("Complete Method Called - Empty");
        });

        System.out.println("Mono Never");
        Mono nvrMono = Mono.never().log();
        nvrMono.subscribe(System.out::println, throwable -> {
            System.out.println(throwable);
        }, () -> {
            System.out.println("Complete Method Called - Never");
        });
    }

    @Test
    public void testFlux(){
        /*Flux.just(new ArrayList<>(),new ArrayList<>());
        Flux.empty();
        Flux.never();*/
        List list = Arrays.asList("A", "B", "C");

        Flux fluxOfAlphabets = Flux.fromIterable(list);
        fluxOfAlphabets.subscribe(System.out::println);
    }


}
