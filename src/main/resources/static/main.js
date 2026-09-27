document.addEventListener('DOMContentLoaded', () => {
  'use strict';

  localStorage.removeItem('userLogged');
  localStorage.removeItem('userEmail');

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

  if (backToTopBtn) {
    backToTopBtn.addEventListener('click', () => {
      window.scrollTo({ top: 0, behavior: 'smooth' });
    });
  }

  const yearSpan = document.getElementById('currentYear');
  if (yearSpan) {
    yearSpan.textContent = new Date().getFullYear();
  }

  const reservaForm = document.getElementById('reservaForm');
  if (reservaForm) {
    const fechaInput = document.getElementById('resFecha');
    if (fechaInput) {
      const hoy = new Date().toISOString().split('T')[0];
      fechaInput.min = hoy;
      if (!fechaInput.value) {
        fechaInput.value = hoy;
      }
    }

    reservaForm.addEventListener('submit', function (event) {
      if (!reservaForm.checkValidity()) {
        event.preventDefault();
        event.stopPropagation();
        reservaForm.classList.add('was-validated');
      }
    }, false);
  }

  const loginForm = document.getElementById('loginForm');
  if (loginForm) {
    loginForm.addEventListener('submit', function (event) {
      if (!loginForm.checkValidity()) {
        event.preventDefault();
        event.stopPropagation();
        loginForm.classList.add('was-validated');
      }
    }, false);
  }

  const loginModalEl = document.getElementById('loginModal');
  const loginErrorAlert = document.getElementById('loginErrorAlert');

  if (loginErrorAlert && loginModalEl) {
    const loginModal = new bootstrap.Modal(loginModalEl);
    loginModal.show();
  }

  if (loginModalEl) {
    loginModalEl.addEventListener('hidden.bs.modal', () => {
      const alert = document.getElementById('loginErrorAlert');
      if (alert) {
        alert.remove();
      }
    });
  }

  if (window.location.search.includes('error')) {
    window.history.replaceState({}, document.title, window.location.pathname);
  }

  const confirmacionModalEl = document.getElementById('confirmacionModal');
  if (confirmacionModalEl && confirmacionModalEl.classList.contains('show-on-load')) {
    const confirmModal = new bootstrap.Modal(confirmacionModalEl);
    confirmModal.show();
  }
});

window.abrirModalEliminar = function (id, nombre) {
  const nombreEl = document.getElementById('nombrePlatoEliminar');
  const btnEl = document.getElementById('btnConfirmarEliminar');
  const modalEl = document.getElementById('modalEliminarPlato');
  if (nombreEl) {
    nombreEl.textContent = `"${nombre}"`;
  }
  if (btnEl) {
    btnEl.href = `/productos/eliminar/${id}`;
  }
  if (modalEl) {
    const modal = bootstrap.Modal.getOrCreateInstance(modalEl);
    modal.show();
  }
};

window.abrirModalEliminarReserva = function (id, nombre) {
  const nombreEl = document.getElementById('nombreReservaEliminar');
  const btnEl = document.getElementById('btnConfirmarEliminarReserva');
  const modalEl = document.getElementById('modalEliminarReserva');
  if (nombreEl) {
    nombreEl.textContent = `"${nombre}"`;
  }
  if (btnEl) {
    btnEl.href = `/reservas/eliminar/${id}`;
  }
  if (modalEl) {
    const modal = bootstrap.Modal.getOrCreateInstance(modalEl);
    modal.show();
  }
};

window.actualizarEstadoReserva = function (id, nuevoEstado) {
  fetch(`/reservas/estado/${id}/${nuevoEstado}`)
    .then(response => {
      if (response.ok) {
        const celda = document.getElementById(`estado-reserva-${id}`);
        if (celda) {
          if (nuevoEstado === 'Confirmada') {
            celda.innerHTML = '<span class="badge bg-success"><i class="bi bi-check-circle-fill me-1"></i>Confirmada</span>';
          } else if (nuevoEstado === 'Cancelada') {
            celda.innerHTML = '<span class="badge bg-danger"><i class="bi bi-x-circle-fill me-1"></i>Cancelada</span>';
          } else {
            celda.innerHTML = '<span class="badge bg-warning text-dark"><i class="bi bi-clock-history me-1"></i>Pendiente</span>';
          }
        }
      }
    })
    .catch(err => console.error('Error al actualizar estado:', err));
};