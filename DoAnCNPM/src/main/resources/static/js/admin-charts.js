document.addEventListener('DOMContentLoaded', () => {
    const nav = document.querySelector('aside nav');
    if (!nav) return;

    // Lấy pathname hiện tại (ví dụ: '/poi-manage' -> 'poi-manage')
    const currentPath = window.location.pathname.replace(/^\/|\/$/g, '');

    const links = nav.querySelectorAll('a');
    links.forEach(link => {
        const href = link.getAttribute('href').replace(/^\/|\/$/g, '');

        if (href === currentPath) {
            link.classList.add('on');
            link.setAttribute('aria-current', 'page');
        } else {
            link.classList.remove('on');
            link.removeAttribute('aria-current');
        }
    });
});

// Biến toàn cục lưu trạng thái hành động hiện tại: 'CREATE', 'UPDATE', hoặc 'DELETE'
let currentAction = 'CREATE';

function closeModal() {
    document.getElementById('poi-modal').style.display = 'none';
    document.getElementById('poi-form').reset();
}

document.addEventListener('DOMContentLoaded', () => {

    const modal = document.getElementById('poi-modal');
    const title = document.getElementById('modal-title');
    const inputsArea = document.getElementById('modal-inputs');
    const deleteMsg = document.getElementById('modal-delete-msg');
    const btnSave = document.getElementById('btn-modal-save');
    const btnDelete = document.getElementById('btn-modal-delete');

    // --- 1. MỞ FORM THÊM MỚI ---
    const btnAdd = document.getElementById('btn-add-poi');
    if (btnAdd) {
        btnAdd.addEventListener('click', () => {
            currentAction = 'CREATE';
            title.textContent = 'Thêm Hiện Vật Mới';
            inputsArea.style.display = 'block';
            deleteMsg.style.display = 'none';
            btnSave.style.display = 'block';
            btnDelete.style.display = 'none';

            // Xóa sạch form cũ
            document.getElementById('poi-form').reset();
            modal.style.display = 'flex';
        });
    }

    // --- 2. MỞ FORM SỬA ---
    document.querySelectorAll('.btn-edit').forEach(btn => {
        btn.addEventListener('click', () => {
            currentAction = 'UPDATE';
            title.textContent = 'Sửa Hiện Vật';
            inputsArea.style.display = 'block';
            deleteMsg.style.display = 'none';
            btnSave.style.display = 'block';
            btnDelete.style.display = 'none';

            // Đổ dữ liệu từ bảng lên form
            document.getElementById('modal-poi-id').value = btn.getAttribute('data-id');
            document.getElementById('modal-name').value = btn.getAttribute('data-name');
            document.getElementById('modal-lat').value = btn.getAttribute('data-lat') || '';
            document.getElementById('modal-lng').value = btn.getAttribute('data-lng') || '';
            document.getElementById('modal-radius').value = btn.getAttribute('data-radius') || 15;
            document.getElementById('modal-status').value = btn.getAttribute('data-status') || 'ACTIVE';
            document.getElementById('modal-thumbnailUrl').value = btn.getAttribute('data-thumbnail') || '';
            document.getElementById('modal-historicalPeriod').value = btn.getAttribute('data-period') || '';
            modal.style.display = 'flex';
        });
    });

    // --- 3. MỞ FORM XÓA ---
    document.querySelectorAll('.btn-delete').forEach(btn => {
        btn.addEventListener('click', () => {
            currentAction = 'DELETE';
            title.textContent = 'Xác nhận xóa';

            // Ẩn khu vực nhập liệu, hiện cảnh báo
            inputsArea.style.display = 'none';
            deleteMsg.style.display = 'block';
            btnSave.style.display = 'none';
            btnDelete.style.display = 'block';

            document.getElementById('modal-poi-id').value = btn.getAttribute('data-id');
            document.getElementById('delete-poi-name').textContent = btn.getAttribute('data-name');

            modal.style.display = 'flex';
        });
    });

    // --- 4. GỬI DỮ LIỆU VỀ SERVER (SUBMIT) ---
    document.getElementById('poi-form').addEventListener('submit', (e) => {
        e.preventDefault();

        // Nếu là Xóa thì không dùng submit form, mà xử lý ở sự kiện nút Xóa bên dưới
        if (currentAction === 'DELETE') return;

        const poiId = document.getElementById('modal-poi-id').value;
        const requestData = {
            poiNameVi: document.getElementById('modal-name').value,
            historicalPeriod: document.getElementById('modal-historicalPeriod').value,
            latitude: parseFloat(document.getElementById('modal-lat').value),
            longitude: parseFloat(document.getElementById('modal-lng').value),
            proximityRadius: parseFloat(document.getElementById('modal-radius').value),
            status: document.getElementById('modal-status').value,
            thumbnailUrl: document.getElementById('modal-thumbnailUrl').value

        };

        const method = currentAction === 'CREATE' ? 'POST' : 'PUT';
        const url = currentAction === 'CREATE' ? '/poi-manage/api' : `/poi-manage/api/${poiId}`;

        fetch(url, {
            method: method,
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(requestData)
        })
            .then(response => {
                if(response.ok) { window.location.reload(); }
                else { alert("Lưu thất bại!"); }
            })
            .catch(err => console.error(err));
    });

    // --- 5. NÚT XÓA ĐỘC LẬP CHẠY API DELETE ---
    btnDelete.addEventListener('click', () => {
        const poiId = document.getElementById('modal-poi-id').value;
        fetch(`/poi-manage/api/${poiId}`, { method: 'DELETE' })
            .then(response => {
                if(response.ok) { window.location.reload(); }
                else { alert("Xóa thất bại!"); }
            })
            .catch(err => console.error(err));
    });
});