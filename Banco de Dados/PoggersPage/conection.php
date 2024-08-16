<?php

function conectBD(){
    $servername = "localhost";
    $username = "id7450078_poggerstv";
    $password = "poggerstv1317";
    $database = "id7450078_bd";

    try {
        $conn = new PDO("mysql:host=$servername;dbname=$database", $username, $password);
        // set the PDO error mode to exception
        $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $link = mysqli_connect($servername, $username, $password, $database);
        echo "Connected successfully";
    } catch(PDOException $e) {
        echo "Connection failed: " . $e->getMessage();
    }
    return $link;
}

/*$SQL = "SELECT * FROM `Usuarios` WHERE 1";
$RS = mysqli_query($link, $SQL);
echo mysqli_error($link);
$RF = mysqli_fetch_array($RS);

echo '<pre>';
print_r($RF[0]);
echo '</pre>';

echo '<pre>';
print_r($RF[1]);
echo '</pre>';*/
?>

