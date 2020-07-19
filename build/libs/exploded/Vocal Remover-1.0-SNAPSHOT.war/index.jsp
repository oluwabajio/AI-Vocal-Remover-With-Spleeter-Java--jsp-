<%--
  Created by IntelliJ IDEA.
  User: administrator
  Date: 14/07/2020
  Time: 12:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>AI Vocal Remover | Remove Vocals & Instrumental from Songs</title>
    <meta name="description" content="Remove Vocals, instrumentals, drums, bass, piano for karaoke and acapella use. The best
     mp3 voice remover using artificial intelligence.">
    <meta name=”robots” content="index, follow">
    <meta name="google-site-verification" content="TRlinhA1GbQa3JpuilovDE-F-xU10DV_YllZjvmtQpw" />

    <!-- Bootstrap core CSS -->
    <link href="template/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="template/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="template/vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet"
          type="text/css">

    <!-- Custom styles for this template -->
    <link href="template/css/landing-page.min.css" rel="stylesheet">
    <link href="template/css/dropzone.css" rel="stylesheet">

    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-172990142-1"></script>
    <script>
        window.dataLayer = window.dataLayer || [];
        function gtag(){dataLayer.push(arguments);}
        gtag('js', new Date());

        gtag('config', 'UA-172990142-1');
    </script>


</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-light bg-light static-top">
    <div class="container">
        <a class="navbar-brand" href="#">AI Vocal Remover</a>
        <a class="btn btn-primary" href="#">Sign In</a>
    </div>
</nav>

<!-- Masthead -->
<header class="masthead text-white text-center">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-xl-9 mx-auto">
                <h1 class="mb-5">Remove Vocals from Songs, Extract Instrumentals for Karaoke!</h1>
            </div>


            <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
<%--                <form>--%>
<%--                    <div class="form-row">--%>
<%--                        <div class="col-12 col-md-9 mb-2 mb-md-0">--%>
<%--                            <input type="email" class="form-control form-control-lg" placeholder="Enter your email...">--%>
<%--                        </div>--%>
<%--                        <div class="col-12 col-md-3">--%>
<%--                            <button type="submit" class="btn btn-block btn-lg btn-primary">Sign up!</button>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </form>--%>


                    <form action="FileTest" method="post" enctype="multipart/form-data">

                        <div class="form-row">
                            <div class="col-12 col-md-9 mb-2 mb-md-0" style="background: white; border: 2px dashed blue !important;">
                                <input type="file" id="fileName" style=" margin: 0; padding: 2rem 1.5rem;
                                color: #5a5a5a; background: white; border:0 none !important; outline:0 !important;" name="fileName"  accept="audio/mpeg3">
                            </div>
                            <div class="col-12 col-md-3">
                                <input type="button"  value="Upload" id="but_upload" class="btn btn-block btn-lg btn-primary"
                                style="height: 100%">
                            </div>
                        </div>

                    </form>

                <div class="container" id="div_buttons">
                    <a href="#" id="btn_instrumental" target="_blank" class="btn mb-2 mr-3 btn-xl btn-outline-light">Download
                        Instrumental</a>
                    <a href="#" id="btn_vocal" target="_blank" class="btn mb-2 btn-xl btn-outline-light">Download
                        Vocal</a>
                </div>

            </div>
        </div>

        <div id="divSpinner" class="container">
            <div class="spinner-border" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>


        <div class="container">
            <div class="row">

            </div>
        </div>


    </div>
</header>

<!-- Icons Grid -->
<section class="features-icons bg-light text-center">
    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
                    <div class="features-icons-icon d-flex">
                        <i class="icon-screen-desktop m-auto text-primary"></i>
                    </div>
                    <h3>Artificial Intelligence</h3>
                    <p class="lead mb-0">Seperate Instrumentals and Vocals using ai. Make acapella and karaoke!</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
                    <div class="features-icons-icon d-flex">
                        <i class="icon-layers m-auto text-primary"></i>
                    </div>
                    <h3>Remove Vocals</h3>
                    <p class="lead mb-0">Remove vocals using ai from mp3 and wav songs for free. Best mp3 vocal remover
                        web app!</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="features-icons-item mx-auto mb-0 mb-lg-3">
                    <div class="features-icons-icon d-flex">
                        <i class="icon-check m-auto text-primary"></i>
                    </div>
                    <h3>Extract Instrumental</h3>
                    <p class="lead mb-0">Extract Instrumentals from songs and tracks easily. Seperate vocals from
                        instrumentals!</p>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Image Showcases -->
