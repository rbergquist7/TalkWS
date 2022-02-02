package com.brightrace.SpringbootRestApiTalkWS.services;

import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brightrace.SpringbootRestApiTalkWS.model.*;
import com.brightrace.SpringbootRestApiTalkWS.repo.*;
@Service
@Transactional
public class TalkService {
    @Autowired
    private TalkRepository repo;
     
    public List<Talk> getTalks() {
        return repo.findAll();
    }
     
    public void save(Talk talk) {
        repo.save(talk);
    }
     
    public Talk getTalk(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
