package com.hiper.repository;

import com.hiper.model.Accessory;
import com.hiper.repository.crud.SupplementCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author desarrolloextremo
 */
@Repository
public class SupplementRepository {

    @Autowired
    private SupplementCrudRepository crudInterface;

    public List<Accessory> listAll() {
        return crudInterface.findAll();
    }

    public Optional<Accessory> getSupplement(String reference) {
        return crudInterface.findById(reference);
    }

    public Accessory create(Accessory clothe) {
        return crudInterface.save(clothe);
    }

    public void update(Accessory clothe) {
        crudInterface.save(clothe);
    }

    public void delete(Accessory clothe) {
        crudInterface.delete(clothe);
    }
    //Reto 5
    public List<Accessory> gadgetsByPrice(double precio) {
        return crudInterface.findByPriceLessThanEqual(precio);
    }
    //Reto 5
    public List<Accessory> findByDescriptionLike(String description) {
        return crudInterface.findByDescriptionLike(description);
    }
}
