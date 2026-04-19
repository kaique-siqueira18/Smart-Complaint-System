# 🚀 Smart Complaint System

Sistema inteligente de monitoramento de restaurantes com análise de qualidade e detecção automática de problemas.

---

## 📌 Sobre o projeto

Este projeto foi desenvolvido com o objetivo de simular um sistema real de monitoramento de restaurantes, inspirado em plataformas como iFood e Uber Eats.

A aplicação permite identificar restaurantes com baixo desempenho, detectar quedas na qualidade ao longo do tempo e gerar relatórios automáticos com base nos dados coletados.

---

## 🧠 Funcionalidades

- 📊 Cadastro e gerenciamento de restaurantes (CRUD)
- ⚠️ Detecção automática de restaurantes problemáticos
- 🚨 Classificação por nível de risco:
  - OK
  - ALERTA
  - CRÍTICO
- 📉 Monitoramento de queda de desempenho (lastRating)
- 🏆 Ranking dos piores restaurantes
- 🔍 Filtro por status e avaliações
- 🤖 Integração com Python para análise de dados
- 📄 Geração automática de relatórios
- 🔄 Monitoramento contínuo (execução automática)

---

## 🏗️ Arquitetura do sistema

O projeto foi dividido em duas partes principais:

### 🔹 Back-end (Java - Spring Boot)
Responsável por:
- Gerenciar dados dos restaurantes
- Aplicar regras de negócio
- Expor API REST

### 🔹 Análise de dados (Python)
Responsável por:
- Consumir a API
- Analisar padrões de qualidade
- Detectar piora de desempenho
- Gerar relatórios automáticos

---

## 🛠️ Tecnologias utilizadas

- Java (Spring Boot)
- PostgreSQL
- Python
- Requests (Python)
- API REST

---

## ▶️ Como executar o projeto

### 1️⃣ Rodar o Back-end (Java)

- Abrir o projeto no Eclipse ou IntelliJ
- Executar a aplicação Spring Boot
- A API estará disponível em:

## 📌 Autor

Desenvolvido por [Kaique Siqueira ]