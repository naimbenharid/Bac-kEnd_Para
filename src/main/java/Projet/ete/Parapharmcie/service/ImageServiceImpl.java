package Projet.ete.Parapharmcie.service;

import Projet.ete.Parapharmcie.model.Image;
import Projet.ete.Parapharmcie.model.Product;
import Projet.ete.Parapharmcie.repo.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepo imageRepo;

    @Override
    public Image uplaodImage(MultipartFile file) throws IOException
    {
        return imageRepo.save(Image.builder() // au lieu de utulisé constrcuteur
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes())
                 .build()
        );
    }

    @Override
    public Image getImageDetails(Long id) throws IOException{
        final Optional<Image> dbImage = imageRepo. findById (id);
        return Image.builder()
                .id(dbImage.get().getId())
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(dbImage.get().getImage()).build() ;
    }
    @Override
    public ResponseEntity<byte[]> getImage(Long id) throws IOException{
        final Optional<Image> dbImage = imageRepo. findById (id);
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(dbImage.get().getImage());
    }
    @Override
    public void deleteImage(Long id) {
        imageRepo.deleteById(id);
    }
    public List<Image> getAllImages() {
        return imageRepo.findAll();
    }

}
