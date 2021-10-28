package Users;
import GameLog.Position;
import GameLog.Word;
import GameLog.Equipment;
import GameLog.Potion;
import java.util.Timer;

import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

public class User extends Position implements Runnable {
   public String Name = "";
   public User p = null;
   public int helthy = 100;
   public Equipment atak = new Equipment();
   public Word w = null;
   public Potion potion = new Potion();
   Random rm = new Random();
   int r = rm.nextInt(30);
   final Timer timer = new Timer();

   public User() {
      atak.damage = getRandomNumberUsingNextInt(1, 10);
   }

   public User(User u) {
      X = u.X;
      Y = u.Y;
      Name = u.Name;
      atak.damage = getRandomNumberUsingNextInt(1, 10);

      if (!Name.equals("@ ")) {
         potion.p = r;
      }
   }

   public void run() {
      boolean fn = false;

      int i = getRandomNumberUsingNextInt(1, 1000000);
      i = i % 2;
      while (this.helthy > 0 && p.helthy > 0) {
         if (i == 0)
            helthy -= p.atak.damage;
         else
            p.helthy -= atak.damage;

         fn = !fn;
      }

      if (p.atak.damage < atak.damage) {
         p.atak = atak;
      }

      String name = this.helthy > 0 ? Name : p.Name;
      System.out.println(name);

      Timer timer = new Timer();
      timer.schedule(new TimerTask() {
         @Override
         public void run() {
            if(p.helthy<50){
               p.helthy+= potion.p;
         }
      }

   },1000,1000);


   }

   private int getRandomNumberUsingNextInt(int min, int max) {

      return rm.nextInt(max - min) + min;
   }
}
