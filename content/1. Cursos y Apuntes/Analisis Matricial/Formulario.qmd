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
      - \fancyhead[L]{Formulario de Matricial}
      - \fancyfoot[C]{Este documento es solo para fines educativos.}
---

\begin{multicols}{3}

Formulario Matricial

1. Matrices, Vectores y Operaciones

1.1. Definiciones básicas y notación

- Matriz A de dimensión m x n: Arreglo rectangular de $m$ filas y $n$ columnas, denotada por $A = [a_{ij}]$, donde $a_{ij}$ es el elemento en la $i$-ésima fila y $j$-ésima columna.

- Matriz cuadrada: $m = n$.

- Matriz rectangular: $m \neq n$.

- Vector fila: Matriz de dimensión $1 \times n$, $X = (x_1 \ x_2 \ \cdots \ x_n)$.

- Vector columna: Matriz de dimensión $m \times 1$, $Y = \begin{pmatrix} y_1 \ y_2 \ \vdots \ y_m \end{pmatrix}$.

- Matriz triangular superior: Matriz cuadrada donde $a_{ij} = 0$ para $i > j$.

- Matriz triangular inferior: Matriz cuadrada donde $b_{ij} = 0$ para $i < j$.

- Matriz diagonal: Matriz cuadrada donde $d_{ij} = 0$ para $i \neq j$.

- Matriz escalar: Matriz diagonal donde todos los elementos de la diagonal principal son iguales a una constante $k$. $S = kI$.

- Matriz unidad o identidad (I): Matriz cuadrada con unos en la diagonal principal y ceros en el resto.

- Matriz nula (O): Matriz donde todos los elementos son cero.

- Matriz escalonada: El número de ceros antes del primer elemento no nulo aumenta fila por fila.

- Matriz escalonada reducida: Es escalonada, el primer elemento no nulo de cada fila es 1 y es el único elemento no nulo en su columna.

  1.2. Adición matricial y multiplicación matricial por un escalar

- Suma de matrices: Si $A = [a_{ij}]$ y $B = [b_{ij}]$ tienen la misma dimensión $m \times n$, entonces $C = A + B = [c_{ij}]$ donde $c_{ij} = a_{ij} + b_{ij}$.
  
  - Propiedad conmutativa: $A + B = B + A$. Demostración: Se basa en la propiedad conmutativa de la suma de números reales: $a_{ij} + b_{ij} = b_{ij} + a_{ij}$.
  
  - Propiedad asociativa: $(A + B) + C = A + (B + C)$. Demostración: Se basa en la propiedad asociativa de la suma de números reales.
  
  - Existencia de neutro: $A + O = O + A = A$, donde $O$ es la matriz nula.
  
  - Existencia del opuesto: $A + (-A) = O$, donde $-A = [-a_{ij}]$.

- Multiplicación por un escalar: Si $A = [a_{ij}]$ es de dimensión $m \times n$ y $k \in \mathbb{R}$ es un escalar, entonces $C = kA = [c_{ij}]$ donde $c_{ij} = ka_{ij}$.

  - Propiedades:

    - $k(A + B) = kA + kB$.
    - $(k + l)A = kA + lA$.
    - $k(lA) = (kl)A$.
    - $1A = A$.
    - $0A = O$.

1.3. Multiplicación matricial

- Si $A = [a_{ij}]$ es de dimensión $m \times n$ y $B = [b_{jl}]$ es de dimensión $n \times p$, entonces $C = AB = [c_{il}]$ es de dimensión $m \times p$, donde $c_{il} = \sum_{j=1}^{n} a_{ij}b_{jl}$.
Propiedades:
  
  - Asociativa: $A(BC) = (AB)C$.
  
  - Distributiva: $A(B + C) = AB + AC$ y $(B + C)D = BD + CD$.
  
  - Asociatividad con escalar: $k(AB) = (kA)B = A(kB)$.
  
  - Neutro: $AI = IA = A$, donde $I$ es la matriz identidad de dimensión adecuada.
  
  - Potencia: $A^p A^q = A^{p+q}$.
  
  - No conmutativa en general: $AB \neq BA$.

1.4. Matrices particionadas

- Una matriz $A$ se puede dividir en submatrices o bloques.
- Suma: Si $A = [A_{ij}]$ y $B = [B_{ij}]$ tienen la misma partición, $A + B = [A_{ij} + B_{ij}]$.
- Multiplicación por escalar: $kA = [kA_{ij}]$.
- Transpuesta: $A^t = [A_{ji}^t]$.
- Multiplicación: Si las particiones son compatibles, $(A)(B) = [\sum_j A_{ij}B_{jk}]$.
- Determinante (caso especial): Si $A = \begin{pmatrix} A_{11} & A_{12} \ O & A_{22} \end{pmatrix}$ o $A = \begin{pmatrix} A_{11} & O \ A_{21} & A_{22} \end{pmatrix}$, entonces $\det(A) = \det(A_{11})\det(A_{22})$.
- Complemento de Schur de $A_{11}$ en $A = \begin{pmatrix} A_{11} & A_{12} \ A_{21} & A_{22} \end{pmatrix}$ (si $A_{11}$ es no singular): $A_{11/A} = A_{22} - A_{21}A_{11}^{-1}A_{12}$.
- Fórmula de Schur: $\det(A) = \det(A_{11})\det(A_{11/A})$ si $A_{11}$ es no singular, y $\det(A) = \det(A_{22})\det(A_{22/A})$ si $A_{22}$ es no singular, donde $A_{22/A} = A_{11} - A_{12}A_{22}^{-1}A_{21}$.

  1.5. La traza de matrices cuadradas

