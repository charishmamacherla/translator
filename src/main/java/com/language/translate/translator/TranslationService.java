package com.language.translate.translator;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static javax.xml.ws.Endpoint.publish;

@Service
public class TranslationService {

    private final static String TOPIC = "arn:aws:sns:us-east-1:538814836106:NotifyStudents";

    public void sendText(String text) throws InterruptedException, IOException {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAJOYNI77QTPTQHMLQ", "jIQYqGj8DwUEjTzSMNUpoMzl8GY+SpcylPmLJRNU");
       String bucketName = "cuhack2019vishnu";
       System.out.println("##### "+text);
       // String bucketName = "arn:aws:s3:::ksutextstorage";
        List<String> lines = Arrays.asList(text);
        Path file = Paths.get("newFile.txt");
        Files.write(file, lines, Charset.forName("UTF-8"));

        File file1 = new File(file.getFileName().toString());
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion("us-east-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();

        TransferManager tm = TransferManagerBuilder.standard()
                .withS3Client(s3Client)
                .build();

        List<Bucket> bucket = s3Client.listBuckets();

        for(Bucket b:bucket){

            System.out.println(b.getName());
        }

        //Upload upload = tm.upload(bucketName, "ksutextstorage", file.toFile());
        s3Client.putObject(new PutObjectRequest(bucketName,"testfile.txt", file1));

       // upload.waitForCompletion();

        System.out.println("done");



    }


}
