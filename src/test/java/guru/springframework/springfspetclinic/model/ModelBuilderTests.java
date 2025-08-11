package guru.springframework.springfspetclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Lombok Builder on JPA Entities")
class ModelBuilderTests {

    @Nested
    @DisplayName("Owner Builder")
    class OwnerBuilderTests {
        @Test
        @DisplayName("builds owner with fields set and default pets initialized")
        void ownerBuilderBuilds() {
            Owner owner = Owner.builder()
                    .address("123 Main St")
                    .city("Springfield")
                    .telephone("1234567890")
                    .build();

            assertNotNull(owner);
            assertEquals("123 Main St", owner.getAddress());
            assertEquals("Springfield", owner.getCity());
            assertEquals("1234567890", owner.getTelephone());
            assertNotNull(owner.getPets());
            assertTrue(owner.getPets().isEmpty());
        }
    }

    @Nested
    @DisplayName("Pet Builder")
    class PetBuilderTests {
        @Test
        @DisplayName("builds pet with birthDate set and default visits initialized")
        void petBuilderBuilds() {
            LocalDate dob = LocalDate.of(2020, 1, 1);
            Pet pet = Pet.builder()
                    .birthDate(dob)
                    .build();

            assertNotNull(pet);
            assertEquals(dob, pet.getBirthDate());
            assertNotNull(pet.getVisits());
            assertTrue(pet.getVisits().isEmpty());
        }
    }

    @Nested
    @DisplayName("Vet Builder")
    class VetBuilderTests {
        @Test
        @DisplayName("builds vet with default specialties initialized")
        void vetBuilderBuilds() {
            Vet vet = Vet.builder().build();

            assertNotNull(vet);
            assertEquals(0, vet.getNrOfSpecialties());
            assertNotNull(vet.getSpecialties());
            assertTrue(vet.getSpecialties().isEmpty());
        }
    }

    @Nested
    @DisplayName("Visit Builder")
    class VisitBuilderTests {
        @Test
        @DisplayName("builds visit with default date set to today and description set")
        void visitBuilderBuilds() {
            Visit visit = Visit.builder()
                    .description("Checkup")
                    .build();

            assertNotNull(visit);
            assertEquals("Checkup", visit.getDescription());
            assertNotNull(visit.getDate());
            assertEquals(LocalDate.now(), visit.getDate());
        }
    }

    @Nested
    @DisplayName("PetType Builder")
    class PetTypeBuilderTests {
        @Test
        @DisplayName("builds pet type")
        void petTypeBuilderBuilds() {
            PetType petType = PetType.builder().build();
            assertNotNull(petType);
        }
    }

    @Nested
    @DisplayName("Speciality Builder")
    class SpecialityBuilderTests {
        @Test
        @DisplayName("builds speciality")
        void specialityBuilderBuilds() {
            Speciality speciality = Speciality.builder().build();
            assertNotNull(speciality);
        }
    }
}
