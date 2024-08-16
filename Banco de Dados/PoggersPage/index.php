<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SHOW VIDEO</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="classes.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">POGGERS TV</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
            </ul>
            <ul class="navbar-nav my-lg-0 mr-sm-2">
                <li class="nav-item">
                    <a class="nav-link" href="#">Cadastrar</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="Usuário" placeholder="Usuário" aria-label="Usuário">
                <input class="form-control mr-sm-2" id="inputPassword2" type="password" placeholder="Senha" aria-label="Senha">
                <button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Entrar</button>
            </form>
        </div>
    </nav> <!--Barra com links e pesquisa-->
    <div>
        <form>
            <div class="form-control-lg my-lg-2 mr-sm-3">
                <label>Pesquisar</label>
                <input type="text" class="form-control my-lg-10" id="search" aria-describedby="Pesquisar"
                       placeholder="Pesquisar">
                <small id="text" class="form-text text-muted">Procure pela sua série favorita</small>
            </div>
        </form>
    </div> <!-- Barra de pesquisa-->
    <div style="padding-top: 10%">
        <form>
            <ul class="list-group list-group-item-dark">
                <li class="list-group-item">
                    <form class="form-inline">
                        <img src="//img.youtube.com/vi/g0ueF0HYNi4/0.jpg" class="img-fluid tumb" alt="Responsive image">
                        <titulo class="text_tumb">Texto aqui</titulo>
                    </form>
                </li>
                <li class="list-group-item">
                    <form class="form-inline">
                        <img src="//img.youtube.com/vi/g0ueF0HYNi4/0.jpg" class="img-fluid tumb" alt="Responsive image">
                        <titulo class="text_tumb">Texto aqui</titulo>
                    </form>
                </li>
                <li class="list-group-item">
                    <form class="form-inline">
                        <img src="//img.youtube.com/vi/g0ueF0HYNi4/0.jpg" class="img-fluid tumb" alt="Responsive image">
                        <titulo class="text_tumb">Texto aqui</titulo>
                    </form>
                </li>
                <li class="list-group-item">
                    <form class="form-inline">
                        <img src="//img.youtube.com/vi/g0ueF0HYNi4/0.jpg" class="img-fluid tumb" alt="Responsive image">
                        <titulo class="text_tumb">Texto aqui</titulo>
                    </form>
                </li>
                <li class="list-group-item">

                </li>
            </ul>
        </form>
    </div> <!-- Lista de mais visualizados ou pesquisados-->
</body>
</html>