package br.com.derich.Observabilidade.controller;

import br.com.derich.Observabilidade.config.RestTemplateConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * O primeiro id que aparece é o tracing id e o segundo é o span id
 * http://localhost:9411/zipkin/ para acessar o zipkin e pesquisar o tracing id
 */
@RestController
@RequestMapping("/logs")
public class LogsController {

    private static final Logger logger = LoggerFactory.getLogger(LogsController.class);

    @Value("${servico2.url:}")
    private String urlServico2;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String mostraMensagem() {
        final double mensagem = Math.random();

        if (urlServico2.length() > 0) {
            final String mensagemDeles =
                    restTemplate.exchange(urlServico2, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();
            return "Eu disse isso: " + mensagem + " e eles disseram isso: (" + mensagemDeles + ")";
        }

        logger.info("Mensagem gerada: {}", mensagem);

        return "Eu deveria parar aqui";
    }
}
