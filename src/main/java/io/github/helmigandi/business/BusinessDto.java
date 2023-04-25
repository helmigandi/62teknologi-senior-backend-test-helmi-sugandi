package io.github.helmigandi.business;

import io.github.helmigandi.attribute.AttributeDto;

import java.util.List;

public class BusinessDto {

    private Long id;

    private String alias;

    private String name;

    private Coordinate coordinate;

    private Double distance;

    private List<AttributeDto> attributes;


    public static class Coordinate {

        private Double longitude;

        private Double latitude;

        public Coordinate(Double longitude, Double latitude) {
            this.longitude = longitude;
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public List<AttributeDto> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeDto> attributes) {
        this.attributes = attributes;
    }

    public void addAttribute(AttributeDto attributeDto) {
        attributes.add(attributeDto);
    }
}
