

   <#list lista["jogos"] as jogoLotoFacil>

        &nbsp;${jogoLotoFacil.concurso}&nbsp;
		&nbsp;${jogoLotoFacil.data?date}&nbsp;
		&nbsp;${jogoLotoFacil.ganhadores}&nbsp;
		&nbsp;${jogoLotoFacil.numeros[0]}&nbsp;
		&nbsp;${jogoLotoFacil.numeros[1]}&nbsp;
		&nbsp;${jogoLotoFacil.numeros[2]}&nbsp;
		&nbsp;${jogoLotoFacil.numeros[3]}&nbsp;		
		&nbsp;${jogoLotoFacil.numeros[4]}&nbsp;
		&nbsp;${jogoLotoFacil.numeros[5]}&nbsp;		
		&nbsp;${jogoLotoFacil.numeros[6]}&nbsp;
		&nbsp;${jogoLotoFacil.numeros[7]}&nbsp;		
		&nbsp;${jogoLotoFacil.numeros[8]}&nbsp;
		&nbsp;${jogoLotoFacil.numeros[9]}&nbsp;		
		&nbsp;${jogoLotoFacil.numeros[10]}&nbsp;
		&nbsp;${jogoLotoFacil.numeros[11]}&nbsp;		
		&nbsp;${jogoLotoFacil.numeros[12]}&nbsp;
		&nbsp;${jogoLotoFacil.numeros[13]}&nbsp;		
		&nbsp;${jogoLotoFacil.numeros[14]}&nbsp;
<br>
    </#list>

${pagina}<br/>
${busca}

<span class="nextAction" style="visibility: hidden">
/jogatina/listarInclude/${pagina}/${busca}
</span> 
<br>

