package guru.springframework.springfspetclinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "specialty")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Speciality extends NamedEntity {

}