<section class="showcase">
    <div class="container-fluid p-0">
        <div class="row no-gutters">

            <div class="col-lg-6 order-lg-2 text-white showcase-img"
                 style="background-image: url('template/img/bg-showcase-1.jpg');"></div>
            <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                <h2>Extremely Fast Tool</h2>
                <p class="lead mb-0">When you select a song and you click on the upload button, it takes about 15
                    seconds for it to finish processing
                    and then you can get your tracks in the form of karaoke, acapella, bass, piano, and other
                    instruments!</p>
            </div>
        </div>
        <div class="row no-gutters">
            <div class="col-lg-6 text-white showcase-img"
                 style="background-image: url('template/img/bg-showcase-2.jpg');"></div>
            <div class="col-lg-6 my-auto showcase-text">
                <h2>Deep Learning Analysis</h2>
                <p class="lead mb-0">We use deep learning analysis to train our AI so we can always deliver a perfect
                    results for our users.
                    We train our system with various music all the time so they can become better at splitting audio
                    tracks!</p>
            </div>
        </div>
        <div class="row no-gutters">
            <div class="col-lg-6 order-lg-2 text-white showcase-img"
                 style="background-image: url('template/img/bg-showcase-3.jpg');"></div>
            <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                <h2>ToTally Free</h2>
                <p class="lead mb-0">Our Tool is totally free, we do not collect any fee from the user. This is the
                    first and only totally free ai vocal
                    remover tool you would ever come across. You can also do bulk vocal remover of mp3 files with our
                    tool!</p>
            </div>
        </div>
    </div>
</section>

<!-- Testimonials -->
<section class="testimonials text-center bg-light">
    <div class="container">
        <h2 class="mb-5">FAQ</h2>
        <div class="row">
            <p>AIVocalRemover is a tool thats available for all musicians to use all the time. Upcoming and growing
                artistes often do not have the luxury to
                purchase instrumental tracks for their music, so they often rely of low quality cheap beats which makes
                their music terrible. Also most upcoming
                artistes would love to sing covers or remixes to popular songs but cannot afford to purchase the
                instrumental version of the song. That is why
                we created this solution. Upcoming artstes no longer have to deal with all these stress. All they have
                to do is upload the song on our website and then
                we provide them with the clean instrumental version in seconds.</p>

            <p>Our AI tool has been specially trained to recognize different stems in music like the piano, bass,
                instruments and vocals, so we can
                efficiently seperates those elements and provide you with the one you want. So if you need instrumental,
                karaoke and acapella version of a song,
                our website is the best platform to achieve that. Ad we do all of these for free at no cost.</p>

            <p>AIVocalRemover allows you to easily split and isolate audio tracks to get vocals only ad instrumetal oly
                which you can use for acapella ad karaoke.
                we are the best vocal remover online ai software that converts songs to karaoke. We accept mp3 and wav
                extensions</p>

            <p>Our AI tool uses artificial intelligence and has been specially trained to produce great reselts all the
                time so you do not have to worry as
                we have your back covered.</p>

        </div>
    </div>
</section>

<!-- Call to Action -->
<section class="call-to-action text-white text-center">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-xl-9 mx-auto">
                <h2 class="mb-4">Ready to get started? Sign up now!</h2>
            </div>
            <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
                <form>
                    <div class="form-row">
                        <div class="col-12 col-md-9 mb-2 mb-md-0">
                            <input type="email" class="form-control form-control-lg" placeholder="Enter your email...">
                        </div>
                        <div class="col-12 col-md-3">
                            <button type="submit" class="btn btn-block btn-lg btn-primary">Sign up!</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<!-- Footer -->
