<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>BooksCode - Java, JavaEE, SpringMVC e Java+</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
</head>
<body>
    <form action="/produtos" method="POST">
        <div>
            <label for="titulo">Título</label>
            <input id="titulo" type="text" name="titulo">
        </div>
        <div>
            <label for="descricao">Descrição</label>
            <textarea name="descricao" id="descricao" cols="20" rows="10"></textarea>
        </div>
        <div>
            <label for="paginas">Páginas</label>
            <input type="text" id="paginas" name="paginas">
        </div>
        <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
            <div>
                <label>${tipoPreco}</label>
                <input type="text" name="precos[${status.index}].preco">
                <input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}"> 
            </div>
        </c:forEach>
        <button type="submit">Cadastrar</button>
    </form>
</body>
</html>