[readme_malha_aerea.md](https://github.com/user-attachments/files/23916294/readme_malha_aerea.md)
# Sistema de Gerenciamento de Malha Aérea

Um sistema completo para gerenciamento de malha aérea desenvolvido em Java 21, seguindo os princípios do Domain-Driven Design (DDD) e oferecendo operações CRUD para aeroportos, rotas e tipos de aeronaves.

## 📋 Sobre o Projeto

Este sistema permite gerenciar uma rede completa de operações aéreas, incluindo o cadastro de aeroportos, definição de rotas entre destinos e registro de tipos de aeronaves. O projeto foi desenvolvido com foco em boas práticas de arquitetura de software, separação de responsabilidades e modelagem de domínio rica.

## 🏗️ Arquitetura

O projeto segue a arquitetura DDD (Domain-Driven Design) organizada em camadas bem definidas:

### Camada de Domínio (Domain Layer)
Esta é a camada central do sistema, onde reside a lógica de negócio. Ela contém as entidades do domínio e as interfaces dos repositórios, garantindo que as regras de negócio sejam respeitadas independentemente da infraestrutura utilizada.

**Entidades principais:**
- **Airport**: Representa um aeroporto com código IATA, nome, cidade e país. Valida que o código IATA esteja sempre em letras maiúsculas e que informações obrigatórias não sejam vazias.
- **Route**: Modela uma rota entre dois aeroportos, incluindo distância em quilômetros e tempo estimado de voo. Garante que origem e destino sejam diferentes e que valores numéricos sejam positivos.
- **Aircraft**: Define um tipo de aeronave com validações de formato de nome, permitindo apenas caracteres alfanuméricos e alguns símbolos específicos.

### Camada de Aplicação (Application Layer)
Responsável por orquestrar as operações e coordenar o fluxo de dados entre a interface do usuário e o domínio.

**Componentes:**
- **Services**: Implementam os casos de uso do sistema (AirportService, RouteService, AircraftService). Cada serviço valida regras de negócio adicionais, como evitar duplicatas de códigos IATA ou rotas já existentes.
- **DTOs**: Objetos de transferência de dados que carregam informações entre as camadas sem expor diretamente as entidades de domínio.

### Camada de Infraestrutura (Infrastructure Layer)
Fornece implementações concretas dos repositórios definidos no domínio. Atualmente utiliza implementações em memória (InMemory) com ConcurrentHashMap para garantir thread-safety.

**Implementações:**
- **InMemoryAirportRepository**: Armazena aeroportos em memória
- **InMemoryRouteRepository**: Gerencia rotas com busca por origem e destino
- **InMemoryAircraftRepository**: Mantém tipos de aeronaves cadastrados

## 🚀 Tecnologias Utilizadas

- **Java 21**: Versão mais recente da linguagem com recursos modernos
- **Arquitetura DDD**: Domain-Driven Design para organização do código
- **Repository Pattern**: Abstração do acesso aos dados
- **Service Layer**: Camada de serviços para lógica de aplicação
- **DTO Pattern**: Transferência de dados entre camadas
- **UUID**: Geração de identificadores únicos para entidades
- **ConcurrentHashMap**: Estruturas thread-safe para armazenamento em memória

## 📦 Estrutura do Projeto

```
com.malha/
├── Main.java                           # Ponto de entrada com interface CLI
├── application/
│   ├── dto/
│   │   ├── AircraftDTO.java           # DTO para tipos de aeronave
│   │   ├── AirportDTO.java            # DTO para aeroportos
│   │   └── RouteDTO.java              # DTO para rotas
│   └── service/
│       ├── AircraftService.java       # Lógica de negócio para aeronaves
│       ├── AirportService.java        # Lógica de negócio para aeroportos
│       └── RouteService.java          # Lógica de negócio para rotas
├── domain/
│   ├── model/
│   │   ├── Aircraft.java              # Entidade de domínio: Aeronave
│   │   ├── Airport.java               # Entidade de domínio: Aeroporto
│   │   └── Route.java                 # Entidade de domínio: Rota
│   └── repository/
│       ├── AircraftRepository.java    # Interface do repositório de aeronaves
│       ├── AirportRepository.java     # Interface do repositório de aeroportos
│       └── RouteRepository.java       # Interface do repositório de rotas
├── exception/
│   └── DomainException.java           # Exceção customizada para erros de domínio
└── infrastructure/
    └── memory/
        ├── InMemoryAircraftRepository.java   # Implementação em memória
        ├── InMemoryAirportRepository.java    # Implementação em memória
        └── InMemoryRouteRepository.java      # Implementação em memória
```

## ⚙️ Como Executar

### Pré-requisitos
- JDK 21 ou superior instalado
- Variável de ambiente JAVA_HOME configurada

### Compilação e Execução

**Opção 1: Via linha de comando**
```bash
# Navegar até o diretório raiz do projeto
cd caminho/para/o/projeto

# Compilar todos os arquivos
javac -d bin src/com/malha/**/*.java

# Executar a aplicação
java -cp bin com.malha.Main
```

**Opção 2: Via IDE**
- Abra o projeto em sua IDE favorita (IntelliJ IDEA, Eclipse, VS Code)
- Configure o JDK 21 como SDK do projeto
- Execute a classe `Main.java`

## 📱 Funcionalidades

O sistema oferece um menu interativo com as seguintes operações:

### Gerenciamento de Aeroportos
1. **Criar Aeroporto**: Cadastra um novo aeroporto informando código IATA (3 letras), nome, cidade e país. O sistema valida se o código já existe antes de criar.
2. **Listar Aeroportos**: Exibe todos os aeroportos cadastrados com suas informações completas.
3. **Atualizar Aeroporto**: Modifica os dados de um aeroporto existente através do seu ID. Valida duplicidade de código IATA.
4. **Deletar Aeroporto**: Remove um aeroporto do sistema através do seu ID.

### Gerenciamento de Rotas
5. **Criar Rota**: Estabelece uma nova rota entre dois aeroportos, definindo distância em quilômetros e tempo estimado de voo em minutos. Valida que origem e destino existam e sejam diferentes, além de evitar rotas duplicadas.
6. **Listar Rotas**: Mostra todas as rotas cadastradas com detalhes de origem, destino, distância e tempo.
7. **Atualizar Rota**: Permite modificar distância e tempo estimado de uma rota existente.
8. **Deletar Rota**: Remove uma rota do sistema.
9. **Listar Rotas por Origem**: Filtra e exibe todas as rotas que partem de um aeroporto específico.

### Gerenciamento de Tipos de Aeronaves
10. **Criar Tipo de Aeronave**: Registra um novo modelo de aeronave (ex: Boeing 737-800, Airbus A320neo). Valida formato do nome e duplicidade.
11. **Listar Tipos de Aeronave**: Exibe todos os modelos de aeronaves cadastrados.
12. **Atualizar Tipo de Aeronave**: Modifica o nome de um tipo de aeronave existente.
13. **Deletar Tipo de Aeronave**: Remove um tipo de aeronave do sistema.

## 🎯 Regras de Negócio Implementadas

### Aeroportos
- Código IATA é obrigatório, único no sistema e sempre convertido para maiúsculas
- Nome do aeroporto não pode ser vazio
- Cidade e país são opcionais mas recomendados

### Rotas
- Aeroporto de origem e destino devem existir no sistema
- Origem e destino não podem ser o mesmo aeroporto
- Não podem existir rotas duplicadas entre os mesmos aeroportos
- Distância deve ser maior que zero
- Tempo estimado deve ser maior que zero

### Aeronaves
- Nome da aeronave não pode ser vazio
- Formato deve conter apenas letras, números, espaços, pontos, hífens e barras
- Nomes de aeronaves devem ser únicos no sistema

## 💡 Exemplo de Uso

Ao executar a aplicação, o sistema já vem pré-configurado com alguns dados iniciais:

- **Aeroporto**: GRU (Guarulhos International Airport, São Paulo, Brasil)
- **Aeronaves**: Boeing 737-800 e Airbus A320neo

A partir daí, você pode interagir com o menu para adicionar mais aeroportos, criar rotas entre eles e registrar novos tipos de aeronaves conforme necessário.

**Fluxo típico de uso:**
1. Cadastrar aeroportos de origem e destino
2. Criar rotas conectando os aeroportos
3. Listar as rotas disponíveis para visualizar a malha aérea
4. Registrar os tipos de aeronaves que operam essas rotas

## 🔄 Tratamento de Erros

O sistema possui tratamento robusto de exceções através da classe `DomainException`, que captura e informa erros como:

- Tentativa de criar entidades com dados inválidos
- Violação de regras de unicidade (códigos IATA duplicados, rotas duplicadas, etc.)
- Tentativa de atualizar ou deletar entidades inexistentes
- Validações de formato de dados

Todas as exceções são capturadas no loop principal e exibidas de forma amigável ao usuário, permitindo que ele corrija o erro e tente novamente.

## 🚧 Melhorias Futuras

Este projeto foi desenvolvido como um sistema base e pode ser expandido com as seguintes funcionalidades:

### Persistência de Dados
- Implementar repositórios com banco de dados relacional (PostgreSQL, MySQL)
- Adicionar JPA/Hibernate para mapeamento objeto-relacional
- Criar migrations para versionamento do esquema do banco

### API REST
- Expor funcionalidades através de endpoints RESTful
- Implementar autenticação e autorização
- Adicionar documentação com Swagger/OpenAPI

### Funcionalidades Avançadas
- Algoritmo de busca do menor caminho entre aeroportos (Dijkstra)
- Gerenciamento de voos programados com horários
- Alocação de aeronaves específicas para rotas
- Cálculo de capacidade de passageiros por aeronave
- Relatórios de utilização da malha aérea

### Qualidade de Código
- Implementar testes unitários com JUnit 5
- Adicionar testes de integração
- Configurar CI/CD com GitHub Actions
- Implementar análise estática de código com SonarQube

### Interface
- Desenvolver interface gráfica desktop com JavaFX
- Criar interface web com Spring Boot + React
- Adicionar visualização gráfica da malha aérea

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais e está disponível para uso livre.

## 👨‍💻 Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests com melhorias, correções de bugs ou novas funcionalidades.

---

Desenvolvido com foco em arquitetura limpa e boas práticas de desenvolvimento Java.
