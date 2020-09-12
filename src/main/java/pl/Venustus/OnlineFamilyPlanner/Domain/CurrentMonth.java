package pl.Venustus.OnlineFamilyPlanner.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class CurrentMonth {
    private List<DayOfMonth> dayList = new ArrayList();

}
