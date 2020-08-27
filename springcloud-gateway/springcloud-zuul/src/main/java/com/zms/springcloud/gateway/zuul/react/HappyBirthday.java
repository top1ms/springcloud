package com.zms.springcloud.gateway.zuul.react;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class HappyBirthday {

    public static void main(String[] args) {

        Subscriber<Integer> subscriber1=new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(Thread.currentThread().getName());
                System.out.println("今天我"+integer+"了");
            }
        };



        Observable.OnSubscribe<Integer> onSubscribe= new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {

                System.out.println("我执行完然后接着执行");

                subscriber.onNext(12);
            }
        };
        Observable<Integer> observable=Observable.create(onSubscribe);
        observable.toSingle().subscribe(subscriber1);
    }
}
