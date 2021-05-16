package com.ossapp.mainapp.controllers;

import com.ossapp.mainapp.dto.RequestCityDto;
import com.ossapp.mainapp.dto.RequestStyleDto;
import com.ossapp.mainapp.entities.City;
import com.ossapp.mainapp.entities.Style;
import com.ossapp.mainapp.service.CityService;
import com.ossapp.mainapp.service.StyleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sites")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<RequestCityDto> post(@RequestBody @Valid RequestCityDto requestCityDto) {
        cityService.save(requestCityDto);
        return new ResponseEntity<>(requestCityDto, HttpStatus.OK);
    }

    @GetMapping()
    public List<City> getAll() {
        return cityService.findAll();
    }

    @GetMapping("/{id}")
    public City getById(@PathVariable("id") Long id) {
        return cityService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable("id") long id) {
        return cityService.deleteById(id);
    }

    @PutMapping("/{id}")
    public RequestCityDto update(@RequestBody  @Valid RequestCityDto requestCityDto, @PathVariable("id") long id) {
        cityService.update(requestCityDto, id);
        return requestCityDto;
    }
}