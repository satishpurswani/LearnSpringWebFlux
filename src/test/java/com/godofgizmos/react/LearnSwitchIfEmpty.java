package com.godofgizmos.react;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Calendar;
import java.util.Random;

public class LearnSwitchIfEmpty {

    private Mono DatabaseCallWithValue(){
        return Mono.delay(Duration.ofSeconds(new Random().nextInt())).create(monoSink -> {
            monoSink.success("MyValue");// Case - Where Some value is returned from DB.
        });
    }

    private Mono DatabaseCallWithEmptyValue(){
        return Mono.delay(Duration.ofSeconds(new Random().nextInt())).create(monoSink -> {
            monoSink.success();//Case - Where empty value is returned from DB.
        });
    }

    @Test
    public void learnSpringSwitchIfEmpty(){
        long startTime = Calendar.getInstance().getTimeInMillis();

//        Mono mono = DatabaseCallWithValue();
        Mono mono = DatabaseCallWithEmptyValue();

        mono
                .switchIfEmpty(Mono.defer(() -> insideEmpty()))
                .map(o -> o + " concating by Satishkumar")
                .subscribe(o -> {
                    System.out.println("Got this value from DB " + o);
                }, throwable -> {
                    System.out.println("This is our error " + throwable);
                }, () -> {
                    System.out.println("Emmitting compelte");
                });
        long totalTimeTaken = Calendar.getInstance().getTimeInMillis() - startTime;
        System.out.println("Time taken to complete : " + totalTimeTaken);
    }

    private Mono insideEmpty(){
        System.out.println("Inside SwitchIfEmpty Method Called");
        return Mono.just("SwitchIfEmpty Subscribers");
    }

}
