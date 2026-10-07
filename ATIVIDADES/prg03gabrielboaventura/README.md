O construtor vazio de Usuario permite criar um usuário sem informar os dados inicialmente, 
para que sejam preenchidos posteriormente.
O construtor com nome, e-mail e senha permite criar um usuário já com seus dados principais preenchidos.

Com 10 usuários, a diferença entre buscar pela List e pelo Map é pequena.
Com 10.000 usuários, o Map é mais eficiente, pois busca pelo login sem precisar percorrer toda a lista.