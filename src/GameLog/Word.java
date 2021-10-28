package GameLog;
import Users.User;

import java.util.ArrayList;
import java.util.Random;

public class Word {
    int size = 24;
    ArrayList<User> list = new ArrayList<>();
    Random random = new Random();
    public Word(int size)
    {
        this.size = size;
    }

    public void RegistrationUser(User x)
    {
        list.add(x);
    }
    ArrayList<Integer> nums = new ArrayList<Integer>();



    public  User Step(User p)
    {
        User u = new User(p);
        list.remove(p);
        int i = direction();

        if(i == 1) // идем в вверх
        {
            Top(p);
        }else if(i == 2)
        {
           Top(p);
           Right(p);
        }
        else if(i == 3)
        {
            Right(p);
        }
        else if(i == 4)
        {
            Bottom(p);
            Right(p);
        }else if(i == 5)
        {
            Bottom(p);
        }
        else if(i == 6)
        {
            Bottom(p);
            Left(p);
        }
        else if(i == 7)
        {
            Left(p);
        }
        else if(i == 8)
        {
            Left(p);
            Top(p);
        }

        var isEn = EnemyCheckObj(p);
        if(isEn == null)
       list.add(p);
        else
            list.add(u);
        return  isEn;
    }


    public User EnemyCheckObj(Position p)
    {
        boolean res = false;

        for(int i = 0; i < list.size(); ++i)
        {
            var u = list.get(i);
            if(u.X == p.X && u.Y == u.Y)
                return u;
        }

        return null;
    }


    void Left(Position p)
    {
        int x = p.X;
        x -= 1;
        if(x > -1)
            p.X = x;
        else
            Right(p);
    }

    void Right(Position p)
    {
        int x = p.X;
        x += 1;
        if(x < size)
            p.X = x;
        else
            Left(p);
    }

    void Top(Position p)
    {
        int y = p.Y;
        y -= 1;
        if(y > -1)
            p.Y = y;
        else
            Bottom(p);
    }

    void Bottom(Position p)
    {
        int y = p.Y;
        y += 1;
        if(y < size)
            p.Y = y;
        else
            Top(p);
    }

    private int direction()
    {

        int i = getRandomNumberUsingNextInt(0, 8000000);

        if(i < 1000000)
        {
            return 8;
        }
         else if(i < 2000000)
        {
            return 7;
        }else if(i < 3000000)
        {
            return 6;
        }else if(i < 4000000)
        {
           return 5;
        }
        else if(i < 5000000)
        {
           return 4;
        }
        else if(i < 6000000)
        {
           return 3;
        }
        else if(i < 7000000)
        {
            return  2;
        }
        else if(i < 8000001)
        {
           return 1;
        }

        return  0;
    }

    private int getRandomNumberUsingNextInt(int min, int max) {

        return random.nextInt(max - min) + min;
    }

    public void Print()
    {
        System.out.println();
        System.out.println();

        for(int i = 0; i < size; ++i) {
            System.out.println();
            for (int j = 0; j < size; ++j) {
                System.out.print(" | ");
                Position p = new Position();
                p.X = i;
                p.Y = j;

                var name = Cheked(p);
                if(name.equals("")) {

                    System.out.print(" ");
                    System.out.print(" ");
                }else {
                    System.out.print(name);
                }

                if(j == size - 1)
                    System.out.print(" | ");
            }


        }
    }


    private String Cheked(Position p)
    {
        String res = "";

        for(int i = 0; i < list.size(); ++i)
        {
            if(p.X == list.get(i).X && p.Y == list.get(i).X)
                return list.get(i).Name;
        }

        return  "";
    }


}
