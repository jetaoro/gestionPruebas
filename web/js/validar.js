
/**
Funci�n que indica si una cadena es vacia
*/
function esVacio(val){
        val = trim(val);
  	return val == null || val == '';
}

/**
 Funci�n que hace un limpia espacios al inicio y al final de una cadena
 */
function trim(cadena) {
    if (cadena != null) {
        cadena = "" + cadena;
        cadena = cadena.replace(/(^\s+)|(\s+$)/g, "");
    }
    return cadena;
}


function printString(cadena, defecto) {
    if (typeof cadena == 'string' && cadena.length > 0)
        return cadena;
    if (typeof defecto == 'string')
        return defecto;
    return "";
}

/**
Funci�n que indica cuantos elementos checkbox
del formulario 'form' con el nombre 'nombre' 
fueron seleccionados
*/
function validarCheck(form, nombre) {
	var frm = document.forms[ form ];
	var objs = frm.elements[ nombre ];
        if (objs != null) {
	if ( esVacio( objs.length ) ) {
		if ( objs.checked && objs.type == 'checkbox' )
			return 1;
	} else {
		var cont = 0;
		for ( var i = 0; i < objs.length; i++ ) {
			if ( objs[ i ].checked && objs[ i ].type == 'checkbox' )
				cont++;
		}
		return cont;
	}
        }
	return 0;
}

/**
Funci�n que indica si un elemntto radioButton
del formulario 'form' con el nombre 'nombre' fue seleccionado
*/
function validarRadio(nfrm, nombre) {
	var frm = document.forms[nfrm];
	var objs = frm.elements[nombre];
        
        if (objs == null)
            return false;

	if (esVacio(objs.length)) {
		if (objs.checked && objs.type == 'radio')
			return true;
	} else {
		for (var i = 0; i < objs.length; i++) {
			if (objs[ i ].checked && objs[ i ].type == 'radio')
				return true;
		}
	}
	return false;
}

function validarSelect(nfrm, nombre){      
        if (document.forms.nfrm.nombre.length==0){             
            return false 
        } 
        return true         
}

/**
Funci�n que chequea elementos checkbox 
del formulario 'form' con el nombre 'nombre'
*/
function chequearTodos(form, nombre, checked) {
    var frm = typeof form == "string" ? document.forms[ form ]: form;
    var objs = frm.elements[ nombre ];
    if ( esVacio( objs.length ) ) {
        if (objs.type == 'checkbox' )
            objs.checked = checked;

    } else {
        for ( var i = 0; i < objs.length; i++ ) {
            if ( objs[ i ].type == 'checkbox' )
                objs[ i ].checked = checked;
        }
    }
}

/**
Funci�n que indica si la cadena indicada 
corresponde a un n�mero entero
*/
function esEntero(cad) {
	return parseInt(cad, 10) == cad;
}

/**
Funci�n que indica si la cadena indicada
corresponde a un n�mero de punto flotante
*/
function esDecimal(cad) {
	return parseFloat(cad) == cad;
}


var digitos = '0123456789';
var mayusculas = 'ABCDEFGHIJKLMN�OPQRSTUVWXYZ';
var minusculas = 'abcdefghijklmn�opqrstuvwxyz '; //ojo esta l�nea incluye el espacio en blanco como letra

/**
Funcion que indica si un caracter es un digito
*/
function esDigito(cad) {
	if (cad.length != 1)
		return false;
	return digitos.indexOf(cad) != -1;
}

/**
Funcion que indica si un caracter es una letra
*/
function esLetra(cad) {
	if (cad.length != 1)
		return false;
	if (mayusculas.indexOf( cad ) != -1)
		return true;
	if (minusculas.indexOf( cad ) != -1)
		return true;
	return false;	
}

/**
Funci�n que indica si un texto es alfab�tico
el espacio lo tienen en cuenta como letra
*/
function esAlfabetico(cad) {
	if (esVacio( cad ))
		return false;
	for (var i = 0; i < cad.length; i++) {
		if (!esLetra(cad.charAt(i)))
			return false;
	}
	return true;
}

/**
Funci�n que indica si una texto es alfab�tico-num�rico
el espacio lo tienen en cuenta como letra
*/
function esAlfanumerico(cad) {
	if (esVacio(cad))
		return false;
	for (var i = 0; i < cad.length; i++) {
		var c = cad.charAt(i);
		if (!esLetra(c) && !esDigito(c))
			return false;
	}
	return true;
}	


