/**
 * 
 */
 function maskTelefone (objeto){
	if(objeto.value.length == 0){
		objeto.value = objeto.value + '(';
	}
	if(objeto.value.length == 3){
		objeto.value = objeto.value + ')';
	}
	if(objeto.value.length == 8){
		objeto.value = objeto.value + '-';
	}
}

function maskData (objeto){
	if(objeto.value.length == 2){
		objeto.value = objeto.value + '/';
	}
	if(objeto.value.length == 5){
		objeto.value = objeto.value + '/';
	}
}

function maskCpf (objeto){
	if(objeto.value.length == 3){
		objeto.value = objeto.value + '.';
	}
	if(objeto.value.length == 7){
		objeto.value = objeto.value + '.';
	}
	if(objeto.value.length == 11){
		objeto.value = objeto.value + '-';
	}
}

function maskCnpj (objeto){
	if(objeto.value.length == 2){
		objeto.value = objeto.value + '.';
	}
	if(objeto.value.length == 6){
		objeto.value = objeto.value + '.';
	}
	if(objeto.value.length == 10){
		objeto.value = objeto.value + '/';
	}
	if(objeto.value.length == 15){
		objeto.value = objeto.value + '-';
	}
}
				
function onlyNum(e){
		tecla = (window.event)?event.keyCode:e.which;
		if ((tecla > 47 && tecla < 58)){
			return true;
		}
		else{
			if ((tecla > 95 && tecla < 106)){
				return true;
			}
			else{
				if (tecla == 8 || tecla == 46){
					return true;
				}
				else{
					return false;	
				}
			}	
		}
}