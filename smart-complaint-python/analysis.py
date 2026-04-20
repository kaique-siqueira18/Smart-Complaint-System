import time
import requests

def executar_monitoramento():
    response = requests.get("http://localhost:8081/restaurants")
    data = response.json()

    print("\n⏳ Rodando análise...\n")

 
    ordenados = sorted(data, key=lambda x: x["averageRating"])
    top3 = ordenados[:3]

    print("📉 TOP 3 PIORES:")
    for r in top3:
        print(f"{r['name']} - Nota: {r['averageRating']} - Status: {r['status']}")

    print("\n⚠️ QUEDAS FORTES:")
    for r in data:
        last = r.get("lastRating")
        current = r.get("averageRating")

        if last is not None:
            queda = last - current

            if queda >= 1.5:
                print(f"{r['name']} caiu {queda} pontos")

 
    print("\n🚨 ALERTAS:")
    for r in data:
        if r["status"] == "CRITICO":
            print(f"CRÍTICO: {r['name']}")
        elif r["status"] == "ALERTA":
            print(f"ALERTA: {r['name']}")


    with open("relatorio.txt", "w", encoding="utf-8") as f:
        f.write("=== RELATÓRIO AUTOMÁTICO ===\n\n")

        f.write("TOP 3 PIORES:\n")
        for r in top3:
            f.write(f"{r['name']} - Nota: {r['averageRating']} - Status: {r['status']}\n")

        f.write("\nQUEDAS FORTES:\n")
        for r in data:
            last = r.get("lastRating")
            current = r.get("averageRating")

            if last is not None:
                queda = last - current

                if queda >= 1.5:
                    f.write(f"{r['name']} caiu {queda} pontos\n")

        f.write("\nALERTAS:\n")
        for r in data:
            if r["status"] == "CRITICO":
                f.write(f"CRÍTICO: {r['name']}\n")
            elif r["status"] == "ALERTA":
                f.write(f"ALERTA: {r['name']}\n")

    print("\n📄 Relatório atualizado!\n")
    
    return data

while True:
    data =  executar_monitoramento()
    time.sleep(60)  

    print("\n🔮 PREVISÃO DE RISCO:\n")
    
    for r in data:
        last = r.get("lastRating")
        current = r.get("averageRating")

        if last is not None:
            queda = last - current

            if r["status"] == "ALERTA" and queda >= 0.5:
                print(f"⚠️ {r['name']} pode se tornar CRÍTICO em breve!")

    print("\n📊 CONFIABILIDADES DOS RESTAURANTES:")

    for r in data:
        rating = r.get ("averageRating", 0)
        reviews = r.get("totalReviews", 0)

        confiabilidade = rating * (reviews / 50)
        if confiabilidade < 3:
            nivel = "BAIXA"
        elif confiabilidade < 6:
            nivel = "MÉDIA"
        else:
            nivel = "ALTA"

            print(f"{r['name']} -> Confiabilidade:{nivel}")
    print("\n 🚨 POSSÍVEL MANIPULAÇÃO:\n")

    for r in data:
        rating = r.get("averageRating", 0)
        reviews = r.get("totalReviews", 0)

        if rating > 4.5 and reviews < 10:
            print(f"{r['name']} pode ter avaliações manipuladas")   


    print("\n==============================")
    print("📊 SMART COMPLAINT ANALYSIS")
    print("==============================\n")
                     