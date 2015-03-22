;Functions written with fn are anonymous
(println ((fn [who] 
   (str "Hello, " who "!")) "Casey"))

;def gives a name a value
(def hello 
  (fn [who]
    (str "Hello, " who "!")))

(println (hello "Casey"))

;To give a function a name right off the bat, use defn
(defn                                  ;Start a function definition
  hello                                ;name
  "Gives out a personalized greeting." ;An optional doc string
  [who]                                ;parameters inside brackets
  (str "Hello, " who "!"))             ;body

;use (doc <function>) to get documentation on a function

(defn 
  square
  "Takes a number and returns the square of itself"
  [x]
  (* x x))

(defn 
  average
  "Returns the average of two parameters"
  [x y]
  (/ (+ x y) 2))