- Para una matriz cuadrada $A$ de dimensión $n \times n$, la traza es $\text{tr}(A) = \sum_{i=1}^{n} a_{ii}$.
- Propiedades:

  - $\text{tr}(kA) = k\text{tr}(A)$.
  - $\text{tr}(A + B) = \text{tr}(A) + \text{tr}(B)$.
  - $\text{tr}(A^t) = \text{tr}(A)$.
  - $\text{tr}(I_n) = n$.
  - $\text{tr}(AB) = \text{tr}(BA)$ (no aparece explícitamente en las fuentes, pero es una propiedad importante).

    1.6. Matrices especiales

- Matriz transpuesta: $A^t = [a_{ji}]$.
  - Propiedades: $(A^t)^t = A$, $(kA)^t = kA^t$, $(A \pm B)^t = A^t \pm B^t$, $(AB)^t = B^t A^t$.
- Matriz simétrica: $A = A^t$ (implica $A$ es cuadrada y $a_{ij} = a_{ji}$).
  - Propiedades: $A + B$ y $kA$ son simétricas si $A$ y $B$ lo son. Si $A$ es invertible, $A^{-1}$ es simétrica. $DD^t$ y $D^tD$ son simétricas para cualquier matriz $D$.
- Matriz antisimétrica: $A = -A^t$ (implica $A$ es cuadrada y $a_{ij} = -a_{ji}$, elementos diagonales son cero).
- Matriz normal: $AA^t = A^tA$ (matrices simétricas, antisimétricas y ortogonales son normales).
- Matriz idempotente: $A^2 = A$.
- Matriz periódica (de periodo p): $B^{p+1} = B$ (si $p = 1$, es idempotente).
- Matriz involutiva: $A^2 = I$ (implica $A = A^{-1}$).
- Matriz nilpotente: $A^p = O$ para algún entero positivo $p$.
- Matriz elemental: Resultado de aplicar una operación elemental a la matriz identidad $I_n$. Toda matriz elemental es invertible, y su inversa también es elemental.
- Matriz inversa: Si $A$ es cuadrada de dimensión $n \times n$, $B$ es su inversa $A^{-1}$ si $AB = BA = I_n$. La inversa, si existe, es única.
  - Propiedades: $(A^{-1})^{-1} = A$, $(kA)^{-1} = \frac{1}{k}A^{-1}$ (si $k \neq 0$), $(AB)^{-1} = B^{-1}A^{-1}$, $(A^t)^{-1} = (A^{-1})^t$, $\det(A^{-1}) = \frac{1}{\det(A)}$.
- Matriz ortogonal: Matriz cuadrada $A$ tal que $AA^t = A^tA = I$, lo que implica $A^{-1} = A^t$.

  - Propiedades: $|A| = \pm 1$, $A^t$ es ortogonal, sus valores propios tienen módulo 1.

    1.7. Aplicación práctica

- La teoría matricial es fundamental en estadística para modelos de gran dimensión, identificación de probabilidades, matrices de transición, análisis factorial, cadenas de Markov, correlaciones, etc..

2. Factorización Matricial

2.2. Descomposición LU

- Para una matriz $A$, se busca $A = LU$, donde $L$ es una matriz triangular inferior (generalmente con unos en la diagonal) y $U$ es una matriz triangular superior. Se encuentra resolviendo el sistema de ecuaciones resultante del producto.

  2.3. Descomposición LDU

- $A = LDU$, donde $L$ es triangular inferior con unos en la diagonal, $D$ es diagonal (con los pivotes de la descomposición LU), y $U$ es triangular superior con unos en la diagonal.

  2.4. Descomposición Cholesky

- Para una matriz simétrica $A$ con valores propios positivos, $A = LL^t$, donde $L$ es una matriz triangular inferior con elementos diagonales positivos. Se relaciona con la descomposición LDU donde $U = L^t$ y $D$ tiene elementos positivos.

  2.5. Descomposición en Valores Singulares (SVD)

