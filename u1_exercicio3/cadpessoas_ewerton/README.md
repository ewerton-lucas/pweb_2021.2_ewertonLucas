# Modificações

# Passo 1:
- Estruturando os arquivos e pastas do projeto (seguindo imagem do drive como exemplo);
- Inserindo MVC;
- Colando front-end do exercício 2 (adaptando ao Spring MVC);
- Ajustando o menu e a navegação para a nova arquitetura;

# Passo 2:
- Ajustando formulários conforme orientações do professor (enviando dados do formulário para o banco de dados);
- Ajustando tabela conforme orientações do professor (tabela dinâmica);

# Passo 3:
- Configurando a classe Pessoa referente ao pacote "model";
- Configurando a classe PessoaController  referente ao pacote "controllers";
- Configurando a classe PessoaRepository  referente ao pacote "repositories";

# Passo 4 - Soluções de bugs

- Alterando nome do atributo "genero" do arquivo import.sql para "sexo" - Isso estava impedindo que a página de listagem de pessoas apresentasse a tabela, uma vez que, o nome do atributo da tabela pessoas, “genero”, estava divergindo do nome usado nos formulários, na tabela e na classe Pessoa do pacote model, “sexo”;
- Alterando banner.txt (por algum motivo havia colado o de 2020.2);
- Alterando o arquivo application.properties (apenas o nome em alguns campos, pois estavam iguais ao do professor);
- Alterando o PessoaController - A anotação para mapear a página de adicionar pessoas estava no caminho errado. Funcionou quando usei: @GetMapping("/adicionarPessoa");

# Observação: 
- Não havia versionado o código no github, mas usei as anotações do caderno para elencar as principais mudanças.