package pl.Venustus.OnlineFamilyPlanner.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.Venustus.OnlineFamilyPlanner.Domain.DayOfMonth;

@Repository
public interface DayOfMonthRepository extends CrudRepository<DayOfMonth, Long> {

    @Override
    DayOfMonth save(DayOfMonth dayOfMonth);

}
