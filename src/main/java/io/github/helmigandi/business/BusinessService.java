package io.github.helmigandi.business;

import io.github.helmigandi.attribute.AttributeDto;
import jakarta.persistence.Tuple;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BusinessService {

    private final BusinessRepository businessRepository;

    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public List<BusinessDto> findNearestBusiness(Double longitude, Double latitude) {
        List<BusinessDto> businessDtos = new ArrayList<>();

        List<Tuple> businessTuples = businessRepository.findNearestBusinessByLatLong(longitude, latitude);

        for (Tuple businessTuple : businessTuples) {
            if (!businessDtos.isEmpty() && businessDtos.get(businessDtos.size() - 1).getId().equals(businessTuple.get("id"))) {
                AttributeDto attributeDto =
                        new AttributeDto((String) businessTuple.get("attribute_alias"), (String) businessTuple.get("attribute_name"));
                businessDtos.get(businessDtos.size() - 1).addAttribute(attributeDto);
            } else {
                businessDtos.add(toBusinessDto(businessTuple));
            }
        }
        return businessDtos;
    }

    private BusinessDto toBusinessDto(Tuple businessTuple) {
        BusinessDto businessDto = new BusinessDto();
        try {
            businessDto.setId((Long) businessTuple.get("id"));
            businessDto.setAlias((String) businessTuple.get("alias"));
            businessDto.setName((String) businessTuple.get("name"));
            Geometry geometry = new WKTReader().read((String) businessTuple.get("location"));
            Point point = (Point) geometry;
            businessDto.setCoordinate(new BusinessDto.Coordinate(point.getX(), point.getY()));
            businessDto.setDistance((Double) businessTuple.get("distance"));
            AttributeDto attributeDto =
                    new AttributeDto((String) businessTuple.get("attribute_alias"), (String) businessTuple.get("attribute_name"));
            businessDto.setAttributes(new ArrayList<>(Collections.singleton(attributeDto)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return businessDto;
    }
}
