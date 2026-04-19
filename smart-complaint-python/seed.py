import requests

url = "http://localhost:8081/restaurants"

restaurants = [
    {
        "name": "Outback Vila Olímpia",
        "averageRating": 4.8,
        "totalReviews": 1240,
        "lastRating": 4.7,
        "description": "Steakhouse premium com ambiente confortável e atendimento rápido"
    },
    {
        "name": "Fogo de Chão Jardins",
        "averageRating": 4.6,
        "totalReviews": 980,
        "lastRating": 4.5,
        "description": "Churrascaria de alto padrão com excelente qualidade"
    },
    {
        "name": "Habib's Paulista",
        "averageRating": 2.9,
        "totalReviews": 2150,
        "lastRating": 3.4,
        "description": "Alta demanda e reclamações frequentes de atraso"
    },
    {
        "name": "McDonald's Consolação",
        "averageRating": 3.7,
        "totalReviews": 3420,
        "lastRating": 4.1,
        "description": "Fast food popular com variação na qualidade"
    },
    {
        "name": "Coco Bambu Morumbi",
        "averageRating": 4.3,
        "totalReviews": 870,
        "lastRating": 4.1,
        "description": "Restaurante premium com pratos bem avaliados"
    },
    {
        "name": "Burger King Brooklin",
        "averageRating": 2.4,
        "totalReviews": 1680,
        "lastRating": 2.8,
        "description": "Baixa satisfação recente e reclamações constantes"
    },
    {
        "name": "Spoleto Ibirapuera",
        "averageRating": 4.9,
        "totalReviews": 650,
        "lastRating": 4.8,
        "description": "Excelente personalização e qualidade consistente"
    },
    {
        "name": "Açaí Concept Vila Madalena",
        "averageRating": 3.5,
        "totalReviews": 420,
        "lastRating": 4.0,
        "description": "Opção saudável com melhora recente na avaliação"
    },
    {
        "name": "Pizza Hut Shopping Eldorado",
        "averageRating": 3.2,
        "totalReviews": 1340,
        "lastRating": 2.9,
        "description": "Problemas recentes com entrega e qualidade"
    },
    {
        "name": "Starbucks Paulista",
        "averageRating": 4.4,
        "totalReviews": 2890,
        "lastRating": 4.2,
        "description": "Cafeteria bem avaliada com grande volume de clientes"
    },
    {
        "name": "Subway Pinheiros",
        "averageRating": 3.8,
        "totalReviews": 760,
        "lastRating": 3.5,
        "description": "Opção saudável com avaliações medianas"
    },
    {
        "name": "China in Box Itaim",
        "averageRating": 2.1,
        "totalReviews": 540,
        "lastRating": 2.6,
        "description": "Baixa avaliação e queda contínua de satisfação"
    },
    {
        "name": "Ráscal Vila Olímpia",
        "averageRating": 4.7,
        "totalReviews": 920,
        "lastRating": 4.6,
        "description": "Restaurante sofisticado com ótima experiência"
    },
    {
        "name": "Bob's Shopping Center Norte",
        "averageRating": 3.1,
        "totalReviews": 680,
        "lastRating": 3.6,
        "description": "Oscilação de qualidade e atendimento"
    },
    {
        "name": "KFC Paulista",
        "averageRating": 3.9,
        "totalReviews": 1120,
        "lastRating": 3.7,
        "description": "Bom sabor, mas com críticas sobre oleosidade"
    },
    {
        "name": "Delivery Express Caos",
        "averageRating": 1.9,
        "totalReviews": 430,
        "lastRating": 2.1,
        "description": "Cancelamentos frequentes e baixa satisfação dos clientes"
    },
    {
        "name": "Restaurante Sabor Perdido",
        "averageRating": 2.3,
        "totalReviews": 780,
        "lastRating": 2.0,
        "description": "Queda constante na qualidade dos pratos e reclamações recentes"
    },
    {
        "name": "FastFood Colapso Center",
        "averageRating": 2.0,
        "totalReviews": 1200,
        "lastRating": 1.8,
        "description": "Atrasos extremos e pedidos chegando incorretos"
    },
    {
        "name": "Burguer Night Problema",
        "averageRating": 2.2,
        "totalReviews": 560,
        "lastRating": 2.3,
        "description": "Atendimento ruim e avaliações negativas frequentes"
    },
    {
        "name": "Pizza Rush Caótica",
        "averageRating": 1.8,
        "totalReviews": 910,
        "lastRating": 2.0,
        "description": "Alta taxa de erro nos pedidos e baixa satisfação geral"
    }
]

for r in restaurants:
    try:
        response = requests.post(url, json=r)
        print(f"{r['name']} → {response.status_code}")
    except Exception as e:
        print(f"Erro ao conectar no Java: {e}")