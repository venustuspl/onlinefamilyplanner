package pl.Venustus.OnlineFamilyPlanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class OnlineFamilyPlannerApplication {
	@SuppressWarnings("unchecked")
	public static void initApp() {

	}

	public static void main(String[] args) {
		//DayOfMonth day = new DayOfMonth(1,1,"desc","opis");
		//System.out.println(day.getDayNumber());
		SpringApplication.run(OnlineFamilyPlannerApplication.class, args);
	}

}
