package pl.Venustus.OnlineFamilyPlanner.Domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Day")
public class DayOfMonth {

    @Id
    private Long id;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "SAVED")
    private String saved;

}