- Para una matriz $A$ de dimensión $m \times n$ y rango $r$, $A = USV^t$, donde $U$ es una matriz ortogonal $m \times m$, $S$ es una matriz diagonal $m \times n$ con valores singulares no negativos $\beta_1 \ge \beta_2 \ge \cdots \ge \beta_r > 0$ en la diagonal, y $V$ es una matriz ortogonal $n \times n$. Los valores singulares son las raíces cuadradas de los valores propios de $A^tA$ (o $AA^t$).

  2.6. Descomposición Espectral y Matrices Raíces Cuadradas

- Para una matriz simétrica $A$ de dimensión $n \times n$, $A = PDP^{-1} = PDP^t$, donde $P$ es una matriz ortogonal cuyas columnas son los vectores propios normalizados de $A$, y $D$ es una matriz diagonal cuyos elementos son los valores propios correspondientes.
- Matriz raíz cuadrada: $\sqrt{A} = P\sqrt{D}P^t$, donde $\sqrt{D}$ es una matriz diagonal cuyos elementos son las raíces cuadradas de los valores propios de $A$ (solo si los valores propios son no negativos).

  2.8. Descomposición de Schur

- Para una matriz cuadrada $A$ de dimensión $n \times n$ con valores propios $\lambda_1, \dots, \lambda_n$, existe una matriz ortogonal $Q$ tal que $Q^tAQ = T$, donde $T$ es una matriz triangular superior con los valores propios de $A$ en la diagonal. Si $A$ es real y simétrica, entonces $T$ es diagonal (la descomposición espectral).

  2.9. Diagonalización simultánea de matrices simétricas

- Dos matrices simétricas $A$ y $B$ son simultáneamente diagonalizables por congruencia si existe una matriz no singular $P$ tal que $P^tAP$ y $P^tBP$ son ambas diagonales.
- Una matriz cuadrada $A$ es ortogonalmente diagonalizable si existe una matriz ortogonal $P$ tal que $P^{-1}AP = PDP^t$ es diagonal. Las columnas de $P$ son los vectores propios ortonormales de $A$, y los elementos de $D$ son los valores propios de $A$.

  2.10. Normas matriciales

- Norma de Frobenius: $|A|_F = \sqrt{\sum_{i=1}^{m}\sum_{j=1}^{n} |a_{ij}|^2} = \sqrt{\text{tr}(AA^H)}$ (en el caso real, $|A|_F = \sqrt{\text{tr}(AA^t)}$).
  - Propiedades:
    - $|A| \ge 0$, $|A| = 0 \iff A = O$.
    - $|kA| = |k||A|$.
    - $|A + B| \le |A| + |B|$ (desigualdad triangular).
    - $|AB| \le |A||B|$ (submultiplicatividad).

3. Inverso Generalizado

3.2. Inversa generalizada

- Una matriz $G$ es una inversa generalizada de $A$ si $AGA = A$.
- Pseudoinversa por la derecha ($R$): Si $\text{rango}(A) = m$, existe $R$ tal que $AR = I_m$, y $R = A^t(AA^t)^{-1}$ (si $AA^t$ es invertible).
- Pseudoinversa por la izquierda ($L$): Si $\text{rango}(A) = n$, existe $L$ tal que $LA = I_n$, y $L = (A^tA)^{-1}A^t$ (si $A^tA$ es invertible).
- Inversa generalizada de Moore-Penrose ($A^+$): Para cualquier matriz $A$ de dimensión $m \times n$, existe una única matriz $A^+$ de dimensión $n \times m$ que satisface las siguientes cuatro condiciones:

  - $AA^+A = A$
  - $A^+AA^+ = A^+$
  - $(AA^+)^t = AA^+$ (simétrica)
  - $(A^+A)^t = A^+A$ (simétrica)

    3.3. Propiedades básicas de la inversa de Moore-Penrose

- Si $A$ es invertible, $A^+ = A^{-1}$.
- $(A^+)^+ = A$.
- $(A^t)^+ = (A^+)^t$.
- $(kA)^+ = k^{-1}A^+$ para $k \neq 0$.

  3.4. Producto matricial de inversas de Moore-Penrose

- $(AD)^+ = D^+A^+$ si se cumplen ciertas condiciones (por ejemplo, si las columnas de $D$ son linealmente independientes y las filas de $A$ son linealmente independientes).
- $(A^+A)(DD^+) = (DD^+)(A^+A)$ (no siempre cierto, la condición dada en la fuente parece incompleta o requiere más contexto sobre $A$ y $D$).

  3.8. Otras inversas generalizadas (Pseudoinversa de Bott-Duffin)

- Para un sistema $Ax + y = b$ con restricciones en $y$ (por ejemplo, $y \in L^\perp$), la pseudoinversa de Bott-Duffin se define como $A^{-1}_{(L)} = P_LA(AP_L + P_{L^\perp})^{-1}$, donde $P_L$ y $P_{L^\perp}$ son proyectores sobre los subespacios $L$ y su complemento ortogonal. Si $AP_L + P_{L^\perp}$ es no singular, una solución es $x = A^{-1}_{(L)}b$ y $y = (I - AA^{-1}_{(L)})b$.

\end{multicols}
