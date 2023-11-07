package Projet.ete.Parapharmcie.controller;

import Projet.ete.Parapharmcie.model.Category;
import Projet.ete.Parapharmcie.model.Product;
import Projet.ete.Parapharmcie.repo.ProductRepo;
import Projet.ete.Parapharmcie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins="http//localhost:4200")
public class ProductController {
 private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/getProductByCategory/{cat}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable Category cat) {
        List<Product> products = productService.getProductByCategory(cat);
        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/getProductByPrice/{price}")
    public ResponseEntity<List<Product>> getProductByPrice(@PathVariable double price) {
        List<Product> products = productService.getProductByPrice(price);
        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/getProductByQte/{qte}")
    public ResponseEntity<List<Product>> getProductByQte(@PathVariable Integer qte) {
        List<Product> products = productService.getProductByQte(qte);
        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    @ResponseBody
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        productService.updateProduct(id, updatedProduct);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
