<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Оплата</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
</head>
<body class="container">
    <form method="post" action="/">
        <div class="row">
            <div class="col-auto">
                <h2 class="form-signin-heading" style="margin-top: 40px">Оплата</h2>
            </div>
        </div>
        <p>
            <label for="amount" class="sr-only">Сумма</label>
            <input type="number" id="amount" name="amount" class="form-control" placeholder="Сумма" required min="0.01" step="0.01" autofocus>
        </p>
        <p class="mb-5">
            <label for="currency" class="sr-only">Валюта</label>
            <input type="text" id="currency" name="currency" class="form-control" placeholder="Валюта" required>
        </p>
        <button class="btn-block" type="submit">Оплатить</button>
    </form>
</body>
</html>