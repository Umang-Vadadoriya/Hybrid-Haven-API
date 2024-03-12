package com.hybrid.hybridhavenapi.Repository;


import com.hybrid.hybridhavenapi.Entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventsRepository extends JpaRepository<Events,Integer> {

    Optional<Events> findByEventName(String name);

    @Override
    Optional<Events> findById(Integer integer);
}
