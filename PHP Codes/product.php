<?php 
require "connect.php";
$Product_name = $_POST["Product_Name"];
$production_date = $_POST["Production_Date"];
$expiration_date = $_POST["Expiration_Date"];
$location = $_POST["Location"];
$User_Id = $_POST["User_Id"];
$QR_String = $_POST["QR_string"];

$mysql_qry = "INSERT INTO `Products`(`Product_Name`, `Production_Date`, `Expiration_Date`, `Location`, `QR_String`, `User_ID`) VALUES ('$Product_name','$production_date','$expiration_date','$location','$QR_String','$User_Id')";
if($conn->query($mysql_qry)=== TRUE){
    
    echo "Product Inserted Successfully";
}
else{
    echo "Oops! Something went wrong!!";
}
 
?>