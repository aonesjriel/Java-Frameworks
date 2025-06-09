package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final InhousePartRepository inhousePartRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(InhousePartRepository inhousePartRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.inhousePartRepository = inhousePartRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */

        if (outsourcedPartRepository.count() == 0) {
            //creating object from outsourced part class
            OutsourcedPart pickup = new OutsourcedPart();

            //setting values
            pickup.setCompanyName("EMGPickups");
            pickup.setName("Pickup");
            pickup.setInv(5);
            pickup.setPrice(266.00);
            pickup.setId(1);

            outsourcedPartRepository.save(pickup);


            OutsourcedPart strings = new OutsourcedPart();
            strings.setCompanyName("ErnieBall");
            strings.setName("Electric Guitar Strings");
            strings.setInv(11);
            strings.setPrice(9.99);
            strings.setId(2);
            outsourcedPartRepository.save(strings);

            OutsourcedPart pick = new OutsourcedPart();
            pick.setCompanyName("Tortex");
            pick.setName("Guitar Pick");
            pick.setInv(35);
            pick.setPrice(0.99);
            pick.setId(3);
            outsourcedPartRepository.save(pick);
        }

        if (inhousePartRepository.count() == 0) {
            InhousePart fretboard = new InhousePart();

            fretboard.setName("Fretboard");
            fretboard.setInv(2);
            fretboard.setPrice(50.00);


            inhousePartRepository.save(fretboard);

            InhousePart customBridge = new InhousePart();
            customBridge.setName("Reverb Custom Bridge");
            customBridge.setInv(7);
            customBridge.setPrice(34.99);
            inhousePartRepository.save(customBridge);
        }

        if (productRepository.count() == 0) {
            Product electricGuitar = new Product("Custom Electric Guitar", 749.99, 5);
            productRepository.save(electricGuitar);
            Product acousticGuitar = new Product("Custom Acoustic Guitar", 549.99, 3);
            productRepository.save(acousticGuitar);
            Product drumKit = new Product("Drum Kit", 699.99, 2);
            productRepository.save(drumKit);
            Product bassGuitar = new Product("Bass Guitar", 487.99, 3);
            productRepository.save(bassGuitar);
            Product microphone = new Product("Microphone", 109.99, 6);
            productRepository.save(microphone);

        }

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+inhousePartRepository.count());
        System.out.println(inhousePartRepository.findAll());

    }
}
