package com.company;
import GameLog.Word;
import Users.User;

public class Main {

    public static void main(String[] args) {
       Word w = new Word(10);
       User u = new User();
       u.X = 8;
       u.Y = 8;
       u.Name = "@ ";
       w.RegistrationUser(u);

        User u1 = new User();
        u1.X = 1;
        u1.Y = 2;
        u1.Name = "A ";
        w.RegistrationUser(u1);



        boolean isStep = true;
        while (true) {

            isStep = w.Step(u);
            if(isStep) break;
            isStep = w.Step(u1);
            if(isStep) break;
            w.Print();
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){

            }
        }

        w.Print();
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
