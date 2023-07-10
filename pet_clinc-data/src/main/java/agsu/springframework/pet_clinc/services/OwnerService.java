package agsu.springframework.pet_clinc.services;

import java.util.List;

import agsu.springframework.pet_clinc.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
