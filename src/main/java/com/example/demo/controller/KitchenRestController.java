package com.example.demo.controller;

import com.example.demo.dto.response.KitchenResponse;
import com.example.demo.entity.Kitchen;
import com.example.demo.entity.UploadFile;
import com.example.demo.service.FileService;
import com.example.demo.service.KitchenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
@RestController
public class KitchenRestController {

    private final KitchenService kitchenService;
    private final FileService fileService;


    @GetMapping("/kitchens")
    public List<KitchenResponse> getKitchens() {
        return kitchenService.getKitchens();
    }

    @GetMapping("/kitchens/{id}")
    public KitchenResponse getKitchenById(@PathVariable(name = "id") Long kitchenId) {
        return kitchenService.getKitchenById(kitchenId);
    }

    @PostMapping("/kitchens")
    public KitchenResponse saveKitchen(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("confirm_password") String confirm_password,
            @RequestParam("workingDays") String workingDays,
            @RequestParam("start_time") String startTime,
            @RequestParam("end_time") String endTime,
            @RequestPart("file") MultipartFile file
    ) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        Kitchen kitchen = Kitchen
                .builder()
                .name(name)
                .email(email)
                .password(password)
                .confirm_password(confirm_password)
                .workingDays(this.convert(workingDays))
                .startTime(LocalTime.parse(startTime, formatter))
                .endTime(LocalTime.parse(endTime, formatter))
                .build();
        fileService.storeFile(file, kitchen);
        return kitchenService.saveKitchen(kitchen);
    }

    @GetMapping("/kitchens/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        UploadFile uploadFile = fileService.findByKitchenId(id);
        try {
            byte[] fileBytes = fileService.getFileBytes(uploadFile.getStoreFileName());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private List<DayOfWeek> convert(String source) {
        source = source.replaceAll("\\[|\\]", "");

        String[] dayStrings = source.split(",");
        List<DayOfWeek> dayOfWeeks = new ArrayList<>();

        for (String dayString : dayStrings) {
            String trimmedDayString = dayString
                    .trim()
                    .replaceAll("^\"|\"$", "")
                    .toUpperCase();

            try {
                DayOfWeek dayOfWeek = DayOfWeek.valueOf(trimmedDayString);
                dayOfWeeks.add(dayOfWeek);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid DayOfWeek value: " + trimmedDayString);
            }
        }

        return dayOfWeeks;
    }

}
