---
lang: es
format:
  pdf:
    papersize: letter
    classoption: [landscape]
    fontsize: 9pt
    geometry: margin=2cm
    header-includes:
      - \usepackage{amsmath}
      - \usepackage{amssymb}
      - \usepackage{amsthm}
      - \usepackage{multicol}
      - \setlength{\columnsep}{0.35cm}
      - \usepackage{fancyhdr}
      - \pagestyle{fancy}
      - \fancyhead[L]{Formulario de Muestreo 1}
      - \fancyfoot[C]{Este documento es solo para fines educativos.}
---

\begin{multicols}{3}

1. Muestreo Aleatorio Simple (MAS)

- Concepto fundamental: Cada unidad de la población tiene una probabilidad conocida y distinta de cero de ser seleccionada en la muestra. En MAS, esta probabilidad es igual para todas las unidades.
    
- Probabilidad de selección:
    
    - Probabilidad simple (unidad $u_i$ sea seleccionada): $\pi_i = n/N$.
    - Probabilidad conjunta (unidades $u_i$ y $u_l$ sean seleccionadas): $\pi_{il} = n(n-1)/(N(N-1))$.
    - Estas probabilidades están relacionadas con una variable aleatoria auxiliar $e_i$, que toma el valor 1 si la unidad $u_i$ está en la muestra y 0 en caso contrario. $E(e_i) = \pi_i$ y $E(e_i e_l) = \pi_{il}$.
- Estimador General de Horvitz y Thompson: Para un parámetro $\theta = \sum_{i=1}^N X_i$, el estimador es $\hat{\theta} = \sum_{i=1}^n X_i / \pi_i$. Para MAS, donde $\pi_i = n/N$, esto se simplifica.
    
- Estimadores básicos (insesgados):
    
    - Media poblacional ($\mu$): El estimador es la media muestral $\bar{X}$. $\hat{\mu} = \bar{X} = \frac{1}{n} \sum_{i=1}^n X_i$. $E(\bar{X}) = \mu$.
    - Total poblacional ($T$): El estimador es $\hat{T} = N\bar{X}$. $E(\hat{T}) = T$.
    - Proporción poblacional ($P$): Para variables dicotómicas (0 o 1), el estimador es la proporción muestral $\hat{P}$. $\hat{P} = \frac{1}{n} \sum_{i=1}^n A_i$. $E(\hat{P}) = P$.
    - Total de casos ($A$): $\hat{A} = N\hat{P}$. $E(\hat{A}) = A$.
- Varianza de los estimadores (parámetros poblacionales):
    
    - Varianza de la Media ($\bar{X}$): $V(\bar{X}) = (1 - f) \frac{S^2}{n}$ donde $f = n/N$ es la fracción de muestreo y $S^2 = \frac{1}{N-1}\sum_{i=1}^N (X_i - \mu)^2$ es la cuasivarianza poblacional.
    - Varianza del Total ($\hat{T}$): $V(\hat{T}) = N^2 V(\bar{X}) = N^2 (1-f) \frac{S^2}{n}$.
    - Varianza de la Proporción ($\hat{P}$): Para variable dicotómica con $A_i \in {0, 1}$ y $P$ la proporción poblacional, $S^2$ se convierte en $P(1-P)$ o $PQ$. $V(\hat{P}) = (1 - f) \frac{PQ}{n} \frac{N}{N-1}$ o aproximadamente $(1-f) \frac{PQ}{n}$ para N grande. Usando cuasivarianza $S^2 = \frac{N}{N-1} P(1-P)$, $V(\hat{P}) = (1-f) \frac{S^2}{n}$.
    - Varianza del Total de casos ($\hat{A}$): $V(\hat{A}) = N^2 V(\hat{P})$.
