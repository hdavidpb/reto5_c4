package com.hiper.service;

import com.hiper.model.Accessory;
import com.hiper.repository.SupplementRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author desarrolloextremo
 */
@Service
public class SupplementService {

    @Autowired
    private SupplementRepository repositorio;

    public List<Accessory> listAll() {
        return repositorio.listAll();
    }

    public Optional<Accessory> getSupplement(String reference) {
        return repositorio.getSupplement(reference);
    }

    public Accessory create(Accessory supplement) {
        if (supplement.getReference() == null) {
            return supplement;
        } else {
            return repositorio.create(supplement);
        }
    }

    public Accessory update(Accessory supplement) {

        if (supplement.getReference() != null) {
            Optional<Accessory> supplementDb = repositorio.getSupplement(supplement.getReference());
            if (!supplementDb.isEmpty()) {
                if (supplement.getBrand() != null) {
                    supplementDb.get().setBrand(supplement.getBrand());
                }
                if (supplement.getCategory() != null) {
                    supplementDb.get().setCategory(supplement.getCategory());
                }

                if (supplement.getDescription() != null) {
                    supplementDb.get().setDescription(supplement.getDescription());
                }
                if (supplement.getPrice() != 0.0) {
                    supplementDb.get().setPrice(supplement.getPrice());
                }
                if (supplement.getQuantity() != 0) {
                    supplementDb.get().setQuantity(supplement.getQuantity());
                }
                if (supplement.getPhotography() != null) {
                    supplementDb.get().setPhotography(supplement.getPhotography());
                }
                supplementDb.get().setAvailability(supplement.isAvailability());
                repositorio.update(supplementDb.get());
                return supplementDb.get();
            } else {
                return supplement;
            }
        } else {
            return supplement;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getSupplement(reference).map(supplement -> {
            repositorio.delete(supplement);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    //Reto 5
    public List<Accessory> gadgetsByPrice(double price) {
        return repositorio.gadgetsByPrice(price);
    }

    //Reto 5
    public List<Accessory> findByDescriptionLike(String description) {
        return repositorio.findByDescriptionLike(description);
    }
}
