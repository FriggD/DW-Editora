package dw.secauth.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.ui.Model;
import dw.secauth.model.Artigo;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Controller
class EditoraController {

    @GetMapping("/editora")
    String index(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Artigo[] artigos = restTemplate.getForObject("http://localhost:8081/api/artigos", Artigo[].class);

        model.addAttribute("artigos", artigos);
        return "editora-list";
    }

    @GetMapping("/editora/add")
    String add(Model model) {
        return "editora-add";
    }

    @GetMapping("/editora/edit")
    String edit(String id, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Artigo artigo = restTemplate.getForObject("http://localhost:8081/api/artigos/"+id, Artigo.class);
        model.addAttribute("artigo", artigo);

        return "editora-edit";
    }

    @PostMapping("editora/criar")
    String criar(String titulo, String resumo) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/artigos";
  
        //setting up the request headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        //setting up the request body
        Artigo artigo = new Artigo();
        artigo.setTitulo(titulo);
        artigo.setResumo(resumo);

        //request entity is created with request body and headers
        HttpEntity<Artigo> requestEntity = new HttpEntity<>(artigo, requestHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        if(responseEntity.getStatusCode() == HttpStatus.OK){
           System.out.println("response retrieved "+responseEntity.toString());
        }
        return "redirect:/editora";
    }

    @PostMapping("editora/atualizar")
    String atualizar(String id, String titulo, String resumo) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/artigos/"+id;
  
        //setting up the request headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        //setting up the request body
        Artigo artigo = new Artigo();
        artigo.setId(id);
        artigo.setTitulo(titulo);
        artigo.setResumo(resumo);

        //request entity is created with request body and headers
        HttpEntity<Artigo> requestEntity = new HttpEntity<>(artigo, requestHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                String.class
        );

        if(responseEntity.getStatusCode() == HttpStatus.OK){
           System.out.println("response retrieved "+responseEntity.toString());
        }
        return "redirect:/editora";
    }

    @GetMapping("editora/remover")
    String remover() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/artigos";
  
        //setting up the request headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Artigo artigo = new Artigo();

        //request entity is created with request body and headers
        HttpEntity<Artigo> requestEntity = new HttpEntity<>(artigo, requestHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                requestEntity,
                String.class
        );

        if(responseEntity.getStatusCode() == HttpStatus.OK){
           System.out.println("response retrieved "+responseEntity.toString());
        }
        return "redirect:/editora";
    }
}
