package tests;

import model.Car;
import model.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase{
    @BeforeClass
    public void preCondition(){
        if (!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("marushana@yandex.ru").setPassword("Pokrov13041986!"));
        }
    }

    @Test
    public void addNewCarSuccess(){
        int i = new Random().nextInt(1000)+1000;
        Car car = Car.builder()
                .location("Haifa")
                .manufacture("Opel")
                .model("Astra")
                .year("2025")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNum("685-900"+i)
                .price(50)
                .about("Nice car")
                .build();


        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("C:\\Users\\marus\\Qa33\\QA_33_51_IlCarro\\Bugatti_Veyron_16.4_–_Frontansicht_(1),_5._April_2012,_Düsseldorf 2.jpg");
        app.getHelperCar().submitCarForm();

    }
}
