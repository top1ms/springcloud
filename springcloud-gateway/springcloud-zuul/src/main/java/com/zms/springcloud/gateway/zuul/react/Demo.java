package com.zms.springcloud.gateway.zuul.react;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public class Demo {

    private Lashi lashi;

    public interface Lashi{
        void lashi();
    }

    void doSomething(Lashi lashi){
        lashi.lashi();
    }





    public static void main(String[] args) {







//        observable.subscribe(new Subscriber<Integer>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                System.out.println(integer);
//            }
//        });
//
//        observable.lift(new Observable.Operator<String, Integer>() {
//            @Override
//            public Subscriber<? super Integer> call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("123");
//
//
//                return new Subscriber<Integer>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        System.out.println(integer);
//                    }
//                };
//            }
//        });









        Observable<Integer> observable=Observable.create(subscriber -> { subscriber.onNext(812); });
        Observable.Operator<String,Integer> operator= subscriber -> {
            subscriber.onNext("happy birthday:ms");
            return new Subscriber<Integer>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(Integer integer) {
                    System.out.println(integer);
                }
            };
        };
        Observable<String> two=observable.lift(operator);
        two.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("hello zms");
            }
        });



    }

    public static void query(Integer integer){
    }

}
