package pl.Venustus.OnlineFamilyPlanner.Domain;


import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DayOfMonthDto {
    private Long id;

    private String status;

    private String description;

    private String note;

    private String saved;
}
