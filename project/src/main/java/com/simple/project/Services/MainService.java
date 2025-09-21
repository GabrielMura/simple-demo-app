package com.simple.project.Services;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.simple.project.DAO.MainDAO;

@Service
public class MainService {
    @Autowired
    private Firestore firestore;

    //get the data from the collection, and store it in the MainDAO object
    //Normally, there would be a separate folder for repository things such as this
    //and the service class would be for data manipulation (not CRUD operations) - but with this simple app it will do
    public MainDAO getSimpleData(){
        ApiFuture<DocumentSnapshot> data = firestore.collection("SimpleData").document("DcNbix4CSc993ptLzVDa").get();
        try{
            return data.get().toObject(MainDAO.class);
        }catch (InterruptedException | ExecutionException e){
            throw new RuntimeException(e);
        }
    }
}
