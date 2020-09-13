package pl.Venustus.OnlineFamilyPlanner.Domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Day")
public class DayOfMonth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
