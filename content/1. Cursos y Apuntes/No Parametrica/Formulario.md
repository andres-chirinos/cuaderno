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
      - \fancyhead[L]{Formulario de No Parametrica}
      - \fancyfoot[C]{Este documento es solo para fines educativos.}
---

\begin{multicols}{3}

Conceptos Fundamentales en las Pruebas de Hipótesis

Las pruebas de hipótesis son procedimientos estadísticos utilizados para tomar decisiones acerca de una población basándose en datos muestrales. Estas pruebas se estructuran en torno a dos afirmaciones contradictorias:

- Hipótesis nula (H₀): Es una afirmación sobre la población que se intenta refutar. Generalmente, representa el "status quo", una situación de no efecto, no cambio o igualdad. Ejemplos:

  - H₀: El dispositivo anticontaminante es efectivo.
  - H₀: El peso medio de las piezas es igual a 300 Kg.

- Hipótesis alternativa (H₁): Es una afirmación que se acepta si los datos de la muestra proporcionan suficiente evidencia para rechazar la hipótesis nula. Ejemplos:
  - H₁: El dispositivo anticontaminante no es efectivo.
  - H₁: El peso medio de las piezas es distinto de 300 Kg.



Errores en las Pruebas de Hipótesis

Al tomar una decisión sobre la hipótesis nula, se pueden cometer dos tipos de errores:

1. Error Tipo I (α): Rechazar H₀ cuando en realidad es verdadera.

   - Se denota como: $ P(\text{Rechazar } H0 | H0 \text{ es verdadera}) $
   - Probabilidad: $ \alpha $
   - Ejemplo: Concluir que el dispositivo anticontaminante no es efectivo cuando en realidad lo es.

2. Error Tipo II (β): No rechazar H₀ cuando en realidad es falsa.
   - Se denota como: $ P(\text{Aceptar } H0 | H0 \text{ es falsa}) $
   - Probabilidad: $ \beta $
   - Ejemplo: Concluir que el dispositivo es efectivo cuando en realidad no lo es.

La potencia de una prueba se define como la probabilidad de rechazar correctamente una hipótesis nula falsa:
$$ 1 - \beta $$



Estadísticos de Prueba y Región Crítica

Para decidir si rechazamos H₀, calculamos un estadístico de prueba basado en los datos de la muestra y lo comparamos con una región crítica.

- Región crítica: Conjunto de valores del estadístico de prueba para los cuales se rechaza H₀.
- Nivel de significancia (α): Umbral máximo de error Tipo I permitido en la prueba.
- Valor-p: Probabilidad de obtener un resultado tan extremo (o más) que el observado, asumiendo que H₀ es verdadera. Si p-valor < α, se rechaza H₀.



Pruebas de Hipótesis Específicas y sus Fórmulas

1. Prueba t de una muestra

Se usa para probar la media de una población cuando la desviación estándar poblacional es desconocida.
$$ T= \frac{\bar{x} - \mu}{s / \sqrt{n}} $$
Donde:

- $ \bar{x} $ = media muestral
- $ \mu $ = media poblacional bajo H₀
- $ s $ = desviación estándar muestral
- $ n $ = tamaño de la muestra

2. Prueba z de una muestra

Se usa cuando la desviación estándar poblacional es conocida.
$$ Z0= \frac{\bar{x} - \mu0}{\sigma / \sqrt{n}} $$
Donde $ \sigma $ es la desviación estándar poblacional.

3. Prueba de Bondad de Ajuste Chi-cuadrado ($\chi^2$)

Evalúa si una distribución observada coincide con una esperada.
$$ \chi*0^2 = \sum_{i=1}^{k} \frac{(Oi - Ei)^2}{Ei} $$
Donde $ Oi $ y $ Ei $ son las frecuencias observadas y esperadas.

4. Prueba de Kolmogorov-Smirnov

Verifica si una muestra sigue una distribución específica.
$$ D = \sup |Fn(x)-F0(x)| $$
Donde $ Fn(x) $ es la función de distribución acumulada empírica y $ F0(x) $ la teórica.

5. Prueba de Normalidad (Shapiro-Wilk y Lilliefors)

Evalúa si los datos provienen de una distribución normal.

6. Prueba del Signo

