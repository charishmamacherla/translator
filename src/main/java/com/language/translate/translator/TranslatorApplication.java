package com.language.translate.translator;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.translate.AmazonTranslateClient;
import com.amazonaws.services.translate.AmazonTranslateClientBuilder;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.amazonaws.services.translate.AmazonTranslate;

import static com.amazonaws.auth.profile.internal.ProfileKeyConstants.REGION;

@SpringBootApplication
public class TranslatorApplication {



	public static void main(String[] args) {

        SpringApplication.run(TranslatorApplication.class, args);



	}




}

