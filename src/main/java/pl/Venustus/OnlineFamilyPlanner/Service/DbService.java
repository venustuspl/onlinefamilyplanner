package pl.Venustus.OnlineFamilyPlanner.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.Venustus.OnlineFamilyPlanner.Domain.DayOfMonth;
import pl.Venustus.OnlineFamilyPlanner.Repository.DayOfMonthRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DbService {
    @Autowired
    DayOfMonthRepository dayOfMonthRepository;

    public List<DayOfMonth> getAllDayOfMonth() {
        return dayOfMonthRepository.findAll();
    }

    public Optional<DayOfMonth> getDayOfMonthByEach(Long id) {
        return dayOfMonthRepository.findAllById(id);
    }

    public List<DayOfMonth> saveDayOfMonthList(List<DayOfMonth> dayOfMonthList) {
        return dayOfMonthList.stream()
                .map(d -> dayOfMonthRepository.save(d))
                .collect(Collectors.toList());

    }

    public DayOfMonth saveDayOfMonth(DayOfMonth dayOfMonth) {
        return dayOfMonthRepository.save(dayOfMonth);

    }

    public void deletaAllDayOfMonth() {
        dayOfMonthRepository.deleteAll();

    }
}
