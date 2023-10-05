/**
 * 
 */

 function validar(){
	 let nome = frmContato.nome.value
	 let fone = frmContato.fone.value
	 if (nome == "") {
		 alert ('Preencher o campo nome')
		 frmContato.nome.focus()
		 return false
	 }else if(fone == "") {
		 alert ('Preencher o campo Telefone')
		 frmContato.fone.focus()
		 return false	 
 	}else {
		 document.forms["frmContato"].submit()
	 }
 }