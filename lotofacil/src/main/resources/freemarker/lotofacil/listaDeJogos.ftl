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
		<#include "/lotofacil/listaDeJogosInclude.ftl" />	
	</div>

<#assign nextPage=(nextPage?number+1)>

<form id="nextPageForm" action="/lotofacil/listar/${nextPage}" method="get">
	<input type="submit" value="post ${nextPage}" />
	
</form>


<a href="/lotofacil/listar/${nextPage}">next page</a>

<input type="button" value="next" class="buttonNext"/>



	</div>
	
	
<script type="text/javascript">
    var frm = $('#nextPageForm');
    frm.submit(function (ev) {
        $.ajax({
            type: frm.attr('method'),
            url: frm.attr('action'),
            data: frm.serialize(),
            success: function (data) {
                $(".scroll" ).append( data );
            }
        });

        ev.preventDefault();
    });
</script>	
    
<script>
$(".scroll" ).append( "<p>Test</p>" );
$(".buttonNext").click(function () {
$(".scroll").append("New Content!");
});
</script>


    </body>
    
    
</html>