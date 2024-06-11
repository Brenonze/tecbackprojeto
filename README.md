RF1 - Requisito Funcional 01

Neste requisito, criamos uma classe Usuario (com seus respectivos campos necessários), UsuarioRepository (para interação de dados com o banco de dados), UsuarioService (para a lógica de negócio) e UsuarioController (para as requisições HTTP). Com isso, estabelecemos os seguintes endpoints:

Cadastro de Usuário (POST) /usuarios
Listagem de Usuários (GET) /usuarios
Busca de Usuário por ID (GET) /usuarios/{id}
Atualização de Usuário por ID (PUT) /usuarios/{id}
Remoção de usuário por ID (DELETE) /usuarios/{id}
Com a API em execução, basta acessar localhost:8080/ e fazer a requisição desejada.

RF3 - Requisito Funcional 03

No terceiro requisito funcional, repetimos o processo do RF1 e adicionamos ao CartaoController os seguintes endpoints:

Criar Cartão (POST) /cartao
Atualizar Cartão (PUT) /cartao
Buscar Cartão por ID (GET) /cartao/{id}
Excluir Cartão por ID (DELETE) /cartao/{id}
Novamente, com a API em execução, acesse localhost:8080/ e faça a requisição desejada.

RF4 - Requisito Funcional 04

Aqui, focamos na criação de uma estrutura completa para séries (Serie, SerieRepository, SerieService e SerieController) para exibir informações detalhadas. Além disso, adicionamos algumas funcionalidades ao FilmeController, que já possuía alguns códigos prontos.

Para cumprir o RF4, adicionamos ao SerieController as seguintes funcionalidades:

Salvar uma nova série (POST) /serie
Listar todas as séries (GET) /serie
Atualizar uma série existente com base no ID (PUT) /serie/{id}
Buscar uma série pelo ID (GET) /serie/{id}
Excluir uma série pelo ID (DELETE) /serie/{id}
Para o FilmeController, adicionamos apenas os endpoints que estavam faltando:

Listar todos os filmes (GET) /filme
Atualizar filme por ID (PUT) /filme/{id}
RF5 - Requisito Funcional 05

Neste requisito, criamos a classe Favoritos e a relacionamos com Usuario, Filme e Serie. Também fizemos com que a requisição criasse novas colunas no banco de dados ("usuario_id", "filme_id" e "serie_id"). Agora, é possível que o usuário adicione filmes e/ou séries à sua lista de favoritos.

Adicionar filme aos favoritos de um usuário (POST) /favoritos/usuario/{usuarioId}/filme/{filmeId}
Adicionar série aos favoritos de um usuário (POST) /favoritos/usuario/{usuarioId}/serie/{serieId}
Listar todos os favoritos de um usuário (GET) /favoritos/usuario/{usuarioId}
Deletar favorito por ID (DELETE) /favoritos/{favoritoId}
RF6 - Requisito Funcional 06

Adicionamos mais duas funcionalidades ao FavoritosController:

Listar filmes favoritos de um usuário (GET) /favoritos/usuario/{usuarioId}/filmes
Listar séries favoritas de um usuário (GET) /favoritos/usuario/{usuarioId}/series
RF7 - Requisito Funcional 07

Implementamos uma lista ordenada de usuários. Para isso, criamos a funcionalidade no serviço usando findAllByOrder e adicionamos o endpoint necessário no UsuarioController:

Listar usuários ordenados por nome (GET) /usuarios/ordenados
