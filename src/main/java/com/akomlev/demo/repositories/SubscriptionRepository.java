package com.akomlev.demo.repositories;
import org.springframework.data.repository.CrudRepository;

import com.akomlev.demo.models.Subscription;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {
    Iterable<Subscription> findAll();
    void delete(Subscription entity);
    <S extends Subscription> S save(S entity);
}
