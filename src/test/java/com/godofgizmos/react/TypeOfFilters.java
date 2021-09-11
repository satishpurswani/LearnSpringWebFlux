package com.godofgizmos.react;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class TypeOfFilters {

    @Test
    public void learnFilters(){
        Flux<String> fromDB = Flux.just("ABZ","BFZ","CBZ","DCZ","EBZ","FCZ");
        fromDB
//                .filter(o -> o.contains("B"))
//                .any(s -> s.contains("X"))
                .all(s -> s.contains("B"))
                .subscribe(System.out::println);
    }
}
