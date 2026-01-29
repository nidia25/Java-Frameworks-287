package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
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

        Set <Product> sampleProducts = new HashSet<Product>();
        Set<Part> sampleParts = new HashSet<>();

        //adds sample products
        Product SimpleBundle= new Product(1,"Simple Bundle", 50.00, 10);
        Product MediumBundle= new Product(2, "Medium Bundle", 149.99, 8);
        Product MegaBundle = new Product(3, "Mega Bundle", 325.00, 12);
        Product CustomMedium = new Product(4, "Custom Medium", 200.00, 10);
        Product CustomLarge = new Product(5, "Custom Large", 300.00, 9);

        sampleProducts.add(SimpleBundle);
        sampleProducts.add(MediumBundle);
        sampleProducts.add(MegaBundle);
        sampleProducts.add(CustomMedium);
        sampleProducts.add(CustomLarge);

        System.out.println("Set: + sampleProducts" );

        //sample Parts
        InhousePart tower = new InhousePart();
        tower.setId(1);
        tower.setName("Tower");
        tower.setPrice(45.99);
        tower.setInv(40);
        tower.setMinInv(2);
        tower.setMaxInv(60);

        InhousePart slide = new InhousePart();
        slide.setId(2);
        slide.setName("Slide");
        slide.setPrice(15.99);
        slide.setInv(10);
        slide.setMinInv(3);
        slide.setMaxInv(40);

        InhousePart garden = new InhousePart();
        garden.setId(3);
        garden.setName("Garden");
        garden.setPrice(59.99);
        garden.setInv(20);
        garden.setMinInv(3);
        garden.setMaxInv(60);

        InhousePart picture = new InhousePart();
        picture.setId(4);
        picture.setName("Picture");
        picture.setPrice(69.99);
        picture.setInv(100);
        picture.setMinInv(1);
        picture.setMaxInv(500);

        InhousePart legoMan = new InhousePart();
        legoMan.setId(5);
        legoMan.setName("Lego Man");
        legoMan.setPrice(50.00);
        legoMan.setInv(50);
        legoMan.setMinInv(1);
        legoMan.setMaxInv(100);

        sampleParts.add(tower);
        sampleParts.add(slide);
        sampleParts.add(garden);
        sampleParts.add(picture);
        sampleParts.add(legoMan);


        if(partRepository.count()==0 && productRepository.count()==0){
            for(Product product:sampleProducts){
                productRepository.save(product);
            }
            for(Part part:sampleParts){
                partRepository.save(part);
            }
        }


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
