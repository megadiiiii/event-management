package com.megadiiiii.eventmanagement.services.impl;

import com.megadiiiii.eventmanagement.services.R2Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class R2ServiceImpl implements R2Service {

    private final S3Client s3Client;

    @Value("${cloudflare.r2.bucket}")
    private String bucket;

    @Value("${cloudflare.r2.accountId}")
    private String accountId;
    @Value("${cloudflare.r2.public-url}")
    private String publicUrl;

    public R2ServiceImpl(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        String key = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        s3Client.putObject(
                PutObjectRequest.builder()
                        .bucket(bucket)
                        .key(key)
                        .contentType(file.getContentType())
                        .build(),
                software.amazon.awssdk.core.sync.RequestBody.fromBytes(file.getBytes())
        );

        return publicUrl + "/" + key;
    }

    @Override
    public List<String> uploadFiles(List<MultipartFile> files) throws IOException {
        List<String> urls = new ArrayList<>();
        for (MultipartFile file : files) {
            urls.add(uploadFile(file));
        }
        return urls;
    }
}
