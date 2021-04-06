# Digytal - Programação, Pesquisa e Educação
www.digytal.com.br
(11) 95894 0362

## Java Desktop Utils

Biblioteca de componentes para desenvolvimento desktop com Java Swing.

#### Colaboradores
- [Frank Marlon](https://github.com/fmarlon)
- [Gleyson Sampaio](https://github.com/glysns)

#### Principais Compenentes
Em Java os camponentes desktop também são classes com a finalidade de gerar interface gráfica.

- SSBotao
- SSCampoTexto
- SSCampoDataHora
- SSCaixaCombinacao
- SSGrade
- SSCabecalho
- SSRodape

* Para o componente SSBotao, o mesmo usa imagem como icone conforme Label - setText() compatível com o arquivo `.png` existente em `/resources/img`
* Para componentes do tipo `Grade` ou `Combo` os mesmos recebem Array ou List e no caso do combo o mesmo recebe um segundo parametro `campoExibicao` para informar qual atributo da classe será exibido.
```
List<Entidade> entidades = new ArrayList<Entidade>();
entidades.add(new Entidade(1, "FRANK MARLON"));
entidades.add(new Entidade(2, "RAIMUNDO BRANCO"));
entidades.add(new Entidade(3, "GLEYSON SAMPAIO"));
entidades.add(new Entidade(4, "RAFAEL ALUNO"));

grade.setValue(entidades);

combo.setItens(entidades, "nome");
```
#### Configuração do WindowBuilder (Editor Visual de Telas para Eclipse)
1. Help -> Install New Software
1. http://download.eclipse.org/windowbuilder/latest/

![](https://github.com/glysns/java-exemplos/blob/main/java-swing/desktop-utils/src/main/resources/window-builder-install.png)
![](https://github.com/glysns/java-exemplos/blob/main/java-swing/desktop-utils/src/main/resources/wb_summary_shot.gif)


#### Para testar o uso dos componentes siga o exemplo do projeto: [desktop-sample](https://github.com/glysns/java-exemplos/tree/main/java-swing/desktop-sample)
