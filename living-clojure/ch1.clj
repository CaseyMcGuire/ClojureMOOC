;Basic types in clojure

;integer
(println 12)

;decimal
(println 12.43)
; -> 12.43

;ratio
(println 1/3)
; -> 1/3

;If the ratio can be reduced it will be
(println 4/2)
; -> 2

;However, this only works with integers
;(println 4.0/2)
;-> error


;strings
(println "hello world")

;keywords
(println :hello)

;chars
(println \c)

;booleans
(println true)
(println false)

;nil
(println nil)

;Clojure contains the following collections
;lists
;vectors
;maps
;sets

;Lists
;To create a list in clojure, put a quote in front of parens and put data inside them
'("hello" :world 1 false)

;As we can see, lists are hetergeneous
;We can think of lists as being made up of two parts: the head and the rest

(first '(:rabbit :pocket-watch :marmalade :door))
; -> :rabbit

(rest '(:rabbit :pocket-watch :marmalade :door))
; -> (:pocket-watch :marmalade :door)

;If you try to take too many elements from a list, you will get nil
(first '())

;You can build lists with the cons function
;cons takes two arguments: the element you want to add and the list you want to add to
(cons :hello '(:world))
; -> (:hello :world)

;Since the end of list is nil, you can create a list with nil
(cons 5 nil)
; -> (5)

;Lists are good if you just want the head of a list but they have linear search time for anything else

;Vectors
;vectors are denoted by square brackets
[:hello :world]

;unlike lists, vectors have (practically) O(1) random access

;some useful functions for vectors are nth and last
(nth [:jar 1 2 3 :hello] 0)
; -> :jar

(last [:jar 1 2 3 :hello])
; -> :hello

;These methods also work on lists but are slower

;All collections in Clojure are immutable and persistent.
;Immutable means the value of the collection does not change
;Persistent means that these collections will do smart creations of new versions of themselves
;by using structural sharing.

;conj is a function that adds an element to a collection but it does so in a way that makes sense
;for that collections
;for a list, it will add it to the front
;for a vector, it will add it to the back

(conj '(:toast :butter) :jam)
; -> '(:toast :butter :jam)

(conj '(:toast :butter) :jam :honey)
; -> (:toast :butter :jam :honey)

;Maps

;maps are collections of key-value pairs 
;They are denoted by brackets with adjacent key-value pairs
{:jam1 "strawberry" :jam2 "blackberry"}
;Here :jam1 is the key for the value "strawberry" and :jam2 is the key for the value "blackberry"
;notice that Clojure assumes that adjacent pairs are key-value pairs. This can be hard to read so
;it can be consider idiomatic to put commas between key-value pairs
{:jam1 "strawberry", :jam2 "blackberry"}

;You can get values out of a map using the get method
(get {:jam1 "strawberry" :jam2 "blackberry"} :jam2)
; -> "blackberry"

;You can specify what to return if the key isn't found
(get {:jam1 "strawberry" :jam2 "blackberry"} :jam3 "not found")
;-> "not found"

;You can just use the key to retrieve a value from a map
(:jam2 {:jam1 "strawberry" :jam2 "blackberry"})
; -> "blackberry"

;to just get the keys from a map, use the keys function
(keys {:jam1 "strawberry" :jam2 "blackberry" :jam3 "marmalade"})
; -> (:jam1 :jam2 :jam3)

;to just get the values from a map, use the values function
(values {:jam1 "strawberry" :jam2 "blackberry" :jam3 "marmalade"})
; -> ("strawberry" "blackberry" "marmalade")

;To insert a new key-value pair, use the assoc function
(assoc {:jam1 "red" :jam2 "black"} :jam3 "orange")
; -> {:jam2 "black", :jam1 "red", :jam3 "orange"}

;To remove a key value pair, use the dissoc function
(dissoc {:jam1 "strawberry" :jam2 "blackberry"} :jam1)
; -> {:jam2 "blackberry"}

;Sets
;sets are collections of unique values
;They are denoted by a pound sign followed by brackets #{}
#{:red :blue :white :pink}

;Sets support basic set operations like union, difference, and intersection
(clojure.set/union #{:r :b :w} #{:w :p :y})
; -> #{:y :r :w :b :p}

(clojure.set/difference #{:r :b :w} #{:w :p :y})
; -> #{:r :b}

(clojure.set/intersection #{:r :b :w} #{:w :p :y})
; -> #{:w}

;You can convert other collections to a set using the set function
(set [:rabbit :rabbit :watch :door])
; -> #{:door :watch :rabbit}

(set {:a 1 :b 2 :c 3})
; -> #{[:c 3] [:b 2] [:a 1]}

;To get an element from a set, you can use get or just the key just as you do with a map

;You can use the contains? function to see if a set contains an element
(contains? #{:rabbit :door :watch} :rabbit)

;You can add elements using the conj function
;You can remove elements using the disj funtion
(disj #{:rabbit :door} :door)

;recap
;Lists are for collections of data that you want to access from the top of the list
;Vectors are for collections of data that you want to access anywhere by position
;Maps are for key-value pairs, which is great for organizing data and having easy access.
;Sets are for collections of unique elements

;lets revisit lists
'(:a :b :c)
;what makes this a list is that apostrophe on the front.
;If thats not there, Clojure will attempt to apply the first element of the list to the rest of 
;elements in this list. In this case, it will cause an error

(+ 1 1 1)
; -> 3
'(+ 1 1 1)
; -> '(+ 1 1 1)

;def allows us to give something a name, so we can refer to it from anywhere in our code.
(def developer "Alice")
; -> #'user/developer
; we're assuming here we're in the user namespace

;What if we want a variable that isn't in the global namespace and is only temporary?
;We can use let
(let [developer "Alice in Wonderland"]
  developer)
; -> "Alice in Wonderland"

(developer)
; -> "Alice"

;The bindings of let are in a vector form. It expects pairs of symbol and values. 

;Creating functions
;defn is very similar to def, but it creates vars for functions.
(defn follow-the-rabbit [] "Off we go!")


;sometimes you need to use a function briefly, but don't want to name it. These are anonymous functions.
;An anonymous function in Clojure can be expressed with the fn operator.
;It takes a vector of parameters and then the body of the function. It can be called, again, simply
;by calling the function with surrounding parens.

(fn [] (str "Off we go!" "!"))
;Returns a function

;invoke with parens
((fn [] (str "Off we go" "!")))

;defn is the same things as using def and binding the name to the anonymous function
(def follow-again (fn [] (str "Off we go" "!")))

;There is a shorthand form of an anonymous function that uses a # in front of parens:
(#(str "Off we go" "!"))

;If there is one parameter, you can use the percent sign (%) to represent it:
(#(str "Off we go" "!" " - " %) "again")
;-> "Off we go! - again"

;If there are multiple parameters, you can number the percent signs

(#(str "Off we go" "!" " - " %1 %2) "again" "?")

;Namespaces
;Namespaces are organized and controlled access to vars
;You can create your own namespaces and switch to it using ns
(ns alice.favfoods)

;Clojure libs are made up of these names and symbols associated with these namespaces. There three ways
;of using libs in your namespaces using require.

;1) Use the require expression with the namespace as the argument. This will load the lib and enable 
;access to it via the fully qualified namespace.

;Previously, we could use clojure.set/union because the clojure.set namespace is implicitly required like
;so: 
;(require 'clojure.set)

;2) Use require with an alias using :as. This allows access to the symbols using the alias as a prefix
;to the name, rather than the original namespace.

;(ns wonderland)
;(require '[alice.favfoods :as af])
;af/fav-food
; -> "strawberry jam"

;although you can use require on its own, its common to see it nested within the ns, using a keyword
;and a vector
;(ns wonderland
;   (:require [alice.favfoods :as af])

;3) Use require with the namespace and the :refer :all options. This loads all the symbols and makes 
;them directly accessible in the current namespace, just by the symbol name. However, this can be 
;confusing because it won't be clear where each function is coming from.
;(ns wonderland
;  (:require [alice.favfoods :refer :all]
;            [rabbit.favfoods :refer :all]))

;Most clojure code uses 2 except for tests. 
