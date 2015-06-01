

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

${pagina}<br/>
${busca}

<span class="nextAction" style="visibility: hidden">
/lotofacil/listarInclude/${pagina}/${busca}
</span> 
<br>