/**
Funcion que indica si una cadena
contiene la sintaxis correcta de una
direcci�n de email
*/
function esEmail(cad) {
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test( cad ) )
		return true;
	else
		return false;
}

/**
M�todo que verifica que una cadena tenga un formato de fecha v�lido
@param fecha fecha en formato dd-MM-yyyy
@param si la fecha tiene un formato v�lido, false en caso contrario
*/
function validarFecha(fecha) {
    if (fecha == null || fecha.length != 10)
        return false;
    fecha = fecha.replace("/", "-");
    var arrFecha = fecha.split("-");
    return validarFechaDMY(arrFecha[0], arrFecha[1], arrFecha[2]);
}

/**
Funci�n que indica si una fecha es v�lida
*/
function validarFechaDMY(dia, mes, ano){
        if (!esEntero(dia))
            return false;
        if (!esEntero(mes))
            return false;
        if (!esEntero(ano))
            return false;

	valida = false;
        var nDia = parseInt(dia, 10);
        var nMes = parseInt(mes, 10);
        var nAno = parseInt(ano, 10);

	switch (nMes) {
		case 2: //febrero
			if (nDia <= 28) 
				valida = true;
			else if (nDia == 29 && nAno % 4 == 0)
				valida = true;
			break;
		case 4: //meses de 30 d�as
		case 6:
		case 9:
		case 11:
			valida = nDia <= 30;
			break;
		case 1: //meses de 31 d�a
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			valida = nDia <= 31;
			break;
	};
	return valida;
}

/**
  *M�todo que dada una fecha en formato DD-MM-YYYY
  *la convierte al formato YYYY-MM-DD
  *@param fecha fecha en formato DD-MM-YYYY
  *@return la fecha en formato YYYY-MM-DD, vacio si el la fecha no tiene formato DD-MM-YYYY
  */
function invertirFecha(fecha) {
    var inv = "";

    if (fecha == null || fecha.length != 10)
        return inv;

    inv = fecha.substring(6);
    inv += "-" + fecha.substring(3, 5);
    inv += "-" + fecha.substring(0, 2);
    return inv;
}

/**
  *M�todo que dada una fecha en formato DD-MM-YYYY
  *la convierte al formato YYYY-MM-DD
  *@param fechaHora fecha en formato DD-MM-YYYY HH:MM
  *@return la fecha en formato YYYY-MM-DD, vacio si el la fecha no tiene formato DD-MM-YYYY
  */
function invertirFechaHora(fechaHora) {
    var inv = "";

    if (fechaHora == null || fechaHora.length != 16)
        return inv;

    var fecha = invertirFecha(fechaHora.substring(0, 10));
    var hora = fechaHora.substring(10);
    return fecha + hora;
}

/**
M�todo que valida si una hora es v�lida
@param hora hora en formato HH:mm
@return true si tiene un formato de hora v�lido, false en caso contrario
*/
function validarHora(hora) {
    if (hora == null || hora.length != 5)
        return false;
    var arrHora = hora.split(":");
    return validarHoraHM(arrHora[0], arrHora[1]);
}

/**
M�todo que valida si una hora es v�lida
@param hora hora
@param min minutos
@return true si hora y minutos son v�lidos
*/
function validarHoraHM(hora, min) {
    if (!esEntero(hora))
        return false;
    if (!esEntero(min))
        return false;
    if (min.length != 2)
        return false;
    var nHora = parseInt(hora, 10);
    var nMin = parseInt(min, 10);
    if (nHora < 0 || nHora > 23)
        return false;
    if (nMin < 0 || nMin > 59)
        return false;
    return true;
}

/**
M�todo que verifica que una fecha tenga formato de fecha hora v�lido
@param fechaHora cadena con la fecha y la hora en formato dd-MM-yyyy HH:mm
@return true si tiene un formato de fecha v�lido, false en caso contrario
*/
function validarFechaHora(fechaHora) {
    if (fechaHora == null || fechaHora.length != 16 || fechaHora.charAt(10) != ' ')
        return false;
    fecha = fechaHora.substring(0, 10);
    hora = fechaHora.substring(11);
    return validarFecha(fecha) && validarHora(hora);
}


/**
M�todo que permite obtener los elementos de un formulario
retornando siempre un array
@param frm formulario al cual se le van a obenter los elementos
@param nombre nombre de los elementos a obtener
*/
function obtenerElementos(frm, nombre) {
    var objs = frm.elements[nombre];

    if (objs == null)
        return null;

    //si existe s�lo un elemento
    if (!esVacio(objs.length))
        return objs;

    var array = new Array();
    array[ 0 ] = objs;
    return array;
}

