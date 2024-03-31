package com.c174.services.implementation;

import com.c174.dto.TicketDTO;
import com.c174.firebase.FirebaseInitializer;
import com.c174.services.abstraction.TicketService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TicketServiceImplementation implements TicketService {
    private final FirebaseInitializer firebase;
    public TicketServiceImplementation(FirebaseInitializer firebase) {
        this.firebase = firebase;
    }
    private CollectionReference  getCollection() {
        return firebase.getFirestore().collection("ticket");
    }
    private Map<String,Object> getDocData(TicketDTO ticket){
        Map<String,Object> docData = new HashMap<>();
        docData.put("eventName",ticket.getEventName());
        docData.put("available",true);
        LocalDateTime currentDate = LocalDateTime.now();
        Timestamp timestampCurrentDate = Timestamp.valueOf(currentDate);
        docData.put("creationTime",timestampCurrentDate);
        return docData;
    }
    @Override
    public List<TicketDTO> list() {
        List<TicketDTO> response = new ArrayList<>();
        TicketDTO ticketDTO;
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()){
                ticketDTO = doc.toObject(TicketDTO.class);
                ticketDTO.setId(doc.getId());
                response.add(ticketDTO);
            }
            return response;
        } catch (Exception e){
            return null;
        }

    }
    @Override
    public Boolean create(TicketDTO ticket){
        Map<String,Object> docData = getDocData(ticket);

        CollectionReference post = getCollection();
        ApiFuture<WriteResult> writeResultApiFuture = post.document().create(docData);
        try{
            if(writeResultApiFuture.get() !=  null){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }catch (Exception e){
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean update(String id, TicketDTO ticket) {
        Map<String,Object> docData = getDocData(ticket);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).set(docData);
        try{
            if(writeResultApiFuture.get() !=  null){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }catch (Exception e){
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean delete(String id) {
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).delete();
        try{
            if(writeResultApiFuture.get() !=  null){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }catch (Exception e){
            return Boolean.FALSE;
        }
    }
}
