API de Controle de Treinamentos
Esta é uma API RESTful desenvolvida em Java com Spring Boot utilizando JDBC puro, sem Hibernate ou JPA, para o gerenciamento de cursos, turmas e participantes.

1 - Funcionalidades
CRUD de cursos

CRUD de turmas (training sessions)

Inclusão e remoção de participantes por turma

Consulta de turmas por curso

Regras de negócio validadas no backend

2 - Tecnologias
Java 11+

Spring Boot

JDBC puro

Banco relacional (ex: PostgreSQL, MySQL)

Bean Validation (jakarta.validation)

Lombok

3 - Endpoints da API 
Cursos (/courses)  -
Método	Endpoint	Descrição:
POST	/courses	Criação de um novo curso

GET	/courses	Listagem de todos os cursos

GET	/courses/{id}	Buscar um curso por ID

PUT	/courses/{id}	Atualizar um curso existente

DELETE	/courses/{id}	Deletar um curso e suas turmas

4 - Participantes (/training-sessions/{sessionId}/participants)
Método	Endpoint	Descrição:
POST	/training-sessions/{sessionId}/participants	Adicionar participante à turma

GET	/training-sessions/{sessionId}/participants	Listar participantes da turma

DELETE	/training-sessions/{sessionId}/participants/{participantId}	Remover participante da turma

5 - Turmas:(/training-sessions)
Método	Endpoint	Descrição:
POST	/training-sessions	Criar nova turma

GET	/training-sessions	Listar todas as turmas

GET	/training-sessions/{id}	Buscar turma por ID

PUT	/training-sessions/{id}	Atualizar dados da turma (exceto o curso)

GET	/training-sessions/courses/{id}	Listar turmas de um curso específico

6 - Regras de Negócio:

Ao excluir um curso, todas as turmas relacionadas a ele também devem ser excluídas.

O curso de uma turma não pode ser alterado após sua criação.

Não é permitido alterar dados de um participante em uma turma — apenas adicionar ou remover.

Listagens devem ser ordenadas conforme o contexto (ex: data de início e fim da turma).