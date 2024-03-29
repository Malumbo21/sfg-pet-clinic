package com.osyrs.sfgpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "owners")
public class Owner extends Person {
    @Column(name = "address")
    private String address;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "city")
    private String city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String telephone, String city, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.telephone = telephone;
        this.city = city;
        if (pets != null)
            this.pets = pets;
    }

    public Pet getPet(String name) {
        return getPet(name, false);
    }

    public Pet getPet(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Pet pet : pets) {
            if (!ignoreNew || !pet.isNew()) {
                String compName = pet.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return pet;
                }
            }
        }
        return null;
    }

}
