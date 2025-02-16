package com.planmypooja.contactapi.service;

import com.planmypooja.contactapi.domain.Contact;
import com.planmypooja.contactapi.repo.ContactRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import static com.planmypooja.contactapi.constant.Constant.PHOTO_DIRECTORY;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/***
 Author: Ambuj
 Date: 17 Nov. 2024
 */

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepo contactRepo;

    public Page<Contact> getAllContacts(int page, int size){
        return contactRepo.findAll(PageRequest.of(page, size, Sort.by("name")));
//        return contactRepo.findAll(PageRequest.of(page, size));

    }

    public Contact getContact(String id){
        return contactRepo.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
    }

    public Contact createContact(Contact contact){
        return contactRepo.save(contact);
    }

//    public void deleteContact(Contact contact){
//        contactRepo.delete(contact);
//    }
    public void deleteContact(String id){
        Optional<Contact> contact = contactRepo.findById(id);
        if (contact.isPresent()) {
            contactRepo.deleteById(id);  // Perform the deletion
            log.info("Contact with id {} has been deleted.", id);  // Log the deletion action
        } else {
            throw new RuntimeException("Contact not found with ID: " + id);  // Throw exception if contact is not found
        }
    }

    public String uploadPhoto(String id, MultipartFile file){
        log.info("Saving picture for user ID: {}", id);
        Contact contact = getContact(id);
        String photoUrl=photoFunction.apply(id,file);
        contact.setPhotoUrl(photoUrl);
        contactRepo.save(contact);
        return photoUrl;
    }

    private final Function<String, String> fileExtension = filename -> Optional.of(filename).filter(name -> name.contains("."))
            .map(name -> "."+name.substring(filename.lastIndexOf(".")+1)).orElse(".png");

    private final BiFunction<String, MultipartFile, String> photoFunction=(id, image) -> {
        String filename = id + fileExtension.apply(image.getOriginalFilename());
        try{
            Path fileStroageLocation = Paths.get(PHOTO_DIRECTORY).toAbsolutePath().normalize();
            if(!Files.exists(fileStroageLocation)){Files.createDirectories(fileStroageLocation);}
            Files.copy(image.getInputStream(), fileStroageLocation.resolve(filename),REPLACE_EXISTING);
            return ServletUriComponentsBuilder
                    .fromCurrentContextPath().
                    path("/contacts/image/"+id+fileExtension.apply(image.getOriginalFilename())).toUriString();
        }catch(Exception exception){
            throw new RuntimeException("Unable to Save Image");
        }
    };

}
