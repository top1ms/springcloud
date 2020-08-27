package com.zms.springcloud.gateway.zuul.react;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class RibbionStimulate {

    public  static Func0<Observable<String>> func0=new Func0<Observable<String>>() {
        @Override
        public Observable<String> call() {
            System.out.println("123");
            return Observable.defer(func01).doOnNext(new Action1<String>() {
                @Override
                public void call(String s) {
                    System.out.println("123456");
                }
            });
        }
    };


    public static Func0<Observable<String>> func01=new Func0<Observable<String>>() {
        @Override
        public Observable<String> call() {
            System.out.println("234");
            return Observable.just("333").doOnNext(new Action1<String>() {
                @Override
                public void call(String s) {
                    System.out.println("12321312");
                }
            });
        }
    };
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Observable.defer(func0).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s+"end");
            }
        });


    }
}
