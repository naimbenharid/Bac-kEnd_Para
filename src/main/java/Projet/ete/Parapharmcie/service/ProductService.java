package Projet.ete.Parapharmcie.service;

import Projet.ete.Parapharmcie.model.Category;
import Projet.ete.Parapharmcie.model.Product;
import Projet.ete.Parapharmcie.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo ;
    @Autowired
     public ProductService(ProductRepo productRepo){
        this.productRepo=productRepo ;
    }
    public Product createProduct(Product product) {
    return productRepo.save(product);
    }


    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }
    public List<Product>  getProductByCategory(Category cat) {
        return productRepo.findByCategory(cat);
    }
    public List<Product>  getProductByPrice(double price) {
        return productRepo.findByPrice(price);
    }
    public List<Product>  getProductByQte(Integer qte) {
        return productRepo.findByQte(qte);
    }

    public void updateProduct(Long id, Product updatedProduct) {
        Product product = getProductById(id);
        if (product != null) {
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setQte(updatedProduct.getQte());
            productRepo.save(product);
        }
    }
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }


}
