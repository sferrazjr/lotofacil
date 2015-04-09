<!DOCTYPE html>

<html>
  <head>
 <meta charset="utf-8">    
    <title>LotoFacil - Lista de Jogos</title>
    

  </head>
  
    <body>
    <script src="/scripts/jquery-1.11.2.js"></script>
    <script src="/scripts/jquery.jscroll.js"></script>

<#assign page = springMacroRequestContext.requestUri?keep_after_last("/") >

<#assign nextPage=(page?number)>

    <a href=/lotofacil/incluir>Incluir Concurso</a>
    <br>
    <a href=/lotofacil/index>Inicio</a>
    
<div id="list" style="border:1px solid black;">
    
    <div class="scroll" style="border:1px solid red;">


   <#list lista["jogos"] as jogoLotoFacil>

        &nbsp;${jogoLotoFacil.concurso}&nbsp;
		&nbsp;${jogoLotoFacil.data?date}&nbsp;
		&nbsp;${jogoLotoFacil.ganhadores}&nbsp;
		&nbsp;${jogoLotoFacil.bolas[0]}&nbsp;
		&nbsp;${jogoLotoFacil.bolas[1]}&nbsp;
		&nbsp;${jogoLotoFacil.bolas[2]}&nbsp;
		&nbsp;${jogoLotoFacil.bolas[3]}&nbsp;		
		&nbsp;${jogoLotoFacil.bolas[4]}&nbsp;
		&nbsp;${jogoLotoFacil.bolas[5]}&nbsp;		
		&nbsp;${jogoLotoFacil.bolas[6]}&nbsp;
		&nbsp;${jogoLotoFacil.bolas[7]}&nbsp;		
		&nbsp;${jogoLotoFacil.bolas[8]}&nbsp;
		&nbsp;${jogoLotoFacil.bolas[9]}&nbsp;		
		&nbsp;${jogoLotoFacil.bolas[10]}&nbsp;
		&nbsp;${jogoLotoFacil.bolas[11]}&nbsp;		
		&nbsp;${jogoLotoFacil.bolas[12]}&nbsp;
		&nbsp;${jogoLotoFacil.bolas[13]}&nbsp;		
		&nbsp;${jogoLotoFacil.bolas[14]}&nbsp;
<br>

    </#list>

</div>
<#assign nextPage=(nextPage?number+1)>

<a href="/lotofacil/listar/${nextPage}">next page</a>





	</div>
    
<script>
$( ".scroll" ).append( "<p>Test</p>" );
</script>


    </body>
    
    
</html>