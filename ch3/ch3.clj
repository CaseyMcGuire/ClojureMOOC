;We often want to givea piece of data a name.
;As we have seen, namespace variables are declared with def
;A function or value that is needed only inside one function can
;be given a local name with let.

;example
(defn hypotenuse [x y]
  (let [xx (* x x)
        yy (* y y)]
    (Math/sqrt (+ xx yy))))

;let introduces one or more names and a scope for them.
;(let [name1 value1
;      name2 value2
;      ....]
;   (expression1)
;   (expression2)
;    ...)

;The names introduced by let are visible in all expressions after them, under let.

;Exercise 1
(defn do-a-thing [x]
  (let [double-it (+ x x)]
    (Math/pow double-it double-it)))

;Names declared in a let expression can refer to a previous name in the same expression but
;cannot refer to names declared later in the expression

;Simple values in clojure
;Numbers like 42, 3/2, 2.1
;Strings like "foo"
;Characters \x, \y, \z. A single character is written with a preceding \
;Keywords like :foo, :? are preceded with a color and are often used as keys in a map
;Booleans true, false

;Clojure has a support for a rich set of collection data structures.

;A vector is a collection that can be indexed with integers, like an array in other 
;languages. It can contain values of different types.
;A vector is written with surrounding brackets [] and the elements are written inside.

;Vectors are indexed with the get function

;(get ["a" "b" "c"] 1) ;=> "b"
;(get ["a" "b" "c"] 15) ;=> nil
;(get ["x"] 0)

;Exercise 2
(defn spiff
  "Returns the sum of the first and third elements of the vector"
  [v]
  (+ (get v 0) (get v 2)))

;Vectors are immutable; once you have a vector, you can not change it. You can, however, 
;easily create new vectors based on a vector
;(conj [1 2 3] 4);=>[1 2 3 4]
;(assoc [1 2 3 4] 2 "foo") => [1 2 "foo" 4]

;conj adds a value to a collection. 

;Exercise 3
(defn cutify
  "Takes a vector and adds '<3' to its end"
  [vec]
  (conj vec "<3"))

;Another way of extracting values from a vector is by destructuring it;
;(let [[x y z] [1 2 3 4 5 6]]
;  (str x y z))
;"123"
;Here, instead of giving a name to the vector [1 2 3 4 5 6], we indicate with
;the brackets in [x y z] that we want to destructure the vector instead.
;Inside the brackets, we give names to the first three elements of the vector.

;Exercise 4
(defn spiff-destructuring
  "Takes a vector and returns the sum of the first and third elements of the vector. Use destructuring."
  [vec]
  (let [[v1 v2 v3] vec]
    (+ v1 v3)))

;consider:
(defn sum-pairs [first-pair second-pair]
  [(+ (first first-pair) (first second-pair))
   (+ (second first-pair) (second second-pair))])

;VS

(defn sum-pairs' [[x1 y1] [x2 y2]]
  [(+ x1 x2) (+ y1 y2)])

;Let's define a simple representation for a two-dimensional point. It will simply be a pair 
;(2-element vector) of two numbers
(defn point [x y]
  [x y])

;and a representation for a rectangle. 
(defn rectangle [bottom-left top-right]
  [bottom-left top-right])

;When you have a nested structure where you know their structure in advance, you can destructure
;multiple levels at a time.
;(let [[[x1 y1] [x2 y2]] rectangle]
; ... do stuff with coordinates)

;Exercise 5

