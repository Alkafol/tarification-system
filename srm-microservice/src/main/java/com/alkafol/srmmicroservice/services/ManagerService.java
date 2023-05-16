package com.alkafol.srmmicroservice.services;

import com.alkafol.srmmicroservice.dto.managerdto.*;
import com.alkafol.srmmicroservice.services.cache.ClientsCacheService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ManagerService {
    private final UserService userService;
    private final RestTemplate restTemplate;
    private final Environment env;
    private final ClientsCacheService clientsCacheService;

    public ManagerService(UserService userService, RestTemplate restTemplate, Environment env,
                          ClientsCacheService clientsCacheService) {
        this.userService = userService;
        this.restTemplate = restTemplate;
        this.env = env;
        this.clientsCacheService = clientsCacheService;
    }

    public ChangeTariffResponseDto changeTariff(ChangeTariffRequestDto changeTariffRequestDto) {
        return restTemplate.patchForObject(
                env.getProperty("brt.microservice.address") + "/change_tariff",
                changeTariffRequestDto,
                ChangeTariffResponseDto.class
        );
    }

    public ClientDto createNewClient(ClientDto clientDto) {
        return restTemplate.postForObject(
                env.getProperty("brt.microservice.address") + "/create_abonent",
                clientDto,
                ClientDto.class
        );
    }

    public TarificationResult startBilling() {
        return restTemplate.getForObject(
                env.getProperty("cdr.microservice.address") + "/prepare_cdr",
                TarificationResult.class
        );
    }

    // регистрация менеджера (логин + пароль)
    public void register(ManagerRegistrationDto managerRegistrationDto) {
        userService.createNewManager(managerRegistrationDto);
    }

    public ClientDto getClientByPhoneNumber(String phoneNumber) {
        if (clientsCacheService.containsKey(phoneNumber)){
            return clientsCacheService.get(phoneNumber);
        }

        ClientDto clientDto = restTemplate.getForObject(
                env.getProperty("brt.microservice.address") + "/get_client_info/" + phoneNumber,
                ClientDto.class
        );
        clientsCacheService.put(phoneNumber, clientDto);

        return clientDto;
    }
}