- Estimadores de la Varianza (estimados a partir de la muestra):
    
    - Estimador de Varianza de la Media ($\bar{X}$): $\hat{V}(\bar{X}) = (1 - f) \frac{s^2}{n}$ donde $s^2 = \frac{1}{n-1}\sum_{i=1}^n (X_i - \bar{X})^2$ es la cuasivarianza muestral. $E(s^2) = S^2$ (insesgado).
    - Estimador de Varianza del Total ($\hat{T}$): $\hat{V}(\hat{T}) = N^2 \hat{V}(\bar{X}) = N^2 (1-f) \frac{s^2}{n}$.
    - Estimador de Varianza de la Proporción ($\hat{P}$): Usando $\hat{p}(1-\hat{p})$ o $\hat{p}\hat{q}$ como estimador de $P(1-P)$. $\hat{V}(\hat{P}) = (1 - f) \frac{\hat{p}\hat{q}}{n} \frac{N}{N-1}$ o aproximadamente $(1-f) \frac{\hat{p}\hat{q}}{n}$. Usando $s^2$ para variables dicotómicas $s^2 = \frac{n}{n-1}\hat{p}\hat{q}$, $\hat{V}(\hat{P}) = (1-f) \frac{s^2}{n}$.
    - Estimador de Varianza del Total de casos ($\hat{A}$): $\hat{V}(\hat{A}) = N^2 \hat{V}(\hat{P})$.

2. Muestreo Aleatorio Estratificado (MAE)

- Concepto fundamental: La población se divide en $L$ subpoblaciones o estratos ($N = \sum_{h=1}^L N_h$), y se toma una muestra independiente en cada estrato ($n = \sum_{h=1}^L n_h$). El objetivo es agrupar unidades homogéneas.
    
- Elementos fundamentales: Tamaño poblacional por estrato ($N_h$), tamaño muestral por estrato ($n_h$), ponderador de estrato ($W_h = N_h/N$).
    
- Estimadores básicos (insesgados):
    
    - Media poblacional estratificada ($\mu_{es}$): El estimador es la media muestral estratificada ponderada. $\hat{\mu}_{es} = \sum_{h=1}^L W_h \bar{X}_h$ donde $\bar{X}_h = \frac{1}{n_h} \sum_{i=1}^{n_h} X_{hi}$ es la media muestral del estrato $h$. $E(\hat{\mu}_{es}) = \mu_{es}$.
    - Total poblacional estratificado ($T_{es}$): El estimador es $\hat{T}_{es} = \sum_{h=1}^L \hat{T}_h = \sum_{h=1}^L N_h \bar{X}_h$. $E(\hat{T}_{es}) = T_{es}$.
    - Proporción poblacional estratificada ($P_{es}$): $\hat{P}_{es} = \sum_{h=1}^L W_h \hat{P}_h$ donde $\hat{P}_h$ es la proporción muestral en el estrato $h$. $E(\hat{P}_{es}) = P_{es}$.
- Varianza de los estimadores (parámetros poblacionales):
    
    - Varianza de la Media Estratificada ($\hat{\mu}_{es}$): Dado que las muestras son independientes por estrato, la varianza es la suma ponderada de las varianzas en cada estrato. $V(\hat{\mu}_{es}) = \sum_{h=1}^L W_h^2 V(\bar{X}_h) = \sum_{h=1}^L W_h^2 (1 - f_h) \frac{S_h^2}{n_h}$ donde $f_h = n_h/N_h$ y $S_h^2$ es la cuasivarianza poblacional en el estrato $h$.
    - Varianza del Total Estratificado ($\hat{T}_{es}$): $V(\hat{T}_{es}) = \sum_{h=1}^L V(\hat{T}_h) = \sum_{h=1}^L N_h^2 V(\bar{X}_h) = \sum_{h=1}^L N_h^2 (1 - f_h) \frac{S_h^2}{n_h}$.
    - Varianza de la Proporción Estratificada ($\hat{P}_{es}$): $V(\hat{P}_{es}) = \sum_{h=1}^L W_h^2 V(\hat{P}_h) = \sum_{h=1}^L W_h^2 (1 - f_h) \frac{P_h Q_h}{n_h} \frac{N_h}{N_h-1}$.
