package com.zms.springcloud.gateway.zuul.react;

import rx.Observable;
import rx.Subscriber;
import rx.internal.util.ObserverSubscriber;
import rx.schedulers.Schedulers;

public class Bfq {

    public interface geiwozhi{
        String zhi();
    }
    public void lawanshile(geiwozhi baba) throws InterruptedException {
        Thread.sleep(5000);
        String jieguo=baba.zhi();
        System.out.println(jieguo);
    }


    public static void main(String[] args) throws InterruptedException {
//        geiwozhi baba =new geiwozhi() {
//            @Override
//            public String zhi() {
//                return "给你纸";
//            }
//        };
//        Bfq bfq=new Bfq();
//        bfq.lawanshile(baba);
        Observable bfq=Observable.just("123");
        bfq.subscribeOn(Schedulers.newThread());
//        bfq.lift(ObserverSubscriber::new);

        bfq.subscribe(new Subscriber<String>() {
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
        });



        Observable<Integer> observable=Observable.create(subscriber -> {
            System.out.println(Thread.currentThread().getName()+":this is father");
            subscriber.onNext(123);
        });
       observable
               .subscribe(integer -> {
                   System.out.println(Thread.currentThread().getName()+":this is son");
                   System.out.println(integer);
               });









    }
}
