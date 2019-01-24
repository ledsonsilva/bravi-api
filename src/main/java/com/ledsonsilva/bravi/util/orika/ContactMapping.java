package com.ledsonsilva.bravi.util.orika;

import com.ledsonsilva.bravi.domain.entity.Contact;
import com.ledsonsilva.bravi.dto.ContactDto;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.stereotype.Component;

@Component
public class ContactMapping implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory orikaMapperFactory) {

        orikaMapperFactory.classMap(Contact.class, ContactDto.class)
                .field("person.id", "personId")
                .field("type", "typeContact")
                .byDefault()
                .register();
    }

}
