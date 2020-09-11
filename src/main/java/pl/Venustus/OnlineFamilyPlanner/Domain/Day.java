package pl.Venustus.OnlineFamilyPlanner.Domain;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Day {
    private Integer id;
    private Integer dayNumber;
    private String shortDesc;
    private String note;


}
