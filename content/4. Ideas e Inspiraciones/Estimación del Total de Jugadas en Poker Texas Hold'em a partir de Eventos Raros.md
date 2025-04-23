---
title: Estimación del Total de Jugadas en Poker Texas Hold'em a partir de Eventos Raros
subtitle: Una pequeña aproximación teórica a una pequeña cuestionante interesante
summary: En este análisis, se estima el número total de manos jugadas en Texas Hold'em a partir de la observación de un evento poco frecuente. la formación de un póker en la mano final de un jugador.
date: 2025-02-28
lang: es
authors:
  - name: Andrés Humberto Chirinos Lizondo
    affiliation:
      - Sociedad Científica de Estudiantes de Estadística - UMSA
    corresponding: true
    email: andreschirinos@sociest.org
    orcid: 0009-0004-1628-6135
format:
  pdf:
    documentclass: article
    geometry:
      - margin=1in
    fontfamily: times
    number-sections: true
    colorlinks: true
    fig-width: 6.5
    fig-height: 4.5
    include-in-header:
      text: |
        \usepackage{amsmath}
        \usepackage{float}
        \usepackage{multicol}
    toc: true
    toc-title: Índice
    header-includes: |
      \AtBeginDocument{\begin{multicols}{2}}
      \AtEndDocument{\end{multicols}}
---


Hola a todos mis amigos y curiosos del póker. Hoy quiero compartirles un análisis estadístico muy interesante que nos permite estimar el número total de manos jugadas en nuestras partidas de Texas Hold'em, basándonos en la observación de un evento poco frecuente: que al final de la mano se forme un póker (es decir, obtener cuatro cartas del mismo rango en la mejor combinación de 7 cartas, que se obtiene al combinar las dos cartas privadas con las cinco comunitarias).

# Definición del Evento y su Probabilidad

En este caso, consideramos que el evento que medimos es **"obtener un póker"** en la mano final de un jugador. La literatura y diversos sitios especializados indican que, cuando se juega Texas Hold'em, la probabilidad teórica de que un jugador termine con un póker (en su mejor mano de 7 cartas) es aproximadamente $0.17\%$, o lo que es lo mismo, $p=0.00168$.

Esta probabilidad se deriva considerando que de todas las combinaciones de 7 cartas que se pueden formar a partir de un mazo de 52 cartas, aquellas que contienen un póker se pueden contar de la siguiente manera:

- Se elige el rango para formar el póker: 13 opciones.
- Se toman las 4 cartas de ese rango (única forma, ya que todas deben aparecer).
- Se eligen las otras 3 cartas entre las 48 restantes: $\binom{48}{3}$.

Así, el número de combinaciones favorables es:

$\text{Favorables} = 13 \times \binom{48}{3}$.

El total de combinaciones de 7 cartas es:

$\text{Total} = \binom{52}{7}$.

La probabilidad es, por tanto:

$p = \frac{13 \times \binom{48}{3}}{\binom{52}{7}} \approx 0.00168 \quad (0.168\%)$.

# Estimación Puntual del Número de Jugadas

Si observamos que en un cierto período se han presentado $k$ pókers, podemos usar un enfoque de máxima verosimilitud para estimar el total de manos jugadas $N$. Bajo el supuesto de que cada mano es un ensayo independiente con probabilidad $p$ de éxito, $k$ sigue (aproximadamente) una distribución de Poisson con parámetro $\lambda = Np$.

El estimador puntual para $N$ se obtiene igualando la media teórica a la observada:

$\hat{N} = \frac{k}{p}$.

**Ejemplo:**  
Si en nuestras partidas se han observado $k = 6$ pókers, la estimación puntual es:

$\hat{N} \approx \frac{6}{0.00168} \approx 3571 \text{ manos}.$

# Construcción del Intervalo de Confianza

Debido a que se trata de un evento raro, es recomendable emplear el enfoque exacto basado en la distribución de Poisson. Para un proceso de Poisson con $\lambda = Np$, los límites de un intervalo de confianza del $95\%$ para $\lambda$ se pueden obtener usando la distribución chi-cuadrado:

