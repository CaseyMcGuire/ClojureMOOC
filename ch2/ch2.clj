;if in clojure takes three parameters: the conditional clause, the then body and the else clause
(defn 
  boolean2
  "Returns true if value is truthy; false otherwise."
  [x]
  (if x
    true
    false))

(println (boolean2 4))

;values can be compared with =
;numbers should be compared with ==

(defn
  teen?
  "Returns true if the passed parameter is a teen number"
  [x]
  (<= 13 x 19))

(println "13")
(println (teen? 13))
(println "14")
(println (teen? 14))
(println "19")
(println (teen? 19))
(println "20")
(println (teen? 20))
  
;In functional programming everything is an expression
(defn 
  abs2
  "Returns the absolute value of the passed parameter"
  [n]
  (if (< n 0)
      (- n)
      n))

(println (abs2 -2))


(defn 
  divides?
  "Returns true if divisor divides n; false otherwise"
  [divisor n]
  (if (== (mod n divisor) 0)
    true
    false))


(println (divides? 2 4))

;When checking for multiple conditions, you can use multiple if clauses
;(if condition1
;  true
;    (if condition2
;      true
;      (if condition3
;       true3
;       ...)))
;This is similar to if/else if. However, you can rewrite them with cond

;(cond
;   condition1 true1
;   condition2 true2
;   condition3 true3
;   ...)

(defn super-sign [number]
  (cond
    (neg? number) "negative"
    (pos? number) "positive"
    :else         "zero"))

(defn fizzbuzz 
  "Returns 'fizz' when n is divisible by 3, 'buzz' when n is divisible by 5, and 'gotcha' when n is divisiable by 15, and '' the empty string otherwise"
  [n]
  (cond 
    (divides? 15 n) "gotcha!"
    (divides? 3 n) "fizz"
    (divides? 5 n) "buzz"
    :else          ""))

;Exercise 6    
(defn generic-doublificate [x]
  (cond 
    (number? x) (* x 2)
    (empty? x) nil
    (list? x) (* (count x) 2)
    (vector? x) (* (count x) 2)
    :else true))

  
