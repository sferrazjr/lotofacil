<!DOCTYPE html>

<html>
  <head>
 <meta charset="utf-8">    
    <title>LotoFacil - Lista de Jogos</title>
    

  </head>
  
    <body>
    <script src="/scripts/jquery-1.11.2.js"></script>
    <script src="/scripts/jquery.jscroll.js"></script>


    <a href=/jogatina/incluir>Incluir Concurso</a>
    <br>
    <a href=/jogatina/>Inicio</a>
    
    

    <div class="scroll" style="border:1px solid red;">

	<#list lista["estatisca"] as estatisticaDeJogos>
		&nbsp;${estatisticaDeJogos.numero}&nbsp;
		&nbsp;${estatisticaDeJogos.vezes}&nbsp;
		<br>
	</#list>


	</div>

    </body>
    
    
</html>