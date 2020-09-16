package pl.Venustus.OnlineFamilyPlanner.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.Venustus.OnlineFamilyPlanner.Domain.DayOfMonth;
import pl.Venustus.OnlineFamilyPlanner.Repository.DayOfMonthRepository;

import java.util.List;
import java.util.Optional;


@Service
public class DbService {
    @Autowired
    DayOfMonthRepository dayOfMonthRepository;

    public DayOfMonth saveDayOfMonth(final DayOfMonth DayOfMonth) {
        return dayOfMonthRepository.save(DayOfMonth);
    }

    public List<DayOfMonth> getAllDayOfMonth() {
        return dayOfMonthRepository.findAll();
    }

    public Optional<DayOfMonth> getDayOfMonthByEach(Long id) {
        return dayOfMonthRepository.findAllById(id);
    }


}
