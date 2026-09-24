document.addEventListener('DOMContentLoaded', () => {
  'use strict';

  // 1. Efecto Scroll en la barra de navegación
  const header = document.querySelector('.site-header');
  const backToTopBtn = document.getElementById('btnBackToTop');

  window.addEventListener('scroll', () => {
    if (window.scrollY > 50) {
      header?.classList.add('scrolled');
      backToTopBtn?.classList.add('active');
    } else {
      header?.classList.remove('scrolled');
      backToTopBtn?.classList.remove('active');
    }
  });

  // 2. Cerrar el menú responsive móvil al hacer clic en un enlace
  const navLinks = document.querySelectorAll('.navbar-nav .nav-link, .btn-reserva-nav');
  const navbarCollapse = document.querySelector('.navbar-collapse');

  navLinks.forEach((link) => {
    link.addEventListener('click', () => {
      if (navbarCollapse && navbarCollapse.classList.contains('show')) {
        const bsCollapse = bootstrap.Collapse.getInstance(navbarCollapse);
        if (bsCollapse) {
          bsCollapse.hide();
        }
      }
    });
  });

  // 3. Scroll suave hacia arriba con el botón Back to Top
  if (backToTopBtn) {
    backToTopBtn.addEventListener('click', () => {
      window.scrollTo({ top: 0, behavior: 'smooth' });
    });
  }

  // 4. Actualización del año actual en el pie de página
  const yearSpan = document.getElementById('currentYear');
  if (yearSpan) {
    yearSpan.textContent = new Date().getFullYear();
  }

  // 5. Validación de formulario de reservas y Modal (de Edu)
  const reservaForm = document.getElementById('reservaForm');

  if (reservaForm) {
    reservaForm.addEventListener('submit', function (event) {
      event.preventDefault();

      if (!reservaForm.checkValidity()) {
        event.stopPropagation();
        reservaForm.classList.add('was-validated');
      } else {
        document.getElementById('modalNombre').textContent = document.getElementById('resNombre').value;
        document.getElementById('modalTelefono').textContent = document.getElementById('resTelefono').value;
        document.getElementById('modalSede').textContent = document.getElementById('resSede').value;
        document.getElementById('modalFecha').textContent = document.getElementById('resFecha').value;
        document.getElementById('modalHora').textContent = document.getElementById('resHora').value;
        document.getElementById('modalPersonas').textContent = document.getElementById('resPersonas').value;

        const confirmModal = new bootstrap.Modal(document.getElementById('confirmacionModal'));
        confirmModal.show();

        reservaForm.reset();
        reservaForm.classList.remove('was-validated');
      }
    }, false);
  }

});