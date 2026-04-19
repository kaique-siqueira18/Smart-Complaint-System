let allRestaurants = [];

async function fetchRestaurants() {
    const container = document.getElementById("list");

    container.innerHTML = `<p class="text-center col-span-full">Carregando...</p>`;

    try {
        const res = await fetch("http://localhost:8081/restaurants");
        const data = await res.json();

        allRestaurants = data;

        updateStats(data);
        render(data);

    } catch (error) {
        container.innerHTML = `
            <p class="text-center text-red-400 col-span-full">
                ❌ Erro ao conectar com backend
            </p>
        `;
    }
}

function updateStats(data) {
    document.getElementById("total").innerText = data.length;

    document.getElementById("critical").innerText =
        data.filter(r => normalize(r.status) === "CRITICO").length;

    document.getElementById("alert").innerText =
        data.filter(r => normalize(r.status) === "ALERTA").length;
}

function normalize(status) {
    return status?.toUpperCase().trim();
}

function render(restaurants) {
    const container = document.getElementById("list");

    if (!restaurants.length) {
        container.innerHTML = `<p class="text-center col-span-full">Nenhum restaurante encontrado</p>`;
        return;
    }

    container.innerHTML = restaurants.map(r => {
        const status = normalize(r.status);

        return `
        <div class="
            bg-slate-900 p-5 rounded-xl border border-white/10 
            hover:scale-105 transition duration-300
            border-l-4
            ${status === 'CRITICO' ? 'border-red-500' : ''}
            ${status === 'ALERTA' ? 'border-yellow-400' : ''}
            ${status === 'OK' ? 'border-green-400' : ''}
        ">

            <div class="flex justify-between items-center">
                <h3 class="text-lg font-bold">${r.name}</h3>

                <span class="text-xs px-3 py-1 rounded-full font-semibold
                    ${status === 'OK' ? 'bg-green-500/20 text-green-400' : ''}
                    ${status === 'ALERTA' ? 'bg-yellow-500/20 text-yellow-400' : ''}
                    ${status === 'CRITICO' ? 'bg-red-500/20 text-red-400' : ''}
                ">
                    ${status}
                </span>
            </div>

            <p class="text-yellow-400 mt-2 font-semibold">
                ⭐ ${r.averageRating}
            </p>

            <p class="text-slate-400 mt-3 text-sm leading-relaxed">
                ${r.description || "Sem descrição disponível"}
            </p>

        </div>
        `;
    }).join("");
}

function handleSearch(e) {
    const term = e.target.value.toLowerCase().trim();

    if (!term) {
        render(allRestaurants);
        return;
    }

    const filtered = allRestaurants.filter(r =>
        r.name.toLowerCase().includes(term)
    );

    render(filtered);
}

window.onload = fetchRestaurants;