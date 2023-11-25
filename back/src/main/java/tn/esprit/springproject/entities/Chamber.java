package tn.esprit.springproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Chamber {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private long idChambre;
    private long numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;
    @OneToMany
    private List <Reservation> reservationList;
    @ManyToOne
    @JsonIgnore
    private Bloc bloc;
}
