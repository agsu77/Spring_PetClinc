package agsu.springframework.pet_clinc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person{
    @Builder
    public Owner(Long id, String firstName, String lastName, String addres, String city, String telphone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.addres = addres;
        this.city = city;
        this.telphone = telphone;
        this.pets = pets;
    }

    @Column(name = "address")
    private String addres;
    @Column(name = "city")
    private String city;
    @Column(name = "telphone")
    private String telphone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();
    
}
