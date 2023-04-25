package io.github.helmigandi.business;

import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRepository extends CrudRepository<Business, Long> {

    @Query(value = """
            select b.id as id, b.alias as alias, b.name as name,
                st_astext(b.location) as location,
                st_distance(b.location, st_point(:longitude, :latitude)) as distance,
                a.alias as attribute_alias,
                a."name" as attribute_name
            from business b
            join business_attribute ba on ba.business_id = b.id
            join attribute a on a.id = ba.attribute_id
            order by b.location <-> st_point(:longitude, :latitude)
            """, nativeQuery = true)
    List<Tuple> findNearestBusinessByLatLong(Double longitude, Double latitude);
}
