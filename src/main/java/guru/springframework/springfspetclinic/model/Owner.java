package guru.springframework.springfspetclinic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Owner extends Person {

    @Column(name = "address")
    @NotEmpty
    private String address;

    @Column(name = "city")
    @NotEmpty
    private String city;

    @Column(name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Pet> pets = new HashSet<>();


    public void addPet(Pet pet) {
        if (pets == null) {
            pets = new HashSet<>();
        }
        pets.add(pet);
        pet.setOwner(this);
    }

    public Pet getPet(String name) {
        return pets.stream()
                .filter(pet -> pet.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public Pet getPet(Integer id) {
        return pets.stream()
                .filter(pet -> pet.getId() != null && pet.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}