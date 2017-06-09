<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Users</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
            crossorigin="anonymous">

    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1>Users</h1>
                </div>
            </div>
            <div class="row">

                <div class="col-sm-6">
                    <form action="/users" method="POST">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Name</label>
                            <input class="form-control" type="text" name="name" />
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Age</label>
                            <input class="form-control" type="number" name="age" />
                        </div>

                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
                <div class="col">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Age</th>
                            </tr>
                        </thead>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.name}</td>
                                <td>${user.age}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>

            <div class="row">
                <div class="col-12">

                </div>
            </div>

        </div>

    </body>

    </html>