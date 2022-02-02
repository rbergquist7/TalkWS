package com.brightrace.SpringbootRestApiTalkWS.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brightrace.SpringbootRestApiTalkWS.model.Talk;


@Repository
public interface TalkRepository extends JpaRepository<Talk, Integer> {
 
}