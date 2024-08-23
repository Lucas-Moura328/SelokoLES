document.addEventListener('DOMContentLoaded', function () {
    // Defina o conteúdo do footer
    const footerContent = `
        <div class="">
            <div class="row">
                <!-- Seção Sobre Nós -->
                <div class="col-12">
                </div>

                <!-- Seção Nossos Endereços -->
                <div class="col-12">
                    <h5>Nossos Endereços</h5>
                    <ul class="list-unstyled">
                        <li>R. da Valeta, 161 - Sta Marta, Xique-Xique - BA</li>
                        <li>Av. Batista Montenegro, Afonso Bezerra - RN</li>
                        <li>Av. Brasil, 450 - Belo Horizonte, MG</li>
                    </ul>
                </div>

                <!-- Seção Redes Sociais -->
                <div class="col-12 text-center">
                <h5>Redes Sociais</h5>
                    <ul class="list-unstyled d-flex justify-content-center social-links">
                        <li class="mx-2"><a href="#" class="social-link"><i class="fab fa-instagram"></i> Instagram</a></li>
                        <li class="mx-2"><a href="#" class="social-link"><i class="fab fa-facebook-f"></i> Facebook</a></li>
                        <li class="mx-2"><a href="#" class="social-link"><i class="fab fa-twitter"></i> Twitter</a></li>
                    </ul>
                    
            </div>

            </div>

            <div class="text-center">
                <p>&copy; 2024 SÉLOKO. Todos os direitos reservados.</p>
            </div>
        </div>
    `;

    // Encontre todas as tags <footer> e insira o conteúdo nelas
    document.querySelectorAll('footer').forEach(footer => {
        footer.innerHTML = footerContent;
    });
});
