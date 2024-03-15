package com.example.demo.service;

import com.example.demo.entity.Kitchen;
import com.example.demo.entity.UploadFile;
import com.example.demo.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    @Value("${file.dir}")
    private String fileDir;


    public void storeFile(MultipartFile multipartFile, Kitchen kitchen) throws IOException {
        if (multipartFile.isEmpty()) {
            return;
        }
        String originalFilename = multipartFile.getOriginalFilename();
        String storeFileName = createStoreFileName(originalFilename);
        multipartFile.transferTo(new File(getFullPath(storeFileName)));
        UploadFile file = UploadFile.builder()
                .uploadFileName(originalFilename)
                .storeFileName(storeFileName)
                .kitchen(kitchen)
                .build();
        fileRepository.save(file);
    }

    public byte[] getFileBytes(String fileName) throws IOException {
        String filePath = getFullPath(fileName);
        File file = new File(filePath);
        return Files.readAllBytes(file.toPath());
    }

    public String getFullPath(String filename) {
        return fileDir + filename;
    }

    public UploadFile findByKitchenId(Long kitchenId) {
        return this.fileRepository.findByKitchenId(kitchenId).orElseThrow();
    }

    private String createStoreFileName(String originalFilename) {
        String ext = extractExt(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    private String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }

}
