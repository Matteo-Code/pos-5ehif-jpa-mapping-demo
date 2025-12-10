package dev.mozgan.session1.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor

@Inheritance(strategy = InheritanceType.JOINED)

@Entity
@Table(name = "person_roles")
public class PersonRole {

    @EmbeddedId
    private PersonRoleId personRoleId;

    @Version
    private Integer version;

    @OneToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "FK_personrole_2_person"))
    private Person person;

    @Embeddable
    public record PersonRoleId(@NotNull @GeneratedValue Long id) {}

}
