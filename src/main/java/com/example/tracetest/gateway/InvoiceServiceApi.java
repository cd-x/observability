package com.example.tracetest.gateway;

import com.example.tracetest.model.Invoice;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class InvoiceServiceApi {
    @Value("${external.services.invoice.base-url}")
    private String invoiceUrl;

    public List<Invoice> getInvoiceList(){
        try(HttpClient httpClient = HttpClient.newBuilder().build()){
            HttpRequest request = HttpRequest.newBuilder(URI.create(invoiceUrl + "/")).GET().build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<Invoice> invoiceList = Collections.emptyList();
            if(response.statusCode() == 200){
                Gson gson = new Gson();
                Invoice[] invoices = gson.fromJson(response.body(), Invoice[].class);
                invoiceList = Arrays.stream(invoices).toList();
            }
            return invoiceList;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
