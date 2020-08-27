package com.zms.springcloud.gateway.zuul.react;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

import java.util.Arrays;

public class Connact {
    public static void main(String[] args) {


        Observable<String> observable=Observable.from(Arrays.asList(
                "http://www.baidu.com/",
                "http://www.google.com/",
                "https://www.bing.com/"))
                .concatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return Observable.just(s);
                    }
                }).concatMap(new Func1<String, Observable<? extends String>>() {
                    @Override
                    public Observable<? extends String> call(String s) {
                        return null;
                    }
                });

        Subscriber<String> s=new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };
        observable.subscribe(s);







    }
}
