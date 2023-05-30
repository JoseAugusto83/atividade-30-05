<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Novo Livro</title>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1>Atualizar Livro</h1>
            <a href="/produto" class="btn btn-primary">Voltar</a>
            <form action="/update" method="post">
                <input type="hidden" name="id" value="${produto.id}">
                <div class="form-group">
                    <label for="titulo">Titulo</label>
                    <input type="text" name="titulo" class="form-control" value="${produto.titulo}">
                    <input type="text" name="descricao" class="form-control" value="${produto.descricao}">
                </div>
                <br>
                <button type="submit" class="btn btn-success">Salvar</button>
            </form>
        </div>
    </body>

</html>
