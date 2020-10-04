package pl.Venustus.OnlineFamilyPlanner.Mapper;

import org.springframework.stereotype.Component;
import pl.Venustus.OnlineFamilyPlanner.Domain.DayOfMonth;
import pl.Venustus.OnlineFamilyPlanner.Domain.DayOfMonthDto;

@Component
public class DayOfMonthMapper {
    public DayOfMonth mapToDaYMonth(final DayOfMonthDto d) {
        return new DayOfMonth(d.getId(), d.getStatus(), d.getDescription(), d.getNote(), d.getSaved());
    }

    public DayOfMonth mapToDaYMonthList(final DayOfMonthDto d) {
        return new DayOfMonth(d.getId(), d.getStatus(), d.getDescription(), d.getNote(), d.getSaved());
    }

}
