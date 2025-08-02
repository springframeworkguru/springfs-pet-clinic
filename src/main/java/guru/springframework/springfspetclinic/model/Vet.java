package guru.springframework.springfspetclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import guru.springframework.springfspetclinic.util.PropertyComparator;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", 
               joinColumns = @JoinColumn(name = "vet_id"), 
               inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Speciality> specialties = new HashSet<>();

    @JsonIgnore
    protected Set<Speciality> getSpecialtiesInternal() {
        if (this.specialties == null) {
            this.specialties = new HashSet<>();
        }
        return this.specialties;
    }

    @JsonIgnore
    protected void setSpecialtiesInternal(Set<Speciality> specialties) {
        this.specialties = specialties;
    }

    public List<Speciality> getSpecialties() {
        List<Speciality> sortedSpecialties = new ArrayList<>(getSpecialtiesInternal());
        PropertyComparator.sort(sortedSpecialties);
        return Collections.unmodifiableList(sortedSpecialties);
    }

    public void setSpecialties(Set<Speciality> specialties) {
        this.specialties = specialties;
    }

    public void addSpecialty(Speciality specialty) {
        getSpecialtiesInternal().add(specialty);
    }

    public void clearSpecialties() {
        getSpecialtiesInternal().clear();
    }

    public int getNrOfSpecialties() {
        return getSpecialtiesInternal().size();
    }
}