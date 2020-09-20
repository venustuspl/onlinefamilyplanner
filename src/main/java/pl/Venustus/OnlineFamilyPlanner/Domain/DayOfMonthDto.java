package pl.Venustus.OnlineFamilyPlanner.Domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DayOfMonthDto {
    private Long id;

    private String status;

    private String description;

    private String note;


}
