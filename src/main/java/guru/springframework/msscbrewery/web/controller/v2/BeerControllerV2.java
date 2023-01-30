package guru.springframework.msscbrewery.web.controller.v2;

import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.val;

import java.util.UUID;

/**
 * Created by jt on 2019-04-23.
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 beerServiceV2;

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping // POST - create new beer
    public ResponseEntity handlePost(@Valid @RequestBody BeerDtoV2 beerDto){

        log.debug("handle post ....");
        val savedDto = beerServiceV2.saveNewBeer(beerDto);

        val headers = new HttpHeaders();
        //todo add hostname to url
        headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto){

        beerServiceV2.updateBeer(beerId, beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteById(beerId);
    }

}
