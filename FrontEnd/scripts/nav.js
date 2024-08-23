document.addEventListener('DOMContentLoaded', function () {
    const navContent = `
    <div class="container">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item"><a class="nav-link" href="#">Bandas</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Séries</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Time</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Oversized</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Rap</a></li>
                </ul>
            </div>
        </div>
    `
    document.querySelectorAll('nav').forEach(nav => {
        nav.innerHTML = navContent;
    });
})