package Projet.ete.Parapharmcie.service;

import Projet.ete.Parapharmcie.model.Brand;
import Projet.ete.Parapharmcie.model.Category;
import Projet.ete.Parapharmcie.model.Product;
import Projet.ete.Parapharmcie.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepo categoryRepository;

    @Autowired
    public CategoryService(CategoryRepo categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }


    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<Product> getProductsByCategory(Category category) {
        return category.getProducts();
    }
    public Category UpdateCategory (Category category)
    {return categoryRepository.save(category);}

}
