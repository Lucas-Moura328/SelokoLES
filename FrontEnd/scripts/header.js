document.addEventListener('DOMContentLoaded', function(){
    const headerContent = `
        <div class="container d-flex justify-content-between align-items-center">
            <div class="logo">
                <h1 class="m-0"><a href="index.html" class="text-white">SÉLOKO</a></h1>
            </div>
            <div class="header-right d-flex align-items-center">
                <div class="search-bar mr-4">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Pesquisar...">
                        <div class="input-group-append">
                            <button class="btn btn-light"><i class="fa-solid fa-magnifying-glass"></i></button>
                        </div>
                    </div>
                </div>
                <div class="login-icon">
                    <a href="login.html" class="text-white"><i class="fa-solid fa-user"></i></a>
                </div>
            </div>
        </div>
    `;

    document.querySelectorAll('header').forEach(header => {
        header.innerHTML = headerContent;
    });
});