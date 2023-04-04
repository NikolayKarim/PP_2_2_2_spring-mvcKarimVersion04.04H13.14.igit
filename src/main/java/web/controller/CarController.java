package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    String model;
    int horses;
    int age;

    public CarController(String model, int horses, int age) {
        this.model = model;
        this.horses = horses;
        this.age = age;
    }

    @Override
    public String toString() {
        return "This cars model is " + model + " , it car have " + horses + " horses , and age is " + age + " !";
    }
//    List <String> cars = createCars();

    public CarController() {
    }

    @GetMapping("/")
    public String presentSite() {
        return "PresentSite";
    }



    @GetMapping(value = "/allCars")
    public String getAllCars(Model modelMap) {
        modelMap.addAttribute("cars", createCars());
        return "getAllCars";
    }


    @GetMapping("/askNumCars")
    public String askNumCars() {
        return "askNumCars";
    }


    @GetMapping(value = "/giveAnyCars")
    public String getAnyCars(@RequestParam("num") String request, Model model) {
        List<String> cars = new ArrayList<>();
        List<String> carsFrom = createCars();
        int num = Integer.parseInt(request);
        if (num <= carsFrom.size()) {
        for (int a = 0; a < num; a++) {
            cars.add(carsFrom.get(a).toString());
        }
        model.addAttribute("giveAniCars", cars);
        return "giveAnyCars";
        } else {
           return "getAllCars";
        }
    }

    @GetMapping("/addSomeCar")
    public String addSomeCar(Model model) {
        model.addAttribute("someCar", new CarController());
        return "addSomeCar";
    }
    @RequestMapping("/showCreatedCar")
    public String addSomeCar(@ModelAttribute("someCar") CarController car, Model model) {
        model.addAttribute("car", car);


        return "showCreatedCar";
    }


    public static List<String> createCars() {
        List<String> cars = new ArrayList<>();
        cars.add(new CarController("BMW", 300, 2018).toString());
        cars.add(new CarController("AUDI", 250, 2015).toString());
        cars.add(new CarController("Peujo", 90, 2000).toString());
        cars.add(new CarController("Wolkswagen", 150, 2016).toString());
        cars.add(new CarController("MCLaren", 900, 2023).toString());

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