- Estimadores de la Varianza (estimados a partir de la muestra):
    
    - Estimador de Varianza de la Media Estratificada ($\hat{\mu}_{es}$): $\hat{V}(\hat{\mu}_{es}) = \sum_{h=1}^L W_h^2 \hat{V}(\bar{X}_h) = \sum_{h=1}^L W_h^2 (1 - f_h) \frac{s_h^2}{n_h}$ donde $s_h^2$ es la cuasivarianza muestral en el estrato $h$. $E(\hat{V}(\hat{\mu}_{es})) = V(\hat{\mu}_{es})$.
    - Estimador de Varianza del Total Estratificado ($\hat{T}_{es}$): $\hat{V}(\hat{T}_{es}) = \sum_{h=1}^L \hat{V}(\hat{T}_h) = \sum_{h=1}^L N_h^2 \hat{V}(\bar{X}_h) = \sum_{h=1}^L N_h^2 (1 - f_h) \frac{s_h^2}{n_h}$.
    - Estimador de Varianza de la Proporción Estratificada ($\hat{P}_{es}$): Usando $\hat{p}_h \hat{q}_h$ para estimar $P_h Q_h$. $\hat{V}(\hat{P}_{es}) = \sum_{h=1}^L W_h^2 \hat{V}(\hat{P}_h) = \sum_{h=1}^L W_h^2 (1 - f_h) \frac{\hat{p}_h \hat{q}_h}{n_h} \frac{N_h}{N_h-1}$.
- Afijación (distribución del tamaño muestral $n$ entre los estratos $n_h$): Varios métodos buscan optimizar la precisión para un costo o tamaño muestral dado. La fórmula de $n_h$ depende del método:
    
    - Uniforme: $n_h = n/L$.
    - Proporcional: $n_h = n \frac{N_h}{N} = n W_h$.
    - Varianza Mínima (Neyman): $n_h = n \frac{N_h S_h}{\sum_{l=1}^L N_l S_l}$ (minimiza la varianza para un tamaño muestral $n$ fijo).
    - Óptima con Costos: $n_h = n \frac{N_h S_h / \sqrt{c_h}}{\sum_{l=1}^L N_l S_l / \sqrt{c_l}}$ (minimiza la varianza para un costo $C$ fijo, donde $c_h$ es el costo por unidad en el estrato $h$).
    - Otros métodos como Afijación Mixta y Potencial.

3. Muestreo Sistemático (MSI)

- Concepto fundamental: Se selecciona una unidad aleatoria inicial ($r$) de 1 a $k=N/n$ (intervalo de muestreo) y luego cada $k$-ésima unidad en la lista.
    
- Elementos fundamentales: Tamaño poblacional ($N$), tamaño muestral ($n$), intervalo de muestreo ($k=N/n$ si es entero).
    
- Estimadores básicos (insesgados bajo ciertas condiciones): La teoría de estimadores es similar a MAS. Para poblaciones ordenadas aleatoriamente, los estimadores de MSI son insesgados.
    
    - Media poblacional ($\mu$): $\hat{\mu}_s = \bar{X}_s = \frac{1}{n} \sum_{i=1}^n X_{r+(i-1)k}$ donde $r$ es el arranque aleatorio.
    - Total poblacional ($T$): $\hat{T}_s = N \bar{X}_s$.
    - Proporción poblacional ($P$): $\hat{P}_s = \frac{1}{n} \sum_{i=1}^n A_{r+(i-1)k}$.
- Varianza de los estimadores: La varianza de MSI depende del orden de la lista. No hay una fórmula de varianza general simple que se pueda estimar directamente de una sola muestra sistemática sin supuestos sobre la población.
    
    - Varianza de la Media ($\bar{X}_s$): $V(\bar{X}_s) = \frac{1}{k} \sum_{r=1}^k (\bar{X}_r - \mu)^2$ donde $\bar{X}_r$ es la media de la $r$-ésima muestra sistemática posible. Esto requiere conocer todas las $k$ muestras posibles.
- Estimación de la Varianza: Se suelen usar métodos basados en supuestos sobre el orden de la población (ej: diferencias sucesivas).
    

4. Métodos Indirectos de Estimación (MIE)

- Concepto fundamental: Se utiliza información de una variable auxiliar ($Y$) altamente correlacionada con la variable de estudio ($X$) para mejorar los estimadores.
    
- Modelos generales:
    
    - Relación lineal que pasa por el origen: $X_i \approx R Y_i$
    - Relación lineal que no pasa por el origen: $X_i \approx a + b Y_i$
