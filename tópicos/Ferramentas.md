# Ferramentas

* Ferramentas de desenvolvimento
    * Kotlin na JVM
    * IntelliJ IDEA CE
    * Git
        * Github
        * Github Classroom

* Questão
    * Ter um repositório Kotlin independente de IDE

* Resposta
    * Gerenciador de _build_ Gradle
    * Repositório Kotlin/JVM + Gradle
        * Assim como C e make (em várias linguagens se dá algo semelhante, ver abaixo)
        * Kotlin adere a módulos definidos por ferramentas
        * Gradle tornou-se programável em Kotlin
    * IntelliJ e Gradle
        * IntelliJ delega processo de _build_ à ferramenta
        * Arquivos de projeto do IntelliJ passam a não existir
        * IntelliJ possui recursos de UI para Gradle
        * CLI do Gradle está valendo
    * ( ( Pelas linguagens de programação por aí
        * Em geral:
            * Há a ferramenta de linha de comando
                * Muitas vezes, também disponível como lib
            * Um formato de empacotamento para distribuição
            * Um centro de distribuição (um site e também uma marca, um nome)
            * Exemplo: Gradle + JAR + Maven-repo
        * Haskell
            *  Cabal + _tarball_ + Hackage 
                * No início, era o Cabal
                * Falhava em conciliar versões
                * Evoluiu muito com a concorrência de Stack
            * Stack + _tarball_ + Stackage
                * Trouxe o conceito de _Long Term Support_ 
            * Shake
            * Hadrian
        * OCaml
            * ocamlbuild + _tarballs_ + Opam
                * Ferramentas de OCaml refletiam a cultura Unix tradicional dos devs
            * Dune
                * Muita coisa se modernizou quando empresas adotaram OCaml
        * Rust
            * Cargo + cradle + cradle.io
                * A linguagem já surge com uma ferramenta bem pensada
                * Surge na década de 2010, portanto com visão moderna
                * Surge nos anos 2010, já com a influência de outras ferramentas em linguagens várias
                * Rust se beneficia de haver satisfação e consenso sobre ferramenta
                ) ) 
                

## Rotinas de trabalho (ou _workflows_)

* Criar um novo projeto
    * Criar um repositório vazio no Github
    * Criar um diretório vazio com mesmo nome (&& entrar)
        * `$ mkdir proj-kotlin-gradle && cd proj-kotlin-gradle`
    * Preparar o controle de versão
        * `$ git init`
        * `$ git remote add origin https://github.com/<conta>/proj-kotlin-gradle.git`
    * Preparar o Gradle
        * `$ gradle init` 
        * Ir respondendo: 
            * Aplicação ou Lib
            * Projeto em Kotlin
            * Configuração do Gradle em Kotlin (em vez de Groovy)
            * O mesmo nome de projeto `proj-kotlin-gradle`
            * Uma hierarquia de pacotes conveniente, como `<empresa>.<proj>` (ex: `aespiral.ktlab`)
        * Observe a hierarquia criada
            * `main` e `teste` são _módulos_ no jargão do Gradle
        * Adicionar `.idea` ao `.gitignore`
            * `$ echo .idea >> .gitignore`
    * Gerar a versão Gênese e atualizar o Github
        * `git add .`
        * `git commit -m "Gênese: configuração do gradle"`
        * `git push --set-upstream origin main`
            
* Clonar um projeto
    * `git clone https://github.com/fulano/proj-existente.git`
    * Sendo um projeto Kotlin/JVM + Grade
        * Na CLI, pode-se usar o _wrapper_ do Gradle
            * `$ ./gradlew build` etc
            * `> gradlew.bat build` no Windows

* Começando o projeto no IntelliJ
    * Solicitar para abrir arquivo de projeto
    * O IntelliJ detecta o Gradle e se autoconfigura para trabalhar com o Gradle
        * Podem ocorrer _downloads_ etc
    * Usar as "tarefas" do Gradle via painel próprio