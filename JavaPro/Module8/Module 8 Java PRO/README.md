# JavaPro_Modulo8_ExercicioSpringSecurity
Exercício para conclusão do Módulo 8 da formação Java-PRO pela Mentorama
O objetivo é a utilização do software (opensource) Keycloak  como mecanismo para estabelecimento de poderes de acesso e 
autenticação de tais poderes quando é executado um endpoint. A verificação/validação é feita através de um token gerado pelo Authentication Server Keycloak
operando sobre a plataforma de serviços Docker e gerenciamento feito pelo servidor de aplicações JBOSS (Linux)
A aplicação em si é muito simples, pois seu objetivo não é a elaboração de diversas funcionalidades, mas sim, implementar um mecanismo de segurança de amplo uso
no mercado. A amplicação simula um cadastro reduzido de aluno e o CRUD habitual juntamente com os seus endpointd.
A centralidade do exercício recai na configuração do Authentication Server Keycloak e nos arquivos de configuração que a aplicação deve possuir para que possa
executar as funcionalidades esperadas: KeycloakSecurityConfig e KeycloakConfiguration.
Outro elemento fundamental na composição da arquitetura da aplicação é o arquivo application.properties. Neste, deve estar implentada a linha abaixo destacada 
como "true" para evitar a ocorrência do erro 403 Access Forbidden quando o endpoint transmite o token gerado para a validação pelo Authentication Server:

keycloak.use-resource-role-mappings=true

As demais linhas do application.properties segue o padrão requerido pelo Keycloak:

server.port=8081 (pois a porta 8080 é utilizada pelo Docker para colocar em funcionamento o Keycloak)
keycloak.auth-server-url=http://localhost:8080/auth
keycloak.realm= (nome do realm conforme definido no keycloak)
keycloak.resource= (nome da api)
keycloak.public-client=true
keycloak.principal-attribute=preferred_username
keycloak.ssl-required=external
keycloak.use-resource-role-mappings=true
