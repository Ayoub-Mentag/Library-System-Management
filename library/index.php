<?php
    include('config/connect_db.php');
    if(isset($_POST['submit'])){
        $username = mysqli_real_escape_string($conn , $_POST['username']);
        $password = mysqli_real_escape_string($conn , $_POST['password']);
        $fname = mysqli_real_escape_string($conn , $_POST['fname']);
        $lname = mysqli_real_escape_string($conn , $_POST['lname']);
        $nCart = mysqli_real_escape_string($conn , $_POST['nCart']);
        $adress = mysqli_real_escape_string($conn , $_POST['adress']);
        $city = mysqli_real_escape_string($conn , $_POST['city']);
        $country = mysqli_real_escape_string($conn , $_POST['country']);
        $email = mysqli_real_escape_string($conn , $_POST['email']);
        $phone = mysqli_real_escape_string($conn , $_POST['phone']);
        $job = mysqli_real_escape_string($conn , $_POST['job']);
        $yearofstudy = mysqli_real_escape_string($conn , $_POST['yearofstudy']);
        $major = mysqli_real_escape_string($conn , $_POST['major']);
    
        $sql = "INSERT INTO member(user_name , password , prenom , nom , nCart , adresse , 
                            ville , pays , email, telephone , profession, anne_etude, specialite)
                           VALUES('$username' , '$password' , '$fname' , '$lname' , '$nCart' 
                    ,'$adress' , '$city' , '$country' , '$email' , '$phone' , '$job','$yearofstudy' ,'$major')";
    
        if(mysqli_query($conn , $sql)){
            //success
            echo 'Success';
        }
        else{
            //error
            echo 'Query error ' . mysqli_error($conn);
        }
        

}
?>

<!DOCTYPE html>



<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Formulaire</title>
</head>
<body>
    
    
   
    <header>
        <h1>Page d'inscription</h1>
    </header>
    <main>
        <form action="formulaire.php" method="POST">
            <div>
                <label for="user_name">Nom d'utilisateur</label>
                <input id="user_name" name="username" type="text" required/>    
            </div>
            <div>
                <label for="pass_word">Mot Passe</label>
                <input id="pass_word" name="password" type="password" required/>    
            </div>  
            <div>
                <label for="f_name">Prénom</label>
                <input id="f_name" name="fname" type="text" required/>    
            </div>  
            <div>
                <label for="l_name">Nom</label>
                <input id="l_name" name="lname" type="text" required/>    
            </div>
            <div>
                <label for="n_Cart">N° Carte National</label>
                <input id="n_Cart" name="nCart" type="text" required/>    
            </div>  
            <div>
                <label for="Adress">Adresse</label>
                <input id="Adress" name="adress" type="text" required/>    
            </div>  
            <div>
                <label for="City">Ville</label>
                <input id="City" name="city" type="text" required/>    
            </div>  
            <div>
                <label for="Country">Pays</label>
                <input id="Country" name="country" type="text" required/>    
            </div>  
            <div>
                <label for="Email">Email</label>
                <input id="Email" name="email" type="email" required/>    
            </div>  
            <div>
                <label for="Phone">Télephone</label>
                <input id="Phone" name="phone" type="tel" required/>    
            </div>  
            <div>
                <label for="Job">Profession</label>
                <input id="Job" name="job" type="text" required/>    
            </div> 
            <div>
                <label for="year_of_study">Année d'étude</label>
                <input id="year_of_study" name="yearofstudy" type="date" required/>    
            </div> 
            <div>
                <label for="Major">Spécialité</label>
                <input id="Major" name="major" type="text" required/>    
            </div>   
           <div>
            <input type="submit" name="submit" value="submit"/>
           </div>
        </form>
    </main>
</body>
</html>