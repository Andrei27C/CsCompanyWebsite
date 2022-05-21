package cscompany.org.website.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppointmentForEmployee {
    private String userName;
    private Date date;
}
