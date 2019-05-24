package com.jcohy.study.responsibility;

public class Client {
    public static void main(String[] args) {
        Support alice = new NoSupport("alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("charlie", 429);
        Support diana = new LimitSupport("diana", 200);
        Support elmo = new OddSupport("elmo");
        Support fred = new LimitSupport("fred", 300);

        //形成链
        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
        for(int i=0;i<500;i+=33) {
            alice.support(new Trouble(i));
        }

    }
}
