<?php 
require "connect.php";
$user_name = $_POST["user_name"];
$password = $_POST["password"];
$first_name = $_POST["First_Name"];
$last_name = $_POST["Last_Name"];
$phone_number1 = $_POST["Phone_Number1"];
$URL = $_POST["URL"];
$email_id = $_POST["Email_Id"];
$address = $_POST["Address"];
$mysql_userqry="Select * from `users` WHERE `User_Name`='$user_name'";

$result=mysqli_query($conn,$mysql_userqry);

if($result->num_rows>0){
    echo "User Name Already exits";
}
else{


$mysql_qry = "INSERT INTO `users`(`User_Name`, `password`, `First_Name`, `Last_Name`, `Email_id`, `Phone_Number1`, `URL`, `Address`) VALUES (?,?,?,?,?,?,?,?)";
$stmt=$conn->prepare($mysql_qry);
$stmt->bind_param("ssssssss",$user_name,$password,$first_name,$last_name,$email_id,$phone_number1,$URL,$address);
if($stmt->execute()){
    
    echo "Data Inserted Successfully";
}
else{
    echo "Oops! Something went wrong!!";
}
} 
 
?>