<footer class="footer bg-light">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 h-100 text-center text-lg-left my-auto">
                <ul class="list-inline mb-2">
                    <li class="list-inline-item">
                        <a href="#">About</a>
                    </li>
                    <li class="list-inline-item">&sdot;</li>
                    <li class="list-inline-item">
                        <a href="#">Contact</a>
                    </li>
                    <li class="list-inline-item">&sdot;</li>
                    <li class="list-inline-item">
                        <a href="#">Terms of Use</a>
                    </li>
                    <li class="list-inline-item">&sdot;</li>
                    <li class="list-inline-item">
                        <a href="#">Privacy Policy</a>
                    </li>
                </ul>
                <p class="text-muted small mb-4 mb-lg-0">&copy; Your Website 2020. All Rights Reserved.</p>
            </div>
            <div class="col-lg-6 h-100 text-center text-lg-right my-auto">
                <ul class="list-inline mb-0">
                    <li class="list-inline-item mr-3">
                        <a href="#">
                            <i class="fab fa-facebook fa-2x fa-fw"></i>
                        </a>
                    </li>
                    <li class="list-inline-item mr-3">
                        <a href="#">
                            <i class="fab fa-twitter-square fa-2x fa-fw"></i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#">
                            <i class="fab fa-instagram fa-2x fa-fw"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</footer>

<!-- Bootstrap core JavaScript -->
<script src="template/vendor/jquery/jquery.min.js"></script>
<script src="template/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="template/dropzone.js"></script>

<%--<script>--%>
<%--    Dropzone.options.myAwesomeDropzone = {--%>
<%--        maxFiles: 1,--%>
<%--        paramName: "fileName", // The name that will be used to transfer the file--%>
<%--        maxFilesize: 20, // MB--%>
<%--        accept: function (file, done) {--%>

<%--            done("File Uploaded Successfully");--%>

<%--        },--%>
<%--        // init: function () {--%>
<%--        //     this.hiddenFileInput.removeAttribute('multiple');--%>
<%--        //     this.on("maxfilesexceeded", function (file) {--%>
<%--        //         this.removeAllFiles();--%>
<%--        //         this.addFile(file);--%>
<%--        //     });--%>
<%--        // }--%>

<%--    };--%>
<%--    //--%>
<%--    // Dropzone.prototype.defaultOptions.init = function () {--%>
<%--    //--%>
<%--    //     this.hiddenFileInput.removeAttribute('multiple');--%>
<%--    //     this.on("maxfilesexceeded", function (file) {--%>
<%--    //         this.removeAllFiles();--%>
<%--    //         this.addFile(file);--%>
<%--    //     });--%>
<%--    // };--%>
<%--</script>--%>

<script>




      $('#divSpinner').hide();
      $('#div_buttons').hide()

      $("#but_upload").click(function () {

          if($('#fileName').length > 0 && $('#fileName').val() != '') {

              $('#divSpinner').show();
              var fd = new FormData();
              var files = $('#fileName')[0].files[0];
              fd.append('fileName', files);

              $.ajax({
                  url: 'FileTest',
                  type: 'post',
                  data: fd,
                  dataType: 'json',
                  contentType: false,
                  processData: false,
                  success: function (response) {
                      if (response != 0) {
                          $("#img").attr("src", response);
                          $(".preview img").show(); // Display image element


                          alert(response.file_name);

                          $.post("ProcessM",
                              {
                                  file_name: response.file_name,
                                  action: "watermark_video"
                              },
                              function (result) {
                                  alert(result.instrumental_path);
                                  $('#divSpinner').hide();
                                  $('#div_buttons').show();
                                  $('#btn_instrumental').attr("href", result.instrumental_path);
                                  $('#btn_vocal').attr("href", result.vocal_path);


                              });


                      } else {
                          alert('file not uploaded');
                          $('#divSpinner').hide();
                      }
                  },
              });

          }else {
              alert('Kindly Select a File');
          }

      });



</script>


</body>

</html>