package com.godofgizmos.react;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoCreate {

    @Test
    public void creatingMono() {
        Mono<Integer> integerMono = Mono.create(integerMonoSink -> {
            integerMonoSink.success(1);
//            integerMonoSink.error(new Exception("This is my exception"));
        });

        integerMono.log().subscribe(System.out::println, throwable -> {
            System.out.println("This is our error : "+ throwable);
        }, () -> {
            System.out.println("This is our complete event!");
        });

    }
}