Se basa en el signo de las diferencias respecto a la mediana.
$$ S^{+} = \sum ai $$
Donde $ ai = 1 $ si $ di > 0 $ y $ ai = 0 $ si $ di < 0 $.

7. Prueba de Wilcoxon con Signo

Usa rangos de las diferencias absolutas.
$$ W^{+} = \sum ai Ri^{\*} $$
Aproximación normal:
$$ z0 = \frac{W^+ - \frac{n(n+1)}{4}}{\sqrt{\frac{n(n+1)(2n+1)}{24}}} $$

8. Prueba de Rachas

Prueba la aleatoriedad en una secuencia binaria.
$$ \chi^2 = \frac{(R - E)^2}{E} $$
Donde $ R $ es el número de rachas y $ E $ es el valor esperado.

9. Prueba de Kruskal-Wallis

Prueba no paramétrica para comparar más de dos grupos independientes.
$$ H = \frac{12}{N(N+1)} \sum_{i=1}^{k} \frac{ni(Ri - \bar{R})^2}{ni} $$
Donde:

- $ N $ = tamaño total de la muestra
- $ ni $ = tamaño del grupo $ i $
- $ Ri $ = suma de rangos del grupo $ i $
- $ \bar{R} $ = media de los rangos

10. Prueba de Friedman

Prueba no paramétrica para comparar más de dos grupos relacionados.
$$ \chi^2*F = \frac{12}{nk(k+1)} \sum_{j=1}^{k} (Rj^2 - \frac{n(n+1)^2}{4}) $$
Donde:

- $ n $ = número de sujetos
- $ k $ = número de tratamientos
- $ Rj $ = suma de rangos para el tratamiento $ j $

11. Prueba de Mann-Whitney

Prueba no paramétrica para comparar dos grupos independientes.
$$ U = n1 n2 + \frac{n1(n1 + 1)}{2} - R1 $$
Donde:

- $ n1 $ y $ n2 $ son los tamaños de las muestras
- $ R1 $ es la suma de los rangos del primer grupo

12. Prueba de Wilcoxon para dos muestras relacionadas

Prueba no paramétrica para comparar dos grupos relacionados.
$$ W = \sum_{i=1}^{n} Ri $$
Donde:

- $ Ri $ es el rango de la diferencia entre las dos muestras.

13. Prueba de Spearman

Correlación no paramétrica entre dos variables.
$$ \rho_s = 1 - \frac{6 \sum_{di}^2}{n(n^2 - 1)} $$
Donde:

- $ di $ es la diferencia entre los rangos de las dos variables.

14. Prueba de Kendall

Correlación no paramétrica entre dos variables.
$$ \tau = \frac{(nc - nd)}{\frac{1}{2} n(n-1)} $$
Donde:

- $ nc $ es el número de concordancias
- $ nd $ es el número de discordancias

15. Prueba de Chi-cuadrado para independencia

Prueba no paramétrica para evaluar la independencia entre dos variables categóricas.
$$ \chi^2 = \sum \frac{(O_{ij} - E_{ij})^2}{E_{ij}} $$
Donde:

- $ O_{ij} $ es la frecuencia observada en la celda $ (i,j) $
- $ E_{ij} $ es la frecuencia esperada en la celda $ (i,j) $

16. Prueba de Chi-cuadrado para homogeneidad

Prueba no paramétrica para evaluar la homogeneidad entre dos o más poblaciones.
$$ \chi^2 = \sum \frac{(O_{ij} - E_{ij})^2}{E_{ij}} $$
Donde:

- $ O_{ij} $ es la frecuencia observada en la celda $ (i,j) $
- $ E_{ij} $ es la frecuencia esperada en la celda $ (i,j) $

17. Prueba de Cochran

Prueba no paramétrica para evaluar la homogeneidad de proporciones en más de dos grupos.
$$ Q = \frac{(R - E)^2}{E} $$
Donde:

- $ R $ es el número de éxitos observados
- $ E $ es el número de éxitos esperados

18. Prueba de McNemar

Prueba no paramétrica para evaluar la diferencia en proporciones en dos grupos relacionados.
$$ \chi^2 = \frac{(b - c)^2}{b + c} $$
Donde:

- $ b $ es el número de discordancias en la primera dirección
- $ c $ es el número de discordancias en la segunda dirección

\end{multicols}
