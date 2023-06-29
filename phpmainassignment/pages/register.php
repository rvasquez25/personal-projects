<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../styles.css">
</head>

<body>
    <div class="container">
        <div class="box">
            <h3>Register</h3>
            <form action="">
                <label>Username</label>
                <input type="text" name="username" placeholder="username">
                <label>Email</label>
                <input type="email" name="email" placeholder="email">
                <label>Password</label>
                <input type="password" name = "password" placeholder="password">

                <button>Login</button>
            </form>
        </div>
    </div>
</body>
</html>

<?php
    if (extract($_REQUEST)!= null) {
        $file = fopen("../textfiles/form.txt", "a");

        // fwrite($file, "Username :");
        
        fwrite($file, $username . "\n");
        // fwrite($file, "Email :");
        // fwrite($file, $email . "\n");
        // fwrite($file, "Password :");
        fwrite($file, $password . "\n");

        fclose($file);
    }
?>