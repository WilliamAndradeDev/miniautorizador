# Mini Autorizador
# Pontos de Atenção

* O projeto foi estruturado inicialmente para funcionar utlizando o _Flyway_ para versionar
o schema porém o _Flyway_ dessa versão atual do _Spring_ não oferece mais suporte para a 
versão 5.7 do _MySQL_ no dockerfile e por isso deixei a responsabilidade da criação do schema
para o hibernate.