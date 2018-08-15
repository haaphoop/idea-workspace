package com.company.threadlocal;

/**
 * Created by daishuli on 2018/4/28.
 */
public class ThreadLocalTest {


    public static void main(String[] args) {
        SequenceNumber sequenceNumber = new SequenceNumber();
        for (int i = 0; i < 100; i++) {
            Client client = new Client(sequenceNumber);
            client.start();
        }
       /* Client client = new Client(sequenceNumber);
        Client client1 = new Client(sequenceNumber);
        Client client2 = new Client(sequenceNumber);
        client.start();
        client1.start();
        client2.start();*/
    }
}
class Client extends Thread {
    private SequenceNumber sequenceNumber;

    public Client(SequenceNumber sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("thread[" + Thread.currentThread().getName()
                    + "] sn[" + sequenceNumber.getNextNum() + "]");
        }
    }
}