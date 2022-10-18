package com.example.messagingrabbitmq.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.example.messagingrabbitmq.aws.TestUser;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AwsConfiguration {

    private final TestUser testUser;

    @Bean
    public AmazonSQSAsync amazonSQSAws() {

        final BasicAWSCredentials awsCreds = new BasicAWSCredentials(testUser.getAccessKeyId(), testUser.getSecretAccessKey());

        return AmazonSQSAsyncClientBuilder.standard().withRegion(testUser.getRegion()).withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
    }
}
