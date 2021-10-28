package com.company;
import GameLog.Word;
import Users.User;

public class Main {

    public static void main(String[] args) {
       Word w = new Word(5);


       User u = new User();
       u.X = 1;
       u.Y = 1;
       u.Name = "@ ";
       u.w = w;
       w.RegistrationUser(u);


        User u1 = new User();
        u1.X = 3;
        u1.Y = 3;
        u1.Name = "A ";
        u1.w = w;
        w.RegistrationUser(u1);


        User isStep = null;
        User p = null;
        User up = null;
        while (true) {

            isStep = w.Step(u);
            if(isStep != null) {
               p = isStep;//w.EnemyCheckObj(u);
               up = u;
                break;
            }
            w.Print();
            isStep = w.Step(u1);
            if(isStep != null) {
                p = isStep;//w.EnemyCheckObj(u1);
                up = u1;
                break;
            }
            w.Print();
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){

            }
        }

        up.p = p;
        Thread myThread = new Thread(up,"User1");
        myThread.start();


        //w.Print();
    }

    static User CreateUser(String name, Word w, int x, int y)
    {
        User u = new User();
        u.X = 1;
        u.Y = 2;
        u.Name = name;
        w.RegistrationUser(u);
        return u;
    }
}
