package com.simple.project.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Configuration
public class MainConfiguration {
    
    //initialize the app if it has not been yet
    @Bean
    public FirebaseApp firebaseApp() throws IOException{
        if (!FirebaseApp.getApps().isEmpty()) {
            // Already initialized (e.g., tests, reloads)
            return FirebaseApp.getInstance();
        }

        FileInputStream serviceAccount = new FileInputStream("/opt/tomcat/secrets/serviceAccountKey.json");

        FirebaseOptions options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build();

        return FirebaseApp.initializeApp(options);
    }

    //get the firestore instance - initialize the firebaseApp if it has not been yet
    @Bean
    public Firestore firestore() throws IOException{
        if(FirebaseApp.getApps().isEmpty()){
            firebaseApp();
        }

        return FirestoreClient.getFirestore();
    }
}
