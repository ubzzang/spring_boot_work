<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div class="navbar-nav">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                            <a class="nav-link" href="/board/list">Board List</a>
                            <a class="nav-link" href="/board/register">Board Register</a>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
    </div>
    <div class="row content">
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Bno</label>
                        <input type="text" class="form-control" name="bno" id="exampleFormControlInput1"
                               value="${board.bno}" readonly>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Title</label>
                        <input type="text" class="form-control" name="title" id="exampleFormControlInput1"
                               value="${board.title}" readonly>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlTextarea1" class="form-label">Content</label>
                        <textarea class="form-control" name="content" id="exampleFormControlTextarea1"
                                  rows="3" readonly>value="${board.content}"</textarea>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Writer</label>
                        <input type="text" class="form-control" name="writer" id="exampleFormControlInput1"
                               value="${board.writer}" readonly>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">PostDate</label>
                        <input type="text" class="form-control" name="postdate" id="exampleFormControlInput1"
                               value="${board.postdate}" readonly>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Readcount</label>
                        <input type="text" class="form-control" name="readcount" id="exampleFormControlInput1"
                               value="${board.readcount}" readonly>
                    </div>
                    <div class="mb-3">
                        <button type="submit" class="btn btn-primary">Modify</button>
                        <button type="reset" class="btn btn-danger">Remove</button>
                        <button type="button" class="btn btn-info">List</button>
                        <script>
                            document.querySelector(".btn-info").addEventListener("click", function (e) {
                                self.location = "/board/list";
                            }, false)
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
            crossorigin="anonymous"></script>
</body>
</html>