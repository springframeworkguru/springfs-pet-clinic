package guru.springframework.springfspetclinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet_types")
public class PetType extends NamedEntity {

}