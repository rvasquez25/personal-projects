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
            <h3>Login</h3>
            <form action="">
                <label>Username</label>
                <input type="text" name="username" placeholder="username">
                <label>Password</label>
                <input type="password" name = "password" placeholder="password">

                <button>Login</button>
            </form>
        </div>
    </div>
</body>
</html>

<?php
    extract($_REQUEST);
    $myfile = fopen("../textfiles/form.txt", "r") or die("Unable to open file!");
    $accounts = [];
    while ($line = fgets($myfile)) {
        array_push($accounts, $line);
    }
    // for ($i = 0; $i < sizeof($accounts); $i++) {
    if (in_array($username . "\n", $accounts) && in_array($password . "\n", $accounts)) 
    {
        header("Location: ../ztunes/index.php");
        exit();
    }
    else {
        echo("INCORRECT");
    }
    // }
    // unset($songs[0]);
    // print_r($accounts[1]);
    // for ($i = 0; $i < sizeof($accounts); $i++)
    // {
    //     $username = [];
    //     $password = [];
    //     // if ($accounts[$i] != "\n" && $accounts[$i] != "\n\n") {
    //     if ($i % 2 != 0 || $i == 0) {
    //         // echo("Username: ");
    //         array_push($username, $accounts[$i]);
    //     }
    //     else {
    //         // echo("Password: ");
    //         array_push($password, $accounts[$i]);
    //     }
    //     // }
    // }
    // echo sizeof($username);
    // echo sizeof($password);
    // for ($i = 0; $i < sizeof($username); $i++) {
    //     echo $username[$i];
    // }
    // for ($i = 0; $i < sizeof($password); $i++) {
    //     echo $password[$i];
    // }
    // print_r($username);
    // echo "end user";
    // echo $password;
    // print_r("end pwd");
?>
