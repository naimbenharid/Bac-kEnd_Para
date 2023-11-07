package Projet.ete.Parapharmcie.service;

import Projet.ete.Parapharmcie.model.Brand;
import Projet.ete.Parapharmcie.model.Product;
import Projet.ete.Parapharmcie.repo.BrandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    private final BrandRepo brandRepository;

    @Autowired
    public BrandService(BrandRepo brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand getBrandById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }

    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand UpdateBrand (Brand brand)
    {return brandRepository.save(brand);}



   /* public Brand updateBrand(Long id, Brand updatedBrand) {
        Brand existingBrand = brandRepository.findById(id).orElse(null);

        if (existingBrand != null) {
            existingBrand.setName(updatedBrand.getName());
            existingBrand.setDescription(updatedBrand.getDescription());


            return brandRepository.save(existingBrand);
        }

        return null;
    }*/


}
