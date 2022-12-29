package agsu.springframework.pet_clinc.model;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person{
    private String addres;
    private String city;
    private String telphone;
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
