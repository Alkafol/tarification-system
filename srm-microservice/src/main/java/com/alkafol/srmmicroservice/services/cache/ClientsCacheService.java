package com.alkafol.srmmicroservice.services.cache;

import com.alkafol.srmmicroservice.dto.managerdto.ClientDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientsCacheService {
    private final Map<String, ClientDto> cache = new HashMap<>();

    public boolean containsKey(String key) {
        return cache.containsKey(key);
    }

    public void put(String key, ClientDto value) {
        cache.put(key, value);
    }

    public ClientDto get(String key) {
        return cache.get(key);
    }

    public void remove(String key){
        cache.remove(key);
    }
}
