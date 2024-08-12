package com.cybage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Complaints;

@Repository
public interface Complaint_Repository extends JpaRepository<Complaints, Integer>{

}
