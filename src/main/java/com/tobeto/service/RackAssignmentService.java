    package com.tobeto.service;

    import com.tobeto.entity.Product;
    import com.tobeto.entity.Rack;
    import com.tobeto.exception.NoSpaceAvailableException;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.stream.Collectors;

    @Service
    public class RackAssignmentService {

        @Autowired
        private ProductService productService;

        @Autowired
        private RackService rackService;/*

        public void assignProductsToRacks() {
            List<Product> products = productService.getAllProducts();
            List<Rack> racks = rackService.getAllRacks();

            for (Product product : products) {
                List<Rack> suitableRacks = findSuitableRacksForProduct(product, racks);
                for (Rack rack : suitableRacks) {
                    assignProductToRack(product, rack);
                }
            }
        }

        private List<Rack> findSuitableRacksForProduct(Product product, List<Rack> racks) throws NoSpaceAvailableException {
            // Filter racks by availability and category matching
            List<Rack> suitableRacks = racks.stream()
                    .filter(rack -> rack.getProducts().isEmpty() || rack.getProducts().stream()
                            .anyMatch(p -> p.getCategory().equals(product.getCategory())))
                    .collect(Collectors.toList());

            // If there are no suitable racks with the same category, prioritize empty racks
            if (suitableRacks.isEmpty()) {
                suitableRacks = racks.stream()
                        .filter(rack -> rack.getProducts().isEmpty())
                        .collect(Collectors.toList());
            }

            // If there are still no suitable racks, throw NoSpaceAvailableException
            if (suitableRacks.isEmpty()) {
                throw new NoSpaceAvailableException("No empty racks available.");
            }

            return suitableRacks;
        }
*/
       /*
        private void assignProductToRack(Product product, Rack rack) {
            // Update the product's rack association
            product.getRacks().add(rack); // Assuming getRacks() returns the list of racks in the Product class
            productService.saveProduct(product);

            // Update the rack's capacity
         rack.setRackCapacity(rack.getRackCapacity() - 1);
           rackService.saveRack(rack);
       }
*/
    }
