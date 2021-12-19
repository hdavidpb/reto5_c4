package com.hiper.repository.crud;

import com.hiper.model.Accessory;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author desarrolloextremo
 */
public interface SupplementCrudRepository extends MongoRepository<Accessory, String> {
    public List<Accessory> findByPriceLessThanEqual(double precio);
    //Reto 5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Accessory> findByDescriptionLike(String description);
}
