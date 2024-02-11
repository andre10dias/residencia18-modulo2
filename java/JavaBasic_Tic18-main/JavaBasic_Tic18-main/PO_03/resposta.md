
1. O que é uma exceção em Java e qual é o propósito de usá-las em programas?
    #### Em Java, uma exceção é um evento anormal que ocorre durante a execução de um programa, interrompendo o fluxo normal de instruções. As exceções podem ser causadas por diversos motivos, como erros de programação, condições imprevisíveis durante a execução ou situações que fogem ao controle do programador.
    #### O propósito das exceções em Java é lidar com essas situações excepcionais de uma maneira estruturada e controlada. Em vez de permitir que o programa termine abruptamente ou produza resultados imprevisíveis quando ocorre um erro, as exceções permitem que o código trate esses erros de forma apropriada. Isso ajuda a melhorar a robustez, a legibilidade e a manutenção do código.
    #### Ao lançar uma exceção em Java, você sinaliza que algo inesperado aconteceu. Outras partes do código podem então capturar (ou "catch") essa exceção e tomar medidas apropriadas, como fornecer uma mensagem de erro ao usuário, fazer log do erro ou tentar recuperar de maneira graciosa.

    #### A estrutura básica para manipular exceções em Java envolve os blocos "try", "catch" e, opcionalmente, "finally":

    * O bloco try contém o código que pode lançar uma exceção.
    * O bloco catch contém o código que será executado se uma exceção do tipo especificado ocorrer.
    * O bloco finally, se presente, contém código que será executado independentemente de ocorrer uma exceção ou não.

2. Pesquise sobre a diferença entre exceções verificadas e não verificadas em Java. Dê exemplos de cada uma.
   #### Em Java, as exceções são divididas em dois tipos: verificadas e não verificadas.

* Exceções verificadas são aquelas que são obrigatórias para serem tratadas. Elas são representadas pela classe Exception e suas subclasses. Exemplos de exceções verificadas incluem:

  * FileNotFoundException - lançada quando um arquivo não pode ser encontrado.
  * ClassNotFoundException - lançada quando uma classe não pode ser encontrada.
  * ArrayIndexOutOfBoundsException - lançada quando um índice de matriz está fora dos limites.
* Exceções não verificadas são aquelas que não são obrigatórias para serem tratadas. Elas são representadas pela classe RuntimeException e suas subclasses. Exemplos de exceções não verificadas incluem:

  * NullPointerException - lançada quando uma referência null é usada para acessar um objeto.
  * ArithmeticException - lançada quando uma operação aritmética é impossível, como dividir por zero.
  * IndexOutOfBoundsException - lançada quando um índice está fora dos limites de um objeto, como uma matriz ou uma lista.
  
3. Como você pode lidar com exceções em Java? Quais são as palavras-chave e as práticas comuns para tratamento de exceções?

    #### Existem duas maneiras de lidar com exceções em Java:
    * Tratamento explícito - o desenvolvedor explicitamente trata a exceção usando um bloco try-catch.
    * Tratamento implícito - o compilador do Java trata a exceção automaticamente gerando um código de exceção padrão.
    
    #### obs: O bloco try-catch é usado para tratar exceções explicitamente. O bloco try contém o código que pode gerar uma exceção. O bloco catch é usado para tratar a exceção que é lançada no bloco try.

    #### Práticas comuns para tratamento de exceções:

    1. Evite capturar exceções genéricas, como Exception, sempre que possível. Em vez disso, capture exceções mais específicas relacionadas ao tipo de erro que você está tratando. Isso ajuda a entender melhor a causa do problema e a aplicar soluções mais direcionadas.
    2. Quando você estiver lidando com recursos que precisam ser fechados, como conexões de banco de dados, arquivos ou sockets, utilize o bloco finally para garantir que esses recursos sejam liberados, independentemente de ocorrer uma exceção ou não.
    3. Evite capturar exceções sem realizar alguma ação apropriada. Se você não puder tomar medidas corretivas ou informativas, pode ser melhor não capturar a exceção no momento e permitir que ela seja propagada para um nível superior na pilha de chamadas.
    4. Sempre que possível, registre informações relevantes sobre a exceção, como mensagens de erro, pilha de chamadas (stack trace) e quaisquer valores relevantes. Isso facilita a depuração e a identificação da causa raiz do problema.
    5. Trate exceções no nível em que você tem informações suficientes para tomar decisões apropriadas. Não é necessário (e muitas vezes não é desejável) lidar com exceções em todos os lugares. Deixe exceções serem propagadas para níveis superiores, onde decisões mais globais podem ser tomadas.
 
 4. O que é o bloco "try-catch" em Java? Como ele funciona e por que é importante usá-lo ao lidar com exceções?
    ####  O bloco try-catch é uma estrutura de controle que permite ao desenvolvedor tratar exceções. O bloco try contém o código que pode gerar uma exceção. O bloco catch é usado para tratar a exceção que é lançada no bloco try.

    1. O código no bloco try é executado.
    2. Se uma exceção for lançada no bloco try, o fluxo de controle é transferido para o bloco catch.
    3. O código no bloco catch é executado.
    4. O fluxo de controle é transferido para o código após o bloco catch.
    #### O bloco try-catch é importante ao lidar com exceções porque permite ao desenvolvedor tratar a exceção de forma controlada. Isso ajuda a garantir que o programa não seja interrompido abruptamente e que a exceção seja tratada de uma maneira que não prejudique o programa ou o usuário.

    #### Além disso, o bloco try-catch pode ser usado para coletar informações sobre a exceção, como o tipo da exceção, o local onde ela foi lançada e uma mensagem de erro. Essas informações podem ser usadas para depurar o programa ou para fornecer feedback ao usuário.

5. Quando é apropriado criar suas próprias exceções personalizadas em Java e como você pode fazer isso? Dê um exemplo de quando e por que você criaria uma exceção personalizada.
   #### É apropriado criar suas próprias exceções personalizadas em Java quando você precisa representar uma condição anormal que não é representada por uma exceção padrão. Por exemplo, você pode criar uma exceção personalizada para representar um erro de validação de dados ou um erro de negócio.

    #### Para criar uma exceção personalizada em Java, você precisa estender a classe Exception ou uma de suas subclasses. A classe Exception fornece alguns métodos úteis para tratar exceções, como o método getMessage(), que retorna uma mensagem de erro sobre a exceção.

    #### Eu usaria uma exceção personalisada, para validar cpf,email ou até mesmo nome. Pois o usuario pode colocar um valor invalido, tipo vazio, validar se o email esta em um determinado formato.