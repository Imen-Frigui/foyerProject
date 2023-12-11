package tn.esprit.springproject.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    int rateNumber;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
