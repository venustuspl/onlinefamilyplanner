package pl.Venustus.OnlineFamilyPlanner.Mapper;

import org.springframework.stereotype.Component;
import pl.Venustus.OnlineFamilyPlanner.Domain.DayOfMonth;
import pl.Venustus.OnlineFamilyPlanner.Domain.DayOfMonthDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DayOfMonthMapper {

    public List<DayOfMonth> mapToDaYMonthList(final List<DayOfMonthDto> dayOfMonthDtoList) {
        return dayOfMonthDtoList.stream()
                .map(d -> new DayOfMonth(d.getId(), d.getStatus(), d.getDescription(), d.getNote()))
                .collect(Collectors.toList());
    }
}