/**
M�todo que valida que un nombre de archivo tenga una extenci�n acorde con un patr�n
@param archivo nombre del archivo
@param patron patron para la extenci�n del archivo
@return true si el nombre del archivo tiene una extenci�n acorde con patr�n, false en caso contrario
*/
function validarExtension(nombre, patron) {
    nombre = nombre.replace("\\", "/");
    return eval("/\.(" + patron + ")$/i.test('" + nombre + "')");
}

//----------------------VISIBILIDAD DE ELEMENTOS POR ID--------------------

/**
 *M�todo que establece la visibilidad de un elemento
 *@param id identificador del elemento
 *@param visible indica si el elemento debe ser o no visible (true|false)
 */
function setVisible(id, visible) {
    var obj = document.getElementById(id);
    if (obj == null) {
        alert("El elemento " + id + " No fue encontrado");
        return;
    }

    if (visible)
        obj.style.display = "block";
    else
        obj.style.display = "none";
}

//-------------------------------FUNCIONES COMBOS--------------------------

/**
 *M�todo que selecciona en un combo el valor indicado
 */
function seleccionarCombo(cmb, val){
    for (var i = 0; i < cmb.length; i++) {
        if (cmb.options[i].value == val)
            cmb.selectedIndex = i;
    }
}

//--------------------FUNCIONES PARA VALIDACIONES DEL TECLADO-------------------

/**
*M�todo que retorna el c�digo de la tecla digitada
*/
function obtenerCodigoTecla(e){
    var digito = -1;
    if (e && e.which) {
        //CTR-C, CTR-V
        if (e.ctrlKey && (e.which == 99 || e.which == 118))
            digito = -1;
        else
            digito = e.which; // NS
    } else if (window.event && window.event.keyCode)
        digito = window.event.keyCode; // IE
    return digito;
}

/**
*Restringe la entrada solo a digitos 0-9, s�lo para enteros
*/
function valorEntero(e) {
    var digito = obtenerCodigoTecla(e);
    return (digito > -1 ? (( digito == 8 ) || (digito > 47 && digito < 58)) : true);
}

/**
*Restringe la entrada a los caracteres 0-9 y '.', s�lo para decimales
*/
function valorDecimal(e) {
    var digito = obtenerCodigoTecla(e);
    return (digito > -1 ? (digito == 8 || digito == 46 || (digito > 47 && digito < 58)) : true);
}

/**
*Restringe la entrada a los caracteres A-Z y a-z y ' ', s�lo para cadenas alfabeticas
*/
function valorAlfabetico(e) {
    var digito = obtenerCodigoTecla(e);
    return (digito > -1 ? (digito == 8 || digito == 32 || (digito >= 65  && digito <= 90) || (digito >= 97  && digito <= 122)) : true);
}

/**
*Restringe la entrada a los caracteres A-z, a-z, 0-9 y ' ', s�lo para cadenas alfanum�ricas
*/
function valorAlfanumerico(e) {
    var digito = obtenerCodigoTecla(e);
    return (digito > -1 ? (digito == 8 || digito == 32 || digito == 45 || (digito > 47 && digito < 58) || (digito >= 65  && digito <= 90) || (digito >= 97  && digito <= 122)) : true);
}

/**
*M�todo para dar formato de moneda a los n�meros
*/
function formatoMoneda(strValue) {
    strValue = strValue.toString().replace(/\$|\,/g, '');
    dblValue = parseFloat(strValue);
    blnSign = (dblValue == (dblValue = Math.abs(dblValue)));
    dblValue = Math.floor( dblValue * 100 + 0.50000000001 );
    intCents = dblValue % 100;
    strCents = intCents.toString();
    dblValue = Math.floor(dblValue / 100).toString();
    if ( intCents < 10 )
            strCents = "0" + strCents;
    for (var i = 0; i < Math.floor( ( dblValue.length - ( 1 + i ) ) / 3); i++)
            dblValue = dblValue.substring(0, dblValue.length - ( 4 * i + 3 ) ) + ','+
            dblValue.substring(dblValue.length - ( 4 * i + 3 ));
    return ( ( (blnSign) ? '': '-') + '$ ' + dblValue + '.' + strCents);
}

function ltrim(s) {
    if (s == null)
        return s;
    s = "" + s;
    return s.replace(/^\s+/, "");
}

function rtrim(s) {
    if (s == null)
        return s;
    s = "" + s;
    return s.replace(/\s+$/, "");
}


