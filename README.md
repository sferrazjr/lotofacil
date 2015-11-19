# lotofacil
It's written in Portuguese because this is an exercise to help others devs to understand MongoDB and Spring Data. Busca sorteis da lotofacil e exibe estatistica dos números mais sorteados. Também permite conferir se o seu palpite jah foi sorteado no historico de jogos. O dump do banco de dados estah na pasta dump.

On 18/November/2015
Give up hybrid (spring boot and war) application. No point to keep an war version as many SaaS use spring boot.
General clean up on files that were needed only for war version
Configuring paths in ftl to use spring boot path system
Give up the idea of having parameters on java files. All parameters are in application.properties
Configuring pom file to java 1.8
No need to have /WEB-INF folder and traditional spring configuration files using spring boot

TODO:
Fix test class
