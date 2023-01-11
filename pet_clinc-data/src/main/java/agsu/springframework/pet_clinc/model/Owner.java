package agsu.springframework.pet_clinc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "owners")
public class Owner extends Person{
    @Column(name = "address")
    private String addres;
    @Column(name = "city")
    private String city;
    @Column(name = "telphone")
    private String telphone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets;
    
    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public Set<Pet> getPets() {
        if (pets != null )
            return pets;
        return new HashSet<>();
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
    
}
