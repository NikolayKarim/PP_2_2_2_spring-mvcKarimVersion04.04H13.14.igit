package web.objects;

import java.util.ArrayList;
import java.util.List;

public class Car {
        String model;
        int horses;
        int age;

        public Car(String model, int horses, int age) {
            this.model = model;
            this.horses = horses;
            this.age = age;
        }

        @Override
        public String toString() {
            return "This cars model is " + model + " , it car have " + horses + " horses , and age is " + age + " !";
        }
//    List <String> cars = createCars();

        public Car() {
        }

        public static List<String> createCars() {
            List<String> cars = new ArrayList<>();
            cars.add(new web.controller.CarController("BMW", 300, 2018).toString());
            cars.add(new web.controller.CarController("AUDI", 250, 2015).toString());
            cars.add(new web.controller.CarController("Peujo", 90, 2000).toString());
            cars.add(new web.controller.CarController("Wolkswagen", 150, 2016).toString());
            cars.add(new web.controller.CarController("MCLaren", 900, 2023).toString());

            return cars;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getHorses() {
            return horses;
        }

        public void setHorses(int horses) {
            this.horses = horses;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;

    }
}
