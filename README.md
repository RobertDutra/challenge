# Back-end-challenge
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/RobertDutra/MainBooks/blob/main/LICENSE) 

# Sobre o projeto

Projeto back end da Zedia, desenvolvido em Java com Spring Boot. Implemente uma microserviço para um formulário de contato que replique o email para o usuário e a empresa que esteja utilizando o serviço, fazendo a validação do nome, email e recaptcha obtidos atráves do formulário. Como não consegui finalizar a implementação da validação token, deixei sempre retornando true para deixar o sistema rodando sem interrupções.

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- Maven
- IntelliJ IDEA
- Junit

## Implantação em produção
```bash
# clonar repositório
git clone https://github.com/RobertDutra/picpaysimplificado
```
```bash
docker build -t back-end .  
```
```bash
docker run -d -p 8080:8080 back-end
```


# Autor

Robert da Silva Dutra 

https://www.linkedin.com/in/robert-dutra-880033226/