- Estimadores:
    
    - Estimador de Razón: Se usa cuando se asume una relación lineal que pasa por el origen.
        
        - Razón ($R=X/Y$): Estimador muestral $\hat{R} = \bar{X}/\bar{Y}$. (Note que $\bar{X}$ y $\bar{Y}$ son medias muestrales de $X$ e $Y$)
        - Media ($X$): $\hat{\mu}_{raz} = \hat{R} \mu_Y$ donde $\mu_Y$ es la media poblacional de $Y$ (que debe ser conocida).
        - Total ($T_X$): $\hat{T}_{raz} = \hat{R} T_Y$ donde $T_Y$ es el total poblacional de $Y$ (conocido). $\hat{T}_{raz} = N \hat{\mu}_{raz}$.
        - Proporción ($P_X$): $\hat{P}_{raz} = \hat{R} P_Y$ donde $P_Y$ es la proporción poblacional de $Y$ (conocida).
    - Estimador de Regresión: Se usa cuando se asume una relación lineal que no pasa por el origen.
        
        - Media ($X$): $\hat{\mu}_{reg} = \bar{X} + b_0 (\mu_Y - \bar{Y})$ donde $b_0$ es una constante (pendiente). Un estimador común para $b_0$ que minimiza la varianza es $\hat{b} = s_{xy} / s_y^2$. $\hat{\mu}_{reg, min} = \bar{X} + \hat{b}(\mu_Y - \bar{Y})$.
        - Total ($T_X$): $\hat{T}_{reg} = N \hat{\mu}_{reg}$.
        - Proporción ($P_X$): $\hat{P}_{reg} = \hat{P}_X + b_0(P_Y - \hat{P}_Y)$.
    - Estimador por Diferencia: Caso particular de regresión donde $b_0 = 1$.
        
        - Media ($X$): $\hat{\mu}_{dif} = \bar{X} + (\mu_Y - \bar{Y})$.
        - Total ($T_X$): $\hat{T}_{dif} = \hat{T}_X + (T_Y - \hat{T}_Y)$.
        - Proporción ($P_X$): $\hat{P}_{dif} = \hat{P}_X + (P_Y - \hat{P}_Y)$.
- Varianza de los estimadores (aproximadas para Razón):
    
    - Varianza de Razón ($\hat{R}$): $V(\hat{R}) \approx \frac{1-f}{n \mu_Y^2} (S_X^2 + R^2 S_Y^2 - 2 R S_{XY})$.
    - Varianza de Media (Razón): $V(\hat{\mu}_{raz}) = \mu_Y^2 V(\hat{R}) \approx \frac{1-f}{n} (S_X^2 + R^2 S_Y^2 - 2 R S_{XY})$.
    - Varianza de Total (Razón): $V(\hat{T}_{raz}) = T_Y^2 V(\hat{R}) = N^2 \mu_Y^2 V(\hat{R}) \approx N^2 \frac{1-f}{n} (S_X^2 + R^2 S_Y^2 - 2 R S_{XY})$.
- Varianza de los estimadores (Regresión y Diferencia):
    
    - Varianza de Media (Regresión): $V(\hat{\mu}_{reg}) = V(\bar{X} - b_0 \bar{Y}) = (1-f) \frac{1}{n} (S_X^2 + b_0^2 S_Y^2 - 2 b_0 S_{XY})$.
        - Varianza Mínima (usando $\hat{b}$): $V_{min}(\hat{\mu}_{reg}) \approx (1-f) \frac{S_X^2 (1 - \rho^2)}{n}$ donde $\rho$ es el coeficiente de correlación entre X e Y.
    - Varianza de Total (Regresión): $V(\hat{T}_{reg}) = N^2 V(\hat{\mu}_{reg})$.
    - Varianza de Media (Diferencia): $V(\hat{\mu}_{dif}) = (1-f) \frac{1}{n} (S_X^2 + S_Y^2 - 2 S_{XY})$ (caso $b_0=1$).
    - Varianza de Total (Diferencia): $V(\hat{T}_{dif}) = N^2 V(\hat{\mu}_{dif})$.
- Estimadores de la Varianza: Se obtienen reemplazando los parámetros poblacionales ($S_X^2, S_Y^2, S_{XY}$) por sus estimadores muestrales ($s_x^2, s_y^2, s_{xy}$).
    

5. Muestreo con Probabilidad Proporcional al Tamaño (PPT)

