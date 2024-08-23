document.addEventListener('DOMContentLoaded', function(){
    const headerContent = `
    <div class="container d-flex justify-content-between align-items-center">
            <div class="logo">
                <h1 class="m-0"><a href="index.html" class="text-white">SÉLOKO</a></h1>
            </div>
            <div class="header-right d-flex align-items-center">
                
            </div>
        </div>
    `;

    document.querySelectorAll('header').forEach(header => {
        header.innerHTML = headerContent;
    });
});