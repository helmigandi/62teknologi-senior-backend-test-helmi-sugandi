package io.github.helmigandi.business;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/business")
public class BusinessController {

    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<BusinessDto> getBusiness(@RequestParam Double longitude,
                                         @RequestParam Double latitude) {
        return businessService.findNearestBusiness(longitude, latitude);
    }
}