- Límite inferior para $\lambda$: $\lambda_{\text{L}} = \frac{1}{2} \chi^2_{\alpha/2,\, 2k}$,
- Límite superior para $\lambda$: $\lambda_{\text{U}} = \frac{1}{2} \chi^2_{1-\alpha/2,\, 2k+2}$,

donde $\alpha = 0.05$ para un $95\%$ de confianza y $k = 6$.

Con:

- $2k = 12$: se tiene que $\chi^2_{0.025,12} \approx 5.226$,
- $2k+2 = 14$: se tiene que $\chi^2_{0.975,14} \approx 26.119$.

De modo que:
$$
\lambda_{\text{L}} \approx \frac{5.226}{2} \approx 2.613, \quad \lambda_{\text{U}} \approx \frac{26.119}{2} \approx 13.06.
$$
Dado que $\lambda = Np$, despejamos $N$:
$$
N_{\text{L}} = \frac{\lambda_{\text{L}}}{p} \approx \frac{2.613}{0.00168} \approx 1555, N_{\text{U}} = \frac{\lambda_{\text{U}}}{p} \approx \frac{13.06}{0.00168} \approx 7774.
$$
**Intervalo de confianza del 95% para $N$:**  
Entre aproximadamente **1555** y **7774** manos.

# Factores que Pueden Afectar esta Estimación

Aunque el cálculo anterior es una buena aproximación teórica, en la práctica hay varios factores que pueden alterar la estimación:

- **Sesgo de muestreo:**  
    Si no se registran todas las manos o se recuerda solo lo extraordinario (los pókers), la estimación puede sesgarse.
    
- **Número de jugadores:**  
    En mesas con más jugadores, la probabilidad de que alguien obtenga un póker puede aumentar. Si se juega en diferentes formatos (heads-up versus mesas completas), la estimación debe ajustar este factor.
    
- **Manos no completadas:**  
    Muchas manos terminan antes del showdown (por ejemplo, cuando los jugadores se retiran antes de revelar sus cartas). Esto puede hacer que no se observen ciertos pókers.
    
- **Calidad del barajado y cartas quemadas:**  
    Aunque la teoría asume que las cartas se reparten aleatoriamente, imperfecciones en el barajado o en la mecánica del juego online podrían introducir pequeños sesgos.
    
- **Estrategia de juego:**  
    El estilo de juego (más agresivo o más pasivo) puede influir en cuántas manos llegan al showdown y, por tanto, en la frecuencia de pókers observados.
    
- **Variabilidad y tamaño de la muestra:**  
    Con solo 6 eventos, la incertidumbre es alta. Con más datos, el intervalo se podría estrechar y la estimación sería más precisa.
    

# Resumen y Conclusión

En resumen, si observamos 6 pókers en nuestras partidas y asumimos que la probabilidad de obtener un póker en la mano final es de aproximadamente $0.17\%$ (o $0.00168$), la estimación puntual del total de manos jugadas es:

$\hat{N} \approx \frac{6}{0.00168} \approx 3571 \text{ manos}$.

El intervalo de confianza del $95\%$ para $N$ se sitúa aproximadamente entre **1555** y **7774** manos.

Esta metodología utiliza el modelo de Poisson y la teoría de máxima verosimilitud, pero es importante recordar que factores prácticos como el sesgo de muestreo, el número de jugadores, la forma en que se juegan las manos y la calidad del barajado pueden afectar la precisión de la estimación.

Espero que este análisis detallado y la explicación matemática les resulte tan interesante como útil para entender mejor la aplicación de la estadística. ¿Qué opinan? ¿Han notado alguna diferencia en la frecuencia de pókers en sus partidas que podría sugerir algún sesgo o factor extra? ¡Los leo en los comentarios!


### Muro de la fama
- Richard
- Mary
- Ulises
- Gustavo
- 