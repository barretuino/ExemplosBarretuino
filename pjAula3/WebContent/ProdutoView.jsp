<%@ 
	page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Produto</title>
</head>
<body>
	<form method="POST" action="./ProdutoController">
	  <p>Código <input type="text" name="codigo" size="40"></p>
	  <p>Descrição <input type="text" name="descricao" size="40"></p>
	  <p>Unidade Medida <select name="unidadeMedida" id="unidadeMedida">
		  <option value="1">kg</option>
		  <option value="2">un</option>
		  <option value="3">lt</option>
		  <option value="4">m</option>
		  <option value="5">pc</option>
		</select>
	  <p>Data de Cadastro <input type="date" name="dataCadastro" size="40"></p>
	  <p>Departamento <select name="departamento" id="departamento">
		  <option value="1">Bebidas</option>
		  <option value="2">Frios</option>
		  <option value="3">Cereais</option>
		</select>
	  <p>Ativo <input type="checkbox" name="ativo"></p>
	  <p><input type="submit" value="Submit"> <input type="reset" value="Reset"></p>
	  <input type="reset" value="Limpar"></td></tr></table></center>
	</form>
</body>
</html>