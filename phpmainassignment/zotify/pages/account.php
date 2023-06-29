<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Music for everyone - Zotify</title>
    <link rel="icon" href="../images/favicon.ico" />
    <link
      href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;500;700&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="../css/styles.css" />
    <link rel="stylesheet" href="../css/media-queries.css" />
  </head>
  <body>
    <!-- HEADER -->
    <header>
      <div class="header-container">
        <div class="header-logo">
          <img src="../images/spotify-logo.svg" />
        </div>
        <!-- This is the menu that will be shown on mobile devices -->
        <nav class="nav-mobile">
          <!-- Profile -->
          <div class="profile">
            <svg viewBox="0 0 1024 1024" class="profile-icon">
              <path
                d="M730.06 679.64q-45.377 53.444-101.84 83.443t-120 29.999q-64.032 0-120.75-30.503t-102.6-84.451q-40.335 13.109-77.645 29.747t-53.948 26.722l-17.142 10.084Q106.388 763.84 84.96 802.41t-21.428 73.107 25.461 59.242 60.754 24.705h716.95q35.293 0 60.754-24.705t25.461-59.242-21.428-72.603-51.679-57.225q-6.554-4.033-18.907-10.84t-51.427-24.453-79.409-30.755zm-221.84 25.72q-34.285 0-67.561-14.873t-60.754-40.335-51.175-60.502-40.083-75.124-25.461-84.451-9.075-87.728q0-64.032 19.915-116.22t54.452-85.964 80.67-51.931 99.072-18.151 99.072 18.151 80.67 51.931 54.452 85.964 19.915 116.22q0 65.04-20.167 130.58t-53.948 116.72-81.426 83.443-98.568 32.268z"
              ></path>
            </svg>
          </div>
          <!-- Hamburger menu -->
          <input type="checkbox" class="toggler" />
          <div class="hamburger-menu"><div></div></div>
          <div class="menu">
            <div class="background-overlay"></div>
            <div class="menu-overlay">
              <ul>
                <li><a href="../index.php">Premium</a></li>
                <li><a href="../index.php">Help</a></li>
                <li><a href="../index.php">Download</a></li>
                <li role="separator"></li>
                <li><a href="../index.php">Account</a></li>
                <li><a href="../index.php">Log out</a></li>
              </ul>
              <div class="menu-overlay-logo">
                <img src="../images/spotify-logo.svg" />
              </div>
            </div>
          </div>
        </nav>
        <!-- This is the menu that will be shown on Desktop -->
        <nav class="nav-desktop">
          <!-- Site menu -->
          <ul>
            <li><a href="#">Premium</a></li>
            <li><a href="#">Help</a></li>
            <li><a href="#">Download</a></li>
            <li role="separator"></li>
          </ul>
          <!-- Profile menu -->
          <div class="profile-container">
            <input type="checkbox" class="dropdown-menu-toggler" />
            <div class="dropdown-menu">
              <ul>
                <li><a href="./pages/account.php">Account</a></li>
                <li><a href="#">Log out</a></li>
              </ul>
            </div>
            <div class="profile">
              <svg viewBox="0 0 1024 1024" class="profile-icon">
                <path
                  d="M730.06 679.64q-45.377 53.444-101.84 83.443t-120 29.999q-64.032 0-120.75-30.503t-102.6-84.451q-40.335 13.109-77.645 29.747t-53.948 26.722l-17.142 10.084Q106.388 763.84 84.96 802.41t-21.428 73.107 25.461 59.242 60.754 24.705h716.95q35.293 0 60.754-24.705t25.461-59.242-21.428-72.603-51.679-57.225q-6.554-4.033-18.907-10.84t-51.427-24.453-79.409-30.755zm-221.84 25.72q-34.285 0-67.561-14.873t-60.754-40.335-51.175-60.502-40.083-75.124-25.461-84.451-9.075-87.728q0-64.032 19.915-116.22t54.452-85.964 80.67-51.931 99.072-18.151 99.072 18.151 80.67 51.931 54.452 85.964 19.915 116.22q0 65.04-20.167 130.58t-53.948 116.72-81.426 83.443-98.568 32.268z"
                ></path>
              </svg>
            </div>
            <ul>
              <li>Profile</li>
              <li>
                <svg viewBox="0 0 1024 1024" class="profile-arrow">
                  <path
                    d="M476.455 806.696L95.291 425.532Q80.67 410.911 80.67 390.239t14.621-34.789 35.293-14.117 34.789 14.117L508.219 698.8l349.4-349.4q14.621-14.117 35.293-14.117t34.789 14.117 14.117 34.789-14.117 34.789L546.537 800.142q-19.159 19.159-38.318 19.159t-31.764-12.605z"
                  ></path>
                </svg>
              </li>
            </ul>
          </div>
        </nav>
      </div>
    </header>
    <section class="hero">
      <div class="hero-container">
        <div class="hero-content">
          <h1 class="hero-title">Go Premium. Be happy.</h1>
        </div>
      </div>
    </section>
    <footer>
      <nav class="footer-nav">
        <div class="logo-footer">
          <a href="#"><img src="../images/spotify-logo.svg" /></a>
        </div>
        <div class="top-links">
          <div class="company-links">
            <ul>
              <li>COMPANY</li>
              <li><a href="../index.php">About</a></li>
              <li><a href="../index.php">Jobs</a></li>
              <li><a href="../index.php">For the Record</a></li>
            </ul>
          </div>
          <div class="communities-links">
            <ul>
              <li>COMMUNITIES</li>
              <li><a href="#">For Artists</a></li>
              <li><a href="#">Developers</a></li>
              <li><a href="#">Advertising</a></li>
              <li><a href="#">Investors</a></li>
              <li><a href="#">Vendors</a></li>
            </ul>
          </div>
          <div class="useful-links">
            <ul>
              <li>USEFUL LINKS</li>
              <li><a href="#">Help</a></li>
              <li><a href="#">Web Player</a></li>
              <li><a href="#">Free Mobile App</a></li>
            </ul>
          </div>
        </div>
        <div class="social-icons">
          <ul>
            <li>
              <a href="#"><img src="../images/instagram-icon.svg" /></a>
            </li>
            <li>
              <a href="#"><img src="../images/twitter-icon.svg" /></a>
            </li>
            <li>
              <a href="#"><img src="../images/facebook-icon.svg" /></a>
            </li>
          </ul>
        </div>
        <div class="country">
          <a href="#"><span>USA</span><img src="../images/us.svg" /></a>
        </div>
        <div class="bottom-links">
          <ul>
            <li><a href="#">Legal</a></li>
            <li><a href="#">Privacy Center</a></li>
            <li><a href="#">Privacy Policy</a></li>
            <li><a href="#">Cookies</a></li>
            <li><a href="#">About Ads</a></li>
            <li><a href="#">Additional CA Privacy Disclosures</a></li>
          </ul>
          <span>© 2020 ZOTIFY AB</span>
        </div>
      </nav>
    </footer>
  </body>
  <!-- Load script.js -->
  <!-- <script src="./js/script.js"></script> -->
</html>
