package hiber;


import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User user1 = new User("Ivan", "Ivanov", "iooo@hjj.com");
      User user2 = new User("Sergei", "Lukas", "luka@mail.ru");
      User user3 = new User("Andrei", "POmpon", "try@mail.com");
      User user4 = new User("Lera", "Lokin", "mailmail@gg.com");

      Car car1 = new Car("Lada", 2121);
      Car car2 = new Car("volga", 2410);
      Car car3 = new Car("uaz", 469);
      Car car4 = new Car("gazel", 31);

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      User uscar = userService.getUserByCar("Cleanliness", 7);
      System.out.println(uscar.toString());


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user.toString());
         System.out.println();
      }
         context.close();
      }
   }

