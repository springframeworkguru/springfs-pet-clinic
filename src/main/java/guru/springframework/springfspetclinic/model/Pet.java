package guru.springframework.springfspetclinic.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Pet extends NamedEntity {

    @Column(name = "birth_date", columnDefinition = "DATE")
    private LocalDate birthDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    private PetType type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Visit> visits = new ArrayList<>();


    public void addVisit(Visit visit) {
        visits.add(visit);
        visit.setPet(this);
    }
}