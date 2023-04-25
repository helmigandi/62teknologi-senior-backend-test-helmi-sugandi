package io.github.helmigandi.business;

import io.github.helmigandi.attribute.Attribute;
import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "business")
public class Business {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "business_id_gen")
    @SequenceGenerator(name = "business_id_gen", sequenceName = "business_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "alias", nullable = false, unique = true, length = 128)
    private String alias;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "location", nullable = false, columnDefinition = "geography")
    private Point location;

    @Column(name = "rating", nullable = false)
    private Float rating;

    @Column(name = "price", nullable = false, length = 10)
    private String price;

    @Column(name = "phone", nullable = false, length = 32)
    private String phone;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    @Column(name = "review_count", nullable = false)
    private Integer reviewCount;

    @Column(name = "url")
    private String url;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "transactions", nullable = false, length = 128)
    private String transactions;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "business_attribute",
            joinColumns = @JoinColumn(name = "business_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id")
    )
    private List<Attribute> attributes = new ArrayList<>();

    public Business() {
    }

    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
        attribute.getBusinesses().add(this);
    }

    public void removeAttribute(Attribute attribute) {
        attributes.remove(attribute);
        attribute.getBusinesses().remove(this);
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

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTransactions() {
        return transactions;
    }

    public void setTransactions(String transactions) {
        this.transactions = transactions;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
