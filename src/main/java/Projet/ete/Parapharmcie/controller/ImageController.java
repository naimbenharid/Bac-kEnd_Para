package Projet.ete.Parapharmcie.controller;

import Projet.ete.Parapharmcie.model.Image;
import Projet.ete.Parapharmcie.model.Product;
import Projet.ete.Parapharmcie.service.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {



    @Autowired
    ImageServiceImpl imageService ;

    @RequestMapping(value = "/upload" , method = RequestMethod.POST)
    public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }
    @RequestMapping(value = "/get/{id}" , method = RequestMethod.GET)
    public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
        return imageService.getImageDetails(id) ;
    }
    @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException
    {
        return imageService.getImage(id);
    }


    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
    public void deleteImage(@PathVariable("id") Long id){
        imageService.deleteImage(id);
    }
    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Image>> getAllProducts() {
        List<Image> images = imageService.getAllImages();
        return new ResponseEntity<>(images, HttpStatus.OK);
    }
}





















    /*
    {
     private final ImageServiceImpl imageServiceImpl;

    @Autowired
    public ImageController(ImageServiceImpl imageServiceImpl) {
        this.imageServiceImpl = imageServiceImpl;
    }

    @PostMapping("/addImage")
    public ResponseEntity<Image> createImage(@RequestBody Image image) {
        Image savedImage = imageServiceImpl.saveImage(image);
        return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
    }

    @GetMapping("/getAllImages")
    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> images = imageServiceImpl.getAllImages();
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping("/getImage/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable Long id) {
        Image image = imageServiceImpl.getImageById(id);
        if (image != null) {
            return new ResponseEntity<>(image, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getImagesByProduct/{productId}")
    public ResponseEntity<List<Image>> getImagesByProduct(@PathVariable Long productId) {
        Product product = new Product();
        product.setId(productId);
        List<Image> images = imageServiceImpl.getImagesByProduct(product);
        return new ResponseEntity<>(images, HttpStatus.OK);
    }
    @PutMapping("/UpdateImage/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable Long id, @RequestBody Image updatedImage) {
        Image updated = imageServiceImpl.updateImage(id, updatedImage);

        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteImage/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageServiceImpl.deleteImage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


     */
