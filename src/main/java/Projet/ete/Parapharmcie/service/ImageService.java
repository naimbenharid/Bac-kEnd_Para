package Projet.ete.Parapharmcie.service;

import Projet.ete.Parapharmcie.model.Image;
import Projet.ete.Parapharmcie.model.Product;
import Projet.ete.Parapharmcie.repo.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    private final ImageRepo imageRepository ;

    @Autowired
    public ImageService(ImageRepo imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }
    public Image updateImage(Long id, Image updatedImage) {
        Image existingImage = imageRepository.findById(id).orElse(null);

        if (existingImage != null) {
            existingImage.setUrl(updatedImage.getUrl());


            return imageRepository.save(existingImage);
        }

        return null;
    }

    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public List<Image> getImagesByProduct(Product product) {
        return imageRepository.findByProduct(product);
    }

    public Image getImageById(Long id) {
        return imageRepository.findImageById(id);
    }
}
