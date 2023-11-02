<h1 align="center">
  Spring Actuator
</h1>


API desenvolvida em Spring Boot, apresenta a implementação de um dashboard de métricas robusto e personalizável, usando as tecnologias: Spring Boot Actuator, Prometheus e Grafana. O dashboard de métricas fornece informações para monitorar e otimizar o desempenho da API. A integração do Spring Boot Actuator oferece insights detalhados sobre a saúde e o status da aplicação, o Prometheus coleta e armazena métricas essenciais e o Grafana proporciona uma experiência de visualização de dados flexível e personalizável.

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator)
- [Prometheus](https://prometheus.io/docs/introduction/overview/)
- [Grafana](https://grafana.com/docs/?pg=oss-graf&plcmt=quick-links)
- [Docker](https://www.docker.com/)



## Como Executar

- Clonar repositório git
```
git clone https://github.com/RodrigoSCoutinho/mvc-actuator.git
```

- Construir o projeto:
```
./mvnw clean package
```

- Rodar o Prometheus com o Docker Compose:
```
$ docker-compose up
```



A API poderá ser acessada em [localhost:8081](http://localhost:8081).

Health check do actuator [localhost:8081/actuator](http://localhost:8081/actuator).

Check the metrics [localhost:8081/actuator/metrics](http://localhost:8081/actuator/metrics).

Check the Prometheus [localhost:9090](http://localhost:9090).

Check the Grafana [localhost:3000](http://localhost:3000).
```
admin | admin
```



