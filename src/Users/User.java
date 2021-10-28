package Users;
import GameLog.Position;

public class User extends Position {
   public String Name = "";
   public User(){}
   public User(User u)
   {
      X = u.X;
      Y = u.Y;
      Name = u.Name;
   }

}
