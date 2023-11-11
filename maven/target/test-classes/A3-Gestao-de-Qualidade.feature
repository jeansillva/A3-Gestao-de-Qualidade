# language: pt

    Cenário: Cadastrar novo cliente com sucesso
        Dado que "Fulano" está no sistema com suas credenciais
        Quando "Fulano" cadastra um novo cliente
        Então o banco de dados deve salvar o registro do novo cliente

