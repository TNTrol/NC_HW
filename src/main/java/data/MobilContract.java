package data;

import lombok.Data;

@Data
public class MobilContract extends AbstractContract{
    private Integer countMinutes;
    private Double traffic;
    private Integer countSMS;

    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append("MobilContract(id=" + getId() + ", dataEnd=" + getDateEnd() + ", number=" + getNumber() + ", owner=" + getOwner());
        str.append(", countMinutes=" + countMinutes + ", traffic=" + traffic + ", countSMS=" + countSMS + ")");
        return str.toString();
    }
}
