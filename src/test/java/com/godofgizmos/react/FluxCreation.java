package com.godofgizmos.react;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class FluxCreation {

    @Test
    public void learnFluxCreation(){
//        usingFluxFromArrays();
        usingFluxCreateMethod();
    }

    private void usingFluxFromArrays(){
        String[] stringArray = new String[5];
        stringArray[0]="A";
        stringArray[1]="B";
        stringArray[2]="C";
        stringArray[3]="D";
        stringArray[4]="E";
        Flux fluxFromArray = Flux.fromArray(stringArray);
        fluxFromArray.log().subscribe(System.out::println, throwable -> {
            System.out.println("This is our error" + throwable);
        }, () -> {
            System.out.println("This is on Complete");
                }
                );
    }

    private void usingFluxCreateMethod(){
        Flux flux = Flux.create(fluxSink -> {
            fluxSink.next("A");
            fluxSink.next("B");
            fluxSink.next("C");
            fluxSink.next("GodOfGizmos");
//            fluxSink.error(new Exception("This is my Exception"));
            fluxSink.complete();
        });

        flux.log().subscribe(System.out::println, throwable -> {
                    System.out.println("This is our error" + throwable);
                }, () -> {
                    System.out.println("This is on Complete");
                }
        );
    }
}
