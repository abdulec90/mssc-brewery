package guru.springframework.msscbrewery.web.mappers;

import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.domain.Beer.BeerBuilder;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2.BeerDtoV2Builder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-30T19:10:17+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Override
    public BeerDtoV2 beerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDtoV2Builder beerDtoV2 = BeerDtoV2.builder();

        beerDtoV2.id( beer.getId() );
        beerDtoV2.beerName( beer.getBeerName() );
        beerDtoV2.beerStyle( beer.getBeerStyle() );
        beerDtoV2.upc( beer.getUpc() );

        return beerDtoV2.build();
    }

    @Override
    public Beer beerDtoToBeer(BeerDtoV2 beer) {
        if ( beer == null ) {
            return null;
        }

        BeerBuilder beer1 = Beer.builder();

        beer1.id( beer.getId() );
        beer1.beerName( beer.getBeerName() );
        beer1.beerStyle( beer.getBeerStyle() );
        beer1.upc( beer.getUpc() );

        return beer1.build();
    }
}
