<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../reset.css">
    <link rel="stylesheet" href="../layout.css">
    <link rel="stylesheet" href="../styles.css">
    <link rel="stylesheet" href="../media-queries.css">
</head>
<body>
    <!-- <header>
        <div class="container">
          <nav>
              <ul>
                <li><img src="../images/apple-logo.png" alt="apple logo"></li>
                <li><a href="#">Mac</a></li>
                <li><a href="#">iPad</a></li>
                <li><a href="#">iPhone</a></li>
                <li><a href="#">Watch</a></li>
                <li><a href="#">TV</a></li>
                <li><a href="#" class="active">Music</a></li>
                <li><a href="#">Support</a></li>
                <li><img src="../images/search.png" alt="search"></li>
                <li><img src="../images/shopping-bag.png" alt="shop"></li>
              </ul>
          </nav>
        </div>
      </header> -->
      <!-- <section class="slide-99">
        <div class="container">
            <h1>
                <span>DOWNLOADS</span>
            </h1>
        </div>
    </section> -->
      <!-- Header -->
  <header>
    <div class="container">
      <nav>
          <ul>
            <li><img src="../images/apple-logo.png" alt="apple logo"></li><!--
            --><li><a href="#" class="active">Download</a></li><!--
            --><li><a href="./library.php">MyLibrary</a></li><!--
            --><li><img src="../images/search.png" alt="search"></li><!--
            --><li><img src="../images/shopping-bag.png" alt="shop"></li>
          </ul>
      </nav>
    </div>
  </header>
    <!-- ALBUMS SECTION -->
    <section class="albums">
        <div class="albums-container">
          <div class="albums-content">
            <h2>Looking for music?</h2>
            <p>Start listening to the best new releases.</p>
            <!-- <button>LAUNCH WEB PLAYER</button> -->
          </div>
          <div class="albums-cards-container">
            <!-- J. Cole -->
            <div class="album jcole">
              <img src="../images/immortal-jcole.png" />
              <div class="album-info">
                <h2>Immortal</h2>
                <h4>J. Cole</h4>
                <!-- <a href="#">PLAY NOW</a> -->
                <?php
                  if(isset($_POST['button1'])) {
                    $myfile = fopen("../userLibraries/libraries/mylibrary.txt", "a") or die("Unable to open file!");
                    $txt = "Immortal J. Cole\n";
                    fwrite($myfile, $txt);
                    fclose($myfile);
                  }
                ?>
                <div class="downloadPage">
                  <form method="post">
                      <input type="submit" name="button1"
                              value="Download"/>
                  </form>
                </div>
                <!-- <a href = "./login.php">Downlaod</a> -->
              </div>
            </div>
            <!-- Kanye -->
            <div class="album kanye">
              <img src="../images/kanyewest.jpg\n" />
              <div class="album-info">
                <h2>Violent Crimes</h2>
                <h4>Kanye West</h4>
                <?php
      
                  if(isset($_POST['button2'])) {
                    $myfile = fopen("../userLibraries/libraries/mylibrary.txt", "a") or die("Unable to open file!");
                    $txt = "Violent Crimes - Kanye West";
                    fwrite($myfile, $txt);
                    fclose($myfile);
                  }
                ?>
                <a href = "./login.php">Downlaod</a>
              </div>
            </div>
            <!-- Playboi Carti -->
            <div class="album carti">
              <img src="../images/carti.jpg" />
              <div class="album-info">
                <h2>Foreign</h2>
                <h4>Playboi Carti</h4>
                <a href="#">PLAY NOW</a>
              </div>
            </div>
            <!-- Kendrick Lamar -->
            <div class="album kendrick">
              <img src="../images/kendrick.jpg" />
              <div class="album-info">
                <h2>The Recipe - Bonus Track</h2>
                <h4>Kendrick Lamar, Dr. Dre</h4>
                <a href="#">PLAY NOW</a>
              </div>
            </div>
            <!-- Mac Miller -->
            <div class="album miller">
              <img src="../images/miller.jpg" />
              <div class="album-info">
                <h2>Day Before (with Mac Miller)</h2>
                <h4>Young Thug, Mac Miller</h4>
                <a href="#">PLAY NOW</a>
              </div>
            </div>
            <!-- tyler -->
            <div class="album tyler">
              <img src="../images/tyler.jpg" />
              <div class="album-info">
                <h2>NEW MAGIC WAND</h2>
                <h4>Tyler, The Creator</h4>
                <a href="#">PLAY NOW</a>
              </div>
            </div>
          </div>
        </div>
      </section>
      <footer>
        <div class="container">
          <hr>
    
          <div class="row">
            <div class="col-2">
              <h3>Shop and Learn</h3>
              <ul>
                <li><a href="#">Mac</a></li>
                <li><a href="#">iPad</a></li>
                <li><a href="#">iPhone</a></li>
                <li><a href="#">Watch</a></li>
                <li><a href="#">TV</a></li>
                <li><a href="#">Music</a></li>
                <li><a href="#">iTunes</a></li>
                <li><a href="#">HomePod</a></li>
                <li><a href="#">Ipod Touch</a></li>
                <li><a href="#">Apple Card</a></li>
                <li><a href="#">Accessories</a></li>
                <li><a href="#">Gift Cards</a></li>
              </ul>
            </div>
    
            <div class="col-2">
              <h3>Apple Store</h3>
              <ul>
                <li><a href="#">Find a Store</a></li>
                <li><a href="#">Genius Bar</a></li>
                <li><a href="#">Today at Apple</a></li>
                <li><a href="#">Apple Camp</a></li>
                <li><a href="#">Field Trip</a></li>
                <li><a href="#">Apple Store App</a></li>
                <li><a href="#">Refurbished and Clearance</a></li>
                <li><a href="#">Financing</a></li>
                <li><a href="#">Apple Trade In</a></li>
                <li><a href="#">Order Status</a></li>
                <li><a href="#">Shopping help</a></li>
              </ul>
            </div>
    
            <div class="col-2">
              <h3>For Education</h3>
              <ul>
                <li><a href="#">Apple and Education</a></li>
                <li><a href="#">Shop for College</a></li>
              </ul>
    
              <h3>For Business</h3>
              <ul>
                <li><a href="#">Apple and Business</a></li>
                <li><a href="#">Shop for Business</a></li>
              </ul>
    
              <h3>For Healthcare</h3>
              <ul>
                <li></li>
                <li><a href="#">Apple in Healthcare</a></li>
                <li><a href="#">Health on Apple Watch</a></li>
                <li><a href="#">Health Records on iPhone</a></li>
              </ul>
            </div>
    
            <div class="col-2">
              <h3>Account</h3>
              <ul>
                <li><a href="#">Manage Your Apple ID</a></li>
                <li><a href="#">Apple Store Account</a></li>
                <li><a href="#">iCloud.com</a></li>
              </ul>
    
              <h3>Apple Values</h3>
              <ul>
                <li><a href="#">Accessebility</a></li>
                <li><a href="#">Education</a></li>
                <li><a href="#">Environment</a></li>
                <li><a href="#">Inclusion and Diversity</a></li>
                <li><a href="#">Privacy</a></li>
                <li><a href="#">Supplier Responsibility</a></li>
              </ul>
            </div>
            
            <div class="col-2">
              <h3>For Government</h3>
              <ul>
                <li><a href="#">Shop for Government</a></li>
                <li><a href="#">Shop for Veterans and Military</a></li>
              </ul>
    
              <h3>About Apple</h3>
              <ul>
                <li><a href="#">Newsroom</a></li>
                <li><a href="#">Apple Leadership</a></li>
                <li><a href="#">Job Oppertunities</a></li>
                <li><a href="#">Investors</a></li>
                <li><a href="#">Events</a></li>
                <li><a href="#">Contact Apple</a></li>
              </ul>
            </div>
          </div>
    
          <p>More ways to shop: <a href="#">Visit an Apple Store</a>, call 1-800-MY-APPLE, or <a href="#">find a reseller</a>.</p>
    
          <hr>
    
          <small>Copyright © 2019 Apple Inc. All rights reserved.</small>
    
          <ul class="footer-nav">
            <li><a href="#">Privacy Policy</a></li>
            <li><a href="#">Terms of Use</a></li>
            <li><a href="#">Sales and Refunds</a></li>
            <li><a href="#">Legal</a></li>
            <li><a href="#">Site Map</a></li>
          </ul>
        </div>
      </footer>
</body>
</html>