- Concepto fundamental: Las unidades muestrales son seleccionadas con una probabilidad que es proporcional a una medida de tamaño conocida asociada a cada unidad.
    
- Elementos fundamentales: Tamaño de la unidad $i$ ($M_i$), tamaño total de la población ($M = \sum_{i=1}^N M_i$).
    
- Probabilidad de selección:
    
    - Probabilidad simple ($\pi_i$): $\pi_i = n \frac{M_i}{M}$.
    - Probabilidad conjunta ($\pi_{il}$): $\pi_{il} = n(n-1) \frac{M_i M_l}{M(M-M_i)}$ (método de Yates y Grundy) u otras fórmulas dependiendo del método de selección.
- Estimador General de Horvitz y Thompson: Es el estimador común utilizado en PPT, ya que las probabilidades $\pi_i$ no son necesariamente iguales. Para un parámetro $\theta = \sum_{i=1}^N X_i$, el estimador es $\hat{\theta} = \sum_{i=1}^n X_i / \pi_i$.
    
- Estimadores básicos (insesgados):
    
    - Total poblacional ($T_X$): $\hat{T}_X = \sum_{i=1}^n \frac{X_i}{\pi_i}$.
    - Media poblacional ($\mu_X$): $\hat{\mu}_X = \frac{1}{N} \hat{T}_X = \frac{1}{N} \sum_{i=1}^n \frac{X_i}{\pi_i}$.
    - Total de casos ($A_X$): $\hat{A}_X = \sum_{i=1}^n \frac{A_i}{\pi_i}$.
    - Proporción poblacional ($P_X$): $\hat{P}_X = \frac{1}{N} \hat{A}_X = \frac{1}{N} \sum_{i=1}^n \frac{A_i}{\pi_i}$.
- Varianza de los estimadores: La fórmula general de Horvitz y Thompson es: $V(\hat{T}_X) = \sum_{i=1}^N \frac{X_i^2 (1-\pi_i)}{\pi_i} + \sum_{i=1}^N \sum_{l \ne i}^N \frac{X_i X_l (\pi_{il} - \pi_i \pi_l)}{\pi_i \pi_l}$ Una forma más estable para estimar la varianza es la de Yates y Grundy (para muestreo sin reemplazo): $V(\hat{T}_X) = \sum_{i<l}^N (\pi_i \pi_l - \pi_{il}) (\frac{X_i}{\pi_i} - \frac{X_l}{\pi_l})^2$
    
- Estimadores de la Varianza: Reemplazando las sumatorias poblacionales por muestrales en la fórmula de Yates y Grundy: $\hat{V}(\hat{T}_X) = \sum_{i<l}^n \frac{(\pi_i \pi_l - \pi_{il})}{\pi_{il}} (\frac{X_i}{\pi_i} - \frac{X_l}{\pi_l})^2$
    

6. Muestreo de Conglomerados Monoetápico (MCM)

- Concepto fundamental: La población se divide en conglomerados, y se selecciona una muestra de conglomerados, observandotodaslas unidades elementales dentro de los conglomerados seleccionados.
    
- Elementos fundamentales: Número de conglomerados en la población ($N$), tamaño de cada conglomerado ($M_i$), número de conglomerados en la muestra ($n$).
    
