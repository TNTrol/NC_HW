package data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Human {
    private Integer id;
    private String FIO;
    private Date date;
    private boolean gender;
    private Integer passport;

    public Integer getAge()
    {
        Date date = new Date();
        return date.getYear() - this.date.getYear();
    }
}
