package com.project.sejmet.controllers;

import com.project.sejmet.entities.Image;
import com.project.sejmet.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    ImageRepository imageRepository;


    @GetMapping
    public List<Image> getImageAll() {
        return imageRepository.findAll();
    }


    @GetMapping("/{id}")
    public Image getImagebyId(@PathVariable int id) {

        Optional<Image> image = imageRepository.findById(id);

        if (image.isPresent()) {
            return image.get();
        }

        return null;
    }


    @PostMapping
    public Image postImage(@RequestBody Image image) {
        imageRepository.save(image);
        return image;
    }


    @PutMapping("/{id}")
    public Image putImagebyId(@PathVariable int id, @RequestBody Image image) {

        Optional<Image> imageCurrent = imageRepository.findById(id);

        if (imageCurrent.isPresent()) {
            Image imageReturn = imageCurrent.get();

            imageReturn.setProduct(image.getProduct());
            imageReturn.setImageName(image.getImageName());
            imageReturn.setImageSrc(image.getImageSrc());

            imageRepository.save(imageReturn);
            return imageReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Image deleteImagebyId(@PathVariable int id) {

        Optional<Image> image = imageRepository.findById(id);

        if (image.isPresent()) {
            Image imageReturn = image.get();
            imageRepository.deleteById(id);
            return imageReturn;
        }

        return null;
    }
}
