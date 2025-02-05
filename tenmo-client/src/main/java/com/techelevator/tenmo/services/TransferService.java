package com.techelevator.tenmo.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.util.BasicLogger;

public class TransferService {

    private AuthenticatedUser currentUser;

    public void setAuthUser(AuthenticatedUser currentUser) {
        this.currentUser = currentUser;
    }

    public static final String API_BASE_URL = "http://localhost:8080/transfers";
    private RestTemplate restTemplate = new RestTemplate();

    public Transfer getTransferById(int transferId) {
        Transfer transfer = null;
        try {
        //TODO GET method
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return transfer;
    }

    public Transfer[] getTransfersByUserId(int userId) {
        Transfer[] transfers = null;
        try {
        //TODO GET method
        } catch (RestClientResponseException | ResourceAccessException e) {
            System.err.println(e);
            BasicLogger.log(e.getMessage());
        }
        return transfers;
    }

    public Transfer[] getPendingTransfers(int accountId) {
        Transfer[] transfers = null;
        try {
        //TODO GET method
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return transfers;
    }

    public Transfer createTransfer(Transfer newTransfer) {
        HttpEntity<Transfer> entity = makeTransferEntity(newTransfer);
        Transfer returnedTransfer = null;
        try {
        //TODO hint:post for object
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return returnedTransfer;
    }

    public boolean updateTransfer(Transfer transfer) {
        HttpEntity<Transfer> entity = makeTransferEntity(transfer);
        boolean success = false;
        try {
        //TODO PUT method
        } catch (RestClientResponseException | ResourceAccessException e) {
            System.out.println("UPDATE TRANSFER ERROR");
            BasicLogger.log(e.getMessage());
        }
        return success;
    }

    private HttpEntity<Transfer> makeTransferEntity(Transfer transfer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(currentUser.getToken());
        return new HttpEntity<>(transfer, headers);
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(currentUser.getToken());
        return new HttpEntity<>(headers);
    }

}
