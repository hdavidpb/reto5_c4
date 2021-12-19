package com.hiper.controller;

import com.hiper.model.Accessory;
import com.hiper.service.SupplementService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author desarrolloextremo
 */
@RestController
@RequestMapping("/api/accessory")
@CrossOrigin("*")
public class AccessoryController {

    @Autowired
    private SupplementService servicio;

    @GetMapping("/all")
    public List<Accessory> listAll() {
        return servicio.listAll();
    }

    @GetMapping("/{reference}")
    public Optional<Accessory> getSupplement(@PathVariable("reference") String reference) {
        return servicio.getSupplement(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Accessory create(@RequestBody Accessory gadget) {
        return servicio.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Accessory update(@RequestBody Accessory gadget) {
        return servicio.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return servicio.delete(reference);
    }

    @GetMapping("/price/{price}")
    public List<Accessory> gadgetsByPrice(@PathVariable("price") double precio) {
        return servicio.gadgetsByPrice(precio);
    }

    @GetMapping("/description/{description}")
    public List<Accessory> findByDescriptionLike(@PathVariable("description") String description) {
        return servicio.findByDescriptionLike(description);
    }
}
