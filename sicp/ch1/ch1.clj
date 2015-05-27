(defn square
  "Returns the square of the passed parameter"
  [x]
  (* x x))

(defn sum-of-squares
  "Return the sum of squares of the passed parameter"
  [x y]
  (+ (square x) (square y)))

;1.1.6
(defn abs
  "Returns the absolute value of the passed parameter"
  [x]
  (if (>= x 0)
    x
    (- x)))

(defn abs2
  [x]
  (cond
    (>= x 0) x
    :else (- x)))

;Exercise 1.3
(defn two-largest-sum-of-squares
  [x y z]
  "Returns the sum of the squares of the two larger numbers"
  (cond
    (or (>= x y z) (>= y x z)) (sum-of-squares x y)
    (or (>= x z y) (>= z x y)) (sum-of-squares z x)
    :else (sum-of-squares y z)))


;section 1.1.7

;(defn good-enough?
;  [guess x]
;  (< (abs (- (square guess) x)) 0.001))

(defn average
  [x y]
  (/ (+ x y) 2))

;(defn improve
;  [guess x]
;  (average guess (/ x guess)))


;(defn sqrt-iter
;  [guess x]
;  (if (good-enough? guess x)
;    guess
;    (sqrt-iter (improve guess x) x )))

;(defn sqrt
;  [x]
;  (sqrt-iter 1.0 x))

;same as above but utilizing lexical scoping and free variables
(defn sqrt
  [x]
  (defn good-enough?
    [guess]
    (< (abs (- (square guess) x)) 0.001))
  (defn improve
    [guess]
    (average guess (/ x guess)))
  (defn sqrt-iter
    [guess]
    (if (good-enough? guess)
      guess
      (sqrt-iter (improve guess))))
  (sqrt-iter 1.0))


;1.2.1

;recursive factorial
(defn factorial
  [n]
  (if (== n 1)
    1
    (* n (factorial (- n 1)))))

;iterative factorial 
(defn factorial-iter 
  [n]
  (defn fact-iter
    [current running-total]
    (if (== current n)
      (* n running-total)
      (fact-iter (+ current 1) (* current running-total))))
      (fact-iter 1 1))
    
;Exercise 1.10
(defn ackermann
  [x y]
  (cond 
    (== y 0) 0
    (== x 0) (* 2 y)
    (== y 1) 2
    :else (ackermann (- x 1) (ackermann x (- y 1)))))

(defn fibonacci
  [n]
  (cond
    (== n 0) 0
    (== n 1) 1
    :else (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))

(defn fibonacci-iter
  [n]
  (defn fib-iter
    [count prev1 prev2]
    (if (== count n)
      (+ prev1 prev2)
      (fib-iter (+ count 1) prev2 (+ prev2 prev1))))
  (cond 
    (== n 0) 0
    (== n 1) 1
    :else (fib-iter 2 0 1)))

