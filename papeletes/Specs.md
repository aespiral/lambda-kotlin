# Especificação do sistema Papeletes

Um papelete (ou pplt) tem um texto. Mas o texto pode mudar por edição, então é melhor que um pplt seja uma
lista de nomes correspondente às versões do nome.

Pplts podem ser organizados em subcategorias. Cada categoria é um pplt também.
Exemplo: `receita/legumes` : `receita` é um pplt , `legumes` é um pplt e é sinônimo de `receita/legumes`

Não pode haver papeletes com mesmo texto, ainda que em subcategorias diferentes.

Há papeletes definidos pelo papelista (usuário) e pela aplicação. 
Os pplts e as ctgrs básicas de um sistema são definidos como configuração, e não como programação.
(Há um repositório de configuração que é carregado.)

O sistema integra-se à aplicação como um serviço ou uma API. 

O sistema fornece sugestões de pplts a partir de trechos de texto, para, por exemplo, aplicar em sugestões
simultâneas à digitação. Os critérios de formação das filas de sugestões podem ser: busca por subtexto,
contagem de usos mais frequentes, mais recentes, e importância para o contexto.



