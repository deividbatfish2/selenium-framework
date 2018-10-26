# selenium-framework

## Inversão de Controle e Injeção de dependência com spring
Umas das dificuldades ao se trabalhar com o design pattern Page Objects em java, é a necessidade de gerenciar o webdriver e passá-lo de classe em classe para intanciar os WebElements.
Uma alternativa para esse problema é delegar a gerência desse objeto para um framework, e deixar que este se encarregue de instanciar e gerenciar este objeto.

Metodos produtores.....
## PageFactory
O selenium webdriver possui uma biblioteca de suporte que contem um fabrica de classes. Ela possibilita instanciar os webelements a partir de annotations.

Mais informações podem ser encontradas no [repositório oficial do seleniumHQ](https://github.com/SeleniumHQ/selenium/wiki/PageFactory).