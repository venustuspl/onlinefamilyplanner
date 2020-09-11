package pl.Venustus.OnlineFamilyPlanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.Venustus.OnlineFamilyPlanner.Domain.Day;

@SpringBootApplication
public class OnlineFamilyPlannerApplication {

	public static void main(String[] args) {
//		Day day = new Day(1,1,"desc","opis");
//		System.out.println(day.getDayNumber());
		SpringApplication.run(OnlineFamilyPlannerApplication.class, args);
	}

}
