<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>BooksCode - Java, JavaEE, SpringMVC e Java+</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
</head>
<body>
    <form:form 
        action="${s:mvcUrl('PC#create').build()}" 
        modelAttribute="produto" 
        method="POST" 
        enctype="multipart/form-data">
        <div>
            <label for="titulo">Título</label>
            <form:input id="titulo" path="titulo"/>
            <form:errors path="titulo"/>
        </div>
        <div>
            <label for="descricao">Descrição</label>
            <form:textarea path="descricao" id="descricao" cols="20" rows="10" />
            <form:errors path="descricao"/>
        </div>
        <div>
            <label for="paginas">Páginas</label>
            <form:input id="paginas" path="paginas" />
            <form:errors path="paginas"/>
        </div>
        <div>
            <label for="data-lancamento">Data de lançamento</label>
            <form:input id="data-lancamento" path="dataLancamento" />
            <form:errors path="dataLancamento" />
        </div>
        <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
            <div>
                <label>${tipoPreco}</label>
                <form:input path="precos[${status.index}].preco"/>
                <form:hidden path="precos[${status.index}].tipo" value="${tipoPreco}"/> 
            </div>
        </c:forEach>
        <div>
            <label for="sumario">Sumário</label>
            <input type="file" name="sumario" id="sumario">
        </div>
        <button type="submit">Cadastrar</button>
    </form:form>
</body>
</html>