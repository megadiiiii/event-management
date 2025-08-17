package com.megadiiiii.eventmanagement.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface R2Service {
    String uploadFile(MultipartFile file) throws IOException;
    List<String> uploadFiles(List<MultipartFile> files) throws IOException;
}
