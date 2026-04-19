# 🚀 Smart Complaint System

Sistema de monitoramento de restaurantes com análise inteligente de desempenho e identificação de riscos operacionais.

---

## 🧠 Sobre o Projeto

O **Smart Complaint System** (Sistema Inteligente de Reclamações) foi desenvolvido com o objetivo de analisar dados de avaliações de restaurantes e identificar automaticamente possíveis problemas operacionais.

Diferente de um CRUD tradicional, este projeto aplica lógica de negócio para interpretar dados e classificar os restaurantes com base em seu desempenho.

---

## 💡 Como funciona

Cada restaurante é analisado com base em:

- ⭐ Média de avaliações
- 📊 Quantidade de reviews
- 📉 Última avaliação recebida

Com base nesses dados, o sistema classifica automaticamente o restaurante em:

- 🟢 **OK** → Operação saudável  
- 🟡 **ALERTA** → Sinais de queda de qualidade  
- 🔴 **CRÍTICO** → Risco operacional identificado  

---

## ⚙️ Tecnologias utilizadas

### Backend
- Java
- Spring Boot
- API REST
- JPA / Hibernate

### Frontend
- HTML
- Tailwind CSS
- JavaScript (fetch API)

### Automação de dados
- Python (seed e análise de dados)

---

## 📊 Funcionalidades

- ✔️ CRUD completo de restaurantes  
- ✔️ Classificação automática de status (OK, ALERTA, CRÍTICO)  
- ✔️ Dashboard com visualização dos dados  
- ✔️ Busca dinâmica em tempo real  
- ✔️ Endpoints específicos:
  - `/restaurants`
  - `/alerts`
  - `/critical`
  - `/ranking`
- ✔️ Integração completa entre backend e frontend  
- ✔️ Simulação de dados reais com Python  

---

## 🌐 API Endpoints

| Método | Endpoint | Descrição |
|--------|--------|----------|
| GET | /restaurants | Lista todos os restaurantes |
| GET | /alerts | Lista restaurantes em alerta |
| GET | /critical | Lista restaurantes críticos |
| GET | /ranking | Ranking por desempenho |
| POST | /restaurants | Cria um restaurante |
| PUT | /restaurants/{id} | Atualiza um restaurante |
| DELETE | /restaurants/{id} | Remove um restaurante |

---

## 📸 Preview do Sistema

*(adicione aqui prints do seu dashboard)*

---

## 🚀 Como rodar o projeto

### 🔧 Backend (Spring Boot)

```bash
# Rodar aplicação
./mvnw spring-boot:run

Desenvolvido por [Kaique Siqueira  ]