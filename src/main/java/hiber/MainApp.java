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
      User user4 = new User("Sergey","Dmitriev", "Sabotage@gmail.com");
      User user1 = new User("Alice","Laevskaya", "alice@mail.ru");
      User user2 = new User("Ilya","Gusarov", "gusarov@yandex.com" );
      User user3 = new User("Nikita","Artamonov","artamonov@mail.ru");
      Car car4 = new Car("IZH",4);
      Car car1 = new Car("Mercedes",6);
      Car car2 = new Car("VAZ",8);
      Car car3 = new Car("Geely",10);
      userService.add(car4);
      userService.add(car1);
      userService.add(car2);
      userService.add(car3);
      List<Car> cars = userService.listCars();
      user4.setCar(cars.get(0));
      user1.setCar(cars.get(1));
      user2.setCar(cars.get(2));
      user3.setCar(cars.get(3));
      userService.add(user4);
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+ user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar());
      }
      System.out.println(userService.userHasCar(cars.get(0)));
      context.close();

   }
}