- Caso: Conglomerados del mismo tamaño ($M_i = M$) con Igual Probabilidad:
    
    - Estimadores básicos (insesgados):
        - Media por unidad elemental ($\mu_{co}$): $\hat{\mu}_{co} = \frac{1}{nM} \sum_{i=1}^n \sum_{j=1}^M X_{ij}$. ($X_{ij}$ es el valor de la unidad $j$ en el conglomerado $i$).
        - Total poblacional ($T_{co}$): $\hat{T}_{co} = NM \hat{\mu}_{co}$.
    - Varianza de los estimadores:
        - Varianza de la Media ($\hat{\mu}_{co}$): $V(\hat{\mu}_{co}) = (1-f) \frac{S_b^2}{n M^2}$ donde $S_b^2 = \frac{1}{N-1}\sum_{i=1}^N (T_i - M \mu_{co})^2$ y $T_i=\sum_{j=1}^M X_{ij}$. Equivalente a $V(\hat{\mu}_{co}) = (1-f) \frac{S_{co}^2}{n}$ donde $S_{co}^2 = \frac{1}{N-1}\sum_{i=1}^N (\bar{X}_i - \mu_{co})^2$.
        - Varianza del Total ($\hat{T}_{co}$): $V(\hat{T}_{co}) = (NM)^2 V(\hat{\mu}_{co}) = (NM)^2 (1-f) \frac{S_{co}^2}{n}$.
    - Estimadores de la Varianza:
        - Estimador de Varianza de la Media ($\hat{\mu}_{co}$): $\hat{V}(\hat{\mu}_{co}) = (1-f) \frac{s_{co}^2}{n}$ donde $s_{co}^2 = \frac{1}{n-1}\sum_{i=1}^n (\bar{X}_i - \hat{\mu}_{co})^2$.
        - Estimador de Varianza del Total ($\hat{T}_{co}$): $\hat{V}(\hat{T}_{co}) = (NM)^2 \hat{V}(\hat{\mu}_{co})$.
- Caso: Conglomerados de distinto tamaño ($M_i$) con Igual Probabilidad:
    
    - Estimadores básicos (insesgados):
        - Media por unidad elemental ($\mu_{co}$): $\hat{\mu}_{co} = \frac{1}{n \bar{M}} \sum_{i=1}^n \sum_{j=1}^{M_i} X_{ij}$ donde $\bar{M} = \frac{1}{n}\sum_{i=1}^n M_i$. Si se conoce $M = \sum_{i=1}^N M_i$, $\hat{\mu}_{co} = \frac{1}{M} \sum_{i=1}^n \frac{M_i \bar{X}_i}{n/N} = \frac{N}{nM} \sum_{i=1}^n M_i \bar{X}_i$.
        - Total poblacional ($T_{co}$): $\hat{T}_{co} = \sum_{i=1}^n \frac{T_i}{n/N} = \frac{N}{n} \sum_{i=1}^n T_i$ donde $T_i = \sum_{j=1}^{M_i} X_{ij}$. Si se conoce $M$, $\hat{T}_{co} = M \hat{\mu}_{co}$ (usando la primera fórmula de $\hat{\mu}_{co}$).
    - Varianza de los estimadores:
        - Varianza de la Media ($\hat{\mu}_{co}$): $V(\hat{\mu}_{co}) = (1-f) \frac{S_X^2}{n \bar{M}_p^2}$ donde $S_X^2 = \frac{1}{N-1}\sum_{i=1}^N (T_i - \mu_{co} M_i)^2$ y $\bar{M}_p = M/N$.
        - Varianza del Total ($\hat{T}_{co}$): $V(\hat{T}_{co}) = N^2 (1-f) \frac{S_T^2}{n}$ donde $S_T^2 = \frac{1}{N-1}\sum_{i=1}^N (T_i - \bar{T}_p)^2$ y $\bar{T}_p = T_{co}/N$.
    - Estimadores de la Varianza: Se obtienen reemplazando $S^2$ por $s^2$.
- Caso: Conglomerados de distinto tamaño ($M_i$) con Probabilidad Desigual (PPT):
    
    - Estimadores básicos (insesgados, Horvitz-Thompson):
        - Total poblacional ($T_{co}$): $\hat{T}_{co} = \sum_{i=1}^n \frac{T_i}{\pi_i}$. Si $\pi_i = n M_i / M$, $\hat{T}_{co} = \frac{M}{n} \sum_{i=1}^n \frac{T_i}{M_i} = \frac{M}{n} \sum_{i=1}^n \bar{X}_i$.
        - Media por unidad elemental ($\mu_{co}$): $\hat{\mu}_{co} = \frac{1}{M} \hat{T}_{co} = \frac{1}{M} \sum_{i=1}^n \frac{T_i}{\pi_i}$.
    - Varianza de los estimadores: Fórmulas generales de Horvitz y Thompson.
    - Estimadores de la Varianza: Fórmulas generales de Horvitz y Thompson.

7. Muestreo de Conglomerados Bietápico (MCB)

- Concepto fundamental: La población se divide en conglomerados (unidades primarias de muestreo - UPM), se selecciona una muestra de UPMs, y dentro de cada UPM seleccionada, se selecciona una submuestra de unidades elementales (unidades secundarias de muestreo - USM).
    
