# 🧩 Padrões de Projeto Orientados a Objetos  
## Prática – Padrão Observer (Telefone)

### 👩‍💻 Autoras
**Alexia Alves**  
**Maria Vitória Melo**

---

## 📘 Descrição da Questão

O exercício propôs adaptar um sistema de telefone simulado para aplicar o **Padrão Observer**, garantindo a separação entre o modelo de dados (telefone) e a interface de usuário (tela).  
O código inicial não possuía notificação de eventos — toda a lógica estava acoplada — e a tarefa era introduzir um mecanismo que notificasse os observadores sempre que um novo dígito fosse inserido.

Nosso objetivo foi:

- Criar uma **interface para observadores** (`PhoneObserver`);
- Adaptar o modelo (`PhoneModel`) para:
  - Registrar e notificar observadores a cada novo dígito;
  - Manter o telefone totalmente desacoplado da interface (`Screen`);
- Implementar **dois observadores especializados**:
  - `DigitDisplayObserver` → imprime o dígito mais recente;
  - `DialingObserver` → imprime “Agora discando 081999887766...” quando o número completo é digitado;
- Garantir que **somente a UI (Screen)** realize a impressão na tela;
- Fazer com que a **classe `Screen` seja responsável por criar e registrar** os observadores no modelo.

O resultado final aplica corretamente o **Padrão Observer**, com foco em **baixo acoplamento**, **responsabilidade única** e **adesão às restrições do enunciado**.

---

## 🧠 Uso da Inteligência Artificial (IA)

Durante o desenvolvimento, a IA foi utilizada em etapas específicas para sugerir a estrutura e os ajustes necessários para a implementação do padrão.  
Todos os prompts, respostas e decisões foram documentados nos commits correspondentes, feitos na **branch master**.

---

### 🪶 Prompt 1 – Adaptação do PhoneModel
> **Objetivo:** Modificar `PhoneModel` para implementar o padrão Observer.  
> **Solução sugerida pela IA:**
> 1. Criar a interface `PhoneObserver`;  
> 2. Adicionar os métodos `addObserver()` e `notifyObservers()` em `PhoneModel.java`;  
> 3. Alterar `addDigit()` para chamar `notifyObservers()` a cada novo dígito;  
> 4. Criar um método auxiliar `getFormattedNumber()` para formatar o número antes da notificação.  
>
> **Justificativa:**  
> Esse commit estabelece a base do padrão Observer. Ele garante que `PhoneModel` (o *Subject*) fique totalmente **desacoplado** das classes de UI, cumprindo apenas o papel de **notificar as mudanças de estado** (cada dígito inserido).  
>
> ✅ **Resultado:** Implementação funcional e em total conformidade com o padrão.

---

### 🪶 Prompt 2 – Criação dos Observers Concretos
> **Objetivo:** Criar os dois observadores especializados que interagem com a UI (`Screen`).  
> **Solução sugerida pela IA:**
> 1. Criar `DigitDisplayObserver` que implementa `PhoneObserver` e utiliza `Screen` para imprimir o último dígito;  
> 2. Criar `DialingObserver` que implementa `PhoneObserver`, verifica se o número tem 12 dígitos e usa `Screen` para exibir a mensagem “Agora discando...”.  
>
> **Justificativa:**  
> Essa etapa completa o segundo passo do padrão Observer. As responsabilidades ficam bem definidas:
> - O `PhoneModel` apenas **notifica**;  
> - Os Observers decidem **como reagir** à notificação.  
> O design também garante que **somente a UI** realize impressões, pois os Observers apenas delegam essa tarefa para a instância de `Screen` passada no construtor.  
>
> ✅ **Resultado:** Nenhum ajuste adicional foi necessário.

---

### 🪶 Prompt 3 – Configuração Final do Cliente (Screen)
> **Objetivo:** Fazer com que `Screen.java` registre automaticamente os observadores e centralize toda a lógica de exibição.  
> **Solução sugerida pela IA:**
> 1. Adicionar métodos `printDigit()` e `printDialing()` em `Screen.java`;  
> 2. No construtor de `Screen`, instanciar e registrar `DigitDisplayObserver` e `DialingObserver`, injetando a própria `Screen` neles;  
> 3. Remover referências desnecessárias e garantir que o `Main` apenas inicialize a `Screen` e o `KeyPad`.  
>
> **Justificativa:**  
> Este commit conclui a implementação, validando completamente o Padrão Observer.  
> A `Screen` passa a ser o ponto central (cliente/fábrica) dos Observers, o que melhora o design quanto a:
> - **Desacoplamento completo** entre modelo e interface;  
> - **Responsabilidade única** da UI;  
> - **Extensibilidade** para futuros observadores.  
>
> ✅ **Resultado:** Projeto concluído com sucesso e comportamento idêntico ao esperado no enunciado.

---

## 🧩 Histórico de Commits Principais (Branch master)

| Data | Commit | Descrição |
|------|---------|-----------|
| 07/10/2025 | `b1e93a1` | Adicionando código base e arquivos iniciais da Questão 2 |
| 07/10/2025 | `c1da16e` | Implementando a base do padrão Observer em `PhoneModel` |
| 07/10/2025 | `d735de1` | Criando Observers especializados (`DigitDisplayObserver` e `DialingObserver`) |
| 07/10/2025 | `bc4325e` | Configurando o cliente `Screen` e finalizando a solução do padrão Observer |

> ⚙️ Outros commits menores foram realizados para ajustes de compatibilidade e refinamento da execução.

---
