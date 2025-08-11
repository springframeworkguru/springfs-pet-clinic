package guru.springframework.springfspetclinic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "visits")
@Getter
@Setter
@SuperBuilder
public class Visit extends BaseEntity {

    @Column(name = "visit_date", columnDefinition = "DATE")
    @Builder.Default
    private LocalDate date = LocalDate.now();

    @NotEmpty
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Visit() {
        this.date = LocalDate.now();
    }

}