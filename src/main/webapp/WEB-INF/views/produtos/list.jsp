<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <h1>BooksCode</h1>
    <div>${mensagem}</div>
     <table>
        <thead>
            <tr>
                <td>Título</td>
                <td>Descrição</td>
                <td>Páginas</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${produtos}" var="produto">
                <tr>
                    <td>
                        <a href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build()}">${produto.titulo}</a>
                    </td>
                    <td>${produto.descricao}</td>
                    <td>${produto.paginas}</td>
                </tr>
            </c:forEach>
        </tbody>
        <tfooter>
            <a href="/produtos/form">Criar</a>
        </tfooter>
    </table>
</body>
</html>