package com.planmypooja.contactapi.resource;

import com.planmypooja.contactapi.domain.Contact;
import com.planmypooja.contactapi.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.planmypooja.contactapi.constant.Constant.PHOTO_DIRECTORY;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

/***
 Author: Ambuj
 Date: 17 Nov. 2024
 */

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactResource {
    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        return ResponseEntity.created(URI.create("/contacts/userID")).body(contactService.createContact(contact));
    }

    @GetMapping
    public ResponseEntity<Page<Contact>> getContacts(@RequestParam(value="page", defaultValue="0")int page,
                                                     @RequestParam(value="size", defaultValue="10")int size) {
        return ResponseEntity.ok().body(contactService.getAllContacts(page,size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContacts(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok().body(contactService.getContact(id));
    }

//    Delete trial
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable(value = "id") String id) {

        try {
            contactService.deleteContact(id);  // Call the service layer to delete the contact
            return ResponseEntity.noContent().build();  // Return 204 No Content if successful
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();  // Return 404 Not Found if the contact does not exist
        }
    }

    @PutMapping("/photo")
    public ResponseEntity<String> updatePhoto(@RequestParam("id") String id, @RequestParam("file") MultipartFile file){
        return ResponseEntity.ok().body(contactService.uploadPhoto(id, file));
    }

    @GetMapping(path = "/image/{filename}", produces= IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable(value = "filename") String filename) throws IOException {
        return Files.readAllBytes(Paths.get(PHOTO_DIRECTORY +"\\"+ filename));
    }


}
