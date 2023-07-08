package com.godin.locationSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godin.locationSpring.model.Message;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByExpediteurId(int expediteurId);
    List<Message> findByRecepteurId(int recepteurId);

    @Query(nativeQuery = true, value="SELECT * FROM message WHERE recepteur_id=?1 OR expediteur_id=?1")
    List<Message> findByUserId(int id);

    @Query(nativeQuery = true, value="SELECT expediteur_id FROM message WHERE expediteur_id!=?1 AND (recepteur_id=?1 OR expediteur_id=?1) GROUP BY expediteur_id")
    List<Integer> findUsersInteracted(int id);

    @Query(nativeQuery = true, value="SELECT * FROM message WHERE (expediteur_id=?1 AND recepteur_id=?2) OR (expediteur_id=?2 AND recepteur_id=?1)")
    List<Message> interactions(int id1, int id2);
}
