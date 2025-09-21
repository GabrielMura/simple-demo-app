package com.simple.project.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class MainConfiguration {
    
    @Bean
    public FirebaseApp firebaseApp() throws IOException{
        if (!FirebaseApp.getApps().isEmpty()) {
            // Already initialized (e.g., tests, reloads)
            return FirebaseApp.getInstance();
        }

        FileInputStream serviceAccount = new FileInputStream("/opt/tomcat/serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build();

        return FirebaseApp.initializeApp(options);
    }
}