- Teorema de Madow: Descompone la varianza de un estimador ($\hat{\theta}$) en dos componentes: $V(\hat{\theta}) = E_1[V_2(\hat{\theta})] + V_1[E_2(\hat{\theta})]$
    
    - $E_1[V_2(\hat{\theta})]$: Esperanza sobre la primera etapa de la varianza de la segunda etapa.
    - $V_1[E_2(\hat{\theta})]$: Varianza sobre la primera etapa de la esperanza de la segunda etapa.
- Caso: UPMs del mismo tamaño ($M$) y USMs del mismo tamaño ($m$) con Igual Probabilidad en ambas etapas:
    
    - Estimador de la Media por unidad elemental ($\mu_{co}$): $\hat{\mu}_{co} = \frac{1}{n} \sum_{i=1}^n \bar{X}_i$ donde $\bar{X}_i = \frac{1}{m} \sum_{j=1}^m X_{ij}$ es la media muestral en la USM del conglomerado $i$. $E(\hat{\mu}_{co}) = \mu_{co}$.
        
    - Estimador del Total poblacional ($T_{co}$): $\hat{T}_{co} = NM \hat{\mu}_{co}$.
        
    - Varianza del Estimador de la Media ($\hat{\mu}_{co}$): Aplicando Madow's Theorem: $V(\hat{\mu}_{co}) = (1-f_1) \frac{S_b^2}{n M^2} + \frac{1-f_2}{nM} S_w^2$ donde $f_1=n/N$, $f_2=m/M$, $S_b^2 = \frac{1}{N-1}\sum_{i=1}^N (T_i - M \mu_{co})^2$ es la cuasivarianzaentremedias de conglomerados (basada en medias poblacionales de conglomerado), y $S_w^2 = \frac{1}{N(M-1)}\sum_{i=1}^N \sum_{j=1}^M (X_{ij} - \mu_i)^2$ es la cuasivarianzadentrode conglomerados (basada en medias poblacionales de conglomerado $\mu_i$). Una fórmula más común es $V(\hat{\mu}_{co}) = (1-f_1) \frac{S_a^2}{n} + f_1 \frac{1-f_2}{nm} S_w^2$ donde $S_a^2 = \frac{1}{N-1}\sum_{i=1}^N (\mu_i - \mu_{co})^2$. O $V(\hat{\mu}_{co}) = (1-f_1)\frac{S_b'^2}{n} + \frac{f_1}{n}(1-f_2)\frac{S_w^2}{m}$.
        
    - Varianza del Estimador del Total ($\hat{T}_{co}$): $V(\hat{T}_{co}) = (NM)^2 V(\hat{\mu}_{co})$.
        
    - Estimadores de la Varianza: La estimación insesgada de la varianza en MCB es más compleja. Un estimador (sesgado) es: $\hat{V}(\hat{\mu}_{co}) = (1-f_1)\frac{s_a^2}{n} + \frac{f_1(1-f_2)}{nm} s_w^2$ donde $s_a^2 = \frac{1}{n-1}\sum_{i=1}^n (\bar{X}_i - \hat{\mu}_{co})^2$ y $s_w^2 = \frac{1}{n(m-1)}\sum_{i=1}^n \sum_{j=1}^m (X_{ij} - \bar{X}_i)^2$.
        
- Casos con UPMs de distinto tamaño ($M_i$) y/o Probabilidad Desigual: Las fórmulas de estimadores y varianzas se vuelven más complejas, involucrando los tamaños $M_i$ y las probabilidades de selección $\pi_i$ (UPMs) y $\pi_{j|i}$ (USMs dentro de UPMs). Se sigue aplicando el teorema de Madow. Horvitz-Thompson general estimator is used.
    

8. Muestreo en tres etapas

- Concepto fundamental: Extiende el MCB al añadir una tercera etapa de muestreo dentro de las USMs seleccionadas.
- Teorema de Madow (3 etapas): $V(\hat{\theta}) = E_1 E_2[V_3(\hat{\theta})] + E_1[V_2(E_3(\hat{\theta}))] + V_1[E_2(E_3(\hat{\theta}))]$.

\end{multicols}
